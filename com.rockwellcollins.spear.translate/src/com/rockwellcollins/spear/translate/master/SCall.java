package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.Renaming;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.lustre.IdExpr;
import jkind.lustre.Type;
import jkind.lustre.VarDecl;

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
	
	public static List<VarDecl> toVarDecl(List<SCall> calls, SSpecification s) {
		List<VarDecl> decls = new ArrayList<>();
		for(SCall call : calls) {
			decls.addAll(call.toVarDecl(s));
		}
		return decls;
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
	private NormalizedCall original;
	
	public List<SVariable> variables = new ArrayList<>();
	
	private SCall(NormalizedCall call, List<SSpecification> specs, Renaming map) {
		this.original=call;
		
		this.callerName=map.lookupOriginal(Utilities.getRoot(call).getName());
		this.caller=SSpecification.lookup(callerName, specs);
		
		this.calledName=map.lookupOriginal(call.getSpec().getName());
		this.called=SSpecification.lookup(this.calledName, specs);
	}
	
	public void resolveCallVars() {
		for(SVariable sv : called.state) {
			String name = called.name + "_" + sv.name;
			//the SVariable registers the name with the caller spec
			variables.add(new SVariable(name,sv.type,caller));
		}
	}
	
	public List<VarDecl> toVarDecl(SSpecification s) {
		List<VarDecl> decls = new ArrayList<>();
		for(SVariable v : variables) {
			Type t = TranslateType.translate(v.type, s.map);
			decls.add(new VarDecl(v.name,t));
		}
		
		for(SCall sub : called.calls) {
			decls.addAll(sub.toVarDecl(called));
		}
		return decls;
	}
	
	public List<jkind.lustre.Expr> getCallArgs() {
		List<jkind.lustre.Expr> args = new ArrayList<>();
		for(SVariable sv : variables) {
			args.add(new IdExpr(sv.name));
		}
		return args;
	}
	
	public String toString() {
		return callerName + " -> " + calledName;
	}
}
