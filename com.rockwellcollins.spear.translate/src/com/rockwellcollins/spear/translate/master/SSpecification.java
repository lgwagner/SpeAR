package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.actions.SpearRuntimeOptions;
import com.rockwellcollins.spear.translate.naming.Renaming;
import com.rockwellcollins.spear.utilities.PLTL;

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
import jkind.lustre.builders.NodeBuilder;

public class SSpecification {

	public static List<String> addNames(Collection<Specification> list, Renaming global) {
		List<String> renamed = new ArrayList<>();
		for(Specification  s : list) {
			renamed.add(SSpecification.addName(s, global));
		}
		return renamed;
	}
	
	public static String addName(Specification s, Renaming global) {
		return global.getName(s.getName());
	}
	
	public static List<SSpecification> build(Collection<Specification> list, Renaming global) {
		List<SSpecification> converted = new ArrayList<>();
		for(Specification s : list) {
			converted.add(SSpecification.build(s, global));
		}
		return converted;
	}
	
	public static SSpecification build(Specification s, Renaming global) {
		return new SSpecification(s,global);
	}
	
	public static SSpecification lookup(String name , List<SSpecification> specs) {
		for(SSpecification s : specs) {
			if(s.name.equals(name)) {
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
	
	private String assertionName;
	private static final String ASSERTION = "assertions";

	private String counterName;
	private static final String COUNTER = "counter";
	
	private String consistencyName;
	private static final String CONSISTENCY = "consistent";
	
	public Renaming map;
	
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
	
	public SSpecification(Specification s, Renaming global) {
		//get the name from the global map
		this.name = global.lookupOriginal(s.getName());
		
		//copy the global map as the local
		this.map = Renaming.copy(global);
		
		// set the name
		this.inputs.addAll(SVariable.build(s.getInputs(), this));
		this.outputs.addAll(SVariable.build(s.getOutputs(), this));
		this.state.addAll(SVariable.build(s.getState(), this));
		this.macros.addAll(SMacro.build(s.getMacros(), this));
		this.assumptions.addAll(SConstraint.build(s.getAssumptions(), this));
		this.requirements.addAll(SConstraint.build(s.getRequirements(), this));
		this.behaviors.addAll(SConstraint.build(s.getBehaviors(), this));
		this.spearCalls.addAll(EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class));
		
		this.assertionName = map.getName(ASSERTION);
		this.counterName = map.getName(COUNTER);
		this.consistencyName = map.getName(CONSISTENCY);
	}

	public void resolveCalls(List<SSpecification> specs) {
		this.calls=SCall.build(spearCalls, specs, map);
	}
	
	public void resolveCallVars() {
		for(SCall call : calls) {
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
		builder.addInputs(SCall.toVarDecl(calls, this));
		
		/*
		 * We must add 
		 	1. locals for the macros 
		 	2. locals for the assumptions 
		 	3. locals for the requirements 
		 	4. locals for the behaviors
		 */
		builder.addLocals(SMacro.toVarDecls(macros, this));
		builder.addLocals(SConstraint.toVarDecl(assumptions, this));
		builder.addLocals(SConstraint.toVarDecl(requirements, this));
		builder.addLocals(SConstraint.toVarDecl(behaviors, this));

		/*
		 * Add assertions as output.
		 */
		builder.addOutput(this.getAssertionVarDecl());
		
		/*
		 * For now, we're not allowing Macros to contain specification calls
		 */
		builder.addEquations(SMacro.toEquations(macros, this));
		builder.addEquations(SConstraint.toEquation(assumptions, this));
		builder.addEquations(SConstraint.toEquation(requirements, this));
		builder.addEquations(SConstraint.toPropertyEquations(behaviors, assertionName, this));
		return builder.build();
	}

	public Node getLogicalEntailmentMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		builder.addEquation(this.getAssertionMainEquation(requirements));

		if (!assumptions.isEmpty()) {
			builder.addAssertion(this.conjunctify(assumptions.iterator()));
		}

		builder.addProperties(SConstraint.toPropertyIds(behaviors, this));
		return builder.build();
	}
	
	public Node getLogicalEntailmentCalled() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());
		
		builder.addEquation(this.getAssertionCalledEquation(requirements));
		return builder.build();
	}

	public Node getLogicalConsistencyMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		builder.addLocal(this.getCounterVarDecl());
		builder.addLocal(this.getConsistencyVarDecl());
		
		builder.addEquation(this.getCounterEquation());
		builder.addEquation(this.getConsistencyEquation());
		builder.addEquation(this.getAssertionMainEquation(getAssumptionsAndRequirements()));
		
		builder.addProperty(this.consistencyName);
		
		List<SConstraint> list = new ArrayList<>();
		list.addAll(assumptions);
		list.addAll(requirements);
		builder.addIvcs(SConstraint.toPropertyIds(list, this));
		
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
		Integer iv = SpearRuntimeOptions.consistencyDepth;
		Expr gt = new BinaryExpr(new IdExpr(this.counterName), BinaryOp.GREATEREQUAL, new IntExpr(iv));
		Expr and = new BinaryExpr(new IdExpr(this.assertionName), BinaryOp.AND, gt);
		Expr rhs = new UnaryExpr(UnaryOp.NOT, and);
		return new Equation(new IdExpr(this.consistencyName), rhs);
	}

	private List<SConstraint> getAssumptionsAndRequirements() {
		List<SConstraint> conjunct = new ArrayList<>();
		conjunct.addAll(assumptions);
		conjunct.addAll(requirements);
		return conjunct;
	}

	private VarDecl getAssertionVarDecl() {
		return new VarDecl(this.assertionName, NamedType.BOOL);
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
		return new Equation(new IdExpr(this.assertionName), new NodeCallExpr(PLTL.historically().id, RHS));
	}
	
	public Equation getAssertionCalledEquation(List<SConstraint> conjunct) {
		Expr RHS;
		if (conjunct.isEmpty()) {
			RHS = new BoolExpr(true);
		} else {
			RHS = conjunctify(conjunct.iterator());
		}
		return new Equation(new IdExpr(this.assertionName), RHS);
	}
	
	public String toString() {
		return this.name;
	}
}
