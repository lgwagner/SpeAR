package com.rockwellcollins.spear.translate.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rockwellcollins.spear.Specification;

import jkind.results.layout.Layout;

public class SpearRealizabilityLayout implements Layout {

	private final Map<String,String> map;
	private final List<String> categories;
	
	public SpearRealizabilityLayout(Specification s) {
		
		if(s == null) {
			throw new IllegalArgumentException("Unable to create layout for null specification.");
		}
		
		categories = new ArrayList<>();
		
		String inputs = "Inputs";
		categories.add(inputs);
		
		String outputs = "Outputs";
		categories.add(outputs);
		
		String state = "State";
		categories.add(state);
		
		String macros = "Macros";
		categories.add(macros);
		
		String assumptions = s.getAssumptionsKeyword();
		if(assumptions != null) {
			categories.add(assumptions);
		}

		String requirements = s.getRequirementsKeyword();
		if(requirements != null) {
			categories.add(requirements);
		}
						
		this.map=new HashMap<>();
		
		s.getInputs().stream().forEach(v -> map.put(v.getName(), inputs));
		s.getOutputs().stream().forEach(v -> map.put(v.getName(), outputs));
		s.getState().stream().forEach(v -> map.put(v.getName(), state));
		s.getMacros().stream().forEach(m -> map.put(m.getName(), macros));
		s.getAssumptions().stream().forEach(c -> map.put(c.getName(), assumptions));
		s.getRequirements().stream().forEach(c -> map.put(c.getName(), requirements));
	}
	
	@Override
	public List<String> getCategories() {
		return categories;
	}

	@Override
	public String getCategory(String signal) {
		String prefix = signal.split("\\.|\\[")[0];
		return map.get(prefix);
	}
}
