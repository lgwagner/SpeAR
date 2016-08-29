package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.utilities.LustreUtilities;

public class RemoveLustreKeywords {

	public static Map<File,Map<String,String>> transform(SpearDocument doc) {
		Map<File,Map<String,String>> filemap = new HashMap<>();
		for(File f : doc.files) {
			filemap.put(f, transform(f));
		}
		return filemap;
	}
	
	public static Map<Pattern,Map<String,String>> transform(PatternDocument doc) {
		Map<Pattern,Map<String,String>> patternmap = new HashMap<>();
		for(Pattern p : doc.patterns) {
			patternmap.put(p, transform(p));
		}
		return patternmap;		
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
