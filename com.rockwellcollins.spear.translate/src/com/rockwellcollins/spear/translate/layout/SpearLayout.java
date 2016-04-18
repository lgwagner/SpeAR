package com.rockwellcollins.spear.translate.layout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;

import jkind.results.layout.Layout;

public class SpearLayout implements Layout {

	private final Map<String,String> map;
	
	private static final String INPUTS = "Inputs";
	private static final String OUTPUTS = "Outputs";
	private static final String STATE = "State";
	private static final String MACROS = "Macros";
	private static final String ASSUMPTIONS = "Assumptions";
	private static final String DERIVED_REQUIREMENTS = "DerivedRequirements";
	private static final String REQUIREMENTS = "REQUIREMENTS";
	
	public static final String[] CATEGORIES = {INPUTS, OUTPUTS, STATE, MACROS, ASSUMPTIONS, DERIVED_REQUIREMENTS, REQUIREMENTS};
	
	public SpearLayout(Specification s, Map<File, Map<String, String>> renamed) {
		if(s == null) {
			throw new IllegalArgumentException("Unable to create layout for null specification.");
		}
		
		this.map=new HashMap<>();
		Map<String,String> nameMapping = renamed.get(s);
		
		for(Variable v : s.getInputs()) {
			map.put(getName(v.getName(),nameMapping), INPUTS);
		}
		
		for(Variable v : s.getOutputs()) {
			map.put(getName(v.getName(),nameMapping), OUTPUTS);
		}
		
		for(Variable v : s.getState()) {
			map.put(getName(v.getName(),nameMapping), STATE);
		}
		
		for(Macro m : s.getMacros()) {
			map.put(getName(m.getName(),nameMapping), MACROS);
		}
		
		for(Constraint c : s.getAssumptions()) {
			map.put(getName(c.getName(),nameMapping), ASSUMPTIONS);
		}
		
		for(Constraint c : s.getRequirements()) {
			map.put(getName(c.getName(),nameMapping), DERIVED_REQUIREMENTS);
		}
		
		for(Constraint c : s.getBehaviors()) {
			map.put(getName(c.getName(),nameMapping), REQUIREMENTS);
		}
	}

	public String getName(String name, Map<String,String> nameMap) {
		if(nameMap.containsKey(name)) {
			return nameMap.get(name);
		} else {
			return name;
		}
	}
	
	@Override
	public List<String> getCategories() {
		return Arrays.asList(CATEGORIES);
	}

	@Override
	public String getCategory(String signal) {
		String prefix = signal.split("\\.|\\[")[0];
		return map.get(prefix);
	}
	
}
