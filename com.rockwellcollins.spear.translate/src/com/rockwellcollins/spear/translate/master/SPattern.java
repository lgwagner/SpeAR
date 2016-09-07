package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.naming.Renaming;

import jkind.lustre.Node;
import jkind.lustre.builders.NodeBuilder;

public class SPattern {

	public static List<String> addNames(List<Pattern> list, SProgram program) {
		List<String> renamed = new ArrayList<>();
		for(Pattern p : list) {
			renamed.add(SPattern.addName(p, program));
		}
		return renamed;
	}
	
	public static String addName(Pattern p, SProgram program) {
		return program.map.getName(p.getName());
	}
	
	public static List<SPattern> build(List<Pattern> list, SProgram program) {
		List<SPattern> built = new ArrayList<>();
		for(Pattern p : list) {
			built.add(SPattern.build(p, program));
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
	
	public static SPattern build(Pattern p, SProgram program) {
		return new SPattern(p,program);
	}
	
	public Renaming map;
	
	public String name;
	public List<SPVariable> inputs;
	public List<SPVariable> outputs;
	public List<SPVariable> locals;
	public List<SLustreEquation> equations;
	public List<SLustreProperty> properties;
	public List<SLustreAssertion> assertions;
	
	public SPattern(Pattern p, SProgram program) {
		//we already added these names to the global map
		this.name = program.map.lookupOriginal(p.getName());
		
		//copy the global name map for the basis of the local
		this.map = Renaming.copy(program.map);
		
		//process everything
		this.inputs = SPVariable.build(p.getInputs(), this);
		this.outputs = SPVariable.build(p.getOutputs(), this);
		this.locals = SPVariable.build(p.getLocals(), this);
		this.equations = SLustreEquation.build(p.getEquations(), this);
		this.properties = SLustreProperty.build(p.getProperties(), this);
		this.assertions = SLustreAssertion.build(p.getAssertions());
	}
	
	public Node toLustre() {
		NodeBuilder builder = new NodeBuilder(this.name);
		builder.addInputs(SPVariable.toVarDecl(this.inputs, this));
		builder.addOutputs(SPVariable.toVarDecl(this.outputs, this));
		builder.addLocals(SPVariable.toVarDecl(this.locals, this));
		builder.addEquations(SLustreEquation.toLustre(this.equations, this));
		builder.addProperties(SLustreProperty.toLustre(this.properties));
		builder.addAssertions(SLustreAssertion.toLustre(this.assertions,this));
		return builder.build();
	}
}
