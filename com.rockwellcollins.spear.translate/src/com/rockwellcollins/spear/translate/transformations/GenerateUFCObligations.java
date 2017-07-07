package com.rockwellcollins.spear.translate.transformations;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.UFC;

public class GenerateUFCObligations {
	
	private Set<FormalConstraint> testObligations = new HashSet<>();
	
	public void crunch(Specification main) {
		for(Constraint c : main.getBehaviors()) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				
			}
		}
	}
	
	private List<FormalConstraint> doGood(FormalConstraint fc) {
		if(fc.getFlag() instanceof UFC) {
			return doGood(fc.getExpr());
		} else {
			return Collections.EMPTY_LIST;
		}
	}
	
	private List<FormalConstraint> doGood(Expr e) {
		return null;
	}
}
