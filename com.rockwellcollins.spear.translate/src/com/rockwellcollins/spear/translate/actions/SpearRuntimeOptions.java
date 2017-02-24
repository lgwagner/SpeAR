package com.rockwellcollins.spear.translate.actions;

import com.rockwellcollins.spear.ui.preferences.PreferencesUtil;

public class SpearRuntimeOptions {

	public static int consistencyDepth = 10;
	public static boolean printFinalLustre = false;
	public static boolean recursiveGraphicalDisplay = false;
	public static boolean enableIVCDuringEntailment = false;
	public static boolean isSolverNonlinear = false;
	
	public static void setRuntimeOptions() {
		SpearRuntimeOptions.consistencyDepth = PreferencesUtil.getConsistencyDepthOption();
		SpearRuntimeOptions.printFinalLustre = PreferencesUtil.getFinalLustreFileOption();
		SpearRuntimeOptions.recursiveGraphicalDisplay = PreferencesUtil.getRecursiveGraphicalDisplayOption();
		SpearRuntimeOptions.enableIVCDuringEntailment = PreferencesUtil.getEnableIVCDuringEntailment();
		SpearRuntimeOptions.isSolverNonlinear = PreferencesUtil.getSolverNonlinear();
	}
}
