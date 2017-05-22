package com.rockwellcollins.spear.ui.views;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import jkind.api.results.JKindResult;
import jkind.api.ui.results.AnalysisResultTable;
import jkind.results.layout.Layout;

/**
 * JKindResult is a helper class for performing analysis.
 */
public class SpearRealizabilityResultsView extends ViewPart {
	public static final String ID = "com.rockwellcollins.spear.ui.views.SpearRealizabilityResultsView";

	private AnalysisResultTable table;
	private SpearRealizabilityMenuListener menuListener;

	@Override
	public void createPartControl(Composite parent) {
		table = new AnalysisResultTable(parent);
		menuListener = new SpearRealizabilityMenuListener(this.getViewSite().getWorkbenchWindow(), table);
		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(menuListener);
		table.getControl().setMenu(manager.createContextMenu(table.getViewer().getTable()));
	}

	@Override
	public void setFocus() {
		table.getControl().setFocus();
	}

	public void setInput(JKindResult result, Layout layout, String title) {
		table.setInput(result);
		menuListener.setLayout(layout);
		if (title != null) {
			setPartName(title);
		} else {
			setPartName("Analysis Results");
		}
	}
}
