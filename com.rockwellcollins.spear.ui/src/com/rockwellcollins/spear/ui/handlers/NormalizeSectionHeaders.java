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
			if(s == null) {
				MessageDialog.openError(window.getShell(), "Specification Not Found", "Please place the cursor inside a valid specification	.");
				return null;
			}
			
			s.setAssumptionsKeyword("Assumptions");
			s.setRequirementsKeyword("Requirements");
			s.setBehaviorsKeyword("Properties");
			return null;
		});
		return null;
	}
}
