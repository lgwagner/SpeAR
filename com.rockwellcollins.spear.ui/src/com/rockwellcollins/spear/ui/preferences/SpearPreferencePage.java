package com.rockwellcollins.spear.ui.preferences;

import java.awt.Desktop;
import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.api.KindApi;

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

	private static final String[][] MODEL_CHECKERS = {
			{ PreferenceConstants.MODEL_CHECKER_JKIND, PreferenceConstants.MODEL_CHECKER_JKIND },
			{ PreferenceConstants.MODEL_CHECKER_KIND2, PreferenceConstants.MODEL_CHECKER_KIND2 },
			{ PreferenceConstants.MODEL_CHECKER_KIND2WEB, PreferenceConstants.MODEL_CHECKER_KIND2WEB } };
	private ComboFieldEditor modelCheckerFieldEditor;
	private String selectedModelChecker;

	private StringFieldEditor remoteUrlFieldEditor;

	private static final String[][] SOLVERS = 
		   {{ PreferenceConstants.SOLVER_SMTINTERPOL, PreferenceConstants.SOLVER_SMTINTERPOL },
			{ PreferenceConstants.SOLVER_Z3, PreferenceConstants.SOLVER_Z3 },
			{ PreferenceConstants.SOLVER_YICES2, PreferenceConstants.SOLVER_YICES2 },
			{ PreferenceConstants.SOLVER_CVC4, PreferenceConstants.SOLVER_CVC4 },
			{ PreferenceConstants.SOLVER_MATHSAT, PreferenceConstants.SOLVER_MATHSAT }};

	private ComboFieldEditor solverFieldEditor;
	private String selectedSolver;

	private BooleanFieldEditor bmcFieldEditor;
	private BooleanFieldEditor kInductionFieldEditor;
	private BooleanFieldEditor invGenFieldEditor;
	private NonNegativeIntegerFieldEditor pdrMaxFieldEditor;
	private BooleanFieldEditor inductCexFieldEditor;
	private BooleanFieldEditor reduceSupportFieldEditor;
	private BooleanFieldEditor smoothCexFieldEditor;
	private BooleanFieldEditor intervalGenFieldEditor;
	private BooleanFieldEditor unusedValidationFieldEditor;
	private BooleanFieldEditor spearFinalLustreFileFieldEditor;
	private NonNegativeIntegerFieldEditor depthFieldEditor;
	private NonNegativeIntegerFieldEditor timeoutFieldEditor;
	private NonNegativeIntegerFieldEditor consistencyFieldEditor;

	/* Spear specific preferences */
	private BooleanFieldEditor debugFieldEditor;

	@Override
	public void createFieldEditors() {
		modelCheckerFieldEditor = new ComboFieldEditor(PreferenceConstants.PREF_MODEL_CHECKER, "Model Checker",
				MODEL_CHECKERS, getFieldEditorParent());
		addField(modelCheckerFieldEditor);

		remoteUrlFieldEditor = new StringFieldEditor(PreferenceConstants.PREF_REMOTE_URL, "Remote URL",
				getFieldEditorParent());
		addField(remoteUrlFieldEditor);

		solverFieldEditor = new ComboFieldEditor(PreferenceConstants.PREF_SOLVER, "SMT Solver", SOLVERS,
				getFieldEditorParent());
		addField(solverFieldEditor);

		bmcFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING,
				"Use bounded model checking", getFieldEditorParent());
		addField(bmcFieldEditor);

		kInductionFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_K_INDUCTION, "Use k-induction",
				getFieldEditorParent());
		addField(kInductionFieldEditor);

		invGenFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INVARIANT_GENERATION,
				"Use invariant generation", getFieldEditorParent());
		addField(invGenFieldEditor);

		pdrMaxFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_PDR_MAX,
				"Maximum number of PDR instances (0 to disable)", getFieldEditorParent());
		addField(pdrMaxFieldEditor);

		inductCexFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES,
				"Generate inductive counterexamples", getFieldEditorParent());
		addField(inductCexFieldEditor);

		reduceSupportFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_REDUCE_IVC,
				"Reduce support (expensive)", getFieldEditorParent());
		addField(reduceSupportFieldEditor);

		spearFinalLustreFileFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_GENERATE_FINAL_LUSTRE_FILE,
				"Generate final Lustre file", getFieldEditorParent());
		addField(spearFinalLustreFileFieldEditor);
		
		unusedValidationFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_DISABLE_UNUSED_VALIDATIONS,
				"Disable unused variable validations", getFieldEditorParent());
		addField(unusedValidationFieldEditor);

		smoothCexFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES,
				"Generate smooth counterexamples (minimal number of input value changes)", getFieldEditorParent());
		addField(smoothCexFieldEditor);

		intervalGenFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INTERVAL_GENERALIZATION,
				"Generalize counterexamples using interval analysis", getFieldEditorParent());
		addField(intervalGenFieldEditor);

		depthFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_DEPTH,
				"Maximum depth for k-induction", getFieldEditorParent());
		addField(depthFieldEditor);

		timeoutFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_TIMEOUT, "Timeout in seconds",
				getFieldEditorParent());
		addField(timeoutFieldEditor);

		consistencyFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH,
				"Depth of consistency check in steps", getFieldEditorParent());
		addField(consistencyFieldEditor);

		debugFieldEditor = new BooleanButtonFieldEditor(PreferenceConstants.PREF_DEBUG, "Debug mode (record log files)",
				"Open temporary folder", this::openTemporaryFolder, getFieldEditorParent());
		addField(debugFieldEditor);

		Button checkAvailableButton = new Button(getFieldEditorParent(), SWT.PUSH);
		checkAvailableButton.setText("Check if available");
		checkAvailableButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				checkAvailable();
			}
		});
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
			String remoteUrl = remoteUrlFieldEditor.getStringValue();
			KindApi api = PreferencesUtil.getKindApi(selectedModelChecker, remoteUrl);
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
		if (event.getSource().equals(solverFieldEditor)) {
			selectedSolver = (String) event.getNewValue();
		} else if (event.getSource().equals(modelCheckerFieldEditor)) {
			selectedModelChecker = (String) event.getNewValue();
		}
		configureEnabledFieldEditors();
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
		IPreferenceStore prefs = getPreferenceStore();
		selectedSolver = prefs.getDefaultString(PreferenceConstants.PREF_SOLVER);
		selectedModelChecker = prefs.getDefaultString(PreferenceConstants.PREF_MODEL_CHECKER);
		configureEnabledFieldEditors();
	}

	private void configureEnabledFieldEditors() {
		boolean isJKind = selectedModelChecker.equals(PreferenceConstants.MODEL_CHECKER_JKIND);
		boolean isRemote = selectedModelChecker.equals(PreferenceConstants.MODEL_CHECKER_KIND2WEB);
		boolean isYices = selectedSolver.equals(PreferenceConstants.SOLVER_YICES);

		remoteUrlFieldEditor.setEnabled(isRemote, getFieldEditorParent());
		bmcFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		kInductionFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		invGenFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		pdrMaxFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		solverFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		inductCexFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		reduceSupportFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		smoothCexFieldEditor.setEnabled(isJKind && isYices, getFieldEditorParent());
		intervalGenFieldEditor.setEnabled(isJKind, getFieldEditorParent());
		depthFieldEditor.setEnabled(isJKind, getFieldEditorParent());
	}

	@Override
	protected void initialize() {
		super.initialize();
		initializeStateVariables();
		configureEnabledFieldEditors();
	}

	private void initializeStateVariables() {
		IPreferenceStore prefs = getPreferenceStore();
		selectedSolver = prefs.getString(PreferenceConstants.PREF_SOLVER);
		selectedModelChecker = prefs.getString(PreferenceConstants.PREF_MODEL_CHECKER);
	}

	private class NonNegativeIntegerFieldEditor extends IntegerFieldEditor {
		public NonNegativeIntegerFieldEditor(String name, String labelText, Composite parent) {
			super(name, labelText, parent);
			setValidRange(0, Integer.MAX_VALUE);
			setErrorMessage("Field must be a non-negative integer");
		}
	}

	@Override
	public void init(IWorkbench workbench) {
	}
}