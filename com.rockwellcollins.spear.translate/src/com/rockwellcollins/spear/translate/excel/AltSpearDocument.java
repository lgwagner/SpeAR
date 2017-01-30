package com.rockwellcollins.spear.translate.excel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.Specification;

public class AltSpearDocument {
	
	public static AltSpearDocument create(Specification main) {
		return new AltSpearDocument(main);
	}
	
	public String mainName;
	public Set<File> used;
	
	private AltSpearDocument(Specification main) {
		this.mainName = main.getName();
		used = new HashSet<>();
		this.processFile(main);
	}
	
	private void processFile(File f) {
		if(used.contains(f)) {
			return;
		}
		
		used.add(f);
		for(Import im : f.getImports()) {
			String URI = im.getImportURI();
			Resource importedResource = EcoreUtil2.getResource(f.eResource(), URI);
			List<EObject> contents = importedResource.getContents();
			for(EObject o : contents) {
				if (o instanceof File) {
					File importedFile = (File) o;
					processFile(importedFile);
				}
			}
		}
	}
}
