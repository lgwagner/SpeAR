package com.rockwellcollins.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.utilities.Utilities;

public class NamesUnique extends AbstractSpearJavaValidator {

	private Set<EObject> get(Map<String,Set<EObject>> map, String s) {
		if(map.containsKey(s)) {
			return map.get(s);
		} else {
			return new HashSet<>();
		}
	}
	
	private void insert(Map<String,Set<EObject>> map, String s, EObject e) {
		Set<EObject> set = get(map,s);
		set.add(e);
		map.put(s, set);
	}
	
	private void checkNamesAreUnique(Map<String,Set<EObject>> globalScope, Pattern p) {
		Map<String,Set<EObject>> map = new HashMap<>(globalScope);
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");

		p.getInputs().stream().forEach(v -> insert(map,resolver.apply(v),v));
		p.getOutputs().stream().forEach(v -> insert(map,resolver.apply(v),v));
		p.getLocals().stream().forEach(v -> insert(map,resolver.apply(v),v));
		
		for(String key : map.keySet()) {
			Set<EObject> set = map.get(key);
			if(set.size() > 1) {
				set.stream().forEach(e -> error("Name " + key + " used in multiple places.", e, null));
			}
		}
	}
	
	@Check
	public void checkNamesAreUnique(Definitions s) {
		Map<String,Set<EObject>> map = new HashMap<>();
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
		
		/* 
		 * s.getUnits().stream().forEach(d -> insert(map,resolver.apply(d),d)); 
		 * 
		 * don't need to add units because they aren't used in the Lustre, at all.
		 * */
		s.getTypedefs().stream().forEach(td -> insert(map,resolver.apply(td),td));
		s.getConstants().stream().forEach(c -> insert(map,resolver.apply(c),c));
		s.getPatterns().stream().forEach(p -> insert(map,resolver.apply(p),p));
		
		//check the patterns
		s.getPatterns().stream().forEach(p -> checkNamesAreUnique(map,p));
		
		for(String key : map.keySet()) {
			Set<EObject> set = map.get(key);
			if(set.size() > 1) {
				set.stream().forEach(e -> error("Name " + key + " used in multiple places.", e, null));
			}
		}
	}
	
	@Check
	public void checkNamesAreUnique(Specification s) {
		Map<String,Set<EObject>> map = new HashMap<>();
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
		
		for(Import im : s.getImports()) {
			List<String> imported = Utilities.getImportNames(s, im);
			if(imported.contains(s.getName())) {
				error(s.getName() + " imports a file with the same name.",im,SpearPackage.Literals.IMPORT__IMPORT_URI);
			}
		}
		
		/* 
		 * s.getUnits().stream().forEach(d -> insert(map,resolver.apply(d),d)); 
		 * 
		 * don't need to add units because they aren't used in the Lustre, at all.
		 * */
		s.getTypedefs().stream().forEach(td -> insert(map,resolver.apply(td),td));
		//need to add enumerations here as well.
		s.getConstants().stream().forEach(c -> insert(map,resolver.apply(c),c));
		s.getPatterns().stream().forEach(p -> insert(map,resolver.apply(p),p));
		
		//check the patterns here because the elements above are used by the patterns
		s.getPatterns().stream().forEach(p -> checkNamesAreUnique(map,p));
		
		s.getMacros().stream().forEach(m -> insert(map,resolver.apply(m),m));
		s.getInputs().stream().forEach(v -> insert(map,resolver.apply(v),v));
		s.getOutputs().stream().forEach(v -> insert(map,resolver.apply(v),v));
		s.getState().stream().forEach(v -> insert(map,resolver.apply(v),v));
		s.getAssumptions().stream().forEach(c -> insert(map,resolver.apply(c),c));
		s.getRequirements().stream().forEach(c -> insert(map,resolver.apply(c),c));
		s.getBehaviors().stream().forEach(c -> insert(map,resolver.apply(c),c));
		
		for(String key : map.keySet()) {
			Set<EObject> set = map.get(key);
			if(set.size() > 1) {
				set.stream().forEach(e -> error("Name " + key + " used in multiple places.", e, null));
			}
		}
	}
}
