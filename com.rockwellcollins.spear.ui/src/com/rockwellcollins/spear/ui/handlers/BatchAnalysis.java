package com.rockwellcollins.spear.ui.handlers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.javatuples.Triplet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.rockwellcollins.SpearRuntimeModule;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.analysis.Analysis;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.ui.actions.ActionUtilities;
import com.rockwellcollins.spear.ui.views.BatchAnalysisView;

import jkind.api.results.JKindResult;
import jkind.api.results.PropertyResult;
import jkind.api.results.Status;

public class BatchAnalysis extends AbstractHandler {

	private static final String TERMINATE_ID = "com.rockwellcollins.spear.ui.commands.terminateBatchAnalysis";
	static public String ID = "com.rockwellcollins.spear.translate.commands.batchAnalysis";
	private XtextResourceSet resourceSet;

	// FIXME: Terrible hack because the registering the same class for two
	// different handlers

	private static Thread ba = null;
	private boolean stop = false;
	private IWorkbenchWindow window;
	private Injector injector;

	public BatchAnalysis() throws PartInitException {
		injector = Guice.createInjector(new SpearRuntimeModule());
		resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		stop = false;
	}

	private BatchAnalysisView getBatchAnalysisView() throws PartInitException {
		BatchAnalysisView bav = (BatchAnalysisView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.showView(BatchAnalysisView.ID);
		return bav;
	}

	private void message(String msg) throws IOException, PartInitException {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					getBatchAnalysisView().list.add(msg);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void message(IFile ifile, String msg) {
		try {
			message(ifile.getFullPath().toString() + " : " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object execute(ExecutionEvent event) {
		String comID = event.getCommand().getId();
		if (comID.compareTo("com.rockwellcollins.spear.ui.commands.terminateBatchAnalysis") == 0) {
			if (ba != null && ba.getState() != Thread.State.TERMINATED && stop == false) {
				stop = true;
				try {
					message("Initiating batch analysis termination ...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		} else if (comID.compareTo("com.rockwellcollins.spear.ui.commands.startBatchAnalysis") == 0) {
			if (ba != null && ba.getState() != Thread.State.TERMINATED) {
				MessageDialog dialog = new MessageDialog(null, "Batch Analysis Error", null,
						"Batch Analysis already running!", MessageDialog.ERROR, new String[] { "ok" }, 0);
				dialog.open();
				return null;
			}
			stop = false;
			ba = new Thread(() -> {
				try {
					resourceSet = injector.getInstance(XtextResourceSet.class);
					work(event);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			ba.start();
			return null;
		} else {
			throw new RuntimeException("BatchAnalysis handler received unfamiliar command : " + comID + ".");
		}
	}

	public void terminate() {
		ba.interrupt();
	}

	private Object work(ExecutionEvent event) throws ExecutionException, IOException, PartInitException {
		window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage activePage = window.getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection sselection = (IStructuredSelection) selection;
				List<Object> models = new LinkedList<>();
				for (Object o : sselection.toArray()) {
					findSpearModels(o, models);
				}

				new WorkspaceJob("Batch Analysis") {
					@Override
					public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
						activateTerminateHandler(monitor);
						for (Object o : models) {
							if (stop) { return null; }
							IFile ifile = (IFile) o;
							URI uri = URI.createPlatformResourceURI(ifile.getFullPath().toString(), true);
							Resource resource = resourceSet.getResource(uri, true);
							XtextResource xtextResource = (XtextResource) resource;
							File file = (File) xtextResource.getContents().get(0);
							if (file instanceof Definitions) { continue; }
							Specification specification = (Specification) file;
							// check the spec and imported files for errors
							if (ActionUtilities.hasErrors(specification.eResource())) {
								message(ifile, "Errors detected, skipping analysis.");
								continue;
							}
											
							runEntailment(ifile, specification, monitor);
							runConsistency(ifile, specification, monitor);
							runRealizability(ifile, specification, monitor);
						}
						
						try {
							message("Analysis complete.");
						} catch (IOException e) {
							e.printStackTrace();
						}
						deactivateTerminateHandler();
						return org.eclipse.core.runtime.Status.OK_STATUS;
					}
				}.schedule();
			}
		}
		
		refreshWorkspace();
		return null;
	}

	private void refreshWorkspace() throws ExecutionException {
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (Exception e) {
			throw new ExecutionException("Error while refreshing workspace : " + e.toString());
		}
	}

	private void runRealizability(IFile ifile, Specification specification,
			IProgressMonitor monitor) {
		if (specification.getBehaviors().size() > 0) {
			try {
				Triplet<Analysis, Document, JKindResult> triple = Analysis
						.realizability(specification, PreferencesUtil.getJKindJar(), "result");
				triple.getValue0().analyze(monitor);

				for (PropertyResult result : triple.getValue2().getPropertyResults()) {
					if (Status.VALID != result.getStatus()) {
						message(ifile, "The property " + result.getName()
								+ " failed during realizability analysis.");
					}
				}
			} catch (Exception e) {
				message(ifile, "Realizability analysis failed.");
			}
		} else {
			message(ifile, "No behaviors found, skipping realizability analysis.");
		}
	}

	private void runConsistency(IFile ifile, Specification specification,
			IProgressMonitor monitor) {
		if (true) {
			try {
				Triplet<Analysis, Document, JKindResult> triple = Analysis
						.consistency(specification, PreferencesUtil.getJKindJar(), "result");
				triple.getValue0().analyze(monitor);
				for (PropertyResult result : triple.getValue2().getPropertyResults()) {
					if (Status.VALID != result.getStatus()) {
						message(ifile, "The property " + result.getName()
								+ " failed during consistency analysis.");
					}
				}
			} catch (Exception e) {
				message(ifile, "Consistency analysis failed.");
			}
		}
	}

	private void runEntailment(IFile ifile, Specification specification, IProgressMonitor monitor) {
		if (specification.getBehaviors().size() > 0) {
			try {
				Triplet<Analysis, Document, JKindResult> triple = Analysis.entailment(specification,
						PreferencesUtil.getJKindJar(), "result");
				triple.getValue0().analyze(monitor);
				for (PropertyResult result : triple.getValue2().getPropertyResults()) {
					if (Status.VALID != result.getStatus()) {
						message(ifile, "The property " + result.getName()
								+ " failed during entailment analysis.");
					}
				}
			} catch (Exception e) {
				message(ifile, "Entailment analysis failed.");
			}
		} else {
			message(ifile, "No behaviors found, skipping entailment analysis.");
		}
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

	private void findSpearModels(Object o, List<Object> models) {
		if (o != null && o instanceof IContainer) {
			try {
				for (IResource r : ((IContainer) o).members()) {
					if (r instanceof IFile) {
						if (((IFile) r).getFileExtension().compareTo("spear") == 0) {
							models.add(r);
						}
					} else {
						findSpearModels(r, models);
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else if (o instanceof IFile) {
			System.out.println(o);
			if (((IFile) o).getFileExtension().compareTo("spear") == 0)
				models.add(o);
		}
	}
}
