package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.intermediate.Document;

public class UniquifyNormalizedCalls {
	
	public static void transform(Document d) {
		UniquifyNormalizedCalls uniquify = new UniquifyNormalizedCalls();
		uniquify.makeUnique(d);
	}
	
	private String getName(String original) {
		String proposed = original;
		Integer unique = 1;
		while(files.containsKey(proposed)) {
			proposed = original + unique;
			unique++;
		}
		return proposed;
	}
	
	private Map<String,File> files = new HashMap<>();
	
	private void processSpec(Specification s) {
		Specification toAdd = null;
		for(NormalizedCall nc : EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class)) {
			Specification next = nc.getSpec();
			if(files.containsValue(next)) {
				toAdd = createCopy(next);
				nc.setSpec(toAdd);
			} else {
				toAdd = next;
			}
			add(toAdd);
			processSpec(toAdd);
		}
	}

	private void add(Specification s) {
		files.put(s.getName(), s);	
	}

	private Specification createCopy(Specification next) {
		String newName = getName(next.getName());
		Specification newNext = EcoreUtil2.copy(next);
		newNext.setName(newName);
		return newNext;
	}
	
	public void makeUnique(Document d) {
		if (d.main instanceof Specification) {
			Specification spec = (Specification) d.main;
			files.put(spec.getName(),spec);
			processSpec(spec);
		}
		
		//clear out the old stuff for the new stuff
		d.files.clear();
		d.files.addAll(this.files.values());
	}
}
