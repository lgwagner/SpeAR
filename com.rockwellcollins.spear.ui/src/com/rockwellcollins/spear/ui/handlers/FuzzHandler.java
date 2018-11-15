package com.rockwellcollins.spear.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
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
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.analysis.FuzzAnalysis;
import com.rockwellcollins.spear.ui.actions.ActionUtilities;
import com.rockwellcollins.ui.internal.SpearActivator;

public class FuzzHandler extends AbstractHandler {

	private IWorkbenchWindow window;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor editor = (XtextEditor) EditorUtils.getActiveXtextEditor();
		
		this.window = HandlerUtil.getActiveWorkbenchWindow(event);
		TextSelection ts = (TextSelection) editor.getSelectionProvider().getSelection();
		
		editor.getDocument().readOnly(resource -> {
			EObject e = new EObjectAtOffsetHelper().resolveContainedElementAt(resource, ts.getOffset());

			Specification s = EcoreUtil2.getContainerOfType(e, Specification.class);
			if (s == null) {
				MessageDialog.openError(window.getShell(), "Specification Not Found",
						"Please place the cursor inside a valid specification.");
				return null;
			}

			if (hasErrors(resource)) {
				MessageDialog.openError(window.getShell(), "Error", "Pattern contains errors.");
				return null;
			}

			FuzzAnalysis fuzz = new FuzzAnalysis(s);
			fuzz.build();
			ActionUtilities.refresh();
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
}
