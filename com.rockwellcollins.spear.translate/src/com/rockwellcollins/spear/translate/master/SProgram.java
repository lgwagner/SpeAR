package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.intermediate.GetUsedConstants;
import com.rockwellcollins.spear.translate.intermediate.GetUsedPatterns;
import com.rockwellcollins.spear.translate.intermediate.GetUsedSpecifications;
import com.rockwellcollins.spear.translate.intermediate.GetUsedTypeDefs;
import com.rockwellcollins.spear.translate.naming.backend.SpearMap;
import com.rockwellcollins.spear.utilities.LustreLibrary;

import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SProgram extends SMapElement {

	public static SProgram build(Document d) {
		if (d.main instanceof File) {
			File f = (File) d.main;
			return new SProgram(d, f);
		}

		if (d.main instanceof Pattern) {
			Pattern p = (Pattern) d.main;
			return new SProgram(d, p);
		}
		throw new RuntimeException("Main element was " + d.main.toString() + ", expected Pattern or Specification.");
	}

	public String mainName;
	public List<STypeDef> typedefs = new ArrayList<>();
	public List<SConstant> constants = new ArrayList<>();
	public List<SPattern> patterns = new ArrayList<>();
	public List<SSpecification> specifications = new ArrayList<>();

	private SProgram(Document d, File main) {
		// initialize the program's global map
		map = SpearMap.getProgramMap();

		// add the PLTL node names to the program namespace
		SpearMap.addLibraries(map);

		// get the names of the typedefs, constants and process them
		typedefs.addAll(STypeDef.build(GetUsedTypeDefs.get(d.main), this));
		constants.addAll(SConstant.build(GetUsedConstants.get(d.main), this));

		// just get the names of these because we need to have them in the
		// namespace
		// before we process them.
		@SuppressWarnings("unused")
		List<String> renamedPatterns = SPattern.addNames(GetUsedPatterns.get(d.main), this);

		Collection<Specification> usedSpecs = GetUsedSpecifications.get(d);
		@SuppressWarnings("unused")
		List<String> renamedSpecifications = SSpecification.addNames(usedSpecs, map);

		// process the patterns. Nothing special to do here.
		patterns.addAll(SPattern.build(GetUsedPatterns.get(d.main), this));

		/*
		 * process the specifications in three steps 1. build them 2. resolve
		 * the calls among them 3. resolve the call variables
		 */
		specifications.addAll(SSpecification.build(usedSpecs, map));
		specifications.stream().forEach(s -> s.resolveCalls(specifications));
		specifications.stream().forEach(s -> s.resolveCallVars());

		// identify the main node.
		this.mainName = map.lookupOriginalProgram(d.getMainName());
	}

	private SProgram(Document d, Pattern main) {
		// create the map
		map = SpearMap.getProgramMap();

		// add the PLTL node names to the program namespace
		SpearMap.addLibraries(map);

		// not going to rename the main name. it will be first in, no conflicts.
		this.mainName = main.getName();

		// add the definitions first
		typedefs = STypeDef.build(GetUsedTypeDefs.get(d.main), this);
		constants = SConstant.build(GetUsedConstants.get(d.main), this);

		Collection<Pattern> usedPatterns = GetUsedPatterns.get(d.main);
		@SuppressWarnings("unused")
		List<String> renamed = SPattern.addNames(usedPatterns, this);

		// then add the patterns (because they have local scope that could
		// conflict
		// with global scope)
		patterns = SPattern.build(usedPatterns, this);
	}

	public Program patternToLustre() {
		ProgramBuilder program = new ProgramBuilder();
		addNodes(program);

		// add the typedefs, constants, and patterns
		program.addTypes(STypeDef.toLustre(typedefs, this));
		program.addConstants(SConstant.toLustre(constants, this));
		program.addNodes(SPattern.toLustre(patterns));

		// set the main name
		program.setMain(this.mainName);
		return program.build();
	}

	public Program getBaseProgram() {
		ProgramBuilder program = new ProgramBuilder();
		addNodes(program);
		program.addConstants(SConstant.toLustre(constants, this));
		program.addTypes(STypeDef.toLustre(typedefs, this));
		program.addNodes(SPattern.toLustre(patterns));
		return program.build();
	}

	private void addNodes(ProgramBuilder program) {
		// add the PLTL nodes
		program.addNodes(LustreLibrary.getLibraries());
		if (PreferencesUtil.getSolverNonlinear()) {
			program.addNodes(LustreLibrary.getNonlinearLibraries());
		}
	}

	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder(this.getBaseProgram());

		for (SSpecification spec : specifications) {
			if (spec.name.equals(this.mainName)) {
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

		for (SSpecification spec : specifications) {
			if (spec.name.equals(this.mainName)) {
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

		for (SSpecification spec : specifications) {
			if (spec.name.equals(this.mainName)) {
				program.addNode(spec.getRealizabilityMain());
			} else {
				program.addNode(spec.getLogicalEntailmentCalled());
			}
		}
		program.setMain(this.mainName);
		return program.build();
	}
}
