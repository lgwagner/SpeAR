package com.rockwellcollins.spear.translate.transformations;

import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.GetAllIdRefs;

public class ReplaceSpecificationCalls extends SpearSwitch<EObject> {

	public static void transform(Document doc) {
		Consumer<File> consume = f -> {
			if (f instanceof Specification) {
				Specification spec = (Specification) f;
				transform(spec);
			}
		};
		doc.files.forEach(consume);
	}
	
	private static File transform(Specification s) {
		Specification updated = (Specification) new ReplaceSpecificationCalls().doSwitch(s);
		return updated;
	}

	private SpearFactory f = SpearFactory.eINSTANCE;
	
	private NormalizedCall getReplacement(Expr ids, SpecificationCall call) {
		NormalizedCall replacement = f.createNormalizedCall();
		replacement.setSpec(call.getSpec());
		replacement.getArgs().addAll(call.getArgs());
		replacement.getIds().addAll(GetAllIdRefs.getReferences(ids));
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
		o.eContents().stream().forEach(sub -> this.doSwitch(sub));
		return o;
	}
}
