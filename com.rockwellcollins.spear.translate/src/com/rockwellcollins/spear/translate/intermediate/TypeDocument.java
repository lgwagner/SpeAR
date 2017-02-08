package com.rockwellcollins.spear.translate.intermediate;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.TypeDef;

public class TypeDocument extends Document {
	
	public TypeDocument(TypeDef top) {
		for(EObject e : FindTypeDependencies.instance(top)) {
			if (e instanceof TypeDef) {
				TypeDef td = (TypeDef) e;
				typedefs.put(td.getName(), td);
			}
		}
	}
}
