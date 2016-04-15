package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.handlers.PatternDeps;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.utilities.PLTL;

import jkind.lustre.Node;
import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SPatternProgram {
	
	public Pattern main;
	public NameMap map;
	
	private List<SFile> files = new ArrayList<>();
	
	public SPatternProgram(Pattern p) {
		map = new NameMap();
		this.main=p;
		
		PatternDeps deps = new PatternDeps(p);
		
		List<File> files = new ArrayList<>(deps.files);
		for(int i=files.size()-1; i>= 0; i--) {
			File current = files.get(i);
			SFile sf = SFile.build(current, map);
			this.files.add(sf);
		}
	}
	
	public Program toLustre() {
		ProgramBuilder program = new ProgramBuilder();
		
		for(Node n : PLTL.getPLTL()) {
			program.addNode(n);
		}
		
		for(SFile sf : map.fileMapping.values()) {
			program.addTypes(STypeDef.toLustre(sf.typedefs, map));
			program.addConstants(SConstant.toLustre(sf.constants, map));
			program.addNodes(SPattern.toLustre(sf.patterns, map));
		}
		program.setMain(map.lookup(main));
		return program.build();
	}
}
