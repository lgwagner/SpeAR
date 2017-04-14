package com.rockwellcollins.spear.utilities;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.Pattern;

public class Utilities {
	
	public static void getImportedFiles(Import im, Set<File> imported) {
		File importedFile = getImportedFile(im);
		if(imported.contains(importedFile)) {
			return;
		}
		
		imported.add(importedFile);
		for(Import subIm : importedFile.getImports()) {
			getImportedFiles(subIm,imported);
		}
	}

	public static File getImportedFile(Import im) {
		String URI = im.getImportURI();
		File root = getRoot(im);
		Resource importedResource = EcoreUtil2.getResource(root.eResource(), URI);
		List<EObject> contents = importedResource.getContents();
		if(contents.size() == 1) {
			EObject element = contents.get(0);
			return (File) element;
		}
		return null;
	}
	
	public static File getRoot(EObject o) {
		EObject root = EcoreUtil2.getRootContainer(o);
		if (root instanceof File) {
			File file = (File) root;
			return file;
		} else {
			throw new RuntimeException("Root of object: " + o + " should be a File construct.");
		}
	}
	
	public static EObject getTopContainer(EObject o) {
		EObject container = o.eContainer();
		if(container instanceof File || container instanceof Pattern) {
			return container;
		}
		return getTopContainer(container);
	}
	
	public static EObject getTopFile(EObject o) {
		if (o instanceof File) {
			return o;
		}
		
		EObject container = o.eContainer();
		if(container instanceof File) {
			return container;
		}
		return getTopContainer(container);		
	}
	
	public static String getName(EObject o) {
		String name = SimpleAttributeResolver.NAME_RESOLVER.apply(o);
		if(name == null) {
			throw new RuntimeException("Name not found for object " + o);
		} else {
			return name;
		}
	}
	
	public static String getFileBasedName(EObject o) {
		String name = getName(o);
		String filename = Utilities.getRoot(o).getName();
		return filename + "." + name;
	}
}
