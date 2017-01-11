package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;

public class GenerateDot {

	public static String generateDot(Specification main) {
		GenerateDot generate = new GenerateDot(main);
		generate.generate();
		return generate.buffer.toString();
	}

	private final static String firstline = "digraph G {";
	private final static String lastline = "}";
	private final static String newline = "\n";
	private final static String spacedArrow = " -> ";
	
	private Specification specification;
	private StringBuffer buffer;
	
	private GenerateDot(Specification s) {
		this.specification=s;
		this.buffer=new StringBuffer();
	}
	
	private void generate() {
		buffer.append(firstline + newline);
		
		Set<File> used = new HashSet<>();
		
		for(Import im : specification.getImports()) {
			String URI = im.getImportURI();
			Resource importedResource = EcoreUtil2.getResource(specification.eResource(), URI);
			List<EObject> contents = importedResource.getContents();
			for(EObject element : contents) {
				if (element instanceof Definitions) {
					Definitions def = (Definitions) element;
					if(!used.contains(def)) {
						buffer.append(specification.getName() + spacedArrow + def.getName() + newline);
						buffer.append(def.getName() + "[shape=polygon,sides=4,label=\"" + def.getName() + "\"]" + newline);
					}
				}
			}
		}
		
		for(SpecificationCall call : EcoreUtil2.getAllContentsOfType(specification, SpecificationCall.class)) {
			Specification called = call.getSpec();
			
			buffer.append(specification.getName() + spacedArrow + called.getName() + newline);
			if(!used.contains(call.getSpec())) {
				used.add(called);
				buffer.append(called.getName() + " [label=\"" + called.getName() + "\"]" + newline);
			}
		}
		buffer.append(lastline);
	}
}
