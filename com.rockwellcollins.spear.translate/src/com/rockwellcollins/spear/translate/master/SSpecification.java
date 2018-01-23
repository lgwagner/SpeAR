package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.naming.backend.Scope;
import com.rockwellcollins.spear.utilities.LustreLibrary;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.EquationBuilder;
import jkind.lustre.builders.NodeBuilder;

public class SSpecification extends SMapElement {

	public static List<String> addNames(Collection<Specification> list, Scope map) {
		return list.stream().map(s -> SSpecification.addName(s, map)).collect(Collectors.toList());
	}

	public static String addName(Specification s, Scope map) {
		return map.addName(s.getName());
	}

	public static List<SSpecification> build(Collection<Specification> list, Scope map) {
		return list.stream().map(s -> SSpecification.build(s, map)).collect(Collectors.toList());
	}

	public static SSpecification build(Specification s, Scope map) {
		return new SSpecification(s, map);
	}

	public static SSpecification lookup(String name, List<SSpecification> specs) {
		for (SSpecification s : specs) {
			if (s.name.equals(name)) {
				return s;
			}
		}
		return null;
	}

	public static Integer callId = 0;

	public static void resetCallID() {
		SSpecification.callId = 0;
	}

	public static Integer getAndIncrement() {
		Integer val = SSpecification.callId;
		SSpecification.callId++;
		return val;
	}

	private String constraintsName;
	private static final String CONSTRAINTS = "constraints";

	private String consistencyName;
	private static final String CONSISTENCY = "consistent";

	private String traceabilityName;
	private static final String TRACEABILITY = "all_properties";

	public String name;
	public List<SMacro> macros = new ArrayList<>();
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();

	private List<NormalizedCall> spearCalls = new ArrayList<>();
	public List<SCall> calls = new ArrayList<>();

	public SSpecification(Specification s, Scope programMap) {
		// get the name from the global map
		this.name = programMap.lookup(s.getName());

		// copy the global map as the local
		this.map = programMap.copy();
		this.map.addScope();

		// set the name
		this.inputs.addAll(SVariable.build(s.getInputs(), this));
		this.outputs.addAll(SVariable.build(s.getOutputs(), this));
		this.state.addAll(SVariable.build(s.getState(), this));
		this.macros.addAll(SMacro.build(s.getMacros(), this));
		this.assumptions.addAll(SConstraint.build(s.getAssumptions(), this));
		this.requirements.addAll(SConstraint.build(s.getRequirements(), this));
		this.behaviors.addAll(SConstraint.build(s.getBehaviors(), this));
		this.spearCalls.addAll(EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class));

