package com.rockwellcollins.spear.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;

public class TerminateHandler extends AbstractHandler {
	private final IProgressMonitor monitor;

	// Needed when TerminateHandler is instantiated by plugin.xml instead of
	// code
	public TerminateHandler() {
		this.monitor = null;
	}

	public TerminateHandler(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public Object execute(ExecutionEvent event) {
		if (monitor != null) {
			monitor.setCanceled(true);
		}
		return null;
	}
}
