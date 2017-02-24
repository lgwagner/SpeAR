package com.rockwellcollins.spear.translate.naming;

import com.rockwellcollins.spear.translate.actions.SpearRuntimeOptions;
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
		for(Node n : LustreLibrary.getLibraries()) {
			map.program.getName(n.id);
		}
		
		if(SpearRuntimeOptions.isSolverNonlinear) {
			for(Node n : LustreLibrary.getNonlinearLibraries()) {
				map.program.getName(n.id);
			}
		}
	}
	
	public Map program;
	public Map module;
	
	private SpearMap() {
		this.program = Map.newMap();
		this.module = null;
	}
	
	private SpearMap(SpearMap programMap) {
		this.program = Map.copy(programMap.program);
		this.module = Map.newMap();
	}
	
	public String getProgramName(String original) {
		return program.getName(original);
	}
	
	public String getModuleName(String original) {
		return module.getName(original);
	}
	
	public String lookupOriginalProgram(String original) {
		return program.lookupOriginal(original);
	}
	
	public String lookupOriginalModule(String original) {
		return module.lookupOriginal(original);
	}
}
