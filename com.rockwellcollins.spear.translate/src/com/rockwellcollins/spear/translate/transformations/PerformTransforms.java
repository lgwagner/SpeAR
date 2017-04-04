package com.rockwellcollins.spear.translate.transformations;

import com.rockwellcollins.spear.translate.intermediate.Document;

public class PerformTransforms {

	public static void apply(Document doc) throws Exception {
		RemoveLustreKeywords.transform(doc);
		ReplaceAbstractTypes.transform(doc);
		PropagatePredicates.transform(doc); //must come after replace Variable array defs
		RemoveCompositeReferences.transform(doc);
		ReplaceShortHandRecords.transform(doc);
		NormalizeOperators.transform(doc);
		RemoveSugar.transform(doc);
		ReplaceSpecificationCalls.transform(doc);
		UniquifyNormalizedCalls.transform(doc);
	}
}
