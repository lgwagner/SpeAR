package com.rockwellcollins.spear.translate.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.master.PProgram;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;
import com.rockwellcollins.spear.translate.views.SpearResultsView;
import com.rockwellcollins.spear.ui.preferences.PreferencesUtil;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.lustre.Program;
import jkind.results.layout.Layout;
import jkind.results.layout.NodeLayout;

public class AnalyzePattern extends AbstractHandler {

	private IWorkbenchWindow window;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
		this.window = HandlerUtil.getActiveWorkbenchWindow(event);
		TextSelection ts = (TextSelection) xtextEditor.getSelectionProvider().getSelection();

		xtextEditor.getDocument().readOnly(resource -> {
			EObject e = new EObjectAtOffsetHelper().resolveContainedElementAt(resource, ts.getOffset());
			
			Pattern p = EcoreUtil2.getContainerOfType(e, Pattern.class);
			if(p == null) {
				System.out.println("No patterns found");
				return null;
			}
			
			analyzePattern(p);
			return null;
		});
		return null;
	}

	private void analyzePattern(Pattern p) {
		PatternDocument document = new PatternDocument(p);

		try {
			@SuppressWarnings("unused")
			Map<EObject,Map<String,String>> remapped = PerformTransforms.apply(document);
		} catch (Exception e1) {
			System.err.println("Unexpected error transforming PatternDocument for analysis.");
			e1.printStackTrace();
		} 
		
		PProgram pprogram = new PProgram(document);
		Program program = pprogram.toLustre();
		
		JKindApi api = (JKindApi) PreferencesUtil.getKindApi();
		JKindResult result = new JKindResult("result");
		for(String prop : program.getMainNode().properties) {
			result.addProperty(prop);
		}
		IProgressMonitor monitor = new NullProgressMonitor();
		String nicename = "Pattern Analysis: " + p.getName();
		showView(result, new NodeLayout(program.getMainNode()), nicename);
		
		try {
			api.execute(program, result, monitor);
		} catch (Exception e) {
			System.out.println(result.getText());
			throw e;
		}		
	}
	
	private void showView(final JKindResult result, final Layout layout, String title) {
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					SpearResultsView page = (SpearResultsView) window.getActivePage().showView(SpearResultsView.ID);
					page.setInput(result, layout, title);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
