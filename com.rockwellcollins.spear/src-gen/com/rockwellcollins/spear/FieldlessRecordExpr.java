/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fieldless Record Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.FieldlessRecordExpr#getType <em>Type</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.FieldlessRecordExpr#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getFieldlessRecordExpr()
 * @model
 * @generated
 */
public interface FieldlessRecordExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(RecordTypeDef)
   * @see com.rockwellcollins.spear.SpearPackage#getFieldlessRecordExpr_Type()
   * @model
   * @generated
   */
  RecordTypeDef getType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.FieldlessRecordExpr#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(RecordTypeDef value);

  /**
   * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exprs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exprs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getFieldlessRecordExpr_Exprs()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getExprs();

} // FieldlessRecordExpr
