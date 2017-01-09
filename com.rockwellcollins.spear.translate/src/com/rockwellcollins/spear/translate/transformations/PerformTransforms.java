package com.rockwellcollins.spear.translate.transformations;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;

public class PerformTransforms {

	public static Map<EObject,Map<String,String>> apply(SpearDocument doc) throws Exception {
		ReplaceAbstractTypes.transform(doc);
		ReplaceVariableArrayDefs.transform(doc);
		Map<EObject,Map<String,String>> renamed = RemoveLustreKeywords.transform(doc);
		NormalizeOperators.transform(doc);
		ReplaceShortHandRecords.transform(doc);
		RemoveSugar.transform(doc);
		TransformObservers.transform(doc);
		ReplaceSpecificationCalls.transform(doc);
		UniquifyNormalizedCalls.transform(doc);
		return renamed;
	}
	
	public static Map<EObject,Map<String,String>> apply(PatternDocument doc) throws Exception {
		ReplaceAbstractTypes.transform(doc);
		ReplaceVariableArrayDefs.transform(doc);
		Map<EObject,Map<String,String>> renamed = RemoveLustreKeywords.transform(doc);
		NormalizeOperators.transform(doc);
		ReplaceShortHandRecords.transform(doc);
		RemoveSugar.transform(doc);
		return renamed;		
	}
}
