package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;

public class UniquifyNormalizedCalls {
	
	public static void transform(SpearDocument d) {
		UniquifyNormalizedCalls uniquify = new UniquifyNormalizedCalls();
		uniquify.makeUnique(d);
	}
	
	private String getName(String original) {
		String proposed = original;
		Integer unique = 1;
		while(map.containsKey(proposed)) {
			proposed = original + unique;
			unique++;
		}
		map.put(proposed, original);
		return proposed;
	}
	
	private Map<String,Specification> specs = new HashMap<>();
	private Map<String,String> map = new HashMap<>();
	
	private void processSpec(Specification s) {
		for(NormalizedCall nc : EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class)) {
			Specification next = nc.getSpec();
			if(specs.containsValue(next)) {
				Specification newNext = createCopy(next);
				nc.setSpec(newNext);
				specs.put(newNext.getName(),newNext);
				processSpec(newNext);
			} else {
				specs.put(next.getName(),next);
				processSpec(next);
			}
		}
	}

	private Specification createCopy(Specification next) {
		String newName = getName(next.getName());
		Specification newNext = EcoreUtil2.copy(next);
		newNext.setName(newName);
		return newNext;
	}
	
	private void populateMap(SpearDocument d) {
		d.typedefs.values().stream().forEach(td -> map.put(td.getName(), td.getName()));
		d.constants.values().stream().forEach(c -> map.put(c.getName(), c.getName()));
		d.patterns.values().stream().forEach(p -> map.put(p.getName(), p.getName()));
		d.specifications.values().stream().forEach(s -> map.put(s.getName(), s.getName()));
	}
	
	public void makeUnique(SpearDocument d) {
		populateMap(d);
		Specification main = d.getMain();
		specs.put(main.getName(),main);
		processSpec(main);
		d.specifications=new HashMap<>(this.specs);
	}
}
