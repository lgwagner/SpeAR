/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Access Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.ArrayAccessExpr#getArray <em>Array</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.ArrayAccessExpr#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getArrayAccessExpr()
 * @model
 * @generated
 */
public interface ArrayAccessExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array</em>' containment reference.
   * @see #setArray(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getArrayAccessExpr_Array()
   * @model containment="true"
   * @generated
   */
  Expr getArray();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.ArrayAccessExpr#getArray <em>Array</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array</em>' containment reference.
   * @see #getArray()
   * @generated
   */
  void setArray(Expr value);

  /**
   * Returns the value of the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' containment reference.
   * @see #setIndex(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getArrayAccessExpr_Index()
   * @model containment="true"
   * @generated
   */
  Expr getIndex();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.ArrayAccessExpr#getIndex <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' containment reference.
   * @see #getIndex()
   * @generated
   */
  void setIndex(Expr value);

} // ArrayAccessExpr
