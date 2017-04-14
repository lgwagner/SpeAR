package com.rockwellcollins.spear.translate.excel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.utilities.Utilities;

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
			File importedFile = Utilities.getImportedFile(im);
			processFile(importedFile);
		}
	}
	
	public Collection<Specification> getSpecifications() {
		List<Specification> list = new ArrayList<>();
		for(File f : used) {
			if (f instanceof Specification) {
				Specification s = (Specification) f;
				list.add(s);
			}
		}
		//this copy needs to happen.
		return EcoreUtil2.copyAll(list);
	}
}
