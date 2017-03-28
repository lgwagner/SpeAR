package com.rockwellcollins.spear.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class GeneratePDF implements IWorkbenchWindowActionDelegate {
	
	private IWorkbenchWindow window;

	@Override
	public void run(IAction action) {
		
		MessageDialog.openError(window.getShell(), "Not Supported", "PDF Output is not yet supported.");
		return;
		
//		SpearInjectorUtil.setInjector(SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR));
//
//		IEditorPart editor = window.getActivePage().getActiveEditor();
//		if (!(editor instanceof XtextEditor)) {
//			MessageDialog.openError(window.getShell(), "Error", "Only SpeAR files can be analyzed.");
//			return;
//		}
//
//		XtextEditor xte = (XtextEditor) editor;
//		IXtextDocument doc = xte.getDocument();
//
//		doc.readOnly(new IUnitOfWork<Void, XtextResource>() {
//
//			@Override
//			public java.lang.Void exec(XtextResource state) throws Exception {
//				Specification specification = (Specification) state.getContents().get(0);
//
//				if (ActionUtilities.hasErrors(specification.eResource())) {
//					MessageDialog.openError(window.getShell(), "Error", "Specification contains errors.");
//					return null;
//				}
//				
//				Specification workingCopy = EcoreUtil2.copy(specification);
//				URI pdfURI = ActionUtilities.createURI(state.getURI(), "", "pdf");
//				
//				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//				IResource pdfResource = root.getFile(new Path(pdfURI.toPlatformString(true)));
//
//				//This is not yet supported so instead we'll comment it out.
//				MakePDF.toPDF(workingCopy,pdfResource.getLocation().toFile());
//
//				//Instead we throw this dialog and null out;
//				MessageDialog.openError(window.getShell(), "Unsupported Feature", "This feature is not yet supported.");
//				
//				// refresh the workspace
//				root.refreshLocal(IResource.DEPTH_INFINITE, null);
//				return null;
//			}
//		});
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
