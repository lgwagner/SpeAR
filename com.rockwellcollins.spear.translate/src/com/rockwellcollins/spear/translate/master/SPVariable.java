package com.rockwellcollins.spear.translate.master;

import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.VarDecl;

public class SPVariable {

	public static List<SPVariable> build(List<Variable> list, SPattern p) {
		return list.stream().map(v -> new SPVariable(v, p)).collect(Collectors.toList());
	}

	public static List<VarDecl> toVarDecl(List<SPVariable> list, SPattern p) {
		return list.stream().map(v -> v.toLustre(p)).collect(Collectors.toList());
	}

	public String name;
	public Type type;

	public SPVariable(Variable v, SPattern pattern) {
		this.name = pattern.map.addName(v.getName());
		this.type = v.getType();
	}

	public VarDecl toLustre(SPattern pattern) {
		return new jkind.lustre.VarDecl(this.name, TranslateType.translate(this.type, pattern.map));
	}
}
