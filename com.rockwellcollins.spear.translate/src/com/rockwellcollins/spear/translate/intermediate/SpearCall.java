package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.utilities.Utilities;

public class SpearCall {
	
	public String caller;
	public String called;
	public List<String> assigned;
	public List<Expr> args;
	
	public SpearCall(NormalizedCall call) {
		this.caller = Utilities.getRoot(call).getName();
		this.called = call.getSpec().getName();
		this.assigned = convert(call.getIds());
		this.args = call.getArgs();
	}
	
	private List<String> convert(List<IdRef> list) {
		List<String> strings = new ArrayList<>();
		for(IdRef idr : list) {
			strings.add(idr.getName());
		}
		return strings;
	}
	
	public String toString() {
		return called;
	}
}
