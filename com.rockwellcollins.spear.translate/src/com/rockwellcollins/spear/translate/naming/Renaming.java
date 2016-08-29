package com.rockwellcollins.spear.translate.naming;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import com.rockwellcollins.spear.utilities.PLTL;

import jkind.lustre.Node;

public class Renaming {

	public static Renaming newMap() {
		Renaming map = new Renaming();
		return map;
	}
	
	public static Renaming copy(Renaming map) {
		Renaming copied = new Renaming(map);
		return copied;
	}
	
	public static void addPLTL(Renaming map) {
		for(Node n : PLTL.getPLTL()) {
			map.getName(n.id);
		}
	}
	
	private DualHashBidiMap<String,String> map;
	
	private Renaming() {
		this.map = new DualHashBidiMap<>();
	}
	
	private Renaming(Renaming existing) {
		this.map = new DualHashBidiMap<>();
		this.map.putAll(existing.map);
	}
	
	/**
	 * This will accept a name and provide a unique one that does not conflict
	 * in the given namespace.
	 * @param original
	 * @return
	 */
	public String getName(String original) {
		String renamed = original;
		Integer unique = 0;
		while(map.containsKey(renamed)) {
			renamed = original + unique;
			unique++;
		}
		map.put(renamed, original);
		return renamed;
	}
	
	/**
	 * This will take the original name and provide back the renamed name.
	 * @param original
	 * @return
	 */
	public String lookupOriginal(String original) {
		return this.map.inverseBidiMap().get(original);
	}
	
	/**
	 * This will take the renamed name and provide back the original name.	
	 * @param renamed
	 * @return
	 */
	public String lookupRenamed(String renamed) {
		return this.map.get(renamed);
	}
}
