package com.rockwellcollins.spear.translate.actions;

import java.io.FileWriter;
import java.nio.file.Files;

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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.rockwellcollins.SpearInjectorUtil;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.graphical.GenerateDot;
import com.rockwellcollins.ui.internal.SpearActivator;

public class GenerateGraph implements IWorkbenchWindowActionDelegate {

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

				if (ActionUtilities.hasErrors(specification.eResource())) {
					MessageDialog.openError(window.getShell(), "Error", "Specification contains errors.");
					return null;
				}
				
				if (!ActionUtilities.checkForDot()) {
					MessageDialog.openError(window.getShell(), "Error", "Unable to find GraphViz installation. \n"
							+ "GraphViz can be downloaded at http://www.graphviz.org");
					return null;					
				}
				
				//Set the runtime options
				SpearRuntimeOptions.setRuntimeOptions();
				
				String result = GenerateDot.generateDot(specification);
				URI pngURI = ActionUtilities.createURI(state.getURI(), "", "png");
				
				java.nio.file.Path dotFile = Files.createTempFile("spear_graphical", ".dot");

				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IResource pdfFile = root.getFile(new Path(pngURI.toPlatformString(true)));

				try {
					FileWriter writer = new FileWriter(dotFile.toFile());
					writer.write(result);
					writer.flush();
					writer.close();
				} catch (Exception e) {
					MessageDialog.openError(window.getShell(), "Error", "Unable to create dot file.");
					e.printStackTrace();
					return null;
				}
				
				try {
					//this string needs to be a filesystem string for DOT to work correctly on it.
					String fileSystemString = pdfFile.getLocation().toFile().toString();
					ProcessBuilder pb = new ProcessBuilder("dot","-Tpng","-o",fileSystemString,dotFile.toString());
					pb.start().waitFor();
					pb = null;
				} catch (Exception e) {
					MessageDialog.openError(window.getShell(), "Error", "Unable to process dot file.");
					e.printStackTrace();
					return null;
				}

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
