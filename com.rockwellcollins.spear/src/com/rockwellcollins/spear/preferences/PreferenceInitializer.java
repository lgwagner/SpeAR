package com.rockwellcollins.spear.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Preferences.store;
		store.setDefault(PreferenceConstants.PREF_MODEL_CHECKER, PreferenceConstants.MODEL_CHECKER_JKIND);
		store.setDefault(PreferenceConstants.PREF_SOLVER, PreferenceConstants.SOLVER_SMTINTERPOL);
		store.setDefault(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING, true);
		store.setDefault(PreferenceConstants.PREF_K_INDUCTION, true);
		store.setDefault(PreferenceConstants.PREF_INVARIANT_GENERATION, true);
		store.setDefault(PreferenceConstants.PREF_PDR_MAX, 2);
		store.setDefault(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES, true);
		// store.setDefault(PreferenceConstants.PREF_REDUCE_IVC, false);
		store.setDefault(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES, false);
		store.setDefault(PreferenceConstants.PREF_INTERVAL_GENERALIZATION, false);
		store.setDefault(PreferenceConstants.PREF_DEBUG, false);
		store.setDefault(PreferenceConstants.PREF_DEPTH, 200);
		store.setDefault(PreferenceConstants.PREF_TIMEOUT, 100);

		// Spear
		store.setDefault(PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH, 10);
		store.setDefault(PreferenceConstants.PREF_SPEAR_PRINT_FINAL_LUSTRE, false);
		store.setDefault(PreferenceConstants.PREF_SPEAR_RECURSIVE_GRAPH, false);
		store.setDefault(PreferenceConstants.PREF_SPEAR_WARN_ON_UNUSED_VARS, false);
		store.setDefault(PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT, false);
	}
}
