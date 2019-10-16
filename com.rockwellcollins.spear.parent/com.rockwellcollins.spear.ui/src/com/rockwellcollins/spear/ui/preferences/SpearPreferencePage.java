package com.rockwellcollins.spear.ui.preferences;

import java.awt.Desktop;
import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rockwellcollins.spear.preferences.PreferenceConstants;
import com.rockwellcollins.spear.preferences.Preferences;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.api.JKindApi;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */
public class SpearPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public SpearPreferencePage() {
		super(GRID);
		setPreferenceStore(SpearActivator.getInstance().getPreferenceStore());
	}

	private static void initString(IPreferenceStore sstore, IPreferenceStore dstore, String key) {
		dstore.setValue(key, sstore.getString(key));
	}

	private static void initBool(IPreferenceStore sstore, IPreferenceStore dstore, String key) {
		dstore.setValue(key, sstore.getBoolean(key));
	}

	private static void initInt(IPreferenceStore sstore, IPreferenceStore dstore, String key) {
		dstore.setValue(key, sstore.getInt(key));
	}

	public static void initStore(IPreferenceStore sstore, IPreferenceStore dstore) {

		String strkeys[] = { PreferenceConstants.PREF_MODEL_CHECKER, PreferenceConstants.PREF_SOLVER };

		for (String key : strkeys) {
			initString(sstore, dstore, key);
		}

		String boolkeys[] = { PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING,
				PreferenceConstants.PREF_INVARIANT_GENERATION, PreferenceConstants.PREF_K_INDUCTION,
				PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES, PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES,
				PreferenceConstants.PREF_DEBUG, PreferenceConstants.PREF_SPEAR_PRINT_FINAL_LUSTRE,
				PreferenceConstants.PREF_SPEAR_RECURSIVE_GRAPH, PreferenceConstants.PREF_SPEAR_WARN_ON_UNUSED_VARS,
				PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT };

		for (String key : boolkeys) {
			initBool(sstore, dstore, key);
		}

		String intkeys[] = { PreferenceConstants.PREF_PDR_MAX, PreferenceConstants.PREF_DEPTH,
				PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH, PreferenceConstants.PREF_TIMEOUT };

		for (String key : intkeys) {
			initInt(sstore, dstore, key);
		}
	}

	private final String selectedModelChecker = PreferenceConstants.MODEL_CHECKER_JKIND;

	private static final String[][] SOLVERS = {
			{ PreferenceConstants.SOLVER_SMTINTERPOL, PreferenceConstants.SOLVER_SMTINTERPOL },
			{ PreferenceConstants.SOLVER_Z3, PreferenceConstants.SOLVER_Z3 },
			{ PreferenceConstants.SOLVER_YICES2, PreferenceConstants.SOLVER_YICES2 },
			{ PreferenceConstants.SOLVER_CVC4, PreferenceConstants.SOLVER_CVC4 } };

	private ComboFieldEditor solverFieldEditor;
	private String selectedSolver;

	private BooleanFieldEditor bmcFieldEditor;
	private BooleanFieldEditor kInductionFieldEditor;
	private BooleanFieldEditor invGenFieldEditor;
	private NonnegativeIntegerFieldEditor pdrMaxFieldEditor;
	private BooleanFieldEditor inductCexFieldEditor;
	private BooleanFieldEditor smoothCexFieldEditor;
	private BooleanFieldEditor spearUnusedVariableWarningsEditor;
	private BooleanFieldEditor spearFinalLustreFileFieldEditor;
	private BooleanFieldEditor spearRecursiveGraphicalDisplayFieldEditor;
	private BooleanFieldEditor spearEnableIVCDuringEntailment;
	private NonnegativeIntegerFieldEditor depthFieldEditor;
	private NonnegativeIntegerFieldEditor timeoutFieldEditor;
	private PositiveIntegerFieldEditor consistencyFieldEditor;

	/* Spear specific preferences */
	private BooleanFieldEditor debugFieldEditor;

	@Override
	public void createFieldEditors() {
		/* BEGIN: Solver Group */
		solverFieldEditor = new ComboFieldEditor(PreferenceConstants.PREF_SOLVER.toString(), "SMT Solver", SOLVERS,
				this.getFieldEditorParent());
		addField(solverFieldEditor);

		Button checkAvailableButton = new Button(this.getFieldEditorParent(), SWT.PUSH);
		checkAvailableButton.setText("Check if available");
		checkAvailableButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				checkAvailable();
			}
		});

		/* END: Solver group, BEGIN: JKind group */

		bmcFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING.toString(),
				"Use bounded model checking", this.getFieldEditorParent());
		addField(bmcFieldEditor);

		kInductionFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_K_INDUCTION.toString(),
				"Use k-induction", this.getFieldEditorParent());
		addField(kInductionFieldEditor);

		invGenFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INVARIANT_GENERATION.toString(),
				"Use invariant generation", this.getFieldEditorParent());
		addField(invGenFieldEditor);

		pdrMaxFieldEditor = new NonnegativeIntegerFieldEditor(PreferenceConstants.PREF_PDR_MAX.toString(),
				"Maximum number of PDR instances (0 to disable)", this.getFieldEditorParent());
		addField(pdrMaxFieldEditor);

		inductCexFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES.toString(),
				"Generate inductive counterexamples", this.getFieldEditorParent());
		addField(inductCexFieldEditor);

		smoothCexFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES.toString(),
				"Generate smooth counterexamples (minimal number of input value changes)", this.getFieldEditorParent());
		addField(smoothCexFieldEditor);

		depthFieldEditor = new NonnegativeIntegerFieldEditor(PreferenceConstants.PREF_DEPTH.toString(),
				"Maximum depth for k-induction (0 for infinite)", this.getFieldEditorParent());
		addField(depthFieldEditor);

		timeoutFieldEditor = new NonnegativeIntegerFieldEditor(PreferenceConstants.PREF_TIMEOUT.toString(),
				"Timeout in seconds (0 for forever)", this.getFieldEditorParent());
		addField(timeoutFieldEditor);

		debugFieldEditor = new BooleanButtonFieldEditor(PreferenceConstants.PREF_DEBUG.toString(),
				"Debug mode (record log files)", "Open temporary folder", this::openTemporaryFolder,
				this.getFieldEditorParent());
		addField(debugFieldEditor);

		/* END: JKind group, BEGIN: SpeAR group */

		spearUnusedVariableWarningsEditor = new BooleanFieldEditor(
				PreferenceConstants.PREF_SPEAR_WARN_ON_UNUSED_VARS.toString(), "Disable unused variable validations",
				this.getFieldEditorParent());
		addField(spearUnusedVariableWarningsEditor);
		
		spearEnableIVCDuringEntailment = new BooleanFieldEditor(
				PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT.toString(),
				"Enable IVC during Logical Entailment Analysis", this.getFieldEditorParent());
		addField(spearEnableIVCDuringEntailment);
		
		spearRecursiveGraphicalDisplayFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.PREF_SPEAR_RECURSIVE_GRAPH.toString(), "Make graphical display recursive",
				this.getFieldEditorParent());
		addField(spearRecursiveGraphicalDisplayFieldEditor);

		spearFinalLustreFileFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.PREF_SPEAR_PRINT_FINAL_LUSTRE.toString(), "Generate final Lustre file",
				this.getFieldEditorParent());
		addField(spearFinalLustreFileFieldEditor);
		
		consistencyFieldEditor = new PositiveIntegerFieldEditor(
				PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH.toString(), "Depth of consistency check in steps",
				this.getFieldEditorParent());
		addField(consistencyFieldEditor);

		/* END: SpeAR group */
	}

	private void openTemporaryFolder() {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(new File(System.getProperty("java.io.tmpdir")));
		} catch (Throwable t) {
			MessageDialog.openError(getShell(), "Error opening temporary directory",
					"Error opening temporary directory: " + t.getMessage());
		}
	}

	private void checkAvailable() {
		try {
			JKindApi api = PreferencesUtil.getJKindApi();
			String details = api.checkAvailable();
			MessageDialog.openInformation(getShell(), "Model checker available", details);
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error running model checker",
					"Error running model checker: " + e.getMessage());
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		//set selected solver if that was the source of the change.
		if (event.getSource().equals(solverFieldEditor)) {
			selectedSolver = (String) event.getNewValue();
		}
		configureEnabledFieldEditors();
	}

	@Override
	public void performApply() {
		super.performApply();
		initStore(getPreferenceStore(), Preferences.store);

		//refresh on apply so the non-linear errors are resolved without the user having to struggle with that.
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
		initialize();
	}

	private void configureEnabledFieldEditors() {
		boolean isJKind = selectedModelChecker.equals(PreferenceConstants.MODEL_CHECKER_JKIND);
		boolean isYices = selectedSolver.equals(PreferenceConstants.SOLVER_YICES2);
		boolean isZ3 = selectedSolver.equals(PreferenceConstants.SOLVER_Z3);
		bmcFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		kInductionFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		invGenFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		pdrMaxFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		solverFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		inductCexFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		depthFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		smoothCexFieldEditor.setEnabled(isJKind && (isYices || isZ3), getFieldEditorParent());
	}

	@Override
	protected void initialize() {
		super.initialize();
		Preferences.store = Preferences.getInitialPreferences();
		initStore(Preferences.getInitialPreferences(), getPreferenceStore());
		initializeStateVariables();
		configureEnabledFieldEditors();
	}

	private void initializeStateVariables() {
		IPreferenceStore prefs = Preferences.getInitialPreferences();
		selectedSolver = prefs.getString(PreferenceConstants.PREF_SOLVER.toString());
	}

	private class NonnegativeIntegerFieldEditor extends IntegerFieldEditor {
		public NonnegativeIntegerFieldEditor(String name, String labelText, Composite parent) {
			super(name, labelText, parent);
			setValidRange(0, Integer.MAX_VALUE);
			setErrorMessage("Field must be a positive integer");
		}
	}
	
	private class PositiveIntegerFieldEditor extends IntegerFieldEditor {
		public PositiveIntegerFieldEditor(String name, String labelText, Composite parent) {
			super(name, labelText, parent);
			setValidRange(1, Integer.MAX_VALUE);
			setErrorMessage("Field must be a positive integer");
		}
	}

	@Override
	public void init(IWorkbench workbench) {}
}