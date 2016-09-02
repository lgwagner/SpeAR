package com.rockwellcollins.spear.translate.intermediate;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.utilities.Utilities;

public class Call {
	
	public String caller;
	public String called;
	public NormalizedCall call;

	public Call(NormalizedCall call) {
		this.caller = Utilities.getRoot(call).getName();
		this.called = call.getSpec().getName();
		this.call = call;
	}
}
