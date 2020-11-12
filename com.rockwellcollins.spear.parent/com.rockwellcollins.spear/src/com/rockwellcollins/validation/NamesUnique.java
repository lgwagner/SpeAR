package com.rockwellcollins.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.LiteralMapper;

public class NamesUnique extends AbstractSpearValidator {

	public static Set<EObject> get(Map<String, Set<EObject>> map, String s) {
		if (map.containsKey(s)) {
			return map.get(s);
		} else {
			return new HashSet<>();
		}
	}

	public static void insert(Map<String, Set<EObject>> map, String s, EObject e) {
		Set<EObject> set = get(map, s);
		set.add(e);
		map.put(s, set);
	}

	private void checkNamesAreUnique(Map<String, Set<EObject>> globalScope, Pattern p) {
		Map<String, Set<EObject>> map = new HashMap<>(globalScope);
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");

		p.getInputs().stream().forEach(v -> insert(map, resolver.apply(v), v));
		p.getOutputs().stream().forEach(v -> insert(map, resolver.apply(v), v));
		p.getLocals().stream().forEach(v -> insert(map, resolver.apply(v), v));

		for (String key : map.keySet()) {
			Set<EObject> set = map.get(key);
			if (set.size() > 1) {
				set.stream()
						.forEach(e -> error("Name " + key + " used in multiple places.", e, LiteralMapper.crunch(e)));
			}
		}
	}

	@Check
	public void checkNamesAreUnique(Definitions d) {
		Map<String, Set<EObject>> map = new HashMap<>();
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");

		insert(map, resolver.apply(d), d);

		/*
		 * s.getUnits().stream().forEach(d -> insert(map,resolver.apply(d),d));
		 * don't need to add units because they aren't used in the Lustre, at
		 * all.
		 */
		d.getTypedefs().stream().forEach(td -> InsertTypeDef.crunch(map, td));
		d.getConstants().stream().forEach(c -> insert(map, resolver.apply(c), c));
		d.getPatterns().stream().forEach(p -> insert(map, resolver.apply(p), p));

		// check the patterns
		d.getPatterns().stream().forEach(p -> checkNamesAreUnique(map, p));

		for (String key : map.keySet()) {
			Set<EObject> set = map.get(key);
			if (set.size() > 1) {
				set.stream()
						.forEach(e -> error("Name " + key + " used in multiple places.", e, LiteralMapper.crunch(e)));
			}
		}
	}

	@Check
	public void checkNamesAreUnique(Specification s) {
		Map<String, Set<EObject>> map = new HashMap<>();
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");

		insert(map, resolver.apply(s), s);

		/*
		 * s.getUnits().stream().forEach(d -> insert(map,resolver.apply(d),d));
		 * don't need to add units because they aren't used in the Lustre, at
		 * all.
		 */
		s.getTypedefs().stream().forEach(td -> InsertTypeDef.crunch(map, td));
		s.getConstants().stream().forEach(c -> insert(map, resolver.apply(c), c));
		s.getPatterns().stream().forEach(p -> insert(map, resolver.apply(p), p));

		// check the patterns here because the elements above are used by the
		// patterns
		s.getPatterns().stream().forEach(p -> checkNamesAreUnique(map, p));

		s.getMacros().stream().forEach(m -> insert(map, resolver.apply(m), m));
		s.getInputs().stream().forEach(v -> insert(map, resolver.apply(v), v));
		s.getOutputs().stream().forEach(v -> insert(map, resolver.apply(v), v));
		s.getState().stream().forEach(v -> insert(map, resolver.apply(v), v));
		s.getAssumptions().stream().forEach(c -> insert(map, resolver.apply(c), c));
		s.getRequirements().stream().forEach(c -> insert(map, resolver.apply(c), c));
		s.getBehaviors().stream().forEach(c -> insert(map, resolver.apply(c), c));

		for (String key : map.keySet()) {
			Set<EObject> set = map.get(key);
			if (set.size() > 1) {
				set.stream()
						.forEach(e -> error("Name " + key + " used in multiple places.", e, LiteralMapper.crunch(e)));
			}
		}
	}

	private static class InsertTypeDef extends SpearSwitch<Integer> {

		public static void crunch(Map<String, Set<EObject>> map, TypeDef td) {
			InsertTypeDef itd = new InsertTypeDef(map);
			itd.doSwitch(td);
		}

		private Map<String, Set<EObject>> map;

		private InsertTypeDef(Map<String, Set<EObject>> map) {
			this.map = map;
		}

		@Override
		public Integer caseTypeDef(TypeDef td) {
			insert(map, td.getName(), td);
			return 0;
		}

		@Override
		public Integer caseEnumTypeDef(EnumTypeDef etd) {
			insert(map, etd.getName(), etd);
			etd.getValues().stream().forEach(ev -> insert(map, ev.getName(), ev));
			return 0;
		}
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
	}
}
