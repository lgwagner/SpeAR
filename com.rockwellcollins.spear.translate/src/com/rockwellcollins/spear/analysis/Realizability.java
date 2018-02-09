package com.rockwellcollins.spear.analysis;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;

import jkind.api.JRealizabilityApi;
import jkind.api.results.JKindResult;
import jkind.api.results.JRealizabilityResult;
import jkind.api.results.Renaming;
import jkind.lustre.Program;

public class Realizability implements Analysis {

	public Document document;
	public JRealizabilityApi api;
	public JRealizabilityResult result;
	
	public Program program;
	
	public Realizability(Specification s, String jarPath) {
		this.setApi(jarPath);
		this.document=new Document(s);
		build();
	}
	
	public void setApi(String jarPath) {
		this.api=new JRealizabilityApi();
		api.setJKindJar(jarPath);
		PreferencesUtil.configureRealizabilityApi(api);
	}
	
	public boolean containsUnspecifiedConstants() {
		List<Constant> constants = document.files.stream().map(file -> file.getConstants())
				.collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toList());
		List<Constant> unspecified = constants.stream().filter(c -> c.getExpr() == null)
				.collect(Collectors.toList());
		
		return unspecified.size() > 0;
	}

	
	public void build() {
		program = document.getRealizability();
		if(PreferencesUtil.printFinalLustre()) {
			document.print(program);
		}
		
		Renaming renaming = document.getRenaming();
		result = new JRealizabilityResult("Realizability", renaming);
	}
	
	public void analyze(IProgressMonitor m) {
		api.execute(program, result, m);
	}

	@Override
	public JKindResult getResult() {
		return result;
	}
}
