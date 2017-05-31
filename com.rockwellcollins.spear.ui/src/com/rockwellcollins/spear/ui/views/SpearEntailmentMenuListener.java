package com.rockwellcollins.spear.ui.views;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.program.Program;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

import jkind.api.results.JKindResult;
import jkind.api.results.PropertyResult;
import jkind.results.Counterexample;
import jkind.results.InvalidProperty;
import jkind.results.Property;
import jkind.results.UnknownProperty;
import jkind.results.ValidProperty;
import jkind.results.layout.Layout;

/**
 * JKindMenuListener is a class necessary to display the Analysis pulldown menu.
 */
public class SpearEntailmentMenuListener implements IMenuListener {
	private final SpearAnalysisResultTable columnViewer;
	private Layout layout;
	private IWorkbenchWindow window;
	private List<String> requirements;

	public SpearEntailmentMenuListener(IWorkbenchWindow window, SpearAnalysisResultTable columnViewer) {
		this.window = window;
		this.columnViewer = columnViewer;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
		IStructuredSelection selection = (IStructuredSelection) columnViewer.getViewer().getSelection();
		if (!selection.isEmpty()) {
			PropertyResult result = (PropertyResult) selection.getFirstElement();
			addLinkedMenus(manager, result);
		}
	}

	private void addLinkedMenus(IMenuManager manager, PropertyResult result) {
		addViewCounterexampleMenu(manager, result);
		addViewTraceabilityMatrix(manager, result);
	}

	private void addViewCounterexampleMenu(IMenuManager manager, PropertyResult result) {
		final Counterexample cex = getCounterexample(result);
		if (cex == null) {
			return;
		}

		boolean inductive = result.getProperty() instanceof UnknownProperty;

		String text = "View " + (inductive ? "Inductive " : "") + "Counterexample in ";
		manager.add(new Action(text + "spreadsheet") {
			@Override
			public void run() {
				viewCexSpreadsheet(cex, layout);
			}
		});

		manager.add(new Action(text + "Eclipse") {
			@Override
			public void run() {
				viewCexEclipse(cex, layout);
			}
		});
	}

	private void addViewTraceabilityMatrix(IMenuManager manager, PropertyResult result) {
		final Set<String> support = getSupport(result);
		if (support == null || support.size() == 0) {
			return;
		}

		manager.add(new Action("View Traceability Matrix") {
			@Override
			public void run() {
				showSpearTraceabilityMatrixView((JKindResult) columnViewer.getViewer().getInput());
			}
		});
	}

	private void viewCexEclipse(Counterexample cex, Layout layout) {
		try {
			SpearCounterexampleView cexView = (SpearCounterexampleView) window.getActivePage()
					.showView(SpearCounterexampleView.ID);
			cexView.setInput(cex, layout);
			cexView.setFocus();
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	private void viewCexSpreadsheet(Counterexample cex, Layout layout) {
		try {
			File file = File.createTempFile("cex", ".xls");
			cex.toExcel(file, layout);
			Program.launch(file.toString());
		} catch (IOException e) {
			MessageDialog.openError(columnViewer.getControl().getShell(), "Error opening spreadsheet", e.getMessage());
			e.printStackTrace();
		}
	}

	private void showSpearTraceabilityMatrixView(JKindResult result) {
		window.getShell().getDisplay().asyncExec(() -> {
			try {
				SpearTraceabilityMatrixView page = (SpearTraceabilityMatrixView) window.getActivePage()
						.showView(SpearTraceabilityMatrixView.ID);
				page.setInput(result, requirements);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		});
	}

	private static Set<String> getSupport(PropertyResult result) {
		Property prop = result.getProperty();
		if (prop instanceof ValidProperty) {
			ValidProperty valid = (ValidProperty) prop;
			return valid.getIvc();
		}
		return null;
	}

	private static Counterexample getCounterexample(PropertyResult result) {
		Property prop = result.getProperty();
		if (prop instanceof InvalidProperty) {
			return ((InvalidProperty) prop).getCounterexample();
		} else if (prop instanceof UnknownProperty) {
			return ((UnknownProperty) prop).getInductiveCounterexample();
		} else {
			return null;
		}
	}

	public void setRequirements(List<String> requirements) {
		this.requirements = requirements;
	}
}