package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.lustre.VarDecl;

public class SLocalFromCall {

	public static List<VarDecl> getVarDecls(List<SLocalFromCall> locals, NameMap map) {
		List<VarDecl> list = new ArrayList<>();
		for(SLocalFromCall local : locals) {
			list.add(local.getVarDecl(map));
		}
		return list;
	}
	
	public String name;
	public Type type;
	
	public Specification caller;
	public Specification called;
	
	public SLocalFromCall(NormalizedCall call, Variable v, NameMap map) {
		this.name = v.getName() + "_" + call.hashCode();
		this.type=v.getType();
		this.caller=(Specification) Utilities.getRoot(call);
		this.called=(Specification) Utilities.getRoot(v);
	}
	
	public VarDecl getVarDecl(NameMap map) {
		return new VarDecl(name,TranslateType.translate(this.type, map));
	}
}

