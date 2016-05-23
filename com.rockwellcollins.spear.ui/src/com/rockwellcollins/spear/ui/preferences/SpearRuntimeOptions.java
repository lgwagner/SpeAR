package com.rockwellcollins.spear.ui.preferences;

public class SpearRuntimeOptions {

	public static int consistencyDepth = 10;
	public static boolean printFinalLustre = false;
	public static boolean disableValidations = false;
	
	public static void setRuntimeOptions() {
		SpearRuntimeOptions.consistencyDepth = PreferencesUtil.getConsistencyDepthOption();
		SpearRuntimeOptions.printFinalLustre = PreferencesUtil.getFinalLustreFileOption();
		SpearRuntimeOptions.disableValidations = false;
	}
}
