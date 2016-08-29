package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.translate.naming.PNameMap;

public class SProgram {

	public static SProgram build(SpearDocument doc) {
		return new SProgram(doc);
	}
	
	public PNameMap map;
	public String main;
	public List<STypeDef> typedefs = new ArrayList<>();
	public List<SConstant> constants = new ArrayList<>();
	public List<SPattern> patterns = new ArrayList<>();
	public List<SSpecification> specifications = new ArrayList<>();
	
	public SProgram(SpearDocument document) {
		//initialize the program's global map
		map = PNameMap.newMap();

		//get the names of the typedefs, constants and process them
		typedefs.addAll(STypeDef.build(document.typedefs, map));
		constants.addAll(SConstant.build(document.constants, map));
		
		//just get the names of these because we need to have them in the 
		//namespace before we process them.
		@SuppressWarnings("unused")
		List<String> renamedPatterns = SPattern.addNames(document.patterns, map);
		@SuppressWarnings("unused")
		List<String> renamedSpecifications = SSpecification.addNames(document.specifications, map);
		
		patterns.addAll(SPattern.build(document.patterns, map));
		specifications.addAll(SSpecification.build(document.specifications, map));
	}
	
//	public Program getLogicalEntailment() {
//		ProgramBuilder program = new ProgramBuilder();
//		
//		for(Node n : PLTL.getPLTL()) {
//			program.addNode(n);
//		}
//		
//		for(SFile sf : map.fileMapping.values()) {
//			program.addTypes(STypeDef.toLustre(sf.typedefs, map));
//			program.addConstants(SConstant.toLustre(sf.constants, map));
//			program.addNodes(SPattern.toLustre(sf.patterns, map));
//			
//			if (sf instanceof SSpecification) {
//				SSpecification spec = (SSpecification) sf;
//				
//				if(this.main.equals(spec)) {
//					program.addNode(spec.getLogicalEntailmentMain(map));	
//				} else {
//					program.addNode(spec.getLogicalEntailmentCalled(map));
//				}
//			}
//		}
//		program.setMain(main.name);
//		return program.build();
//	}
//	
//	public Program getLogicalConsistency() {
//		ProgramBuilder program = new ProgramBuilder();
//		
//		for(Node n : PLTL.getPLTL()) {
//			program.addNode(n);
//		}
//		
//		for(SFile sf : map.fileMapping.values()) {
//			program.addTypes(STypeDef.toLustre(sf.typedefs, map));
//			program.addConstants(SConstant.toLustre(sf.constants, map));
//			program.addNodes(SPattern.toLustre(sf.patterns, map));
//			
//			if (sf instanceof SSpecification) {
//				SSpecification spec = (SSpecification) sf;
//				
//				if(this.main.equals(spec)) {
//					program.addNode(spec.getLogicalConsistencyMain(map));	
//				} else {
//					program.addNode(spec.getLogicalConsistencyCalled(map));
//				}
//			}
//		}
//		program.setMain(main.name);
//		return program.build();
//	}
}
