package com.rockwellcollins.spear.translate.transformations;

import com.rockwellcollins.spear.translate.intermediate.Document;

public class PerformTransforms {

	public static void apply(Document d, boolean rename) throws Exception {
		ReplaceAbstractTypes.transform(d);
		PropagatePredicates.transform(d);
		if(rename) { CreateUserNamespace.transform(d); }
		RemoveCompositeReferences.transform(d);
		ReplaceShortHandRecords.transform(d);
		NormalizeOperators.transform(d);
		RemoveSugar.transform(d);
		ReplaceSpecificationCalls.transform(d);
		UniquifyNormalizedCalls.transform(d);
	}
}
