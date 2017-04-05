package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.Utilities;

public class FindDependencies {

	public static Collection<EObject> get(EObject main) {
		Set<EObject> elements = new HashSet<>();
		elements.add(main);
		File root = (File) Utilities.getTopFile(main);
		get(root,elements);
		return EcoreUtil2.copyAll(elements);
	}
	
	private static void get(File root, Set<EObject> elements) {
		elements.add(root);
		for(Import im : root.getImports()) {
			File imported = Utilities.getImportedFile(root, im);
			if(!elements.contains(imported)) {
				get(imported,elements);
			}
		}
	}
}
