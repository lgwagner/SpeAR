package com.rockwellcollins.spear.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import jkind.results.Counterexample;
import jkind.results.layout.Layout;

/**
 * JKindCounterexampleView is a view.
 */
public class SpearCounterexampleView extends ViewPart {
  public static final String ID = "com.rockwellcollins.spear.ui.views.SpearCounterexampleView";

  private SpearCEXTreeView   tree;

  @Override
  public void createPartControl(Composite parent) {
    tree = new SpearCEXTreeView(parent);
  }

  @Override
  public void setFocus() {
    tree.setFocus();
  }

  public void setInput(Counterexample cex, Layout layout) {
    tree.setInput(cex, layout);
  }
}
