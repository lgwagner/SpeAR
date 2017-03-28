package com.rockwellcollins.spear.preferences;

public class PreferenceStore extends org.eclipse.jface.preference.PreferenceStore {
  
  public PreferenceStore() {
    super();
    setDefault(PreferenceConstants.PREF_MODEL_CHECKER,PreferenceConstants.MODEL_CHECKER_JKIND);
    setDefault(PreferenceConstants.PREF_SOLVER, PreferenceConstants.SOLVER_SMTINTERPOL);
    setDefault(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING, true);
    setDefault(PreferenceConstants.PREF_K_INDUCTION, true);
    setDefault(PreferenceConstants.PREF_INVARIANT_GENERATION, true);
    setDefault(PreferenceConstants.PREF_PDR_MAX, 2);
    setDefault(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES, true);
//    setDefault(PreferenceConstants.PREF_REDUCE_IVC, false);
    setDefault(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES, false);
    setDefault(PreferenceConstants.PREF_INTERVAL_GENERALIZATION, false);
    setDefault(PreferenceConstants.PREF_DEBUG, false);
    setDefault(PreferenceConstants.PREF_DEPTH, 200);
    setDefault(PreferenceConstants.PREF_TIMEOUT, 100);
    
    //Spear
    setDefault(PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH, 10);
    setDefault(PreferenceConstants.PREF_SPEAR_PRINT_FINAL_LUSTRE, false);
    setDefault(PreferenceConstants.PREF_SPEAR_RECURSIVE_GRAPH, false);
    setDefault(PreferenceConstants.PREF_SPEAR_WARN_ON_UNUSED_VARS, false);
    setDefault(PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT, false);
  }

}
