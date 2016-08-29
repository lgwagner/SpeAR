package com.rockwellcollins.spear.translate.transformations;

import java.util.Map;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;

public class PerformTransforms {

	public static Map<File,Map<String,String>> apply(SpearDocument doc) throws Exception {
		Map<File,Map<String,String>> renamed = RemoveLustreKeywords.transform(doc);
		NormalizeOperators.transform(doc);
		ReplaceShortHandRecords.transform(doc);
		RemoveSugar.transform(doc);
		ReplaceSpecificationCalls.transform(doc);
		return renamed;
	}
	
	public static Map<Pattern,Map<String,String>> apply(PatternDocument doc) throws Exception {
		Map<Pattern,Map<String,String>> renamed = RemoveLustreKeywords.transform(doc);
		NormalizeOperators.transform(doc);
		ReplaceShortHandRecords.transform(doc);
		RemoveSugar.transform(doc);
		return renamed;		
	}
}
