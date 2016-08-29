package com.rockwellcollins.spear.translate.naming;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class PNameMap {

	public static PNameMap newMap() {
		PNameMap map = new PNameMap();
		return map;
	}
	
	public static PNameMap copy(PNameMap map) {
		PNameMap copied = new PNameMap(map);
		return copied;
	}
	
	private DualHashBidiMap<String,String> map;
	
	private PNameMap() {
		this.map = new DualHashBidiMap<>();
	}
	
	private PNameMap(PNameMap existing) {
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
