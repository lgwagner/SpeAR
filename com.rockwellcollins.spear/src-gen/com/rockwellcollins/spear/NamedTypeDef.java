/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.NamedTypeDef#getType <em>Type</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.NamedTypeDef#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getNamedTypeDef()
 * @model
 * @generated
 */
public interface NamedTypeDef extends TypeDef
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see com.rockwellcollins.spear.SpearPackage#getNamedTypeDef_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.NamedTypeDef#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

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
   * @see com.rockwellcollins.spear.SpearPackage#getNamedTypeDef_Unit()
   * @model
   * @generated
   */
  UnitDef getUnit();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.NamedTypeDef#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitDef value);

} // NamedTypeDef
