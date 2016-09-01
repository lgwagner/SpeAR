package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.translate.naming.Renaming;
import com.rockwellcollins.spear.utilities.PLTL;

import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SProgram {

	public static SProgram build(SpearDocument doc) {
		return new SProgram(doc);
	}
	
	public Renaming map;
	public String main;
	public List<STypeDef> typedefs = new ArrayList<>();
	public List<SConstant> constants = new ArrayList<>();
	public List<SPattern> patterns = new ArrayList<>();
	public List<SSpecification> specifications = new ArrayList<>();
	
	public SProgram(SpearDocument document) {
		//initialize the program's global map
		map = Renaming.newMap();
		
		//add the PLTL node names to the program namespace
		Renaming.addPLTL(map);

		//get the names of the typedefs, constants and process them
		typedefs.addAll(STypeDef.build(document.typedefs, map));
		constants.addAll(SConstant.build(document.constants, map));
		
		//just get the names of these because we need to have them in the namespace before we process them.
		List<String> renamedPatterns = SPattern.addNames(document.patterns, map);
		List<String> renamedSpecifications = SSpecification.addNames(document.specifications, map);

		//process the patterns. Nothing special to do here.
		patterns.addAll(SPattern.build(document.patterns, map));
		
		/* 
		 * process the specifications in two steps
		 * 1. build them
		 * 2. resolve the calls among them
		 */
		specifications.addAll(SSpecification.build(document.specifications, map));
		resolveSpecificationCalls(document);
		
		//identify the main node.
		this.main = map.lookupOriginal(document.mainName);
	}

	private void resolveSpecificationCalls(SpearDocument document) {
		for(SSpecification s : specifications) {
			s.resolveCalls(document.calls, specifications);
		}
	}
	
	public Program getBaseProgram() {
		ProgramBuilder program = new ProgramBuilder();
		
		//add the PLTL nodes
		program.addNodes(PLTL.getPLTL());
		
		program.addConstants(SConstant.toLustre(constants, map));
		program.addTypes(STypeDef.toLustre(typedefs, map));
		program.addNodes(SPattern.toLustre(patterns));
		return program.build();
	}
	
	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder(this.getBaseProgram());
	
		for(SSpecification spec : specifications) {
			if(spec.name.equals(this.main)) {
				program.addNode(spec.getLogicalEntailmentMain());
			}
			//TODO add an else case for the called nodes
		}
		program.setMain(this.main);
		return program.build();
	}
	
	public Program getLogicalConsistency() {
		ProgramBuilder program = new ProgramBuilder(this.getBaseProgram());
		
		for(SSpecification spec : specifications) {
			if(spec.name.equals(this.main)) {
				program.addNode(spec.getLogicalConsistencyMain());
			}
			//TODO add an else case for the called nodes
		}
		program.setMain(this.main);
		return program.build();
	}
}
