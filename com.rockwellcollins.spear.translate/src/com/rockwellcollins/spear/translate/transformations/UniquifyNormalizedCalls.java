package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
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
	
	private Set<Specification> specs = new HashSet<>();
	private Map<String,String> map = new HashMap<>();
	
	private void processSpec(Specification s) {
		for(NormalizedCall nc : EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class)) {
			Specification next = nc.getSpec();
			if(specs.contains(next)) {
				Specification newNext = createCopy(next);
				nc.setSpec(newNext);
				specs.add(newNext);
				processSpec(newNext);
			} else {
				specs.add(next);
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
		for(TypeDef td : d.typedefs) {
			map.put(td.getName(), td.getName());
		}
		
		for(Constant c : d.constants) {
			map.put(c.getName(), c.getName());
		}
		
		for(Pattern p : d.patterns) {
			map.put(p.getName(), p.getName());
		}
		
		for(Specification s : d.specifications) {
			map.put(s.getName(), s.getName());
		}
	}
	
	public void makeUnique(SpearDocument d) {
		populateMap(d);
		Specification main = d.getMain();
		specs.add(main);
		processSpec(main);
		d.specifications=new ArrayList<>(this.specs);
	}
}
