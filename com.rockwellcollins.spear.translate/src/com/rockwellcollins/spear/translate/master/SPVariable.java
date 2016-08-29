package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.Renaming;

import jkind.lustre.VarDecl;

public class SPVariable {

	public static List<SPVariable> build(List<Variable> list, Renaming map) {
		List<SPVariable> processed = new ArrayList<>();
		for(Variable v : list) {
			processed.add(SPVariable.build(v, map));
		}
		return processed;
	}
	
	public static List<VarDecl> toVarDecl(List<SPVariable> list, Renaming map) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SPVariable svar : list) {
			lustre.add(svar.toLustre(map));
		}
		return lustre;
	}
	
	public static SPVariable build(Variable v, Renaming map) {
		return new SPVariable(v,map);
	}
	
	public String name;
	public Type type;
	
	public SPVariable(Variable v, Renaming map) {
		this.name=map.getName(v.getName());
		this.type=v.getType();
	}
	
	public VarDecl toLustre(Renaming map) {
		jkind.lustre.Type type = TranslateType.translate(this.type, map);
		return new jkind.lustre.VarDecl(this.name,type);
	}
}
