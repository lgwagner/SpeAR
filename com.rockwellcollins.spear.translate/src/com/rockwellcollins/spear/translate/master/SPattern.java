package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.naming.Renaming;

import jkind.lustre.Node;
import jkind.lustre.builders.NodeBuilder;

public class SPattern {

	public static List<String> addNames(List<Pattern> list, Renaming global) {
		List<String> renamed = new ArrayList<>();
		for(Pattern p : list) {
			renamed.add(SPattern.addName(p, global));
		}
		return renamed;
	}
	
	public static String addName(Pattern p, Renaming global) {
		return global.getName(p.getName());
	}
	
	public static List<SPattern> build(List<Pattern> list, Renaming global) {
		List<SPattern> built = new ArrayList<>();
		for(Pattern p : list) {
			built.add(SPattern.build(p, global));
		}
		return built;
	}
	
	public static List<Node> toLustre(List<SPattern> list) {
		List<Node> lustre = new ArrayList<>();
		for(SPattern p : list) {
			lustre.add(p.toLustre());
		}
		return lustre;
	}
	
	public static SPattern build(Pattern p, Renaming map) {
		return new SPattern(p,map);
	}
	
	public Renaming local;
	public String name;
	public List<SPVariable> inputs;
	public List<SPVariable> outputs;
	public List<SPVariable> locals;
	public List<SLustreEquation> equations;
	public List<SLustreProperty> properties;
	public List<SLustreAssertion> assertions;
	
	public SPattern(Pattern p, Renaming global) {
		//we already added these names to the global map
		this.name = global.lookupOriginal(p.getName());
		
		//copy the global name map for the basis of the local
		this.local = Renaming.copy(global);
		
		//process everything
		this.inputs = SPVariable.build(p.getInputs(), local);
		this.outputs = SPVariable.build(p.getOutputs(), local);
		this.locals = SPVariable.build(p.getLocals(), local);
		this.equations = SLustreEquation.build(p.getEquations(), local);
		this.properties = SLustreProperty.build(p.getProperties(), local);
		this.assertions = SLustreAssertion.build(p.getAssertions());
	}
	
	public Node toLustre() {
		NodeBuilder builder = new NodeBuilder(this.name);
		builder.addInputs(SPVariable.toVarDecl(this.inputs, local));
		builder.addOutputs(SPVariable.toVarDecl(this.outputs, local));
		builder.addLocals(SPVariable.toVarDecl(this.locals, local));
		builder.addEquations(SLustreEquation.toLustre(this.equations, local));
		builder.addProperties(SLustreProperty.toLustre(this.properties));
		builder.addAssertions(SLustreAssertion.toLustre(this.assertions,local));
		return builder.build();
	}
}
