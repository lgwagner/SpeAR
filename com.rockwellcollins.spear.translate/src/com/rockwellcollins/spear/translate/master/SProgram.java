package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
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
	public String mainName;
	public List<STypeDef> typedefs = new ArrayList<>();
	public List<SConstant> constants = new ArrayList<>();
	public List<SPattern> patterns = new ArrayList<>();
	public List<SSpecification> specifications = new ArrayList<>();
	
	public SSpecification lookupSpec(String name) {
		for(SSpecification s : specifications) {
			if(s.name.equals(mainName)) {
				return s;
			}
		}
		return null;
	}
	
	public SProgram(SpearDocument document) {
		//initialize the program's global map
		map = Renaming.newMap();
		
		//add the PLTL node names to the program namespace
		Renaming.addPLTL(map);

		//get the names of the typedefs, constants and process them
		typedefs.addAll(STypeDef.build(document.typedefs, this));
		constants.addAll(SConstant.build(document.constants, this));
		
		//just get the names of these because we need to have them in the namespace before we process them.
		@SuppressWarnings("unused")
		List<String> renamedPatterns = SPattern.addNames(document.patterns, this);
		@SuppressWarnings("unused")
		List<String> renamedSpecifications = SSpecification.addNames(document.specifications, map);

		//process the patterns. Nothing special to do here.
		patterns.addAll(SPattern.build(document.patterns, this));
		
		/* 
		 * process the specifications in three steps
		 * 1. build them
		 * 2. resolve the calls among them
		 * 3. resolve the call variables
		 */
		specifications.addAll(SSpecification.build(document.specifications, map));
		
		resolveCalls();	
		resolveCallVars();
		
		//identify the main node.
		this.mainName = map.lookupOriginal(document.mainName);
	}
	
	public SProgram(PatternDocument document) {
		//create the map
		map = Renaming.newMap();
		
		//not going to rename the main name. it will be first in, no conflicts.
		this.mainName = document.mainName;
		
		//add the definitions first
		typedefs = STypeDef.build(document.typedefs, this);
		constants = SConstant.build(document.constants, this);
		
		@SuppressWarnings("unused")
		List<String> renamed = SPattern.addNames(document.patterns, this);
		
		//then add the patterns (because they have local scope that could conflict with global scope)
		patterns = SPattern.build(document.patterns, this);		
	}
	
	public Program patternToLustre() {
		ProgramBuilder program = new ProgramBuilder();
		program.addTypes(STypeDef.toLustre(typedefs, this));
		program.addConstants(SConstant.toLustre(constants, this));
		program.addNodes(SPattern.toLustre(patterns));
		program.setMain(this.mainName);
		return program.build();
	}
	private void resolveCalls() {
		for(SSpecification s : specifications) {
			s.resolveCalls(specifications);
		}
	}
	
	private void resolveCallVars() {
		for(SSpecification s : specifications) {
			s.resolveCallVars();
		}
	}
	
	public Program getBaseProgram() {
		ProgramBuilder program = new ProgramBuilder();
		
		//add the PLTL nodes
		program.addNodes(PLTL.getPLTL());
		
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
}
