package com.rockwellcollins.spear.translate.master;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.Pattern;

import jkind.lustre.Node;
import jkind.lustre.builders.NodeBuilder;

public class SPattern extends SMapElement {

	public static void addNames(Collection<Pattern> list, SProgram program) {
		list.stream().map(p -> SPattern.addName(p, program)).collect(Collectors.toList());
	}

	private static String addName(Pattern p, SProgram program) {
		return program.map.addName(p.getName());
	}

	public static List<SPattern> build(Collection<Pattern> list, SProgram program) {
		return list.stream().map(p -> new SPattern(p, program)).collect(Collectors.toList());
	}

	public static List<Node> toLustre(List<SPattern> list) {
		return list.stream().map(p -> p.toLustre()).collect(Collectors.toList());
	}

	public String name;
	public List<SPVariable> inputs;
	public List<SPVariable> outputs;
	public List<SPVariable> locals;
	public List<SLustreEquation> equations;
	public List<SLustreProperty> properties;
	public List<SLustreAssertion> assertions;

	public SPattern(Pattern p, SProgram program) {
		// we already added these names to the global map
		this.name = program.map.lookup(p.getName());

		// copy the global name map for the basis of the local
		this.map = program.map.copy();
		this.map.addScope();

		// process everything
		this.inputs = SPVariable.build(p.getInputs(), this);
		this.outputs = SPVariable.build(p.getOutputs(), this);
		this.locals = SPVariable.build(p.getLocals(), this);
		this.equations = SLustreEquation.build(p.getEquations(), this);
		this.properties = SLustreProperty.build(p.getProperties(), this);
		this.assertions = SLustreAssertion.build(p.getAssertions());
	}

	public Node toLustre() {
		NodeBuilder builder = new NodeBuilder(name);
		builder.addInputs(SPVariable.toVarDecl(inputs, this));
		builder.addOutputs(SPVariable.toVarDecl(outputs, this));
		builder.addLocals(SPVariable.toVarDecl(locals, this));
		builder.addEquations(SLustreEquation.toLustre(equations, this));
		builder.addProperties(SLustreProperty.toLustre(properties));
		builder.addAssertions(SLustreAssertion.toLustre(assertions, this));
		return builder.build();
	}
}
