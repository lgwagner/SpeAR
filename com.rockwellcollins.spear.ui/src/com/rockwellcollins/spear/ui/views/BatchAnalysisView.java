package com.rockwellcollins.spear.ui.views;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class BatchAnalysisView extends ViewPart {

	public static final String ID = "com.rockwellcollins.spear.ui.views.BatchAnalysisView";

	public List list;

	private Action stopAnalysisAction;

	public void createPartControl(Composite parent) {

		parent.setLayout(new GridLayout());

		list = new List(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);

		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		createActions();
		createToolbar();

	}

	/**
	 * Create toolbar.
	 */
	private void createToolbar() {
		// IToolBarManager mgr =
		// getViewSite().getActionBars().getToolBarManager();
		// mgr.add(stopAnalysisAction);
	}

	public void createActions() {
		/*
		 * stopAnalysisAction = new Action("Stop Analysis") { public void run()
		 * { IHandlerService handlerService = (IHandlerService) PlatformUI
		 * .getWorkbench().getActiveWorkbenchWindow().getService(
		 * IHandlerService. class); try { Event e = new Event();
		 * e.data="String"; handlerService.executeCommand(
		 * "com.rockwellcollins.spear.ui.commands.startBatchAnalysis",e); }
		 * catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } }; Bundle bundle =
		 * FrameworkUtil.getBundle(BatchAnalysisView.class); URL url =
		 * FileLocator.find(bundle, new Path("icons/terminate.png"), null);
		 * ImageDescriptor imageDcr = ImageDescriptor.createFromURL(url);
		 * stopAnalysisAction.setImageDescriptor(imageDcr);
		 */
	}

	public void setFocus() {
		list.setFocus();
	}
}