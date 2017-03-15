package com.rockwellcollins.spear.translate.views;

import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import jkind.api.results.JKindResult;
import jkind.results.layout.Layout;

/**
 * JKindResult is a helper class for performing analysis.
 */
public class SpearEntailmentResultsView extends ViewPart {
	public static final String ID = "com.rockwellcollins.spear.translate.views.SpearEntailmentResultsView";

	private SpearAnalysisResultTable table;
	private SpearEntailmentMenuListener menuListener;

	@Override
	public void createPartControl(Composite parent) {
		table = new SpearAnalysisResultTable(parent);
		menuListener = new SpearEntailmentMenuListener(this.getViewSite().getWorkbenchWindow(), table);
		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(menuListener);
		table.getControl().setMenu(manager.createContextMenu(table.getViewer().getTable()));
	}

	@Override
	public void setFocus() {
		table.getControl().setFocus();
	}

	public void setInput(JKindResult result, Layout layout, List<String> requirements, List<String> observers) {
		table.setInput(result);
		table.setObservers(observers);
		menuListener.setLayout(layout);
		menuListener.setRequirements(requirements);
		setPartName("Analysis Results");
	}
}
