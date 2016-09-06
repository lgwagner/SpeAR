package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.translate.intermediate.Call;
import com.rockwellcollins.spear.translate.naming.Renaming;

public class SCall {

	public static List<SCall> build(List<Call> calls, Renaming map) {
		List<SCall> scalls = new ArrayList<>();
		for(Call call : calls) {
			scalls.add(SCall.build(call, map));
		}
		return scalls;
	}
	
	public static SCall build(Call call, Renaming map) {
		return new SCall(call,map);
	}
	
	public String caller;
	public String called;
	public NormalizedCall call;
	public Integer callID;
	public List<SCall> calls = new ArrayList<>();
	
	public SCall(Call call, Renaming map) {
		this.callID = call.callID;
		this.caller = map.lookupOriginal(call.caller);
		this.called = map.lookupOriginal(call.called);
		this.call = call.call;
		this.calls = SCall.build(call.calls, map);
	}
	
	public List<String> getIds(List<SSpecification> specifications) {
		SSpecification called = SSpecification.lookup(this.called, specifications);
		List<String> ids = new ArrayList<>();
		for(SVariable v : called.state) {
			ids.add(v.name + this.callID);
		}
		
		for(SCall sub : this.calls) {
			ids.addAll(sub.getIds(specifications));
		}
		
		return ids;
	}
	
	public String toString() {
		return caller + " -> " + "(" + callID + ":" + called + ")";
	}
}
