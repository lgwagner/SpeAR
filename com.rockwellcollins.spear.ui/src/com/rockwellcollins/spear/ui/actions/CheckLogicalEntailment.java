package com.rockwellcollins.spear.ui.actions;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
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
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.layout.SpearRegularLayout;
import com.rockwellcollins.spear.translate.master.SProgram;
import com.rockwellcollins.spear.ui.handlers.TerminateHandler;
import com.rockwellcollins.spear.ui.views.SpearEntailmentResultsView;
import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.api.results.MapRenaming;
import jkind.api.results.MapRenaming.Mode;
import jkind.api.results.Renaming;
import jkind.lustre.Program;
import jkind.results.layout.Layout;

public class CheckLogicalEntailment implements IWorkbenchWindowActionDelegate {

	private static final String TERMINATE_ID = "com.rockwellcollins.spear.translate.commands..terminateLogicalEntailment";

	private IWorkbenchWindow window;

	@Override
	public void run(IAction action) {
		SpearInjectorUtil.setInjector(SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR));

		IEditorPart editor = window.getActivePage().getActiveEditor();
		if (!(editor instanceof XtextEditor)) {
			MessageDialog.openError(window.getShell(), "Error", "Only SpeAR files can be analyzed.");
			return;
		}

		XtextEditor xte = (XtextEditor) editor;
		IXtextDocument doc = xte.getDocument();

		runAnalysis(doc, new NullProgressMonitor());
	}

	private void runAnalysis(IXtextDocument doc, IProgressMonitor monitor) {
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
				if(ActionUtilities.hasErrors(specification, window)) {
					return null;
				}

				if (specification.getBehaviors().size() == 0) {
					MessageDialog.openError(window.getShell(), "Nothing to analyze",
							"The user must specify at least one property to check for logical entailment.");
					return null;
				}

				Document workingCopy = new Document(specification);
				workingCopy.transform();

				SProgram program = SProgram.build(workingCopy);
				Program p = program.getLogicalEntailment();

				if (PreferencesUtil.printFinalLustre()) {
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

					// create the generated folder
					URI folderURI = ActionUtilities.createFolder(state.getURI(), "generated");
					ActionUtilities.makeFolder(root.getFolder(new Path(folderURI.toPlatformString(true))));

					// create the lustre file
					String filename = ActionUtilities.getGeneratedFile(state.getURI(), "lus");
					URI lustreURI = ActionUtilities.createURI(folderURI, filename);
					IResource finalResource = root.getFile(new Path(lustreURI.toPlatformString(true)));
					ActionUtilities.printResource(finalResource, p.toString());

					// refresh the workspace
					root.refreshLocal(IResource.DEPTH_INFINITE, null);
				}

				JKindApi api = PreferencesUtil.getJKindApi();
				setApiOptions(api);

				Renaming renaming = new MapRenaming(workingCopy.renamed.get(workingCopy.main), Mode.IDENTITY);
				List<Boolean> invert = new ArrayList<>();
				Specification s = (Specification) workingCopy.main;
				for (Constraint c : s.getBehaviors()) {
					if (c instanceof FormalConstraint) {
						FormalConstraint fc = (FormalConstraint) c;
						if (fc.getFlagAsWitness() != null) {
							invert.add(true);
						} else {
							invert.add(false);
						}
					} else {
						invert.add(false);
					}
				}

				// this is a hack to ensure the invert list accounts for the
				// additional property that captures all properties.
				if (PreferencesUtil.getEnableIVCDuringEntailment()) {
					api.setIvcReduction();
					invert.add(false);
				}

				JKindResult result = new JKindResult("Spear Result", p.getMainNode().properties, invert, renaming);
				activateTerminateHandler(monitor);
				List<String> requirements = specification.getRequirements().stream().map(req -> req.getName()).collect(toList());
				List<String> observers = getObservers(specification);
				showView(result, new SpearRegularLayout(specification), requirements, observers);

				new Thread(() -> {
					try {
						api.execute(p, result, monitor);
					} catch (Exception e) {
						System.err.println(result.getText());
						throw e;
					} finally {
						deactivateTerminateHandler();
					}
				}).start();

				return null;
			}

			private void setApiOptions(JKindApi api) {
				if (PreferencesUtil.generalizeCEX()) {
					api.setIntervalGeneralization();
				}

				if (PreferencesUtil.smoothCEX()) {
					api.setSmoothCounterexamples();
				}
			}
		});
	}

	private List<String> getObservers(Specification specification) {
		List<String> result = new ArrayList<>();
		for (Constraint c : specification.getBehaviors()) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				if ("observe".equals(fc.getFlagAsWitness())) {
					result.add(c.getName());
				}
			}
		}
		return result;
	}

	private IHandlerActivation activation;

	private void activateTerminateHandler(final IProgressMonitor monitor) {
		final IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				if (activation != null) {
					handlerService.deactivateHandler(activation);
				}
				activation = handlerService.activateHandler(TERMINATE_ID, new TerminateHandler(monitor));
			}
		});
	}

	private void deactivateTerminateHandler() {
		final IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				handlerService.deactivateHandler(activation);
				activation = null;
			}
		});
	}

	private void showView(final JKindResult result, final Layout layout, List<String> requirements, List<String> observers) {
		window.getShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
					SpearEntailmentResultsView page = (SpearEntailmentResultsView) window.getActivePage().showView(SpearEntailmentResultsView.ID);
					page.setInput(result, layout, requirements, observers);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void init(IWorkbenchWindow arg0) {
		this.window = arg0;
	}
}
