package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReplaceSpecificationCalls extends SpearSwitch<EObject> {

	public static void transform(SpearDocument p) {
		for(Specification s : p.specifications.values()) {
			transform(s);
		}
	}
	
	private static File transform(Specification s) {
		Specification updated = (Specification) new ReplaceSpecificationCalls().doSwitch(s);
		return updated;
	}

	private NormalizedCall getReplacement(Expr ids, SpecificationCall call) {
		NormalizedCall replacement = f.createNormalizedCall();
		replacement.setSpec(call.getSpec());
		replacement.getArgs().addAll(call.getArgs());
		replacement.getIds().addAll(EcoreUtil2.getAllContentsOfType(ids, IdRef.class));
		return replacement;
	}
	
	@Override
	public Expr caseBinaryExpr(BinaryExpr be) {
		Expr left = (Expr) this.doSwitch(be.getLeft());
		Expr right = (Expr) this.doSwitch(be.getRight());

		//Validations should enforce the following two scenarios. ONE must be true.
		if (right instanceof SpecificationCall) {
			SpecificationCall specificationCall = (SpecificationCall) right;
			this.doSwitch(specificationCall.getSpec());
			EcoreUtil2.replace(be, getReplacement(left,specificationCall));
		}
		
		if (left instanceof SpecificationCall) {
			SpecificationCall specificationCall = (SpecificationCall) left;
			this.doSwitch(specificationCall.getSpec());
			EcoreUtil2.replace(be, getReplacement(right,specificationCall));
		}
	
		return be;
	}
	
	@Override
	public EObject defaultCase(EObject o) {
		for(EObject sub : o.eContents()) {
			this.doSwitch(sub);
		}
		return o;
	}
	
	SpearFactory f = SpearFactory.eINSTANCE;
}
