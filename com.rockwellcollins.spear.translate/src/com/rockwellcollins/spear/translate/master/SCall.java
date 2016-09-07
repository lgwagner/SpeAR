package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.translate.naming.Renaming;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.lustre.IdExpr;

public class SCall {

	public static List<SCall> build(List<NormalizedCall> calls, List<SSpecification> specs, Renaming map) {
		List<SCall> built = new ArrayList<>();
		for(NormalizedCall call : calls) {
			built.add(SCall.build(call,specs,map));
		}
		return built;
	}
	
	public static SCall build(NormalizedCall call, List<SSpecification> specs, Renaming map) {
		return new SCall(call,specs,map);
	}
	
	public static SCall get(NormalizedCall call, List<SCall> calls) {
		for(SCall scall : calls) {
			if(scall.original.equals(call)) {
				return scall;
			}
		}
		return null;
	}
	
	public String callerName;
	public String calledName;
	public SSpecification caller;
	public SSpecification called;
	public List<IdRef> ids;
	public List<Expr> args;
	private NormalizedCall original;
	
	private List<SVariable> callVars = new ArrayList<>();

	private SCall(NormalizedCall call, List<SSpecification> specs, Renaming map) {
		this.original=call;
		
		this.callerName=map.lookupOriginal(Utilities.getRoot(call).getName());
		this.caller=SSpecification.lookup(callerName, specs);
		
		this.calledName=map.lookupOriginal(call.getSpec().getName());
		this.called=SSpecification.lookup(this.calledName, specs);
		
		this.ids=new ArrayList<>(call.getIds());
		this.args=new ArrayList<>(call.getArgs());
	}
	
	public List<SVariable> getCallVariables() {
		for(SVariable sv : called.state) {
			String name = called.name + "_" + sv.name;
			this.callVars.add(new SVariable(name,sv.type,caller));
		}
		
		for(SCall call : called.calls) {
			this.callVars.addAll(call.getCallVariables());
		}
		return this.callVars;
	}
	
	public List<jkind.lustre.Expr> getCallVarExprs() {
		List<jkind.lustre.Expr> exprs = new ArrayList<>();
		for(SVariable sv : this.callVars) {
			exprs.add(new IdExpr(sv.name));
		}
		return exprs;
	}
	
	public String toString() {
		return callerName + " -> " + calledName;
	}
}
