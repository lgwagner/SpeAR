package com.rockwellcollins.spear.translate.transformations;

import com.rockwellcollins.spear.translate.intermediate.Document;

public class PerformTransforms {

	public static void apply(Document d) throws Exception {
		ReplaceAbstractTypes.transform(d);
		PropagatePredicates.transform(d);
		CreateUserNamespace.transform(d);
		RemoveCompositeReferences.transform(d);
		ReplaceShortHandRecords.transform(d);
		NormalizeOperators.transform(d);
		RemoveSugar.transform(d);
		ReplaceSpecificationCalls.transform(d);
		UniquifyNormalizedCalls.transform(d);
	}
}
