package com.rockwellcollins.spear.ui.views;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

import jkind.api.results.AnalysisResult;
import jkind.api.results.JRealizabilityResult;
import jkind.api.results.PropertyResult;
import jkind.api.results.ResultsUtil;
import jkind.api.results.Status;
import jkind.api.ui.results.AnalysisResultColumnViewer.Column;
import jkind.api.ui.results.AnalysisResultLabelProvider;
import jkind.results.InconsistentProperty;
import jkind.util.Util;

public class SpearAnalysisResultLabelProvider extends AnalysisResultLabelProvider {
	private List<String> observers = Collections.emptyList();

	public SpearAnalysisResultLabelProvider(Column column, ColumnViewer viewer) {
		super(column, viewer);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof PropertyResult) {
			PropertyResult pr = (PropertyResult) element;
			switch (column) {
			case PROPERTY:
				if (pr.getName().equals(Util.REALIZABLE)) {
					return pr.getParent().getName();
				} else {
					return pr.getName();
				}
			case RESULT:
				switch (pr.getStatus()) {
				case WAITING:
					return pr.getStatus().toString();
				case WORKING:
					return pr.getStatus().toString() + "..." + getProgress(pr) + " ("
							+ Util.secondsToTime(pr.getElapsed()) + ")";
				case INCONSISTENT:
					InconsistentProperty ic = (InconsistentProperty) pr.getProperty();
					return getFinalStatus(pr) + " (" + ic.getK() + " steps, " + Util.secondsToTime(pr.getElapsed())
							+ ")";
				default:
					return getFinalStatus(pr) + " (" + Util.secondsToTime(pr.getElapsed()) + ")";
				}
			}
		} else if (element instanceof JRealizabilityResult) {
			JRealizabilityResult result = (JRealizabilityResult) element;
			return getText(result.getPropertyResult());
		} else if (element instanceof AnalysisResult) {
			AnalysisResult result = (AnalysisResult) element;
			switch (column) {
			case PROPERTY:
				return result.getName();
			case RESULT:
				return ResultsUtil.getMultiStatus(result).toString();
			}
		}

		return "";
	}

	protected static final Image OBSERVED_IMAGE = spearLoadImage("/icons/spreadsheet.png");

	protected static Image spearLoadImage(String filename) {
		try (InputStream stream = SpearAnalysisResultLabelProvider.class.getResourceAsStream(filename)) {
			return new Image(null, new ImageData(stream));
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public Image getImage(Object element) {
		if (column == Column.PROPERTY && element instanceof PropertyResult) {
			PropertyResult pr = (PropertyResult) element;
			return getStatusImage(pr.getStatus(), pr.getName());
		} else {
			return super.getImage(element);
		}
	}

	protected Image getStatusImage(Status status, String name) {
		if (status == Status.VALID && observers.contains(name)) {
			return OBSERVED_IMAGE;
		} else {
			return super.getStatusImage(status);
		}
	}

	public void setObservers(List<String> observers) {
		this.observers = observers;
	}
}
