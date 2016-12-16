/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Update Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.ArrayUpdateExpr#getAccess <em>Access</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.ArrayUpdateExpr#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getArrayUpdateExpr()
 * @model
 * @generated
 */
public interface ArrayUpdateExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Access</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access</em>' containment reference.
   * @see #setAccess(ArrayAccessExpr)
   * @see com.rockwellcollins.spear.SpearPackage#getArrayUpdateExpr_Access()
   * @model containment="true"
   * @generated
   */
  ArrayAccessExpr getAccess();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.ArrayUpdateExpr#getAccess <em>Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access</em>' containment reference.
   * @see #getAccess()
   * @generated
   */
  void setAccess(ArrayAccessExpr value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getArrayUpdateExpr_Value()
   * @model containment="true"
   * @generated
   */
  Expr getValue();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.ArrayUpdateExpr#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expr value);

} // ArrayUpdateExpr
