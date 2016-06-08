package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.IdExpr;
import jkind.lustre.VarDecl;

public class SCall {
	
	public static int uniqueKey = 0;
	
	public static List<SCall> build(List<NormalizedCall> calls, NameMap map) {
		List<SCall> scalls = new ArrayList<>();
		for(NormalizedCall call : calls) {
			scalls.add(new SCall(call,map));
		}
		return scalls;
	}
	
	public NormalizedCall call;
	public int localKey;
	public List<Expr> args = new ArrayList<>();
	public List<SLocalFromCall> ndlocals = new ArrayList<>();
	
	public SCall(NormalizedCall call, NameMap map) {
		this.call=call;
		this.localKey = uniqueKey;
		uniqueKey++;
		args = new ArrayList<>(call.getArgs());
		
		for(Variable v : call.getSpec().getState()) {
			ndlocals.add(new SLocalFromCall(call,this,v,map));
		}
		map.callMapping.put(call, this);
	}
	
	public List<VarDecl> getNDLocals(NameMap map) {
		List<VarDecl> ndstate = new ArrayList<>(SLocalFromCall.getVarDecls(ndlocals, map));
		return ndstate;
	}
	
	public List<IdExpr> getCallsArgs(NameMap map) {
		List<IdExpr> thisCallsArgs = SLocalFromCall.getArgIds(ndlocals, map);
		SSpecification calledSpec = (SSpecification) map.fileMapping.get(call.getSpec());
		for(SCall calls : calledSpec.calls) {
			thisCallsArgs.addAll(calls.getCallsArgs(map));
		}
		return thisCallsArgs;
	}
}
