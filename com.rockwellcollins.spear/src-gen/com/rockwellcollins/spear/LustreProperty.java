/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lustre Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.LustreProperty#getPropertyId <em>Property Id</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getLustreProperty()
 * @model
 * @generated
 */
public interface LustreProperty extends EObject
{
  /**
   * Returns the value of the '<em><b>Property Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Id</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Id</em>' reference.
   * @see #setPropertyId(Variable)
   * @see com.rockwellcollins.spear.SpearPackage#getLustreProperty_PropertyId()
   * @model
   * @generated
   */
  Variable getPropertyId();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.LustreProperty#getPropertyId <em>Property Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Id</em>' reference.
   * @see #getPropertyId()
   * @generated
   */
  void setPropertyId(Variable value);

} // LustreProperty
