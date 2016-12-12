/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.EnumTypeDef#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getEnumTypeDef()
 * @model
 * @generated
 */
public interface EnumTypeDef extends TypeDef
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.EnumValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getEnumTypeDef_Values()
   * @model containment="true"
   * @generated
   */
  EList<EnumValue> getValues();

} // EnumTypeDef
