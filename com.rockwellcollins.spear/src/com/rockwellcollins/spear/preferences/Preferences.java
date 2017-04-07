package com.rockwellcollins.spear.preferences;

import org.eclipse.jface.preference.PreferenceStore;

public class Preferences {
  
  public static PreferenceStore store = getInitialPreferences();
  
  public static PreferenceStore getInitialPreferences() {
    PreferenceStore s = new PreferenceStore();
    s.setDefault(PreferenceConstants.PREF_MODEL_CHECKER,PreferenceConstants.MODEL_CHECKER_JKIND);
    s.setDefault(PreferenceConstants.PREF_SOLVER, PreferenceConstants.SOLVER_SMTINTERPOL);
    s.setDefault(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING, true);
    s.setDefault(PreferenceConstants.PREF_K_INDUCTION, true);
    s.setDefault(PreferenceConstants.PREF_INVARIANT_GENERATION, true);
    s.setDefault(PreferenceConstants.PREF_PDR_MAX, 2);
    s.setDefault(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES, true);
//    setDefault(PreferenceConstants.PREF_REDUCE_IVC, false);
    s.setDefault(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES, false);
    s.setDefault(PreferenceConstants.PREF_INTERVAL_GENERALIZATION, false);
    s.setDefault(PreferenceConstants.PREF_DEBUG, false);
    s.setDefault(PreferenceConstants.PREF_DEPTH, 200);
    s.setDefault(PreferenceConstants.PREF_TIMEOUT, 100);
    
    //Spear
    s.setDefault(PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH, 10);
    s.setDefault(PreferenceConstants.PREF_SPEAR_PRINT_FINAL_LUSTRE, false);
    s.setDefault(PreferenceConstants.PREF_SPEAR_RECURSIVE_GRAPH, false);
    s.setDefault(PreferenceConstants.PREF_SPEAR_WARN_ON_UNUSED_VARS, false);
    s.setDefault(PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT, false);
    
    return s;
  }
  
}
