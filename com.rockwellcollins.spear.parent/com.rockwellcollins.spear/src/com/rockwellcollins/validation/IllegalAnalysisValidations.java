package com.rockwellcollins.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpecificationCall;

/**
 * This class will create validations that highlight anything that is
 * unsupported.
 * 
 * @author lgwagner
 *
 */
public class IllegalAnalysisValidations extends AbstractSpearValidator {

	@Check
	public void flagIllegalExpressionsInPatterns(Pattern p) {
		for (SpecificationCall call : EcoreUtil2.getAllContentsOfType(p, SpecificationCall.class)) {
			error("Specification calls are unsupported inside of patterns.", call, null);
		}
	}

	@Check
	public void flagSpecCallsInMacros(Macro m) {
		for (SpecificationCall call : EcoreUtil2.getAllContentsOfType(m, SpecificationCall.class)) {
			error("Specification calls are not supported inside of macros.", call, null);
		}
	}

	@Check
	public void flagImproperSpecificationCalls(SpecificationCall call) {
		EObject container = call.eContainer();

		if (container instanceof Macro) {
			return;
		}

		if (container instanceof BinaryExpr) {
			BinaryExpr be = (BinaryExpr) container;
			Set<String> ops = getEqualBinaryOperators();

			if (!ops.contains(be.getOp())) {
				error("Specification call results must be equated to local specification variables.", call, null);
			}
		} else {
			error("Specification call results must be equated to local specification variables.", call, null);
		}
	}

	private Set<String> getEqualBinaryOperators() {
		Set<String> acceptable = new HashSet<>();
		acceptable.add("==");
		acceptable.add("equal to");
		acceptable.add("is equal to");
		return acceptable;
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
	}
}
