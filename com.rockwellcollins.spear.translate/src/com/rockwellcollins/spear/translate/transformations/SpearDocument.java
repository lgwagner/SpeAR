package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.actions.FindFileDependencies;

public class SpearDocument {

	public String mainName;
	public List<File> files = new ArrayList<>();

	public SpearDocument(Specification main) {
		this.mainName = main.getName();
		for (File file : FindFileDependencies.instance(main).getCalledFiles()) {
			files.add(file);
		}
	}
	
	public Specification getMain() {
		for(File f : files) {
			if(f.getName().equals(mainName)) {
				return (Specification) f;
			}
		}
		return null;
	}
}
