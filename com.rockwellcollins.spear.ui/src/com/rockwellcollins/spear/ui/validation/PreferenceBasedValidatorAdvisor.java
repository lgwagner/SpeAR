package com.rockwellcollins.spear.ui.validation;

import org.eclipse.jface.preference.IPreferenceStore;

import com.rockwellcollins.spear.ui.preferences.PreferenceConstants;
import com.rockwellcollins.ui.internal.SpearActivator;
import com.rockwellcollins.validation.IValidatorAdvisor;

public class PreferenceBasedValidatorAdvisor implements IValidatorAdvisor {

	private final IPreferenceStore preferencesStore;

	public PreferenceBasedValidatorAdvisor() {
		preferencesStore = SpearActivator.getInstance().getPreferenceStore();
	}

	@Override
	public boolean isUnusedValidationsDisabled() {
		return preferencesStore.getBoolean(PreferenceConstants.PREF_DISABLE_UNUSED_VALIDATIONS);
	}
	
	@Override
	public boolean isSolverNonlinear() {
		String solver = preferencesStore.getString(PreferenceConstants.PREF_SOLVER);
		return solver.equals(PreferenceConstants.SOLVER_Z3) || solver.equals(PreferenceConstants.SOLVER_YICES2);
	}
}
