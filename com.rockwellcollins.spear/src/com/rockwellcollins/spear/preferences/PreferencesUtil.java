package com.rockwellcollins.spear.preferences;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;

import com.rockwellcollins.atc.z3.Z3Plugin;

import jkind.JKindException;
import jkind.SolverOption;
import jkind.api.JKindApi;
import jkind.api.JLustre2ExcelApi;
import jkind.api.JRealizabilityApi;

public class PreferencesUtil {

	public static int getConsistencyDepthOption() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getInt(PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH);
	}

	public static boolean printFinalLustre() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getBoolean(PreferenceConstants.PREF_SPEAR_PRINT_FINAL_LUSTRE);
	}

	public static boolean getRecursiveGraphicalDisplayOption() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getBoolean(PreferenceConstants.PREF_SPEAR_RECURSIVE_GRAPH);
	}

	public static boolean getEnableIVCDuringEntailment() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getBoolean(PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT);
	}

	public static boolean getDisabledUnusedValidations() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getBoolean(PreferenceConstants.PREF_SPEAR_WARN_ON_UNUSED_VARS);
	}

	public static boolean getSolverNonlinear() {
		IPreferenceStore prefs = getPreferenceStore();
		String solver = prefs.getString(PreferenceConstants.PREF_SOLVER);
		return solver.equals(PreferenceConstants.SOLVER_Z3);
	}

	public static boolean smoothCEX() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getBoolean(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES);
	}

	private static IPreferenceStore getPreferenceStore() {
		return Preferences.store;
	}

	public static void configureJKindApi(JKindApi api) {
		IPreferenceStore prefs = getPreferenceStore();
		
		String vmArgString = prefs.getString(PreferenceConstants.PREF_VM_ARGS);
		String[] splitString = vmArgString.split("\\s+");
		api.setVmArgs(new ArrayList<>(Arrays.asList(splitString)));
		
		String solverString = prefs.getString(PreferenceConstants.PREF_SOLVER).toUpperCase().replaceAll(" ", "");
		SolverOption solver = SolverOption.valueOf(solverString);
		
		try {
			api.setEnvironment("Z3_HOME", Z3Plugin.getZ3Directory());
		} catch (NoClassDefFoundError e) {
			e.printStackTrace();
		}
		
		api.setSolver(solver);
		if (!prefs.getBoolean(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING)) {
			api.disableBoundedModelChecking();
		}
		if (!prefs.getBoolean(PreferenceConstants.PREF_K_INDUCTION)) {
			api.disableKInduction();
		}
		if (!prefs.getBoolean(PreferenceConstants.PREF_INVARIANT_GENERATION)) {
			api.disableInvariantGeneration();
		}
		api.setPdrMax(prefs.getInt(PreferenceConstants.PREF_PDR_MAX));
		
		//0 means maxint
		int k = prefs.getInt(PreferenceConstants.PREF_DEPTH);
		api.setN(k == 0 ? Integer.MAX_VALUE : k);

		int timeout = prefs.getInt(PreferenceConstants.PREF_TIMEOUT);
		api.setTimeout(timeout == 0 ? Integer.MAX_VALUE : timeout);

		boolean smoothPossible = solver.equals(SolverOption.Z3) || solver.equals(SolverOption.YICES);
		if (prefs.getBoolean(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES) && smoothPossible) {
			api.setSmoothCounterexamples();
		}
		
		if (prefs.getBoolean(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES)) {
			api.setInductiveCounterexamples();
		}

		if (prefs.getBoolean(PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT)) {
			api.setIvcReduction();
		}
		
		if (prefs.getBoolean(PreferenceConstants.PREF_DEBUG)) {
			api.setApiDebug();
		}
	}

	public static void configureRealizabilityApi(JRealizabilityApi api) {
		IPreferenceStore prefs = getPreferenceStore();

		String vmArgString = Preferences.store.getString(PreferenceConstants.PREF_VM_ARGS);
		api.setVmArgs(new ArrayList<>(Arrays.asList(vmArgString.split(" "))));		
		
		try {
			api.setEnvironment("Z3_HOME", Z3Plugin.getZ3Directory());
		} catch (NoClassDefFoundError e) {
			e.printStackTrace();
		}
		
		int k = prefs.getInt(PreferenceConstants.PREF_DEPTH);
		api.setN(k == 0 ? Integer.MAX_VALUE : k);

		int timeout = prefs.getInt(PreferenceConstants.PREF_TIMEOUT);
		api.setTimeout(timeout == 0 ? Integer.MAX_VALUE : timeout);

		if (prefs.getBoolean(PreferenceConstants.PREF_DEBUG)) {
			api.setApiDebug();
		}
	}

	public static JKindApi getJKindApi() {
		JKindApi api = new JKindApi();
		api.setJKindJar(getJKindJar());
		configureJKindApi(api);
		return api;
	}

	public static JRealizabilityApi getJRealizabilityApi() {
		JRealizabilityApi api = new JRealizabilityApi();
		api.setJKindJar(getJKindJar());
		return api;
	}

	public static JLustre2ExcelApi getJLustre2ExcelApi() {
		JLustre2ExcelApi api = new JLustre2ExcelApi();
		api.setJKindJar(getJKindJar());
		return api;
	}

	public static String getJKindJar() {
		Bundle bundle = Platform.getBundle("com.rockwellcollins.spear");
		URL url = bundle.getEntry("dependencies/jkind/jkind.jar");
		try {
			URL fileUrl = FileLocator.toFileURL(url);
			return new File(fileUrl.getPath()).toString();
		} catch (Exception e) {
			throw new JKindException("Unable to extract jkind.jar from plug-in", e);
		}
	}

}
