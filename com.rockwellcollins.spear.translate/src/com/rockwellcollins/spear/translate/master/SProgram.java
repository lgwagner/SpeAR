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
		typedefs.addAll(STypeDef.build(document.typedefs, map));
		constants.addAll(SConstant.build(document.constants, map));
		
		//just get the names of these because we need to have them in the namespace before we process them.
		List<String> renamedPatterns = SPattern.addNames(document.patterns, map);
		List<String> renamedSpecifications = SSpecification.addNames(document.specifications, map);

		//process the patterns. Nothing special to do here.
		patterns.addAll(SPattern.build(document.patterns, map));
		
		/* 
		 * process the specifications in three steps
		 * 1. build them
		 * 2. resolve the calls among them
		 * 3. resolve the call variables
		 */
		specifications.addAll(SSpecification.build(document.specifications, map));
		
		//identify the main node.
		this.mainName = map.lookupOriginal(document.mainName);
		SSpecification main = SSpecification.lookup(this.mainName, specifications);
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
			if(spec.name.equals(this.mainName)) {
				program.addNode(spec.getLogicalEntailmentMain());
			} else {
				program.addNode(spec.toBaseLustre());
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
				program.addNode(spec.toBaseLustre());
			}
		}
		program.setMain(this.mainName);
		return program.build();
	}
}
