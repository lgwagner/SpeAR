package com.rockwellcollins.spear.translate.transformations;

import java.util.Map;

import com.rockwellcollins.spear.File;

public class PerformTransforms {

	public static Map<File,Map<String,String>> apply(SpearDocument p) throws Exception {
		Map<File,Map<String,String>> renamed = RemoveLustreKeywords.transform(p);
		NormalizeOperators.transform(p);
		ReplaceShortHandRecords.transform(p);
		RemoveSugar.transform(p);
		ReplaceSpecificationCalls.transform(p);
		return renamed;
	}
}
