package com.rockwellcollins.spear.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

	/* SpeAR preferences */
	public static final String PREF_SPEAR_CONSISTENCY_DEPTH = "consistency depth";
	public static final String PREF_SPEAR_PRINT_FINAL_LUSTRE = "final lustre file";
	public static final String PREF_SPEAR_RECURSIVE_GRAPH = "recursive graphical display";
	public static final String PREF_SPEAR_WARN_ON_UNUSED_VARS = "disable unused variable validations";
	public static final String PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT = "Enable IVC during logical entailment";

	/* JKIND preferences */
	public static final String PREF_BOUNDED_MODEL_CHECKING = "boundedModelChecking";
	public static final String PREF_K_INDUCTION = "kInduction";
	public static final String PREF_INVARIANT_GENERATION = "invariantGeneration";
	public static final String PREF_PDR_MAX = "pdrMax";
	public static final String PREF_INDUCTIVE_COUNTEREXAMPLES = "inductiveCounterexamples";
	public static final String PREF_SMOOTH_COUNTEREXAMPLES = "smoothCounterexamples";
	public static final String PREF_DEBUG = "apiDebug";
	public static final String PREF_DEPTH = "inductionDepth";
	public static final String PREF_TIMEOUT = "timeout";
	public static final String PREF_SOLVER = "solver";
	public static final String SOLVER_SMTINTERPOL = "SMTInterpol";
	public static final String SOLVER_Z3 = "Z3";
	public static final String SOLVER_YICES2 = "Yices 2";
	public static final String SOLVER_CVC4 = "CVC4";

	/* Model Checker preferences */
	/* hint...there's only one model checker allowed */
	public static final String PREF_MODEL_CHECKER = "modelChecker";
	public static final String MODEL_CHECKER_JKIND = "JKind";
}