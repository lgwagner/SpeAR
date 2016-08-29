package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.Node;
import jkind.lustre.builders.NodeBuilder;

public class SPattern {

	public static List<SPattern> build(List<Pattern> list, NameMap map) {
		List<SPattern> built = new ArrayList<>();
		for(Pattern p : list) {
			built.add(SPattern.build(p, map));
		}
		return built;
	}
	
	public static List<Node> toLustre(List<SPattern> list, NameMap map) {
		List<Node> lustre = new ArrayList<>();
		for(SPattern p : list) {
			lustre.add(p.toLustre(map));
		}
		return lustre;
	}
	
	public static SPattern build(Pattern p, NameMap map) {
		return new SPattern(p,map);
	}
	
	public String name;
	protected List<SPVariable> inputs;
	protected List<SPVariable> outputs;
	protected List<SPVariable> locals;
	protected List<SLustreEquation> equations;
	protected List<SLustreProperty> properties;
	protected List<SLustreAssertion> assertions;
	
	public SPattern(Pattern p, NameMap map) {
		map.addPattern(p, this);
		this.name = map.getFileBasedName(p);
		this.inputs = SPVariable.build(p.getInputs(), p, map);
		this.outputs = SPVariable.build(p.getOutputs(), p, map);
		this.locals = SPVariable.build(p.getLocals(), p, map);
		this.equations = SLustreEquation.build(p.getEquations(), map);
		this.properties = SLustreProperty.build(p.getProperties(), map);
		this.assertions = SLustreAssertion.build(p.getAssertions());
	}
	
	public Node toLustre(NameMap map) {
		NodeBuilder builder = new NodeBuilder(this.name);
		builder.addInputs(SPVariable.toVarDecl(this.inputs, map));
		builder.addOutputs(SPVariable.toVarDecl(this.outputs, map));
		builder.addLocals(SPVariable.toVarDecl(this.locals, map));
		builder.addEquations(SLustreEquation.toLustre(this.equations, map));
		builder.addProperties(SLustreProperty.toLustre(this.properties));
		builder.addAssertions(SLustreAssertion.toLustre(this.assertions,map));
		return builder.build();
	}
}
