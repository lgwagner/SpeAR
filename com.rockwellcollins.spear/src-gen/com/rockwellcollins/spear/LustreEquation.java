/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lustre Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.LustreEquation#getIds <em>Ids</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.LustreEquation#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getLustreEquation()
 * @model
 * @generated
 */
public interface LustreEquation extends EObject
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getLustreEquation_Ids()
   * @model
   * @generated
   */
  EList<Variable> getIds();

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getLustreEquation_Rhs()
   * @model containment="true"
   * @generated
   */
  Expr getRhs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.LustreEquation#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Expr value);

} // LustreEquation
