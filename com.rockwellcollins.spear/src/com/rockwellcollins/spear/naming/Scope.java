package com.rockwellcollins.spear.naming;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

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
	
	public Deque<BiMap<String,String>> scopes = new ArrayDeque<>();
	
	public Scope copy() {
		Scope copy = new Scope();
		copy.scopes.addAll(this.scopes);
		return copy;
	}
	
	public void addScope() {
		scopes.push(new BiMap<>());
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
		Iterator<BiMap<String,String>> iterator = scopes.iterator();
		while(iterator.hasNext()) {
			BiMap<String,String> current = iterator.next();
			if(current.containsKey(renamed)) {
				return current.get(renamed);
			}
		}
		return null;
	}
	
	public String lookUpInv(String original) {
		Iterator<BiMap<String,String>> iterator = scopes.iterator();
		while(iterator.hasNext()) {
			BiMap<String,String> current = iterator.next();
			if(current.invContainsKey(original)) {
				return current.invGet(original);
			}
		}
		return null;
	}
}