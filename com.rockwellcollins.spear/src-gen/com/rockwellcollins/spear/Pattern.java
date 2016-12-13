/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getLocals <em>Locals</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getEquations <em>Equations</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.Pattern#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Inputs()
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
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Outputs()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getOutputs();

  /**
   * Returns the value of the '<em><b>Locals</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Locals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Locals</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Locals()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getLocals();

  /**
   * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.LustreEquation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equations</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Equations()
   * @model containment="true"
   * @generated
   */
  EList<LustreEquation> getEquations();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.LustreProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Properties()
   * @model containment="true"
   * @generated
   */
  EList<LustreProperty> getProperties();

  /**
   * Returns the value of the '<em><b>Assertions</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.LustreAssertion}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assertions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertions</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Assertions()
   * @model containment="true"
   * @generated
   */
  EList<LustreAssertion> getAssertions();

  /**
   * Returns the value of the '<em><b>Data</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Data}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Data()
   * @model containment="true"
   * @generated
   */
  EList<Data> getData();

} // Pattern
