/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.DerivedUnit#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getDerivedUnit()
 * @model
 * @generated
 */
public interface DerivedUnit extends UnitDef
{
  /**
   * Returns the value of the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' containment reference.
   * @see #setUnit(UnitExpr)
   * @see com.rockwellcollins.spear.SpearPackage#getDerivedUnit_Unit()
   * @model containment="true"
   * @generated
   */
  UnitExpr getUnit();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.DerivedUnit#getUnit <em>Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' containment reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitExpr value);

} // DerivedUnit
