package com.rockwellcollins.spear.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.javatuples.Triplet;

import com.rockwellcollins.SpearInjectorUtil;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.analysis.Analysis;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.layout.SpearRealizabilityLayout;
import com.rockwellcollins.spear.ui.handlers.TerminateHandler;
import com.rockwellcollins.spear.ui.views.SpearRealizabilityResultsView;
import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.api.results.JKindResult;
import jkind.results.layout.Layout;

public class CheckRealizability implements IWorkbenchWindowActionDelegate {

	private static final String TERMINATE_ID = "com.rockwellcollins.spear.ui.commands.terminateRealizability";

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
				if (ActionUtilities.hasErrors(specification, window)) {
					return null;
				}

				Triplet<Analysis, Document, JKindResult> triplet = Analysis.realizability(specification, PreferencesUtil.getJKindJar(),"result");
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);

				activateTerminateHandler(monitor);
				showView(triplet.getValue2(), new SpearRealizabilityLayout(specification));

				new Thread() {
					public void run() {
						try {
							triplet.getValue0().analyze(monitor);
						} catch (Exception e) {
							System.err.println(triplet.getValue2().getText());
							throw e;
						} finally {
							deactivateTerminateHandler();
						}
					}
				}.start();

				return null;
			}
		});
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

	private void showView(final JKindResult result, final Layout layout) {
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					SpearRealizabilityResultsView page = (SpearRealizabilityResultsView) window.getActivePage()
							.showView(SpearRealizabilityResultsView.ID);
					page.setInput(result, layout, null);
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
