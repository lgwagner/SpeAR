/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.TraceData#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getTraceData()
 * @model
 * @generated
 */
public interface TraceData extends Data
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' attribute list.
   * @see com.rockwellcollins.spear.SpearPackage#getTraceData_Ids()
   * @model unique="false"
   * @generated
   */
  EList<String> getIds();

} // TraceData
