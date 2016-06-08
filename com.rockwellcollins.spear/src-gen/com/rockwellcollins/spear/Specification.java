/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.Specification#getUnits <em>Units</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Specification#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Specification#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Specification#getState <em>State</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Specification#getMacros <em>Macros</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Specification#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Specification#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Specification#getBehaviors <em>Behaviors</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends File
{
  /**
   * Returns the value of the '<em><b>Units</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.UnitDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Units</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_Units()
   * @model containment="true"
   * @generated
   */
  EList<UnitDef> getUnits();

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getInputs();

  /**
   * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outputs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_Outputs()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getOutputs();

  /**
   * Returns the value of the '<em><b>State</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_State()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getState();

  /**
   * Returns the value of the '<em><b>Macros</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Macro}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macros</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macros</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_Macros()
   * @model containment="true"
   * @generated
   */
  EList<Macro> getMacros();

  /**
   * Returns the value of the '<em><b>Assumptions</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Constraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assumptions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assumptions</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_Assumptions()
   * @model containment="true"
   * @generated
   */
  EList<Constraint> getAssumptions();

  /**
   * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Constraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_Requirements()
   * @model containment="true"
   * @generated
   */
  EList<Constraint> getRequirements();

  /**
   * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Constraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behaviors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behaviors</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecification_Behaviors()
   * @model containment="true"
   * @generated
   */
  EList<Constraint> getBehaviors();

} // Specification
