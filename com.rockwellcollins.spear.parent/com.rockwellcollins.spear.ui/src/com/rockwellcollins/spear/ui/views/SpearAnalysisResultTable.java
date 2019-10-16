package com.rockwellcollins.spear.ui.views;

import java.util.List;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jkind.api.ui.results.AnalysisResultColumnViewer;
import jkind.api.ui.results.AnalysisResultLabelProvider;

public class SpearAnalysisResultTable extends AnalysisResultColumnViewer {
	private TableViewer tableViewer;
	private SpearAnalysisResultLabelProvider propertyLabelProvider;

	public SpearAnalysisResultTable(Composite parent) {
		super(parent);
	}

	@Override
	protected ColumnViewer createViewer() {
		tableViewer = new TableViewer(composite, SWT.FULL_SELECTION);
		tableViewer.getTable().setHeaderVisible(true);
		createColumns();
		return tableViewer;
	}

	private void createColumns() {
		TableViewerColumn propertyColumn = new TableViewerColumn(tableViewer, SWT.None);
		propertyColumn.getColumn().setText("Property");
		propertyColumn.getColumn().setWidth(400);
		propertyLabelProvider = new SpearAnalysisResultLabelProvider(Column.PROPERTY, tableViewer);
		propertyColumn.setLabelProvider(propertyLabelProvider);

		TableViewerColumn resultColumn = new TableViewerColumn(tableViewer, SWT.None);
		resultColumn.getColumn().setText("Result");
		resultColumn.setLabelProvider(new AnalysisResultLabelProvider(Column.RESULT));

		TableColumnLayout layout = new TableColumnLayout();
		composite.setLayout(layout);
		layout.setColumnData(propertyColumn.getColumn(), new ColumnWeightData(2));
		layout.setColumnData(resultColumn.getColumn(), new ColumnWeightData(1));
	}

	@Override
	public TableViewer getViewer() {
		return tableViewer;
	}

	public void setObservers(List<String> observers) {
		propertyLabelProvider.setObservers(observers);
	}
}
