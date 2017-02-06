package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.translate.utilities.EmitPredicateProperties;

public class PropagatePredicates {
	
	public static void transform(SpearDocument doc) {
		doc.specifications.values().stream().forEach(s -> transform(s));
	}
	
	public static void transform(Specification s) {
		List<FormalConstraint> assumptions = new ArrayList<>();
		List<FormalConstraint> properties = new ArrayList<>();
		
		for(Macro m : s.getMacros()) {
			Expr e = EmitPredicateProperties.crunch(m);
			properties.add(makeConstraint(m,e));
		}

		for(Variable v : s.getInputs()) {
			Expr e = EmitPredicateProperties.crunch(v);
			assumptions.add(makeConstraint(v,e));
		}

		for(Variable v : s.getOutputs()) {
			Expr e = EmitPredicateProperties.crunch(v);
			properties.add(makeConstraint(v,e));
		}
		
		for(Variable v : s.getState()) {
			Expr e = EmitPredicateProperties.crunch(v);
			properties.add(makeConstraint(v,e));
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
