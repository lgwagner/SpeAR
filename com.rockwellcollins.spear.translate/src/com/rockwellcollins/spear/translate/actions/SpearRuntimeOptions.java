package com.rockwellcollins.spear.translate.actions;

import com.rockwellcollins.spear.ui.preferences.PreferencesUtil;

public class SpearRuntimeOptions {

	public static int consistencyDepth = 10;
	protected static boolean printFinalLustre = false;
	
	public static void setRuntimeOptions() {
		SpearRuntimeOptions.consistencyDepth = PreferencesUtil.getConsistencyDepthOption();
		SpearRuntimeOptions.printFinalLustre = PreferencesUtil.getFinalLustreFileOption();
	}
}
