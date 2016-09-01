package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.Renaming;

import jkind.lustre.VarDecl;

public class SCallVar {

	public static List<VarDecl> toVarDecl(List<SCallVar> callvars, Renaming map) {
		List<VarDecl> decls = new ArrayList<>();
		for(SCallVar callvar : callvars) {
			decls.add(callvar.toVarDecl(map));
		}
		return decls;
	}
	
	public String name;
	public Type type;

	public SCallVar(SVariable var, SSpecification caller, Integer id, SSpecification called, Renaming map) {
		String proposed = called.name + id + "_" + var.name;
		this.name = map.getName(proposed);
		this.type = var.type;
	}
	
	public VarDecl toVarDecl(Renaming map) {
		jkind.lustre.Type t = TranslateType.translate(this.type, map);
		return new VarDecl(this.name, t);
	}
	
	public String toString() {
		return name;
	}
}
