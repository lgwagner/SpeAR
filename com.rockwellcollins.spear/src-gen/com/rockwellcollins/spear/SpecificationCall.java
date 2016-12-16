/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.SpecificationCall#getSpec <em>Spec</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.SpecificationCall#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getSpecificationCall()
 * @model
 * @generated
 */
public interface SpecificationCall extends Expr
{
  /**
   * Returns the value of the '<em><b>Spec</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Spec</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Spec</em>' reference.
   * @see #setSpec(Specification)
   * @see com.rockwellcollins.spear.SpearPackage#getSpecificationCall_Spec()
   * @model
   * @generated
   */
  Specification getSpec();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.SpecificationCall#getSpec <em>Spec</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Spec</em>' reference.
   * @see #getSpec()
   * @generated
   */
  void setSpec(Specification value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getSpecificationCall_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getArgs();

} // SpecificationCall
