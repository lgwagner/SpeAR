package com.rockwellcollins.spear.translate.master;

import static jkind.lustre.LustreUtil.varDecl;

import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.VarDecl;

public class SVariable {

	public static List<SVariable> build(List<Variable> list, SSpecification s) {
		return list.stream().map(v -> new SVariable(v, s)).collect(Collectors.toList());
	}

	public static List<VarDecl> toVarDecl(List<SVariable> list, SSpecification s) {
		return list.stream().map(v -> v.toLustre(s)).collect(Collectors.toList());
	}

	public String original;
	public String name;
	public Type type;

	public SVariable(Variable v, SSpecification s) {
		this.original = v.getName();
		this.name = s.map.addName(original);
		this.type = v.getType();
	}

	public SVariable(String name, Type t, SSpecification s) {
		this.original = name;
		this.name = s.map.addName(original);
		this.type = t;
	}

	public jkind.lustre.VarDecl toLustre(SSpecification s) {
		return varDecl(name, TranslateType.translate(this.type, s.map));
	}

	public String toString() {
		return name;
	}
}
