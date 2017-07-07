package com.rockwellcollins.spear.translate.transformations;

import com.rockwellcollins.spear.translate.intermediate.Document;

public class PerformTransforms {

	public static void apply(Document d, boolean rename) throws Exception {
		if (rename) { CreateUserNamespace.transform(d); }
		ReplaceAbstractTypes.transform(d);
		PropagatePredicates.transform(d);
		
		//these must be in this order
		NormalizeOperators.transform(d);
		RemoveSugar.transform(d);
		GenerateUFCObligations.crunch(d);
		
		RemoveCompositeReferences.transform(d);
		ReplaceShortHandRecords.transform(d);
		ReplaceSpecificationCalls.transform(d);
		UniquifyNormalizedCalls.transform(d);
	}
}
