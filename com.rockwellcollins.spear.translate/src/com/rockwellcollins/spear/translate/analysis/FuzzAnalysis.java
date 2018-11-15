package com.rockwellcollins.spear.translate.analysis;

import org.eclipse.core.runtime.IProgressMonitor;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.intermediate.Document;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.lustre.Program;

public class FuzzAnalysis implements Analysis {

	public Document document;
	public JKindApi api;
	public JKindResult result;
	
	public Program program;
	
	public FuzzAnalysis(Specification s) {
		document = new Document(s);
	}
	
	public void build() {
		program = document.getFuzzingAnalysis();
		document.print(program);
	}
	
	@Override
	public void analyze(IProgressMonitor m) {}

	@Override
	public JKindResult getResult() {
		return null;
	}

}
