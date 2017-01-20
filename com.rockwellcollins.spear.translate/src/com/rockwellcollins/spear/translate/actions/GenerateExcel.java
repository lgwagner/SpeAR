package com.rockwellcollins.spear.translate.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.rockwellcollins.SpearInjectorUtil;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.ui.internal.SpearActivator;

public class GenerateExcel implements IWorkbenchWindowActionDelegate {
	
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

		doc.readOnly(new IUnitOfWork<Void, XtextResource>() {

			@Override
			public java.lang.Void exec(XtextResource state) throws Exception {
				Specification specification = (Specification) state.getContents().get(0);

				if (ActionUtilities.hasErrors(specification.eResource())) {
					MessageDialog.openError(window.getShell(), "Error", "Specification contains errors.");
					return null;
				}
				
				Specification workingCopy = EcoreUtil2.copy(specification);
				// This is where you will create the URI for the excel file.
				URI excelURI = ActionUtilities.createURI(state.getURI(), "", "xls");
				
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IResource excelResource = root.getFile(new Path(excelURI.toPlatformString(true)));

				//This is where you will create the excel file.				
				//MakeExcel.toPDF(workingCopy,pdfResource.getLocation().toFile());
				
				//Turn this off / remove this when you want to test your code.
				MessageDialog.openError(window.getShell(), "Feature Unsupported", "This feature is not yet supported.");

				// refresh the workspace
				root.refreshLocal(IResource.DEPTH_INFINITE, null);
				return null;
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
