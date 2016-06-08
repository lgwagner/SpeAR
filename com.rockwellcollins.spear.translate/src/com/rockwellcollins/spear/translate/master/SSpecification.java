package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.actions.SpearRuntimeOptions;
import com.rockwellcollins.spear.translate.naming.NameMap;
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

public class SSpecification extends SFile {

	private String assertionName;
	private static final String ASSERTION = "assertions";

	private String counterName;
	private static final String COUNTER = "counter";
	
	private String consistencyName;
	private static final String CONSISTENCY = "consistent";

	public List<SMacro> macros = new ArrayList<>();
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();
	public List<SCall> calls = new ArrayList<>();
	
	public SSpecification(Specification s, NameMap map) {
		// this initializes the map to include an entry for this object
		map.addFile(s, this);
	
		// set the name
		this.name = map.getName(s);
		this.typedefs.addAll(STypeDef.build(s.getTypedefs(), map));
		this.constants.addAll(SConstant.build(s.getConstants(), map));
		this.patterns.addAll(SPattern.build(s.getPatterns(), map));
		this.inputs.addAll(SVariable.build(s.getInputs(), map));
		this.outputs.addAll(SVariable.build(s.getOutputs(), map));
		this.state.addAll(SVariable.build(s.getState(), map));
		this.macros.addAll(SMacro.build(s.getMacros(), map));
		this.assumptions.addAll(SConstraint.build(s.getAssumptions(), map));
		this.requirements.addAll(SConstraint.build(s.getRequirements(), map));
		this.behaviors.addAll(SConstraint.build(s.getBehaviors(), map));
		this.calls.addAll(SCall.build(EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class),map));		
		
		this.assertionName = map.getName(s, ASSERTION);
		this.counterName = map.getName(s, COUNTER);
		this.consistencyName = map.getName(s, CONSISTENCY);
	}

	public List<VarDecl> getAllCalledStateVariables(NameMap map) {
		List<VarDecl> list = new ArrayList<>();
		for(SCall thisCall : this.calls) {
			list.addAll(thisCall.getNDLocals(map));
			SSpecification s = (SSpecification) map.fileMapping.get(thisCall.call.getSpec());
			list.addAll(s.getAllCalledStateVariables(map));
		}
		return list;
	}
	
	public Node toBaseLustre(NameMap map) {
		NodeBuilder builder = new NodeBuilder(name);

		/*
		 * We must add: 1. the true inputs 2. the shadow inputs for the outputs
		 * 3. the shadow inputs for the state 4. the args from any calls that
		 * also need shadow inputs 5. the args from any call's, calls that need
		 * shadow args
		 */
		builder.addInputs(SVariable.toVarDecl(inputs, map));
		builder.addInputs(SVariable.toVarDecl(outputs, map));
		builder.addInputs(SVariable.toVarDecl(state, map));
		builder.addInputs(this.getAllCalledStateVariables(map));

		/*
		 * We must add 1. locals for the macros 2. locals for the assumptions 3.
		 * locals for the requirements 4. locals for the behaviors
		 */
		builder.addLocals(SMacro.toVarDecls(macros, map));
		builder.addLocals(SConstraint.toVarDecl(assumptions, map));
		builder.addLocals(SConstraint.toVarDecl(requirements, map));
		builder.addLocals(SConstraint.toVarDecl(behaviors, map));

		/*
		 * For now, we're not allowing Macros to contain specification calls
		 */
		builder.addEquations(SMacro.toEquations(macros, map));
		builder.addEquations(SConstraint.toEquation(assumptions, map));
		builder.addEquations(SConstraint.toEquation(requirements, map));
		builder.addEquations(SConstraint.toPropertyEquations(behaviors, assertionName, map));

		return builder.build();
	}

	public Node getLogicalEntailmentMain(NameMap map) {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre(map));
		builder.addOutput(this.getAssertionVarDecl());
		builder.addEquation(this.getAssertionMainEquation(requirements));

		if (!assumptions.isEmpty()) {
			builder.addAssertion(this.conjunctify(assumptions.iterator()));
		}

		builder.addProperties(SConstraint.toPropertyIds(behaviors, map));
		return builder.build();
	}

	public Node getLogicalEntailmentCalled(NameMap map) {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre(map));

		/*
		 * The nodes have only a single output, the assertions to be passed up
		 * the chain.
		 */
		builder.addOutput(this.getAssertionVarDecl());
		builder.addEquation(this.getAssertionCalledEquation(requirements));

		builder.addProperties(SConstraint.toPropertyIds(assumptions, map));
		builder.addProperties(SConstraint.toPropertyIds(behaviors, map));

		return builder.build();
	}

	public Node getLogicalConsistencyMain(NameMap map) {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre(map));

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
		builder.addIvcs(SConstraint.toPropertyIds(list, map));
		
		return builder.build();
	}
	
	public Node getLogicalConsistencyCalled(NameMap map) {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre(map));

		/*
		 * The nodes have only a single output, the assertions to be passed up
		 * the chain.
		 */
		builder.addOutput(this.getAssertionVarDecl());
		builder.addEquation(this.getAssertionCalledEquation(requirements));
		return builder.build();		
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

	private Equation getAssertionCalledEquation(List<SConstraint> conjunct) {
		Expr RHS;
		if (conjunct.isEmpty()) {
			RHS = new BoolExpr(true);
		} else {
			RHS = conjunctify(conjunct.iterator());
		}
		return new Equation(new IdExpr(this.assertionName), RHS);
	}
}
