package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.actions.SpearRuntimeOptions;
import com.rockwellcollins.spear.translate.naming.PNameMap;
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

	public static List<String> addNames(List<Specification> list, PNameMap global) {
		List<String> renamed = new ArrayList<>();
		for(Specification  s : list) {
			renamed.add(SSpecification.addName(s, global));
		}
		return renamed;
	}
	
	public static String addName(Specification s, PNameMap global) {
		return global.getName(s.getName());
	}
	
	public static List<SSpecification> build(List<Specification> list, PNameMap global) {
		List<SSpecification> converted = new ArrayList<>();
		for(Specification  s : list) {
			converted.add(SSpecification.build(s, global));
		}
		return converted;
	}
	
	public static SSpecification build(Specification s, PNameMap global) {
		return new SSpecification(s,global);
	}
	
	private String assertionName;
	private static final String ASSERTION = "assertions";

	private String counterName;
	private static final String COUNTER = "counter";
	
	private String consistencyName;
	private static final String CONSISTENCY = "consistent";
	
	public PNameMap local;
	
	public String name;
	public List<SMacro> macros = new ArrayList<>();
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();
//	public List<SCall> calls = new ArrayList<>();
	
	public SSpecification(Specification s, PNameMap global) {
		//get the name from the global map
		this.name = global.lookupOriginal(s.getName());
		
		//copy the global map as the local
		this.local = PNameMap.copy(global);
		
		// set the name
		this.inputs.addAll(SVariable.build(s.getInputs(), local));
		this.outputs.addAll(SVariable.build(s.getOutputs(), local));
		this.state.addAll(SVariable.build(s.getState(), local));
		this.macros.addAll(SMacro.build(s.getMacros(), local));
		this.assumptions.addAll(SConstraint.build(s.getAssumptions(), local));
		this.requirements.addAll(SConstraint.build(s.getRequirements(), local));
		this.behaviors.addAll(SConstraint.build(s.getBehaviors(), local));
		
		this.assertionName = local.getName(ASSERTION);
		this.counterName = local.getName(COUNTER);
		this.consistencyName = local.getName(CONSISTENCY);
	}

//	public List<VarDecl> getAllCalledStateVariables(PNameMap map) {
//		List<VarDecl> list = new ArrayList<>();
//		for(SCall thisCall : this.calls) {
//			list.addAll(thisCall.getNDLocals(map));
//			SSpecification s = (SSpecification) map.fileMapping.get(thisCall.call.getSpec());
//			list.addAll(s.getAllCalledStateVariables(map));
//		}
//		return list;
//	}
	
	public Node toBaseLustre() {
		NodeBuilder builder = new NodeBuilder(name);

		/*
		 * We must add: 1. the true inputs 2. the shadow inputs for the outputs
		 * 3. the shadow inputs for the state 4. the args from any calls that
		 * also need shadow inputs 5. the args from any call's, calls that need
		 * shadow args
		 */
		builder.addInputs(SVariable.toVarDecl(inputs, local));
		builder.addInputs(SVariable.toVarDecl(outputs, local));
		builder.addInputs(SVariable.toVarDecl(state, local));
//		builder.addInputs(this.getAllCalledStateVariables(local));

		/*
		 * We must add 1. locals for the macros 2. locals for the assumptions 3.
		 * locals for the requirements 4. locals for the behaviors
		 */
		builder.addLocals(SMacro.toVarDecls(macros, local));
		builder.addLocals(SConstraint.toVarDecl(assumptions, local));
		builder.addLocals(SConstraint.toVarDecl(requirements, local));
		builder.addLocals(SConstraint.toVarDecl(behaviors, local));

		/*
		 * For now, we're not allowing Macros to contain specification calls
		 */
		builder.addEquations(SMacro.toEquations(macros, local));
		builder.addEquations(SConstraint.toEquation(assumptions, local));
		builder.addEquations(SConstraint.toEquation(requirements, local));
		builder.addEquations(SConstraint.toPropertyEquations(behaviors, assertionName, local));

		return builder.build();
	}

	public Node getLogicalEntailmentMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());
		builder.addOutput(this.getAssertionVarDecl());
		builder.addEquation(this.getAssertionMainEquation(requirements));

		if (!assumptions.isEmpty()) {
			builder.addAssertion(this.conjunctify(assumptions.iterator()));
		}

		builder.addProperties(SConstraint.toPropertyIds(behaviors, local));
		return builder.build();
	}

//	public Node getLogicalEntailmentCalled() {
//		NodeBuilder builder = new NodeBuilder(this.toBaseLustre(map));
//
//		/*
//		 * The nodes have only a single output, the assertions to be passed up
//		 * the chain.
//		 */
//		builder.addOutput(this.getAssertionVarDecl());
//		builder.addEquation(this.getAssertionCalledEquation(requirements));
//
////		builder.addProperties(SConstraint.toPropertyIds(assumptions, map));
////		builder.addProperties(SConstraint.toPropertyIds(behaviors, map));
//		return builder.build();
//	}

	public Node getLogicalConsistencyMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		builder.addLocal(this.getCounterVarDecl());
		builder.addLocal(this.getConsistencyVarDecl());
		
		builder.addOutput(this.getAssertionVarDecl());

		builder.addEquation(this.getCounterEquation());
		builder.addEquation(this.getConsistencyEquation());
		builder.addEquation(this.getAssertionMainEquation(getAssumptionsAndRequirements()));
		
		builder.addProperty(this.consistencyName);
		
		List<SConstraint> list = new ArrayList<>();
		list.addAll(assumptions);
		list.addAll(requirements);
		builder.addIvcs(SConstraint.toPropertyIds(list, local));
		
		return builder.build();
	}
	
//	public Node getLogicalConsistencyCalled(NameMap map) {
//		NodeBuilder builder = new NodeBuilder(this.toBaseLustre(map));
//
//		/*
//		 * The nodes have only a single output, the assertions to be passed up
//		 * the chain.
//		 */
//		builder.addOutput(this.getAssertionVarDecl());
//		builder.addEquation(this.getAssertionCalledEquation(requirements));
//		return builder.build();		
//	}

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

//	private Equation getAssertionCalledEquation(List<SConstraint> conjunct) {
//		Expr RHS;
//		if (conjunct.isEmpty()) {
//			RHS = new BoolExpr(true);
//		} else {
//			RHS = conjunctify(conjunct.iterator());
//		}
//		return new Equation(new IdExpr(this.assertionName), RHS);
//	}
}
