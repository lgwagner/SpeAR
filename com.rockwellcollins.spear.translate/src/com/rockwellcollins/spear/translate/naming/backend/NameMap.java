package com.rockwellcollins.spear.translate.naming.backend;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class NameMap {

	public static NameMap newMap() {
		NameMap map = new NameMap();
		return map;
	}

	public static NameMap copy(NameMap map) {
		NameMap copied = new NameMap(map);
		return copied;
	}

	private DualHashBidiMap<String, String> map;

	private NameMap() {
		this.map = new DualHashBidiMap<>();
	}

	private NameMap(NameMap existing) {
		this.map = new DualHashBidiMap<>();
		this.map.putAll(existing.map);
	}

	/**
	 * This will accept a name and provide a unique one that does not conflict
	 * in the given namespace.
	 * 
	 * @param original
	 * @return
	 */
	public String getName(String original) {
		String renamed = original;
		Integer unique = 0;
		while (map.containsKey(renamed)) {
			renamed = original + unique;
			unique++;
		}
		map.put(renamed, original);
		return renamed;
	}
	
	public String getName(NameMap program, String original) {
		String renamed = original;
		Integer unique = 0;
		while (program.contains(renamed) || map.containsKey(renamed)) {
			renamed = original + unique;
			unique++;
		}
		map.put(renamed, original);
		return renamed;
	}

	/**
	 * This will take the original name and provide back the renamed name.
	 * 
	 * @param original
	 * @return
	 */
	public String lookupOriginal(String original) {
		return this.map.inverseBidiMap().get(original);
	}

	/**
	 * This will take the renamed name and provide back the original name.
	 * 
	 * @param renamed
	 * @return
	 */
	public String lookupRenamed(String renamed) {
		return this.map.get(renamed);
	}

	public String put(String key, String value) {
		return map.put(key, value);
	}

	public boolean contains(String key) {
		return map.containsKey(key);
	}
}
