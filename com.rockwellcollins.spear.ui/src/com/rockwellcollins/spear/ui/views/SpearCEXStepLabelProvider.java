package com.rockwellcollins.spear.ui.views;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import jkind.api.ui.counterexample.CategoryHeader;
import jkind.api.ui.counterexample.SignalGroup;
import jkind.lustre.values.RealValue;
import jkind.lustre.values.Value;

public class SpearCEXStepLabelProvider extends ColumnLabelProvider {
	private final int step;

	public SpearCEXStepLabelProvider(int step) {
		this.step = step;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof SignalGroup) {
			SignalGroup group = (SignalGroup) element;
			if (group.isSingleton()) {
				Value value = group.getSignals().get(0).getValue(step);
				if (value == null) {
					return "";
				} else if (value instanceof RealValue) {
					RealValue rv = (RealValue) value;
					return String.valueOf(rv.value.doubleValue());
				} else {
					return value.toString();
				}
			}
		}

		return "";
	}

	@Override
	public Color getForeground(Object element) {
		if (element instanceof CategoryHeader) {
			return Display.getCurrent().getSystemColor(CategoryHeader.FOREGROUND_COLOR);
		} else if (element instanceof SignalGroup && step > 0) {
			SignalGroup group = (SignalGroup) element;
			if (group.isSingleton()) {
				Value prev = group.getSignals().get(0).getValue(step - 1);
				Value curr = group.getSignals().get(0).getValue(step);
				if (prev != null && prev.equals(curr)) {
					return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
				}
			}
		}

		return null;
	}

	@Override
	public Color getBackground(Object element) {
		if (element instanceof CategoryHeader) {
			return Display.getCurrent().getSystemColor(CategoryHeader.BACKGROUND_COLOR);
		}

		return null;
	}
}
