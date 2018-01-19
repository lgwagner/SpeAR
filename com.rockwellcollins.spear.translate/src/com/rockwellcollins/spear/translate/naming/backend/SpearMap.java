package com.rockwellcollins.spear.translate.naming.backend;

import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.utilities.LustreLibrary;

import jkind.lustre.Node;

public class SpearMap {

	public static SpearMap getProgramMap() {
		return new SpearMap();
	}

	public static SpearMap getModuleMap(SpearMap programMap) {
		return new SpearMap(programMap);
	}

	public static void addLibraries(SpearMap map) {
		for (Node n : LustreLibrary.getLibraries()) {
			map.program.getName(n.id);
		}

		if (PreferencesUtil.getSolverNonlinear()) {
			for (Node n : LustreLibrary.getNonlinearLibraries()) {
				map.program.getName(n.id);
			}
		}
	}

	public NameMap program;
	public NameMap module;

	private SpearMap() {
		this.program = NameMap.newMap();
		this.module = null;
	}

	private SpearMap(SpearMap programMap) {
		this.program = NameMap.copy(programMap.program);
		this.module = NameMap.newMap();
	}

	public String getProgramName(String original) {
		return program.getName(original);
	}

	public String getModuleName(String original) {
		return module.getName(this.program,original);
	}

	public String lookupOriginalProgram(String original) {
		return program.lookupOriginal(original);
	}

	public String lookupOriginalModule(String original) {
		return module.lookupOriginal(original);
	}
}
