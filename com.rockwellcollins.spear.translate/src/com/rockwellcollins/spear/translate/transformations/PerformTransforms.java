package com.rockwellcollins.spear.translate.transformations;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class PerformTransforms {

	public static Map<EObject,Map<String,String>> apply(SpearDocument doc) throws Exception {
		Map<EObject,Map<String,String>> renamed = RemoveLustreKeywords.transform(doc);
		NormalizeOperators.transform(doc);
		ReplaceShortHandRecords.transform(doc);
		RemoveSugar.transform(doc);
		ReplaceSpecificationCalls.transform(doc);
		return renamed;
	}
	
	public static Map<EObject,Map<String,String>> apply(PatternDocument doc) throws Exception {
		Map<EObject,Map<String,String>> renamed = RemoveLustreKeywords.transform(doc);
		NormalizeOperators.transform(doc);
		ReplaceShortHandRecords.transform(doc);
		RemoveSugar.transform(doc);
		return renamed;		
	}
}
