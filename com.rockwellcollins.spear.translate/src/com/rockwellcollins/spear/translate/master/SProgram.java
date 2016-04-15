package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.translate.transformations.SpearDocument;
import com.rockwellcollins.spear.utilities.PLTL;

import jkind.lustre.Node;
import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SProgram {

	public static SProgram build(SpearDocument doc) {
		return new SProgram(doc);
	}
	
	public SFile main;
	public NameMap map;
	
	public SProgram(SpearDocument document) {
		//initialize the map
		map = new NameMap();
		
		//copy the files from the SpeAR document
		List<File> files = new ArrayList<>(document.files);
		
		//this is a gross way to traverse the list in reverse order, but so be it.
		for(int i=files.size()-1; i>=0; i--) {
			File f = files.get(i);
			SFile sfile = SFile.build(f, map);
			if(f.getName().equals(document.mainName)) {
				this.main = sfile;
			}	
		}
	}
	
	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder();
		
		for(Node n : PLTL.getPLTL()) {
			program.addNode(n);
		}
		
		for(SFile sf : map.fileMapping.values()) {
			program.addTypes(STypeDef.toLustre(sf.typedefs, map));
			program.addConstants(SConstant.toLustre(sf.constants, map));
			program.addNodes(SPattern.toLustre(sf.patterns, map));
			
			if (sf instanceof SSpecification) {
				SSpecification spec = (SSpecification) sf;
				
				if(this.main.equals(spec)) {
					program.addNode(spec.getLogicalEntailmentMain(map));	
				} else {
					program.addNode(spec.getLogicalEntailmentCalled(map));
				}
			}
		}
		program.setMain(main.name);
		return program.build();
	}
	
	public Program getLogicalConsistency() {
		ProgramBuilder program = new ProgramBuilder();
		
		for(Node n : PLTL.getPLTL()) {
			program.addNode(n);
		}
		
		for(SFile sf : map.fileMapping.values()) {
			program.addTypes(STypeDef.toLustre(sf.typedefs, map));
			program.addConstants(SConstant.toLustre(sf.constants, map));
			program.addNodes(SPattern.toLustre(sf.patterns, map));
			
			if (sf instanceof SSpecification) {
				SSpecification spec = (SSpecification) sf;
				
				if(this.main.equals(spec)) {
					program.addNode(spec.getLogicalConsistencyMain(map));	
				} else {
					program.addNode(spec.getLogicalConsistencyCalled(map));
				}
			}
		}
		program.setMain(main.name);
		return program.build();
	}
}
