package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.TypeDef;

public class Document {

	public String mainName;
	public Map<String,TypeDef> typedefs = new HashMap<>();
	
	public Map<EObject,Map<String,String>> renamed;

}
