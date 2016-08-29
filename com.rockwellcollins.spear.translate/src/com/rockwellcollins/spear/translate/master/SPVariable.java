package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.PNameMap;

import jkind.lustre.VarDecl;

public class SPVariable {

	public static List<SPVariable> build(List<Variable> list, PNameMap map) {
		List<SPVariable> processed = new ArrayList<>();
		for(Variable v : list) {
			processed.add(SPVariable.build(v, map));
		}
		return processed;
	}
	
	public static List<VarDecl> toVarDecl(List<SPVariable> list, PNameMap map) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SPVariable svar : list) {
			lustre.add(svar.toLustre(map));
		}
		return lustre;
	}
	
	public static SPVariable build(Variable v, PNameMap map) {
		return new SPVariable(v,map);
	}
	
	public String name;
	public Type type;
	
	public SPVariable(Variable v, PNameMap map) {
		this.name=map.getName(v.getName());
		this.type=v.getType();
	}
	
	public VarDecl toLustre(PNameMap map) {
		jkind.lustre.Type type = TranslateType.translate(this.type, map);
		return new jkind.lustre.VarDecl(this.name,type);
	}
}
