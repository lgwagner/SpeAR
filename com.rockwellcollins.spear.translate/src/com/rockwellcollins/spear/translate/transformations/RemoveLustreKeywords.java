package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.utilities.LustreUtilities;

public class RemoveLustreKeywords {

	public static Map<EObject,Map<String,String>> transform(SpearDocument doc) {
		Map<EObject,Map<String,String>> map = new HashMap<>();
		doc.patterns.values().stream().forEach(p -> map.put(p, transform(p)));
		doc.specifications.values().stream().forEach(s -> map.put(s, transform(s)));
		return map;
	}
	
	public static Map<EObject,Map<String,String>> transform(PatternDocument doc) {
		Map<EObject,Map<String,String>> map = new HashMap<>();
		doc.patterns.values().stream().forEach(p -> map.put(p, transform(p)));
		return map;		
	}
	
	public static Map<String,String> transform(EObject o) {
		RemoveLustreKeywords rlk = new RemoveLustreKeywords();
		return rlk.processNames(o);
	}

	private final Set<String> keywords;
	
	public RemoveLustreKeywords() {
		keywords = LustreUtilities.getLustreKeywordSet();
	}
	
	private boolean checkForConflict(String name) {
		for(String keyword : keywords) {
			if(name.equals(keyword)) {
				return true;
			}
		}
		return false;
	}
	
	private String makeNameUnique(String original) {
		return original + "_";
	}
	
	private Map<String,String> processNames(EObject root) {
		Map<String,String> renamed = new HashMap<>();
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
		for (EObject e : EcoreUtil2.getAllContentsOfType(root, EObject.class)) {
			String name = resolver.apply(e);
			if (name != null) {
				if (checkForConflict(name)) {
					String uniqueName = makeNameUnique(name);
					e.eSet(resolver.getAttribute(e), uniqueName);
					renamed.put(uniqueName,name);
				}
			}
		}
		return renamed;
	}
}
