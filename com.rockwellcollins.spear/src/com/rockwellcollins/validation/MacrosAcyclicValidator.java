package com.rockwellcollins.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.utilities.CycleUtilities;

import jkind.util.CycleFinder;

public class MacrosAcyclicValidator extends AbstractSpearJavaValidator {

	@Check
	public void checkMacrosAcyclic(Specification spec) {
		Map<String, Set<String>> dependencies = getDependencies(spec);
		List<String> cycle = CycleFinder.findCycle(dependencies);
		if(cycle != null) {
			error(spec, cycle);
		}
	}
	
	protected Map<String, Set<String>> getDependencies(Specification spec) {
		Map<String, Set<String>> dependencies = new HashMap<>();
		for(Macro m : spec.getMacros()) {
			Set<String> set = new HashSet<>();
			for (IdExpr ide : EcoreUtil2.getAllContentsOfType(m, IdExpr.class)) {
				if(ide.getId() instanceof Macro) {
					Macro m2 = (Macro) ide.getId();
					set.add(m2.getName());
				}
			}
			dependencies.put(m.getName(), set);
		}
		return dependencies;
	}
	
	protected void error(Specification spec, List<String> cycle) {
		String message = "Cycle in macro definitions " + CycleUtilities.getCycleErrorMessage(cycle);
		Map<String, Macro> table = getMacroTable(spec);
		boolean first = true;
		for(String node : cycle) {
			if (first) {
				first = false;
			} else {
				error(message, table.get(node), SpearPackage.Literals.MACRO__EXPR);
			}
		}
	}
	
	private Map<String, Macro> getMacroTable(Specification spec) {
		Map<String, Macro> table = new HashMap<>();
		for(Macro m : spec.getMacros()) {
			table.put(m.getName(), m);
		}
		return table;
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// this is intentionally empty to prevent the composed check from registering itself.
	}
}
