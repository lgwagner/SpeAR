package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.VarDecl;

public class SVariable {

	public static List<SVariable> build(List<Variable> list, SSpecification s) {
		List<SVariable> processed = new ArrayList<>();
		for(Variable v : list) {
			processed.add(SVariable.build(v, s));
		}
		return processed;
	}
	
	public static List<VarDecl> toVarDecl(List<SVariable> list, SSpecification s) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SVariable svar : list) {
			lustre.add(svar.toLustre(s));
		}
		return lustre;
	}
	
	public static SVariable build(Variable v, SSpecification s) {
		return new SVariable(v,s);
	}
	
	public String original;
	public String name;
	public Type type;
	
	public SVariable(Variable v, SSpecification s) {
		this.original=v.getName();
		this.name=s.map.getModuleName(original);
		this.type=v.getType();
	}
	
	public SVariable(String name, Type t, SSpecification s) {
		this.original=name;
		this.name=s.map.getModuleName(original);
		this.type=t;
	}
	
	public jkind.lustre.VarDecl toLustre(SSpecification s) {
		jkind.lustre.Type type = TranslateType.translate(this.type, s.map);
		return new jkind.lustre.VarDecl(this.name,type);
	}
	
	public String toString() {
		return this.name;
	}
}
