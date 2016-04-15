package com.rockwellcollins.spear.translate.naming;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.utilities.PLTL;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.lustre.Node;

public class FileMap {
	private File file;
	private DualHashBidiMap<String,String> map = new DualHashBidiMap<>();
	
	public FileMap(File file) {
		this.file=file;
		for(Node n : PLTL.getPLTL()) {
			String original = n.id;
			String renamed = getUniqueName(original);
			register(original,renamed);
		}
	}
	
	private String getUniqueName(String proposed) {
		Integer unique = 0;
		String renamed = proposed;
		while(map.containsKey(renamed)) {
			renamed = proposed + "_" + unique;
			unique++;
		}
		return renamed;
	}
	
	private void register(String original, String renamed) {
		map.put(renamed, original);
	}
	
	public String getName(EObject o) {
		String original = Utilities.getName(o);
		return getName(original);
	}
	
	public String getName(String original) {
		String renamed = getUniqueName(original);
		register(original,renamed);
		return renamed;
	}
	
	public String getFileBasedName(EObject o) {
		String original = Utilities.getName(o);
		String proposed = file.getName() + "_" + original;
		String renamed = getUniqueName(proposed);
		register(original,renamed);
		return renamed;
	}
	
	public String getDefinitionsName(EObject o) {
		String original = Utilities.getName(o);
		String proposed = file.getName() + "_" + original + "_definition";
		String renamed = getUniqueName(proposed);
		register(proposed,renamed);
		return renamed;
	}
	
	public String getShadowName(Variable v) {
		String original = Utilities.getName(v);
		String proposed = original + "_" + "_shadow";
		String renamed = getUniqueName(proposed);
		register(proposed,renamed);
		return renamed;
	}
	
	public String lookup(String key) {
		return this.map.inverseBidiMap().get(key);
	}
	
	public String lookup(EObject o) {
		String name = Utilities.getName(o);
		return lookup(name);
	}
}
