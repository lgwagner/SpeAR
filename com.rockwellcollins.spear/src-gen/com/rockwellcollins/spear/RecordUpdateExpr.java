/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Update Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.RecordUpdateExpr#getRecord <em>Record</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.RecordUpdateExpr#getField <em>Field</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.RecordUpdateExpr#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getRecordUpdateExpr()
 * @model
 * @generated
 */
public interface RecordUpdateExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record</em>' containment reference.
   * @see #setRecord(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getRecordUpdateExpr_Record()
   * @model containment="true"
   * @generated
   */
  Expr getRecord();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.RecordUpdateExpr#getRecord <em>Record</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record</em>' containment reference.
   * @see #getRecord()
   * @generated
   */
  void setRecord(Expr value);

  /**
   * Returns the value of the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' reference.
   * @see #setField(FieldType)
   * @see com.rockwellcollins.spear.SpearPackage#getRecordUpdateExpr_Field()
   * @model
   * @generated
   */
  FieldType getField();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.RecordUpdateExpr#getField <em>Field</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' reference.
   * @see #getField()
   * @generated
   */
  void setField(FieldType value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getRecordUpdateExpr_Value()
   * @model containment="true"
   * @generated
   */
  Expr getValue();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.RecordUpdateExpr#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expr value);

} // RecordUpdateExpr
