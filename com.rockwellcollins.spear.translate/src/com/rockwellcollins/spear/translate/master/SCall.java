package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.utilities.Utilities;

public class SCall {

	public static List<SCall> build(List<NormalizedCall> calls) {
		List<SCall> scalls = new ArrayList<>();
		for(NormalizedCall call : calls) {
			scalls.add(new SCall(call));
		}
		return scalls;
	}
	
	public Specification caller;
	public Specification called;
	public List<Expr> args;
	
	public SCall(NormalizedCall call) {
		caller = (Specification) Utilities.getRoot(call);
		called = call.getSpec();
		args = new ArrayList<>(call.getArgs());
	}
}
