package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;

public class TransformObservers {
	
	public static void transform(SpearDocument doc) {
		for(Specification s : doc.specifications.values()) {
			transform(s);
		}
	}
	
	private static EObject transform(Specification s) {
		
		for(Constraint c : s.getBehaviors()) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				if(fc.getFlagAsWitness() != null) {
					Expr not = Create.createNot(fc.getExpr());
					fc.setExpr(not);
				}
			}
		}
		
		return s;
	}
}
