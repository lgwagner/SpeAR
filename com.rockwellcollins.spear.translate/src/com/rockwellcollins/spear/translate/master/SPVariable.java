package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.VarDecl;

public class SPVariable {

	public static List<SPVariable> build(List<Variable> list, SPattern pattern) {
		List<SPVariable> processed = new ArrayList<>();
		for(Variable v : list) {
			processed.add(SPVariable.build(v, pattern));
		}
		return processed;
	}
	
	public static List<VarDecl> toVarDecl(List<SPVariable> list, SPattern pattern) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SPVariable svar : list) {
			lustre.add(svar.toLustre(pattern));
		}
		return lustre;
	}
	
	public static SPVariable build(Variable v, SPattern pattern) {
		return new SPVariable(v,pattern);
	}
	
	public String name;
	public Type type;
	
	public SPVariable(Variable v, SPattern pattern) {
		this.name=pattern.map.getName(v.getName());
		this.type=v.getType();
	}
	
	public VarDecl toLustre(SPattern pattern) {
		jkind.lustre.Type type = TranslateType.translate(this.type, pattern.map);
		return new jkind.lustre.VarDecl(this.name,type);
	}
}
