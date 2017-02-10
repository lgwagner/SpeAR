package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.optional.Optional;
import com.rockwellcollins.spear.optional.Some;
import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.translate.utilities.EmitPredicateProperties;

public class PropagatePredicates {
	
	public static void transform(SpearDocument doc) {
		//doc.patterns.values().stream().forEach(p -> transform(p));
		doc.specifications.values().stream().forEach(s -> transform(s));
	}
	
	public static void transform(PatternDocument doc) {
		doc.patterns.values().stream().forEach(p -> transform(p));		
	}
	
	private static void transform(Specification s) {
		List<FormalConstraint> assumptions = new ArrayList<>();
		List<FormalConstraint> properties = new ArrayList<>();
		
		for(Constant c : s.getConstants()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(c);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(c,some.value));	
			}
		}
		
		for(Macro m : s.getMacros()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(m);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(m,some.value));	
			}
		}

		for(Variable v : s.getInputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				assumptions.add(makeConstraint(v,some.value));	
			}
		}

		for(Variable v : s.getOutputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(v,some.value));
			}
		}
		
		for(Variable v : s.getState()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(v,some.value));
			}
		}
		s.getAssumptions().addAll(assumptions);
		s.getBehaviors().addAll(properties);
	}
	
	private static void transform(Pattern p) {
		List<LustreAssertion> assertions = new ArrayList<>();
		List<LustreProperty> properties = new ArrayList<>();
		List<Variable> locals = new ArrayList<>();
		List<LustreEquation> equations = new ArrayList<>();
		
		for(Variable v : p.getInputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				Variable prop = createPropertyVariable(v);
				locals.add(prop);
				equations.add(Create.createLustreEquation(Collections.singletonList(prop), some.value));
				assertions.add(Create.createLustreAssertion(prop));
			}
		}
		
		for(Variable v : p.getOutputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				Variable prop = createPropertyVariable(v);
				locals.add(prop);
				equations.add(Create.createLustreEquation(Collections.singletonList(prop), some.value));
				properties.add(Create.createLustreProperty(prop));
			}
		}
		
		for(Variable v : p.getLocals()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				Variable prop = createPropertyVariable(v);
				locals.add(prop);
				equations.add(Create.createLustreEquation(Collections.singletonList(prop), some.value));
				properties.add(Create.createLustreProperty(prop));
			}
		}
		
		p.getAssertions().addAll(assertions);
		p.getEquations().addAll(equations);
		p.getProperties().addAll(properties);
		p.getLocals().addAll(locals);
	}
	
	private static FormalConstraint makeConstraint(IdRef idr, Expr e) {
		String original = SimpleAttributeResolver.NAME_RESOLVER.apply(idr);
		String name = original + "_satisfies_predicate";
		return Create.createFormalConstraint(name, e);
	}
	
	private static Variable createPropertyVariable(Variable v) {
		String original = v.getName();
		String name = original + "_satisfies_predicate";
		return Create.createBoolVariable(name);
	}
}
