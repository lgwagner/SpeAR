package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.lustre.VarDecl;

public class SCall {

	public static List<SCall> build(List<NormalizedCall> calls, NameMap map) {
		List<SCall> scalls = new ArrayList<>();
		for(NormalizedCall call : calls) {
			scalls.add(new SCall(call,map));
		}
		return scalls;
	}
	
	public Specification caller;
	public Specification called;
	public List<Expr> args = new ArrayList<>();
	public List<SLocalFromCall> ndlocals = new ArrayList<>();
	
	public SCall(NormalizedCall call, NameMap map) {
		caller = (Specification) Utilities.getRoot(call);
		called = call.getSpec();
		for(Variable v : called.getState()) {
			ndlocals.add(new SLocalFromCall(call,v,map));
		}
		args = new ArrayList<>(call.getArgs());
		
		//TODO: review this.
		map.callMapping.put(call, this);
	}
	
	public List<VarDecl> getNDLocals(NameMap map) {
		return SLocalFromCall.getVarDecls(ndlocals, map);
	}
}
