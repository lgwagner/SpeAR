package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.util.SpearSwitch;

public class CreateUserNamespace extends SpearSwitch<Integer> {
	
	public static void transform(Document d) {
		CreateUserNamespace namespace = new CreateUserNamespace();
		d.files.stream().forEach(f -> namespace.doSwitch(f));
		d.renamed = namespace.renamed;
	}
	
	private SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
	private Map<EObject,Map<String,String>> renamed = new HashMap<>();
	private Map<String, String> current = new HashMap<>();
	
	@Override
	public Integer caseFile(File f) {
		String oldName = f.getName();
		Map<String,String> prev = current;
		current = new HashMap<String,String>();
		
		this.defaultCase(f);
		
		renamed.put(f, current);
		String newName = f.getName();
		current = prev;
		current.put(newName, oldName);
		return 0;
	}
	
	@Override
	public Integer casePattern(Pattern p) {
		String oldName = p.getName();
		Map<String,String> prev = current;
		current = new HashMap<String,String>();
		
		this.defaultCase(p);
		
		renamed.put(p, current);
		String newName = p.getName();
		current = prev;
		current.put(newName, oldName);
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject o) {
		rename(o);
		o.eContents().stream().forEach(sub -> this.doSwitch(sub));
		return 0;
	}
	
	private void rename(EObject e) {
		String name = resolver.apply(e);
		if (name != null) {
			String uniqueName = "USER_" + name;
			e.eSet(resolver.getAttribute(e), uniqueName);
			current.put(uniqueName,name);
		}
	}
}
