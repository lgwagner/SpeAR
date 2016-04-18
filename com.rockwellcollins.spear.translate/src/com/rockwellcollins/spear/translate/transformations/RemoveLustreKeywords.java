package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.utilities.LustreUtilities;

public class RemoveLustreKeywords {

	public static Map<File,Map<String,String>> transform(SpearDocument p) {
		Map<File,Map<String,String>> filemap = new HashMap<>();
		for(File f : p.files) {
			filemap.put(f, transform(f));
		}
		return filemap;
	}
	
	public static Map<String,String> transform(File f) {
		RemoveLustreKeywords rlk = new RemoveLustreKeywords();
		return rlk.processNames(f);
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
					System.out.println("Variable " + name + " has been renamed to " + uniqueName + " for analysis.");
				}
			}
		}
		return renamed;
	}
}
