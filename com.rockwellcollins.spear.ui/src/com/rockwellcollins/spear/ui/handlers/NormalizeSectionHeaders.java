package com.rockwellcollins.spear.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.rockwellcollins.spear.Specification;

public class NormalizeSectionHeaders extends AbstractHandler {

  private IWorkbenchWindow window;

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
    this.window = HandlerUtil.getActiveWorkbenchWindow(event);
    TextSelection ts = (TextSelection) xtextEditor.getSelectionProvider().getSelection();

    xtextEditor.getDocument().modify(resource -> {
      EObject e = new EObjectAtOffsetHelper().resolveContainedElementAt(resource, ts.getOffset());

      Specification s = EcoreUtil2.getContainerOfType(e, Specification.class);
      if (s == null) {
        MessageDialog.openError(window.getShell(), "Specification Not Found",
            "Please place the cursor inside a valid specification.");
        return null;
      }

      String set1 = "Assumptions/Requirements/Properties";
      String set2 = "Assumptions/DerivedRequirements/Requirements";
      String set3 = "Assumptions/Implementation/Guarantees";

      MessageDialog dialog = new MessageDialog(window.getShell(), "Choose Heading Set", null,
          "Please Choose a Set of Section Headings for your specification.", MessageDialog.QUESTION,
          new String[] { set1, set2, set3 }, 0);

      int result = dialog.open();

      if (result == 1) {
        s.setAssumptionsKeyword("Assumptions");
        s.setRequirementsKeyword("DerivedRequirements");
        s.setBehaviorsKeyword("Requirements");
      } else if (result == 2) {
        s.setAssumptionsKeyword("Assumptions");
        s.setRequirementsKeyword("Implementation");
        s.setBehaviorsKeyword("Guarantees");
      } else {
        s.setAssumptionsKeyword("Assumptions");
        s.setRequirementsKeyword("Requirements");
        s.setBehaviorsKeyword("Properties");
      }

      return null;
    });
    return null;
  }
}
