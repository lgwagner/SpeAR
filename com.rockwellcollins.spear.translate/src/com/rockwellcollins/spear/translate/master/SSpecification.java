package com.rockwellcollins.spear.translate.master;

import static jkind.lustre.LustreUtil.TRUE;
import static jkind.lustre.LustreUtil.and;
import static jkind.lustre.LustreUtil.arrow;
import static jkind.lustre.LustreUtil.eq;
import static jkind.lustre.LustreUtil.greaterEqual;
import static jkind.lustre.LustreUtil.id;
import static jkind.lustre.LustreUtil.integer;
import static jkind.lustre.LustreUtil.not;
import static jkind.lustre.LustreUtil.plus;
import static jkind.lustre.LustreUtil.pre;
import static jkind.lustre.LustreUtil.varDecl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.naming.Scope;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.utilities.LustreLibrary;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.LustreUtil;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.NodeBuilder;

public class SSpecification extends SMapElement {

	public static void addNames(Collection<Specification> list, Scope map) {
		list.stream().map(s -> SSpecification.addName(s, map)).collect(Collectors.toList());
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

		/*
		 * For now, we're not allowing Macros to contain specification calls
		 */
		builder.addEquation(getCounterEquation());
		builder.addEquations(SMacro.toEquations(macros, this));
		builder.addEquations(SConstraint.toEquation(assumptions, this));
		builder.addEquations(SConstraint.toEquation(requirements, this));

		//this needs to move
		return builder.build();
	}

	public Node getLogicalEntailmentMain() {
		NodeBuilder builder = new NodeBuilder(toBaseLustre());
		
		//add the constraints output and assignment
		builder.addOutput(this.getAssertionVarDecl());
		Equation assertionMainEquation = getAssertionMainEquation(Stream.of(assumptions,requirements).flatMap(x -> x.stream()).collect(Collectors.toList()));
		builder.addEquation(assertionMainEquation);		

		builder.addProperties(SConstraint.toPropertyIds(behaviors, this));
		if (PreferencesUtil.getEnableIVCDuringEntailment()) {
			VarDecl vd = varDecl(traceabilityName, NamedType.BOOL);
			builder.addLocal(vd);

			List<SConstraint> justProperties = getJustProperties(behaviors);
			builder.addEquation(eq(id(vd.id),justProperties.isEmpty() ? TRUE :conjunctify(justProperties.iterator())));
			builder.addProperty(vd.id);
			builder.addIvcs(SConstraint.toPropertyIds(Stream.of(assumptions,requirements).flatMap(x -> x.stream()).collect(Collectors.toList()), this));
		}
		
		builder.addEquations(SConstraint.toPropertyEquations(behaviors, constraintsName, this));		
		return builder.build();
	}
	
	private List<SConstraint> getConjunctsWithoutOne(List<SConstraint> list, SConstraint skip) {
		List<SConstraint> conj = new ArrayList<>();
		for(SConstraint sc : list) {
			if(sc.equals(skip)) {
				continue;
			}
			conj.add(sc);
		}
		
		return conj;
	}
	
	public Node getFuzzAnalysisMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		List<SConstraint> all = new ArrayList<>();
		assumptions.stream().filter(sc -> !sc.name.startsWith("predicate")).collect(Collectors.toList()).forEach(sc -> all.add(sc));
		all.addAll(requirements);

		Map<String, List<SConstraint>> fuzzingConjuncts = new LinkedHashMap<>();		
		for(SConstraint sc : all) {
			fuzzingConjuncts.put("fuzz_" + sc.name, getConjunctsWithoutOne(all, sc));
		}

		builder.addEquations(SConstraint.toEquation(behaviors, this));		
		
		for(String key : fuzzingConjuncts.keySet()) {
			
			Expr lhs = historicallyConjunctify(fuzzingConjuncts.get(key).iterator());
			for(SConstraint behavior : behaviors) {
				if(behavior instanceof SFormalConstraint) {
					SFormalConstraint formal = (SFormalConstraint) behavior;
					if(!formal.isObserver) {
						continue;
					}
				}
				
				VarDecl vd = LustreUtil.varDecl(key + "_" + behavior.name, NamedType.BOOL);
				builder.addLocal(vd);
				Expr e = LustreUtil.implies(lhs, id(behavior.toVarDecl(this).id));
				builder.addEquation(LustreUtil.eq(id(vd.id), e));
				builder.addProperty(vd.id);
			}
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
		builder.addOutput(this.getAssertionVarDecl());
		builder.addEquation(getAssertionCalledEquation(requirements));
		return builder.build();
	}

	public Node getLogicalConsistencyMain() {
		NodeBuilder builder = new NodeBuilder(this.toBaseLustre());

		builder.addOutput(this.getAssertionVarDecl());
		builder.addEquation(getAssertionMainEquation(Stream.of(assumptions,requirements).flatMap(x -> x.stream()).collect(Collectors.toList())));
	
		builder.addLocal(getConsistencyVarDecl());
		builder.addEquation(getConsistencyEquation());
		builder.addProperty(consistencyName);

		List<SConstraint> list = new ArrayList<>();
		list.addAll(assumptions);
		list.addAll(requirements);
		builder.addIvcs(SConstraint.toPropertyIds(list, this));

		return builder.build();
	}

	public Node getRealizabilityMain() {
		NodeBuilder builder = new NodeBuilder(toBaseLustre());

		builder.addOutput(this.getAssertionVarDecl());
		builder.addEquation(getAssertionMainEquation(requirements));

		if (!assumptions.isEmpty()) {
			builder.addAssertion(conjunctify(assumptions.iterator()));
		}

		builder.addProperty(constraintsName);
		builder.setRealizabilityInputs(inputs.stream().map(input -> input.name).collect(Collectors.toList()));
		return builder.build();
	}

	public Node getLogicalConsistencyCalled() {
		return getLogicalEntailmentCalled();
	}

	private VarDecl getCounterVarDecl() {
		return varDecl(counterName, NamedType.INT);
	}

	private VarDecl getConsistencyVarDecl() {
		return varDecl(consistencyName, NamedType.BOOL);
	}

	private Equation getCounterEquation() {
		return eq(id(counterName), arrow(integer(1), plus(pre(id(counterName)),integer(1))));
	}

	private Equation getConsistencyEquation() {
		Integer iv = PreferencesUtil.getConsistencyDepthOption();
		return eq(id(consistencyName), not(and(id(constraintsName), greaterEqual(id(counterName), integer(iv)))));
	}

	private VarDecl getAssertionVarDecl() {
		return varDecl(constraintsName, NamedType.BOOL);
	}

	private Expr historicallyConjunctify(Iterator<SConstraint> it) {
		return new NodeCallExpr("historically",conjunctify(it));
	}
	
	private Expr conjunctify(Iterator<SConstraint> it) {
		SConstraint current = it.next();
		if (it.hasNext()) {
			return and(id(current.name),conjunctify(it));
		} else {
			return id(current.name);
		}
	}

	private Equation getAssertionMainEquation(List<SConstraint> conjunct) {
		Expr RHS = conjunct.isEmpty() ? TRUE : conjunctify(conjunct.iterator());
		return new Equation(id(constraintsName), new NodeCallExpr(LustreLibrary.historically().id, RHS));
	}

	public Equation getAssertionCalledEquation(List<SConstraint> conjunct) {
		Expr RHS = conjunct.isEmpty() ? TRUE : conjunctify(conjunct.iterator()); 
		return new Equation(id(constraintsName), RHS);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
