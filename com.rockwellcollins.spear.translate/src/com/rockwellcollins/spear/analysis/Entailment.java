package com.rockwellcollins.spear.analysis;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.api.results.Renaming;
import jkind.lustre.Program;

public class Entailment implements Analysis {

	public Document document;
	public JKindApi api;
	public JKindResult result;
	
	public Program program;
	
	public Entailment(Specification s, String jarPath) {
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
		program = document.getLogicalEntailment();
		if(PreferencesUtil.printFinalLustre()) {
			document.print(program);
		}
		
		Renaming renaming = document.getRenaming();
		Specification s = (Specification) document.main;
		List<Boolean> invert = s.getBehaviors().stream().map(Utilities::invert).collect(Collectors.toList());
		
		// if IVC is enabled we have one more property to account for
		if (PreferencesUtil.getEnableIVCDuringEntailment()) {
			api.setIvcReduction();
			invert.add(false);
		}
		
		result = new JKindResult("Entailment", program.getMainNode().properties, invert, renaming);
	}
	
	public void analyze(IProgressMonitor m) {
		api.execute(program, result, m);
	}

	@Override
	public JKindResult getResult() {
		return result;
	}
}
