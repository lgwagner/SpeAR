package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.utilities.Utilities;

public class Call {
	
	public static Integer ID = 0;
	
	private static Integer nextID() {
		Integer next = ID;
		ID++;
		return next;
	}
	
	public static void reset() {
		ID = 0;
	}
	
	public String caller;
	public String called;
	public NormalizedCall call;
	public Integer callID;
	public List<Call> calls = new ArrayList<>();

	public Call(NormalizedCall call) {
		this.callID = Call.nextID();
		this.caller = Utilities.getRoot(call).getName();
		this.called = call.getSpec().getName();
		this.call = call;
		
		List<NormalizedCall> subCalls = EcoreUtil2.getAllContentsOfType(call.getSpec(), NormalizedCall.class);
		for(NormalizedCall nc : subCalls) {
			calls.add(new Call(nc));
		}
	}
	
	public String toString() {
		return this.callID + ": " + caller + " -> " + called;
	}
}
