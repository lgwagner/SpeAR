package com.rockwellcollins.spear.translate.analysis;

import org.eclipse.core.runtime.IProgressMonitor;

import jkind.api.results.JKindResult;

public interface Analysis {
	
	public void analyze(IProgressMonitor m);
	public JKindResult getResult();
	
}
