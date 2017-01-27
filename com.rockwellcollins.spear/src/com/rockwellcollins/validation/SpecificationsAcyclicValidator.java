package com.rockwellcollins.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;

import jkind.util.CycleFinder;

public class SpecificationsAcyclicValidator extends AbstractSpearJavaValidator {

	@Check
	public void checkSpecificationIsAcyclic(Specification spec) {
		Map<String,Set<String>> dependencies = getDependencies(spec,new HashMap<String,Set<String>>());
		List<String> cycle = CycleFinder.findCycle(dependencies);
		if(cycle != null) {
			error(spec,cycle);
		}
	}
	
	protected Map<String,Set<String>> getDependencies(Specification spec, Map<String,Set<String>> dependencies) {
		for(SpecificationCall call : EcoreUtil2.getAllContentsOfType(spec, SpecificationCall.class)) {
			insert(dependencies,spec.getName(),call.getSpec().getName());
			if(!dependencies.containsKey(call.getSpec().getName())) {
				getDependencies(call.getSpec(),dependencies);
			}
		}
		return dependencies;
	}

	private Map<String, Set<String>> insert(Map<String, Set<String>> map, String spec, String calledSpec) {
		Set<String> specSet;
		if(map.containsKey(spec)) {
			specSet = map.get(spec);
		} else {
			specSet = new HashSet<>();
		}
		
		specSet.add(calledSpec);
		map.put(spec, specSet);
		return map;
	}

	protected void error(Specification spec, List<String> cycle) {
		String message = "Cycle detected: " + getCycleErrorMessage(cycle);
		for(SpecificationCall specCall : EcoreUtil2.getAllContentsOfType(spec, SpecificationCall.class)) {
			if(cycle.contains(specCall.getSpec().getName())) {
				error(message, specCall, SpearPackage.Literals.SPECIFICATION_CALL__SPEC);
			}
		}
	}
	
	private String getCycleErrorMessage(List<String> cycle) {
		StringBuilder text = new StringBuilder();
		boolean first = true;
		for (String node : cycle) {
			if (first) {
				first = false;
			} else {
				text.append(" -> ");
			}
			text.append(node);
		}
		return text.toString();
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {}
}
