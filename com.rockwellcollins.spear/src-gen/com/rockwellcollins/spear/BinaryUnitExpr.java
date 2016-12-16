/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Unit Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.BinaryUnitExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.BinaryUnitExpr#getOp <em>Op</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.BinaryUnitExpr#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getBinaryUnitExpr()
 * @model
 * @generated
 */
public interface BinaryUnitExpr extends UnitExpr
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(UnitExpr)
   * @see com.rockwellcollins.spear.SpearPackage#getBinaryUnitExpr_Left()
   * @model containment="true"
   * @generated
   */
  UnitExpr getLeft();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.BinaryUnitExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(UnitExpr value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see com.rockwellcollins.spear.SpearPackage#getBinaryUnitExpr_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.BinaryUnitExpr#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(UnitExpr)
   * @see com.rockwellcollins.spear.SpearPackage#getBinaryUnitExpr_Right()
   * @model containment="true"
   * @generated
   */
  UnitExpr getRight();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.BinaryUnitExpr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(UnitExpr value);

} // BinaryUnitExpr
