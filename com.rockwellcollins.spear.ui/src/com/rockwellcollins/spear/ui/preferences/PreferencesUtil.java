package com.rockwellcollins.spear.ui.preferences;

import java.io.File;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;

import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.JKindException;
import jkind.SolverOption;
import jkind.api.JKindApi;
import jkind.api.JRealizabilityApi;

public class PreferencesUtil {
	
	public static int getConsistencyDepthOption() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getInt(PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH);
	}
	
	public static boolean getFinalLustreFileOption() {
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
	
	public static boolean generalizeCEX() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getBoolean(PreferenceConstants.PREF_INTERVAL_GENERALIZATION);
	}
	
	public static boolean smoothCEX() {
		IPreferenceStore prefs = getPreferenceStore();
		return prefs.getBoolean(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES);
	}
	
	private static IPreferenceStore getPreferenceStore() {
		return SpearActivator.getInstance().getPreferenceStore();
	}

	public static JKindApi getJKindApi() {
		IPreferenceStore prefs = getPreferenceStore();
		JKindApi api = new JKindApi();
		api.setJKindJar(getJKindJar());

		String solverString = prefs.getString(PreferenceConstants.PREF_SOLVER).toUpperCase()
				.replaceAll(" ", "");
		SolverOption solver = SolverOption.valueOf(solverString);
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
		if (prefs.getBoolean(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES)) {
			api.setInductiveCounterexamples();
		}
		if (prefs.getBoolean(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES)
				&& solver == SolverOption.YICES) {
			api.setSmoothCounterexamples();
		}
		if (prefs.getBoolean(PreferenceConstants.PREF_INTERVAL_GENERALIZATION)) {
			api.setIntervalGeneralization();
		}
		if (prefs.getBoolean(PreferenceConstants.PREF_DEBUG)) {
			api.setApiDebug();
		}

		api.setN(prefs.getInt(PreferenceConstants.PREF_DEPTH));
		api.setTimeout(prefs.getInt(PreferenceConstants.PREF_TIMEOUT));
		return api;
	}
	
	public static JRealizabilityApi getJRealizabilityApi() {
		JRealizabilityApi api = new JRealizabilityApi();
		api.setJKindJar(getJKindJar());
		return api;
	}

	public static String getJKindJar() {
		Bundle bundle = Platform.getBundle("com.rockwellcollins.spear");
		URL url = bundle.getEntry("dependencies/jkind.jar");
		try {
			URL fileUrl = FileLocator.toFileURL(url);
			return new File(fileUrl.getPath()).toString();
		} catch (Exception e) {
			throw new JKindException("Unable to extract jkind.jar from plug-in", e);
		}
	}


}
