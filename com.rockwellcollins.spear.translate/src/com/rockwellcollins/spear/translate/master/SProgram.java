package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.translate.naming.SpearMap;
import com.rockwellcollins.spear.utilities.LustreLibrary;

import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SProgram extends SMapElement {

	public static SProgram build(SpearDocument doc) {
		return new SProgram(doc);
	}
	
	public static SProgram build(PatternDocument doc) {
		return new SProgram(doc);
	}
	
	public String mainName;
	public List<STypeDef> typedefs = new ArrayList<>();
	public List<SConstant> constants = new ArrayList<>();
	public List<SPattern> patterns = new ArrayList<>();
	public List<SSpecification> specifications = new ArrayList<>();
	
	private SProgram(SpearDocument document) {
		//initialize the program's global map
		map = SpearMap.getProgramMap();
		
		//add the PLTL node names to the program namespace
		SpearMap.addPLTL(map);

		//get the names of the typedefs, constants and process them
		typedefs.addAll(STypeDef.build(document.typedefs.values(), this));
		constants.addAll(SConstant.build(document.constants.values(), this));
		
		//just get the names of these because we need to have them in the namespace before we process them.
		@SuppressWarnings("unused")
		List<String> renamedPatterns = SPattern.addNames(document.patterns.values(), this);
		@SuppressWarnings("unused")
		List<String> renamedSpecifications = SSpecification.addNames(document.specifications.values(), map);

		//process the patterns. Nothing special to do here.
		patterns.addAll(SPattern.build(document.patterns.values(), this));
		
		/* 
		 * process the specifications in three steps
		 * 1. build them
		 * 2. resolve the calls among them
		 * 3. resolve the call variables
		 */
		specifications.addAll(SSpecification.build(document.specifications.values(), map));
		specifications.stream().forEach(s -> s.resolveCalls(specifications));
		specifications.stream().forEach(s -> s.resolveCallVars());
		
		//identify the main node.
		this.mainName = map.lookupOriginalProgram(document.mainName);
	}
	
	private SProgram(PatternDocument document) {
		//create the map
		map = SpearMap.getProgramMap();
		
		//add the PLTL node names to the program namespace
		SpearMap.addPLTL(map);
		
		//not going to rename the main name. it will be first in, no conflicts.
		this.mainName = document.mainName;
		
		//add the definitions first
		typedefs = STypeDef.build(document.typedefs.values(), this);
		constants = SConstant.build(document.constants.values(), this);
		
		@SuppressWarnings("unused")
		List<String> renamed = SPattern.addNames(document.patterns.values(), this);
		
		//then add the patterns (because they have local scope that could conflict with global scope)
		patterns = SPattern.build(document.patterns.values(), this);		
	}
	
	public Program patternToLustre() {
		ProgramBuilder program = new ProgramBuilder();
		
		//add the PLTL nodes
		program.addNodes(LustreLibrary.getLibraries());
		
		//add the typedefs, constants, and patterns
		program.addTypes(STypeDef.toLustre(typedefs, this));
		program.addConstants(SConstant.toLustre(constants, this));
		program.addNodes(SPattern.toLustre(patterns));
		
		//set the main name
		program.setMain(this.mainName);
		return program.build();
	}
	
	public Program getBaseProgram() {
		ProgramBuilder program = new ProgramBuilder();
		
		//add the PLTL nodes
		program.addNodes(LustreLibrary.getLibraries());
		
		program.addConstants(SConstant.toLustre(constants, this));
		program.addTypes(STypeDef.toLustre(typedefs, this));
		program.addNodes(SPattern.toLustre(patterns));
		return program.build();
	}
	
	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder(this.getBaseProgram());
	
		for(SSpecification spec : specifications) {
			if(spec.name.equals(this.mainName)) {
				program.addNode(spec.getLogicalEntailmentMain());
			} else {
				program.addNode(spec.getLogicalEntailmentCalled());
			}
		}
		program.setMain(this.mainName);
		return program.build();
	}
	
	public Program getLogicalConsistency() {
		ProgramBuilder program = new ProgramBuilder(this.getBaseProgram());
		
		for(SSpecification spec : specifications) {
			if(spec.name.equals(this.mainName)) {
				program.addNode(spec.getLogicalConsistencyMain());
			} else {
				program.addNode(spec.getLogicalConsistencyCalled());
			}
		}
		program.setMain(this.mainName);
		return program.build();
	}
	
	public Program getRealizability() {
		ProgramBuilder program = new ProgramBuilder(this.getBaseProgram());
		
		for(SSpecification spec : specifications) {
			if(spec.name.equals(this.mainName)) {
				program.addNode(spec.getRealizabilityMain());
			} else {
				program.addNode(spec.getLogicalEntailmentCalled());
			}
		}
		program.setMain(this.mainName);
		return program.build();
	}
}
