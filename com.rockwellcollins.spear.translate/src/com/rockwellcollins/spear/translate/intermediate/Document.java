package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;

public class Document {

	public EObject main;
	public Collection<File> files = new HashSet<>();
	public Map<EObject,Map<String,String>> renamed = new HashMap<>();
	private SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
	
	public Document(EObject o) {
		String mainName = resolver.apply(o);
		Collection<EObject> objects = FindDependencies.get2(o);
		for(EObject ob : objects) {
			if (ob instanceof File) {
				File f = (File) ob;
				files.add(f);
			}
		}
		
		for(EObject ob : objects) {
			String name = resolver.apply(ob);
			if(name.equals(mainName)) {
				this.main=ob;
			}
		}
	}

	public void transform() {
		try {
			PerformTransforms.apply(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMainName() {
		return resolver.apply(this.main);
	}
}
