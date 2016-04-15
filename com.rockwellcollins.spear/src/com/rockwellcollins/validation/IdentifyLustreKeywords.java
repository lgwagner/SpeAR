package com.rockwellcollins.validation;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.utilities.LustreUtilities;

public class IdentifyLustreKeywords extends AbstractSpearJavaValidator {

	public Set<String> keywords = LustreUtilities.getLustreKeywordSet();
	
	@Check
	public void checkName(EObject o) {
		String name = SimpleAttributeResolver.NAME_RESOLVER.apply(o);
		if(name != null) {
			if(keywords.contains(name)) {
				error(name + " is a reserved keyword, please choose a different name.", o, null);
			}
		}
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {}
}
