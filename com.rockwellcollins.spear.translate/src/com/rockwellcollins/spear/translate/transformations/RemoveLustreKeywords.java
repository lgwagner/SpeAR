package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.LustreUtilities;

public class RemoveLustreKeywords extends SpearSwitch<EObject> {

	public static void transform(SpearDocument p) {
		for(File f : p.files) {
			transform(f);
		}
	}

	private static File transform(File f) {
		new RemoveLustreKeywords().doSwitch(f);
		return f;
	}
	
	private final Set<String> keywords;
	
	public RemoveLustreKeywords() {
		keywords = LustreUtilities.getLustreKeywordSet();
	}
	
	private boolean checkForConflict(String name) {
		for(String keyword : keywords) {
			//this used to be name.startsWith
			if(name.equals(keyword)) {
				return true;
			}
		}
		return false;
	}
	
	private String makeNameUnique(String original) {
		return original + "_";
	}
	
	private List<String> processNames(EObject root) {
		List<String> renamed = new ArrayList<>();
		
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
		for (EObject e : EcoreUtil2.getAllContentsOfType(root, EObject.class)) {
			String name = resolver.apply(e);
			if (name != null) {
				if (checkForConflict(name)) {
					String uniqueName = makeNameUnique(name);
					renamed.add(uniqueName);
					e.eSet(resolver.getAttribute(e), uniqueName);
				}
			}
		}
		return renamed;
	}
	
	@Override
	public File caseFile(File f) {
		this.processNames(f);
		for(SpecificationCall sc : EcoreUtil2.getAllContentsOfType(f, SpecificationCall.class)) {
			this.processNames(sc.getSpec());
		}
		return f;
	}
	
	@Override
	public EObject defaultCase(EObject o) {
		throw new RuntimeException("Expected a specification but received a " + o);
	}
}
