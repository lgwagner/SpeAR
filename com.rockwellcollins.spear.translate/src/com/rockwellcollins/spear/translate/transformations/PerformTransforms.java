package com.rockwellcollins.spear.translate.transformations;

import com.rockwellcollins.spear.translate.intermediate.Document;

public class PerformTransforms {

	public static void apply(Document d, boolean rename) throws Exception {
		ReplaceAbstractTypes.transform(d);
		PropagatePredicates.transform(d);

		//these must be in this order
		NormalizeOperators.transform(d);
		RemoveSugar.transform(d);
		ExpandInExpressions.transform(d);
		
		if (rename) { CreateUserNamespace.transform(d); }

		GenerateUFCObligations.crunch(d);
		
		RemoveCompositeReferences.transform(d);
		ReplaceShortHandRecords.transform(d);
		ReplaceSpecificationCalls.transform(d);
		UniquifyNormalizedCalls.transform(d);
	}
}
