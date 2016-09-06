package com.rockwellcollins.spear.translate.lustre;

import java.util.HashMap;
import java.util.Map;

import com.rockwellcollins.spear.NormalizedCall;

public class CallMap {

	private static Integer key = 0;
	public static Map<Integer,NormalizedCall> callmap = new HashMap<>();
	
	public static void reset() {
		key = 0;
	}
	
	private static void incrementKey() {
		key++;
	}
	
	public static Integer addCall(NormalizedCall call) {
		callmap.put(key, call);
		incrementKey();
		return key;
	}
}
