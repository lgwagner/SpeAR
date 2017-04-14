package com.rockwellcollins.spear.ui.preferences;

import java.awt.Desktop;
import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.PreferenceStore;
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

	private final String selectedModelChecker = PreferenceConstants.MODEL_CHECKER_JKIND;

	private static final String[][] SOLVERS = 
		   {{ PreferenceConstants.SOLVER_SMTINTERPOL, PreferenceConstants.SOLVER_SMTINTERPOL },
			{ PreferenceConstants.SOLVER_Z3, PreferenceConstants.SOLVER_Z3 },
			{ PreferenceConstants.SOLVER_YICES2, PreferenceConstants.SOLVER_YICES2 },
			{ PreferenceConstants.SOLVER_CVC4, PreferenceConstants.SOLVER_CVC4 }};

	private ComboFieldEditor solverFieldEditor;
	private String selectedSolver;

	private BooleanFieldEditor bmcFieldEditor;
	private BooleanFieldEditor kInductionFieldEditor;
	private BooleanFieldEditor invGenFieldEditor;
	private NonNegativeIntegerFieldEditor pdrMaxFieldEditor;
	private BooleanFieldEditor inductCexFieldEditor;
	private BooleanFieldEditor smoothCexFieldEditor;
	private BooleanFieldEditor intervalGenFieldEditor;
	private BooleanFieldEditor spearUnusedVariableWarningsEditor;
	private BooleanFieldEditor spearFinalLustreFileFieldEditor;
	private BooleanFieldEditor spearRecursiveGraphicalDisplayFieldEditor;
	private BooleanFieldEditor spearEnableIVCDuringEntailment;
	private NonNegativeIntegerFieldEditor depthFieldEditor;
	private NonNegativeIntegerFieldEditor timeoutFieldEditor;
	private NonNegativeIntegerFieldEditor consistencyFieldEditor;

	/* Spear specific preferences */
	private BooleanFieldEditor debugFieldEditor;

	@Override
	public void createFieldEditors() {
		
		/* BEGIN: Solver Group */
		solverFieldEditor = new ComboFieldEditor(PreferenceConstants.PREF_SOLVER, "SMT Solver",SOLVERS,this.getFieldEditorParent());
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
		
		bmcFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING,"Use bounded model checking",this.getFieldEditorParent());
		addField(bmcFieldEditor);

		kInductionFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_K_INDUCTION,"Use k-induction",this.getFieldEditorParent());
		addField(kInductionFieldEditor);

		invGenFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INVARIANT_GENERATION,"Use invariant generation",this.getFieldEditorParent());
		addField(invGenFieldEditor);

		pdrMaxFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_PDR_MAX,"Maximum number of PDR instances (0 to disable)",this.getFieldEditorParent());
		addField(pdrMaxFieldEditor);

		inductCexFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INDUCTIVE_COUNTEREXAMPLES,"Generate inductive counterexamples",this.getFieldEditorParent());
		addField(inductCexFieldEditor);

		smoothCexFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_SMOOTH_COUNTEREXAMPLES,"Generate smooth counterexamples (minimal number of input value changes)",this.getFieldEditorParent());
		addField(smoothCexFieldEditor);

		intervalGenFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INTERVAL_GENERALIZATION,"Generalize counterexamples using interval analysis",this.getFieldEditorParent());
		addField(intervalGenFieldEditor);

		depthFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_DEPTH,"Maximum depth for k-induction",this.getFieldEditorParent());
		addField(depthFieldEditor);

		timeoutFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_TIMEOUT, "Timeout in seconds",this.getFieldEditorParent());
		addField(timeoutFieldEditor);

		debugFieldEditor = new BooleanButtonFieldEditor(PreferenceConstants.PREF_DEBUG, "Debug mode (record log files)","Open temporary folder",this::openTemporaryFolder, this.getFieldEditorParent());
		addField(debugFieldEditor);
		
		/* END: JKind group, BEGIN: SpeAR group */
		
		spearFinalLustreFileFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_SPEAR_PRINT_FINAL_LUSTRE,"Generate final Lustre file",this.getFieldEditorParent());
		addField(spearFinalLustreFileFieldEditor);
		
		spearRecursiveGraphicalDisplayFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_SPEAR_RECURSIVE_GRAPH,"Make graphical display recursive",this.getFieldEditorParent());
		addField(spearRecursiveGraphicalDisplayFieldEditor);
		
		spearEnableIVCDuringEntailment = new BooleanFieldEditor(PreferenceConstants.PREF_SPEAR_ENABLE_IVC_ON_ENTAILMENT,"Enable IVC during Logical Entailment Analysis",this.getFieldEditorParent());
		addField(spearEnableIVCDuringEntailment);
		
		spearUnusedVariableWarningsEditor = new BooleanFieldEditor(PreferenceConstants.PREF_SPEAR_WARN_ON_UNUSED_VARS,"Disable unused variable validations",this.getFieldEditorParent());
		addField(spearUnusedVariableWarningsEditor);
		
		consistencyFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_SPEAR_CONSISTENCY_DEPTH,"Depth of consistency check in steps",this.getFieldEditorParent());
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
		if (event.getSource().equals(solverFieldEditor)) {
			selectedSolver = (String) event.getNewValue();
		} 
		configureEnabledFieldEditors();
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
		PreferenceStore dprefs = Preferences.getInitialPreferences();
		IPreferenceStore prefs = getPreferenceStore();
		for ( String name : dprefs.preferenceNames()) {
		  prefs.setValue(name,dprefs.getString(name));
		}
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
		smoothCexFieldEditor.setEnabled(isJKind && (isYices || isZ3), getFieldEditorParent());
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
		IPreferenceStore prefs = Preferences.getInitialPreferences();
		selectedSolver = prefs.getString(PreferenceConstants.PREF_SOLVER);
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