		this.constraintsName = map.addName(CONSTRAINTS);
		this.counterName = map.addName(COUNTER);
		this.consistencyName = map.addName(CONSISTENCY);
		this.traceabilityName = map.addName(TRACEABILITY);
	}

	public void resolveCalls(List<SSpecification> specs) {
		this.calls = SCall.build(spearCalls, specs, map);
	}

	public void resolveCallVars() {
		for (SCall call : calls) {
			call.resolveCallVars();
		}
	}

	public Node toBaseLustre() {
		NodeBuilder builder = new NodeBuilder(name);

		/*
		 * We must add: 1. the true inputs 2. the shadow inputs for the outputs
		 * 3. the shadow inputs for the state 4. the args from any calls that
		 * also need shadow inputs 5. the args from any calls, calls that need
		 * shadow args
		 */
		builder.addInputs(SVariable.toVarDecl(inputs, this));
		builder.addInputs(SVariable.toVarDecl(outputs, this));
		builder.addInputs(SVariable.toVarDecl(state, this));
		builder.addInputs(SCall.toVarDeclList(calls, this));

		/*
		 * We must add 1. locals for the macros 2. locals for the assumptions 3.
		 * locals for the requirements 4. locals for the behaviors
		 */
		builder.addLocals(SMacro.toVarDecls(macros, this));
		builder.addLocals(SConstraint.toVarDecl(assumptions, this));
		builder.addLocals(SConstraint.toVarDecl(requirements, this));
		builder.addLocals(SConstraint.toVarDecl(behaviors, this));
		
		/*
		 * We add a local for counters to support the "counter" expression in SpeAR
		 */
		builder.addLocal(this.getCounterVarDecl());

		/*
		 * Add assertions as output.
		 */
		builder.addOutput(this.getAssertionVarDecl());

		/*
		 * For now, we're not allowing Macros to contain specification calls
		 */
		builder.addEquation(this.getCounterEquation());
		builder.addEquations(SMacro.toEquations(macros, this));
		builder.addEquations(SConstraint.toEquation(assumptions, this));
		builder.addEquations(SConstraint.toEquation(requirements, this));
		builder.addEquations(SConstraint.toPropertyEquations(behaviors, constraintsName, this));
		return builder.build();
	}

	public Node getLogicalEntailmentMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		builder.addEquation(this.getAssertionMainEquation(requirements));

		if (!assumptions.isEmpty()) {
			builder.addAssertion(this.conjunctify(assumptions.iterator()));
		}

		builder.addProperties(SConstraint.toPropertyIds(behaviors, this));
		if (PreferencesUtil.getEnableIVCDuringEntailment()) {
			VarDecl vd = new VarDecl(this.traceabilityName, NamedType.BOOL);
			builder.addLocal(vd);

			List<SConstraint> justProperties = getJustProperties(behaviors);
			EquationBuilder eq = new EquationBuilder();
			eq.addLhs(vd.id);
			if (justProperties.isEmpty()) {
				// another hack for when there are no properties
				eq.setExpr(new BoolExpr(true));
			} else {
				eq.setExpr(conjunctify(justProperties.iterator()));
			}
			builder.addEquation(eq.build());
			builder.addProperty(vd.id);
			builder.addIvcs(SConstraint.toPropertyIds(ListUtils.union(assumptions, requirements), this));
		}
		return builder.build();
	}

	private List<SConstraint> getJustProperties(List<SConstraint> behaviors) {
		List<SConstraint> filtered = new ArrayList<>();
		for (SConstraint c : behaviors) {
			if (c instanceof SFormalConstraint) {
				SFormalConstraint sfc = (SFormalConstraint) c;
				if (!sfc.isObserver) {
					filtered.add(sfc);
				}
			}
		}
		return filtered;
	}

	public Node getLogicalEntailmentCalled() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());
		builder.addEquation(this.getAssertionCalledEquation(requirements));
		return builder.build();
	}

	public Node getLogicalConsistencyMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		builder.addLocal(this.getConsistencyVarDecl());
		
		builder.addEquation(this.getConsistencyEquation());
		builder.addEquation(this.getAssertionMainEquation(ListUtils.union(assumptions, requirements)));

		builder.addProperty(this.consistencyName);

		List<SConstraint> list = new ArrayList<>();
		list.addAll(assumptions);
		list.addAll(requirements);
		builder.addIvcs(SConstraint.toPropertyIds(list, this));

		return builder.build();
	}

	public Node getRealizabilityMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		builder.addEquation(this.getAssertionMainEquation(requirements));

		if (!assumptions.isEmpty()) {
			builder.addAssertion(this.conjunctify(assumptions.iterator()));
		}

		builder.addProperty(constraintsName);
		builder.setRealizabilityInputs(this.inputs.stream().map(input -> input.name).collect(Collectors.toList()));
		return builder.build();
	}

	public Node getLogicalConsistencyCalled() {
		return getLogicalEntailmentCalled();
	}

	private VarDecl getCounterVarDecl() {
		return new VarDecl(this.counterName, NamedType.INT);
	}

	private VarDecl getConsistencyVarDecl() {
		return new VarDecl(this.consistencyName, NamedType.BOOL);
	}

	private Equation getCounterEquation() {
		IntExpr zero = new IntExpr(0);
		IntExpr one = new IntExpr(1);
		UnaryExpr pre_counter = new UnaryExpr(UnaryOp.PRE, new IdExpr(this.counterName));
		Expr RHS = new BinaryExpr(zero, BinaryOp.ARROW, new BinaryExpr(pre_counter, BinaryOp.PLUS, one));
		return new Equation(new IdExpr(this.counterName), RHS);
	}

	private Equation getConsistencyEquation() {
		Integer iv = PreferencesUtil.getConsistencyDepthOption();
		Expr gt = new BinaryExpr(new IdExpr(this.counterName), BinaryOp.GREATEREQUAL, new IntExpr(iv));
		Expr and = new BinaryExpr(new IdExpr(this.constraintsName), BinaryOp.AND, gt);
		Expr rhs = new UnaryExpr(UnaryOp.NOT, and);
		return new Equation(new IdExpr(this.consistencyName), rhs);
	}

	private VarDecl getAssertionVarDecl() {
		return new VarDecl(this.constraintsName, NamedType.BOOL);
	}

	private Expr conjunctify(Iterator<SConstraint> it) {
		SConstraint current = it.next();
		jkind.lustre.IdExpr expr = new jkind.lustre.IdExpr(current.name);

		if (it.hasNext()) {
			return new jkind.lustre.BinaryExpr(expr, BinaryOp.AND, conjunctify(it));
		} else {
			return expr;
		}
	}

	private Equation getAssertionMainEquation(List<SConstraint> conjunct) {
		Expr RHS;
		if (conjunct.isEmpty()) {
			RHS = new BoolExpr(true);
		} else {
			RHS = conjunctify(conjunct.iterator());
		}
		return new Equation(new IdExpr(this.constraintsName), new NodeCallExpr(LustreLibrary.historically().id, RHS));
	}

	public Equation getAssertionCalledEquation(List<SConstraint> conjunct) {
		Expr RHS;
		if (conjunct.isEmpty()) {
			RHS = new BoolExpr(true);
		} else {
			RHS = conjunctify(conjunct.iterator());
		}
		return new Equation(new IdExpr(this.constraintsName), RHS);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
