/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>After Until Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.AfterUntilExpr#getAfter <em>After</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.AfterUntilExpr#getUntil <em>Until</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getAfterUntilExpr()
 * @model
 * @generated
 */
public interface AfterUntilExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>After</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>After</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>After</em>' containment reference.
   * @see #setAfter(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getAfterUntilExpr_After()
   * @model containment="true"
   * @generated
   */
  Expr getAfter();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.AfterUntilExpr#getAfter <em>After</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>After</em>' containment reference.
   * @see #getAfter()
   * @generated
   */
  void setAfter(Expr value);

  /**
   * Returns the value of the '<em><b>Until</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until</em>' containment reference.
   * @see #setUntil(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getAfterUntilExpr_Until()
   * @model containment="true"
   * @generated
   */
  Expr getUntil();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.AfterUntilExpr#getUntil <em>Until</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until</em>' containment reference.
   * @see #getUntil()
   * @generated
   */
  void setUntil(Expr value);

} // AfterUntilExpr
