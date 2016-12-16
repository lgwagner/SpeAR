/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Unit Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.NamedUnitExpr#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getNamedUnitExpr()
 * @model
 * @generated
 */
public interface NamedUnitExpr extends UnitExpr
{
  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitDef)
   * @see com.rockwellcollins.spear.SpearPackage#getNamedUnitExpr_Unit()
   * @model
   * @generated
   */
  UnitDef getUnit();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.NamedUnitExpr#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitDef value);

} // NamedUnitExpr
