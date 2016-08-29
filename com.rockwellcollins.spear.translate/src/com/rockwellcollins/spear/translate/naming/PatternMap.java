//package com.rockwellcollins.spear.translate.naming;
//
//import org.apache.commons.collections4.bidimap.DualHashBidiMap;
//import org.eclipse.emf.ecore.EObject;
//
//import com.rockwellcollins.spear.utilities.Utilities;
//
//public class PatternMap {
//
//	private DualHashBidiMap<String,String> map = new DualHashBidiMap<>();
//	
//	private String getUniqueName(String proposed) {
//		Integer unique = 0;
//		String renamed = proposed;
//		while(map.containsKey(renamed)) {
//			renamed = proposed + "_" + unique;
//			unique++;
//		}
//		return renamed;
//	}
//	
//	private void register(String original, String renamed) {
//		map.put(renamed, original);
//	}
//	
//	public String getName(String original) {
//		String renamed = getUniqueName(original);
//		register(original,renamed);
//		return renamed;
//	}
//	
//	public String getName(EObject o) {
//		String original = Utilities.getName(o);
//		return getName(original);
//	}
//	
//	public String lookup(String key) {
//		return this.map.inverseBidiMap().get(key);
//	}
//	
//	public String lookup(EObject o) {
//		String name = Utilities.getName(o);
//		return lookup(name);
//	}
//}
