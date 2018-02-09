package com.rockwellcollins.spear.analysis;

import org.eclipse.core.runtime.IProgressMonitor;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.api.results.Renaming;
import jkind.lustre.Program;

public class Consistency implements Analysis {

	public Document document;
	public JKindApi api;
	public JKindResult result;
	
	public Program program;
	
	public Consistency(Specification s, String jarPath) {
		this.setApi(jarPath);
		this.document=new Document(s);
		build();
	}
	
	public void setApi(String jarPath) {
		this.api=new JKindApi();
		api.setJKindJar(jarPath);
		PreferencesUtil.configureJKindApi(api);
	}
	
	public void build() {
		program = document.getLogicalConsistency();
		
		if(PreferencesUtil.printFinalLustre()) {
			document.print(program);
		}
		
		Renaming renaming = document.getRenaming();
		result = new JKindResult("Consistency", renaming);
	}
	
	public void analyze(IProgressMonitor m) {
		api.execute(program, result, m);
	}

	@Override
	public JKindResult getResult() {
		return result;
	}
}
