package com.rockwellcollins.spear.ui.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;

import jkind.api.results.JKindResult;
import jkind.api.results.PropertyResult;
import jkind.results.ValidProperty;

public class SpearTraceabilityMatrixView extends ViewPart {
  public static final String ID = "com.rockwellcollins.spear.ui.views.SpearTraceabilityMatrixView";

  protected Composite        composite;
  protected Table            table;

  @Override
  public void createPartControl(Composite parent) {
    this.composite = new Composite(parent, SWT.None);
    this.composite.setLayout(new FillLayout());
  }

  public void setFocus() {
    if (table != null) {
      table.setFocus();
    }
  }

  public void setInput(JKindResult result, List<String> requirements) {
    for (Control control : composite.getChildren()) {
      control.dispose();
    }
    table = new Table(composite, SWT.FULL_SELECTION);

    createColumns(requirements);
    createContent(result, requirements);
    packColumns();

    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    composite.layout(true);
  }

  private void createColumns(List<String> reqs) {
    TableColumn tc = new TableColumn(table, SWT.CENTER);
    tc.setText("");
    tc.setWidth(10);

    for (String req : reqs) {
      tc = new TableColumn(table, SWT.CENTER);
      tc.setWidth(10);
      tc.setText(req);
    }
  }

  private void createContent(JKindResult result, List<String> reqs) {
    for (PropertyResult pr : result.getPropertyResults()) {
      if (pr.getProperty() instanceof ValidProperty) {
        ValidProperty vp = (ValidProperty) pr.getProperty();
        Set<String> ivc = vp.getIvc();
        if (ivc != null && !ivc.isEmpty()) {
          createRow(vp.getName(), ivc, reqs);
        }
      }
    }
  }

  private void createRow(String name, Set<String> ivc, List<String> reqs) {
    List<String> row = new ArrayList<>();
    row.add(name);
    for (String req : reqs) {
      if (ivc.contains(req)) {
        row.add("X");
      } else {
        row.add(" ");
      }
    }

    TableItem ti = new TableItem(table, SWT.None);
    ti.setText(row.toArray(new String[row.size()]));
  }

  private void packColumns() {
    for (int i = 0; i < table.getColumnCount(); i++) {
      table.getColumn(i).pack();
    }
  }
}