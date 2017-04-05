package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.utilities.Utilities;

public class FindDependencies {

	public static Collection<File> get(EObject main) {
		Set<File> files = new HashSet<>();
		File mainFile = (File) Utilities.getTopFile(main);
		get(mainFile,files);
		return EcoreUtil2.copyAll(files);
	}
	
	private static void get(File root, Set<File> elements) {
		elements.add(root);
		for(Import im : root.getImports()) {
			File imported = Utilities.getImportedFile(root, im);
			if(!elements.contains(imported)) {
				get(imported,elements);
			}
		}
	}
}
