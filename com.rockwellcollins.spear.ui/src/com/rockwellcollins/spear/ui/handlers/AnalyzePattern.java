package com.rockwellcollins.spear.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.master.SProgram;
import com.rockwellcollins.spear.ui.views.SpearConsistencyResultsView;
import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.api.results.MapRenaming;
import jkind.api.results.MapRenaming.Mode;
import jkind.api.results.Renaming;
import jkind.lustre.Program;
import jkind.results.layout.Layout;
import jkind.results.layout.NodeLayout;

public class AnalyzePattern extends AbstractHandler {

	private static final String TERMINATE_ID = "com.rockwellcollins.spear.translate.commands.terminateAnalysis";

	private IWorkbenchWindow window;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
		this.window = HandlerUtil.getActiveWorkbenchWindow(event);
		TextSelection ts = (TextSelection) xtextEditor.getSelectionProvider().getSelection();

		xtextEditor.getDocument().readOnly(resource -> {
			EObject e = new EObjectAtOffsetHelper().resolveContainedElementAt(resource, ts.getOffset());

			Pattern p = EcoreUtil2.getContainerOfType(e, Pattern.class);
			if (p == null) {
				MessageDialog.openError(window.getShell(), "Pattern Not Found",
						"Please place the cursor inside a valid pattern.");
				return null;
			}

			if (hasErrors(resource)) {
				MessageDialog.openError(window.getShell(), "Error", "Pattern contains errors.");
				return null;
			}

			analyzePattern(p);
			return null;
		});
		return null;
	}

	protected boolean hasErrors(Resource res) {
		Injector injector = SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR);
		IResourceValidator resourceValidator = injector.getInstance(IResourceValidator.class);

		for (Issue issue : resourceValidator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl)) {
			if (issue.getSeverity() == Severity.ERROR) {
				return true;
			}
		}
		return false;
	}

	private void analyzePattern(Pattern p) {
		Document d = null;
		try {
			d = new Document(p, true);
		} catch (Exception e1) {
			System.err.println("Unexpected error transforming PatternDocument for analysis.");
			e1.printStackTrace();
		}

		SProgram IR = SProgram.build(d);
		Program program = IR.patternToLustre();

		JKindApi api = PreferencesUtil.getJKindApi();

		Renaming renaming = new MapRenaming(d.renamed.get(d.main), Mode.IDENTITY);
		JKindResult result = new JKindResult("result", program.getMainNode().properties, renaming);
		IProgressMonitor monitor = new NullProgressMonitor();
		String nicename = "Pattern Analysis: " + p.getName();

		activateTerminateHandler(monitor);
		showView(result, new NodeLayout(program.getMainNode()), nicename);

		new Thread() {
			public void run() {
				try {
					api.execute(program, result, monitor);
				} catch (Exception e) {
					System.out.println(result.getText());
					throw e;
				} finally {
					deactivateTerminateHandler();
				}
			}
		}.start();
	}

	private void showView(final JKindResult result, final Layout layout, String title) {
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					SpearConsistencyResultsView page = (SpearConsistencyResultsView) window.getActivePage()
							.showView(SpearConsistencyResultsView.ID);
					page.setInput(result, layout, title);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private IHandlerActivation activation;

	private void activateTerminateHandler(final IProgressMonitor monitor) {
		final IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
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
			}
		});
	}
}
