package com.rockwellcollins.spear.translate.naming.backend;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.utilities.LustreLibrary;

import jkind.lustre.Node;

public class Scope {

	public static void addLibraries(Scope map) {
		for (Node n : LustreLibrary.getLibraries()) {
			map.addName(n.id);
		}

		if (PreferencesUtil.getSolverNonlinear()) {
			for (Node n : LustreLibrary.getNonlinearLibraries()) {
				map.addName(n.id);
			}
		}
	}
	
	public Deque<Map<String,String>> scopes = new ArrayDeque<>();
	
	public Scope() {
		this.addScope();
	}
	
	public Scope copy() {
		Scope copy = new Scope();
		copy.scopes.addAll(this.scopes);
		return copy;
	}
	
	public void addScope() {
		scopes.push(new HashMap<>());
	}
	
	public String addName(String original) {
		String renamed = original;
		Integer index = 1;
		while(lookup(renamed) != null) {
			renamed = original + "_" + index;
			index++;
		}
		
		scopes.peek().put(renamed, original);
		return renamed;
	}
	
	public String lookup(String renamed) {
		Iterator<Map<String,String>> iterator = scopes.iterator();
		while(iterator.hasNext()) {
			Map<String,String> current = iterator.next();
			if(current.containsKey(renamed)) {
				return current.get(renamed);
			}
		}
		return null;
	}
}
