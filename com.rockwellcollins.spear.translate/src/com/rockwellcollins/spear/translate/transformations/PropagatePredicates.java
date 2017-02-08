package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.optional.OptionalExpr;
import com.rockwellcollins.spear.optional.SomeExpr;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.translate.utilities.EmitPredicateProperties;

public class PropagatePredicates {
	
	public static void transform(SpearDocument doc) {
		doc.specifications.values().stream().forEach(s -> transform(s));
	}
	
	public static void transform(Specification s) {
		List<FormalConstraint> assumptions = new ArrayList<>();
		List<FormalConstraint> properties = new ArrayList<>();
		
		for(Constant c : s.getConstants()) {
			OptionalExpr oe = EmitPredicateProperties.crunch(c);
			if (oe instanceof SomeExpr) {
				SomeExpr some = (SomeExpr) oe;
				properties.add(makeConstraint(c,some.expr));	
			}
		}
		
		for(Macro m : s.getMacros()) {
			OptionalExpr oe = EmitPredicateProperties.crunch(m);
			if (oe instanceof SomeExpr) {
				SomeExpr some = (SomeExpr) oe;
				properties.add(makeConstraint(m,some.expr));	
			}
		}

		for(Variable v : s.getInputs()) {
			OptionalExpr oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof SomeExpr) {
				SomeExpr some = (SomeExpr) oe;
				assumptions.add(makeConstraint(v,some.expr));	
			}
		}

		for(Variable v : s.getOutputs()) {
			OptionalExpr oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof SomeExpr) {
				SomeExpr some = (SomeExpr) oe;
				properties.add(makeConstraint(v,some.expr));
			}
		}
		
		for(Variable v : s.getState()) {
			OptionalExpr oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof SomeExpr) {
				SomeExpr some = (SomeExpr) oe;
				properties.add(makeConstraint(v,some.expr));
			}
		}
		s.getAssumptions().addAll(assumptions);
		s.getBehaviors().addAll(properties);
	}
	
	private static FormalConstraint makeConstraint(IdRef idr, Expr e) {
		String original = SimpleAttributeResolver.NAME_RESOLVER.apply(idr);
		String name = original + "_satisfies_predicate";
		return Create.createFormalConstraint(name, e);
	}
}
