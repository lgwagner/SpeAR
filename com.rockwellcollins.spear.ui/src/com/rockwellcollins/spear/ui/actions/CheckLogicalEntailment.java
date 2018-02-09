package com.rockwellcollins.spear.ui.actions;

import static com.rockwellcollins.spear.utilities.Utilities.checkForUFCFlag;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.rockwellcollins.SpearInjectorUtil;
import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Observe;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.analysis.Entailment;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.layout.SpearRegularLayout;
import com.rockwellcollins.spear.ui.handlers.TerminateHandler;
import com.rockwellcollins.spear.ui.views.SpearEntailmentResultsView;
import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.api.results.JKindResult;
import jkind.results.layout.Layout;

public class CheckLogicalEntailment implements IWorkbenchWindowActionDelegate {

	private static final String TERMINATE_ID = "com.rockwellcollins.spear.ui.commands.terminateLogicalEntailment";

	private IWorkbenchWindow window;

	@Override
	public void run(IAction action) {
		SpearInjectorUtil
				.setInjector(SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR));

		IEditorPart editor = window.getActivePage().getActiveEditor();
		if (!(editor instanceof XtextEditor)) {
			MessageDialog.openError(window.getShell(), "Error", "Only SpeAR files can be analyzed.");
			return;
		}

		XtextEditor xte = (XtextEditor) editor;
		IXtextDocument doc = xte.getDocument();

		runAnalysis(doc);
	}

	private void runAnalysis(IXtextDocument doc) {
		doc.readOnly(new IUnitOfWork<Void, XtextResource>() {

			@Override
			public java.lang.Void exec(XtextResource state) throws Exception {
				File f = (File) state.getContents().get(0);

				Specification specification = null;
				if (f instanceof Definitions) {
					MessageDialog.openError(window.getShell(), "Error", "Cannot analyze a Definitions file.");
					return null;
				} else {
					specification = (Specification) f;
				}

				// check the spec and imported files for errors
				if (ActionUtilities.hasErrors(specification, window)) {
					return null;
				}

				if (getEntailmentPropCount(specification) == 0) {
					MessageDialog.openError(window.getShell(), "Nothing to analyze",
							"The user must specify at least one property to check for logical entailment.");
					return null;
				}

				Entailment entailment = new Entailment(specification,PreferencesUtil.getJKindJar());
				ActionUtilities.refresh();
				
				List<String> requirements = specification.getRequirements().stream().map(req -> req.getName()).collect(toList());
				List<String> observers = getObservers(entailment.document);
				
				showView(entailment.result, new SpearRegularLayout(specification), requirements, observers);

				new WorkspaceJob("Entailment") {
					@Override
					public IStatus runInWorkspace(IProgressMonitor monitor) {
						try {
							activateTerminateHandler(monitor);
							entailment.analyze(monitor);
						} catch (Exception e) {
							System.err.println(entailment.result.getText());
							e.printStackTrace();
						} finally {
							deactivateTerminateHandler();
						}
						return Status.OK_STATUS;
					}
				}.schedule();
				return null;
			}
		});
	}

	private Integer getEntailmentPropCount(Specification specification) {
		List<Constraint> ufcRequirements = specification.getRequirements().stream().filter(c -> checkForUFCFlag(c))
				.collect(Collectors.toList());
		return specification.getBehaviors().size() + ufcRequirements.size();
	}

	private List<String> getObservers(Document d) {
		Specification specification = (Specification) d.main;
		List<String> result = new ArrayList<>();
		for (Constraint c : specification.getBehaviors()) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				if (fc.getFlag() != null && (fc.getFlag() instanceof Observe)) {
					if(d.renamed.get(d.main).containsKey(c.getName())) {
						result.add(d.renamed.get(d.main).get(c.getName()));
					} else {
						result.add(c.getName());	
					}
					
				}
			}
		}
		return result;
	}

	private IHandlerActivation activation;

	private void activateTerminateHandler(final IProgressMonitor monitor) {
		final IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
		window.getShell().getDisplay().syncExec(() -> {
			if (activation != null) {
				handlerService.deactivateHandler(activation);
			}
			activation = handlerService.activateHandler(TERMINATE_ID, new TerminateHandler(monitor));
		});
	}

	private void deactivateTerminateHandler() {
		final IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
		window.getShell().getDisplay().syncExec(() -> {
			handlerService.deactivateHandler(activation);
			activation = null;
		});
	}

	private void showView(final JKindResult result, final Layout layout, List<String> requirements,
			List<String> observers) {
		window.getShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
					SpearEntailmentResultsView page = (SpearEntailmentResultsView) window.getActivePage()
							.showView(SpearEntailmentResultsView.ID);
					page.setInput(result, layout, requirements, observers);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {}

	@Override
	public void dispose() {}

	@Override
	public void init(IWorkbenchWindow arg0) {
		this.window = arg0;
	}
}
