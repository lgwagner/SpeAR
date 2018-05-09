package com.rockwellcollins.spear.translate.transformations;

import static com.rockwellcollins.spear.language.Create.createBoolVariable;
import static com.rockwellcollins.spear.language.Create.createFormalConstraint;
import static com.rockwellcollins.spear.language.Create.createLustreAssertion;
import static com.rockwellcollins.spear.language.Create.createLustreEquation;
import static com.rockwellcollins.spear.language.Create.createLustreProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.optional.Optional;
import com.rockwellcollins.spear.optional.Some;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.utilities.EmitPredicateProperties;

public class PropagatePredicates {

	public static void transform(Document doc) {
		Consumer<File> consume = f -> {
			if (f instanceof Specification) {
				Specification spec = (Specification) f;
				transform(spec);
			}
		};

		doc.files.stream().forEach(consume);

		if (doc.main instanceof Pattern) {
			Pattern pattern = (Pattern) doc.main;
			transform(pattern);
		}
	}

	private static void transform(Specification s) {
		List<FormalConstraint> assumptions = new ArrayList<>();
		List<FormalConstraint> properties = new ArrayList<>();

		for (Constant c : s.getConstants()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(c);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(c, some.value));
			}
		}

		for (Macro m : s.getMacros()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(m);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(m, some.value));
			}
		}

		for (Variable v : s.getInputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				assumptions.add(makeConstraint(v, some.value));
			}
		}

		for (Variable v : s.getOutputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(v, some.value));
			}
		}

		for (Variable v : s.getState()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				properties.add(makeConstraint(v, some.value));
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

		for (Variable v : p.getInputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				Variable prop = createPropertyVariable(v);
				locals.add(prop);
				equations.add(createLustreEquation(Collections.singletonList(prop), some.value));
				assertions.add(createLustreAssertion(prop));
			}
		}

		for (Variable v : p.getOutputs()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				Variable prop = createPropertyVariable(v);
				locals.add(prop);
				equations.add(createLustreEquation(Collections.singletonList(prop), some.value));
				properties.add(createLustreProperty(prop));
			}
		}

		for (Variable v : p.getLocals()) {
			Optional<Expr> oe = EmitPredicateProperties.crunch(v);
			if (oe instanceof Some) {
				Some<Expr> some = (Some<Expr>) oe;
				Variable prop = createPropertyVariable(v);
				locals.add(prop);
				equations.add(createLustreEquation(Collections.singletonList(prop), some.value));
				properties.add(createLustreProperty(prop));
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
		return createFormalConstraint(name, e);
	}

	private static Variable createPropertyVariable(Variable v) {
		String original = v.getName();
		String name = original + "_satisfies_predicate";
		return createBoolVariable(name);
	}
}
