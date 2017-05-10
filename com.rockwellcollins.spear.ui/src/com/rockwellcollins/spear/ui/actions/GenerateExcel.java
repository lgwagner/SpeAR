package com.rockwellcollins.spear.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.rockwellcollins.SpearInjectorUtil;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.excel.AltSpearDocument;
import com.rockwellcollins.spear.translate.excel.MakeExcel;
import com.rockwellcollins.ui.internal.SpearActivator;

public class GenerateExcel
    implements IWorkbenchWindowActionDelegate {

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

        if (hasErrors(specification.eResource())) {
          MessageDialog.openError(window.getShell(), "Error", "Specification contains errors.");
          return null;
        }

        AltSpearDocument spearDoc = AltSpearDocument.create(specification);

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

        // create the generated folder
        URI folderURI = ActionUtilities.createFolder(state.getURI(), "generated");
        ActionUtilities.makeFolder(root.getFolder(new Path(folderURI.toPlatformString(true))));

        // create the lustre file
        String filename = ActionUtilities.getGeneratedFile(state.getURI(), "xls");
        URI excelURI = ActionUtilities.createURI(folderURI, filename);
        IResource finalResource = root.getFile(new Path(excelURI.toPlatformString(true)));

        try {
          MakeExcel.toExcel(spearDoc, finalResource.getLocation().toFile());
        } catch (Exception e) {
          MessageDialog.openError(window.getShell(), "Unable to export to spreadsheet.", e.getMessage());
          e.printStackTrace();
        }

        // refresh the workspace
        root.refreshLocal(IResource.DEPTH_INFINITE, null);
        return null;
      }
    });
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
