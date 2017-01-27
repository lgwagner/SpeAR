package com.rockwellcollins.spear.ui.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {
	
	/*Spear specifics */
	public static final String PREF_SPEAR_CONSISTENCY_DEPTH = "consistency depth";
	public static final String PREF_GENERATE_FINAL_LUSTRE_FILE = "final lustre file";
	public static final String PREF_RECURSIVE_GRAPHICAL_DISPLAY = "recursive graphical display";
	public static final String PREF_DISABLE_UNUSED_VALIDATIONS = "disable unused validations";
	public static final String PREF_ENABLE_IVC_ENTAILMENT = "Enable IVC during logical entailment";
	
	public static final String PREF_BOUNDED_MODEL_CHECKING = "boundedModelChecking";
	public static final String PREF_K_INDUCTION = "kInduction";
	public static final String PREF_INVARIANT_GENERATION = "invariantGeneration";
	public static final String PREF_PDR_MAX = "pdrMax";
	public static final String PREF_INDUCTIVE_COUNTEREXAMPLES = "inductiveCounterexamples";
	public static final String PREF_REDUCE_IVC = "reduceIVC";
	public static final String PREF_SMOOTH_COUNTEREXAMPLES = "smoothCounterexamples";
	public static final String PREF_INTERVAL_GENERALIZATION = "intervalGeneralization";
	public static final String PREF_DEBUG = "apiDebug";

	public static final String PREF_DEPTH = "inductionDepth";

	public static final String PREF_TIMEOUT = "timeout";
	
	public static final String PREF_SOLVER = "solver";

	public static final String SOLVER_YICES = "Yices";
	public static final String SOLVER_Z3 = "Z3";
	public static final String SOLVER_CVC4 = "CVC4";
	public static final String SOLVER_YICES2 = "Yices 2";
	public static final String SOLVER_MATHSAT = "MathSAT";
	public static final String SOLVER_SMTINTERPOL = "SMTInterpol";

	public static final String PREF_MODEL_CHECKER = "modelChecker";
	
	public static final String MODEL_CHECKER_JKIND = "JKind";
	public static final String MODEL_CHECKER_KIND2 = "Kind 2";
	public static final String MODEL_CHECKER_KIND2WEB = "Kind 2 Remote";

	public static final String PREF_REMOTE_URL = "remoteUrl";
}