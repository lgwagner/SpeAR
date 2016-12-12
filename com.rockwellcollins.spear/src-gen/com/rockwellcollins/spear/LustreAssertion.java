/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lustre Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.LustreAssertion#getAssertionExpr <em>Assertion Expr</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getLustreAssertion()
 * @model
 * @generated
 */
public interface LustreAssertion extends EObject
{
  /**
   * Returns the value of the '<em><b>Assertion Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assertion Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertion Expr</em>' containment reference.
   * @see #setAssertionExpr(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getLustreAssertion_AssertionExpr()
   * @model containment="true"
   * @generated
   */
  Expr getAssertionExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.LustreAssertion#getAssertionExpr <em>Assertion Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assertion Expr</em>' containment reference.
   * @see #getAssertionExpr()
   * @generated
   */
  void setAssertionExpr(Expr value);

} // LustreAssertion
