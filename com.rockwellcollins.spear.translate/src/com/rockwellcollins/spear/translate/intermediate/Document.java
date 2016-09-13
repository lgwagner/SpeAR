package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;

public class Document {

	public String mainName;
	public Map<String,TypeDef> typedefs = new HashMap<>();
	public Map<String,Constant> constants = new HashMap<>();
	public Map<String,Pattern> patterns = new HashMap<>();
	
	public Map<EObject,Map<String,String>> renamed;

}
