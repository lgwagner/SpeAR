/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Previous Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.PreviousExpr#getVar <em>Var</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.PreviousExpr#getInit <em>Init</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getPreviousExpr()
 * @model
 * @generated
 */
public interface PreviousExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference.
   * @see #setVar(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getPreviousExpr_Var()
   * @model containment="true"
   * @generated
   */
  Expr getVar();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.PreviousExpr#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(Expr value);

  /**
   * Returns the value of the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getPreviousExpr_Init()
   * @model containment="true"
   * @generated
   */
  Expr getInit();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.PreviousExpr#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(Expr value);

} // PreviousExpr
