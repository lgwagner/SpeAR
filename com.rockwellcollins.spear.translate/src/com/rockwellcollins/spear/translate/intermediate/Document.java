package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;
import com.rockwellcollins.spear.utilities.Utilities;

public class Document {

	public EObject main;
	public Collection<File> files = new HashSet<>();
	public Map<EObject,Map<String,String>> renamed = new HashMap<>();
	
	private SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
	
	public Document(Specification f) {
		Collection<File> deps = FindDependencies.get(f);
		
		//fixme
		Map<String,File> filemap = new HashMap<>();
		deps.stream().forEach(file -> filemap.put(file.getName(), file));
		
		files.addAll(deps);
		this.main=filemap.get(f.getName());
	}
	
	public Document(Pattern p) {
		Collection<File> deps = FindDependencies.get(p);
		
		File mainFile = (File) Utilities.getTopFile(p);
		Map<String,File> filemap = new HashMap<>();
		deps.stream().forEach(f -> filemap.put(f.getName(), f));
	
		File newMainFile = filemap.get(mainFile.getName());
		Map<String,Pattern> patternmap = new HashMap<>();
		newMainFile.getPatterns().stream().forEach(pat -> patternmap.put(pat.getName(),pat));
		
		files.addAll(filemap.values());
		this.main=patternmap.get(p.getName());
	}
	
	public Document(TypeDef td) {
		Collection<File> deps = FindDependencies.get(td);
		
		File mainFile = (File) Utilities.getTopFile(td);
		Map<String,File> filemap = new HashMap<>();
		deps.stream().forEach(f -> filemap.put(f.getName(), f));
	
		File newMainFile = filemap.get(mainFile.getName());
		Map<String,TypeDef> typedefmap = new HashMap<>();
		newMainFile.getTypedefs().stream().forEach(tydef -> typedefmap.put(tydef.getName(),tydef));
		
		files.addAll(filemap.values());
		this.main=typedefmap.get(td.getName());		
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
