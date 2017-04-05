package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.translate.intermediate.Document;

public class CreateUserNamespace {
	
	public static void transform(Document doc) {
		doc.files.forEach(f -> doc.renamed.put(f, transform(f)));
	}
	
	public static Map<String,String> transform(EObject o) {
		CreateUserNamespace usernames = new CreateUserNamespace();
		return usernames.processNames(o);
	}

	private SimpleAttributeResolver<EObject, String> resolver;

	public CreateUserNamespace() {
		resolver = SimpleAttributeResolver.newResolver(String.class,"name");
	}
	
	private String makeUsername(String original) {
		return "USER_" + original;
	}
	
	private Map<String,String> processNames(EObject root) {
		Map<String,String> renamed = new HashMap<>();
		rename(renamed,root);
		for (EObject e : EcoreUtil2.getAllContentsOfType(root, EObject.class)) {
			rename(renamed, e);
		}
		return renamed;
	}

	private void rename(Map<String, String> renamed, EObject e) {
		String name = resolver.apply(e);
		if (name != null) {
			String uniqueName = makeUsername(name);
			e.eSet(resolver.getAttribute(e), uniqueName);
			renamed.put(uniqueName,name);
		}
	}
}
