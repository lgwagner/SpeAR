package com.rockwellcollins.spear.translate.master;

import java.util.List;

import com.rockwellcollins.spear.translate.naming.PNameMap;
import com.rockwellcollins.spear.translate.transformations.PatternDocument;

import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class PProgram {

	public String main;
	public List<STypeDef> typedefs;
	public List<SConstant> constants;
	public List<SPattern> patterns;
	
	public PNameMap map;

	public PProgram(PatternDocument doc) {
		//create the map
		map = PNameMap.newMap();
		
		//not going to rename the main name. it will be first in, no conflicts.
		this.main = doc.mainName;
		
		//add the definitions first
		typedefs = STypeDef.build(doc.typedefs, map);
		constants = SConstant.build(doc.constants, map);
		
		@SuppressWarnings("unused")
		List<String> renamed = SPattern.addNames(doc.patterns, map);
		
		//then add the patterns (because they have local scope that could conflict with global scope)
		patterns = SPattern.build(doc.patterns, map);
	}
	
	public Program toLustre() {
		ProgramBuilder program = new ProgramBuilder();
		program.addTypes(STypeDef.toLustre(typedefs, map));
		program.addConstants(SConstant.toLustre(constants, map));
		program.addNodes(SPattern.toLustre(patterns));
		program.setMain(main);
		return program.build();
	}
}
