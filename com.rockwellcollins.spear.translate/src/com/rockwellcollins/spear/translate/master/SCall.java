package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.backend.SpearMap;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.lustre.IdExpr;
import jkind.lustre.VarDecl;

public class SCall {

	public static List<SCall> build(List<NormalizedCall> calls, List<SSpecification> specs, SpearMap map) {
		return calls.stream().map(call -> new SCall(call, specs, map)).collect(Collectors.toList());
	}

	public static List<VarDecl> toVarDeclList(List<SCall> calls, SSpecification s) {
		List<VarDecl> decls = new ArrayList<>();
		for (SCall call : calls) {
			decls.addAll(call.toVarDecl(s));
		}
		return decls;
	}

	public static SCall get(NormalizedCall call, List<SCall> calls) {
		for (SCall scall : calls) {
			if (scall.original.equals(call)) {
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

	private SCall(NormalizedCall call, List<SSpecification> specs, SpearMap map) {
		this.original = call;

		this.callerName = map.lookupOriginalProgram(Utilities.getRoot(call).getName());
		this.caller = SSpecification.lookup(callerName, specs);

		this.calledName = map.lookupOriginalProgram(call.getSpec().getName());
		this.called = SSpecification.lookup(this.calledName, specs);
	}

	public void resolveCallVars() {
		for (SVariable sv : called.state) {
			String name = called.name + "_" + sv.name;
			// the SVariable registers the name with the caller spec
			variables.add(new SVariable(name, sv.type, caller));
		}
	}

	public List<VarDecl> toVarDecl(SSpecification s) {
		List<VarDecl> decls = new ArrayList<>();
		for (SVariable sv : variables) {
			decls.add(new VarDecl(sv.name, TranslateType.translate(sv.type, caller.map)));
		}

		for (SCall call : called.calls) {
			decls.addAll(call.toVarDecl(called));
		}
		return decls;
	}

	public List<jkind.lustre.Expr> getCallArgs() {
		List<jkind.lustre.Expr> args = new ArrayList<>();
		for (SVariable sv : variables) {
			args.add(new IdExpr(sv.name));
		}

		for (SCall call : called.calls) {
			args.addAll(call.getCallArgs());
		}
		return args;
	}

	public String toString() {
		return callerName + " -> " + calledName;
	}
}
