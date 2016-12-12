/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.FormalConstraint#getExpr <em>Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.FormalConstraint#getDescriptor <em>Descriptor</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getFormalConstraint()
 * @model
 * @generated
 */
public interface FormalConstraint extends Constraint
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expr)
   * @see com.rockwellcollins.spear.SpearPackage#getFormalConstraint_Expr()
   * @model containment="true"
   * @generated
   */
  Expr getExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.FormalConstraint#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expr value);

  /**
   * Returns the value of the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Descriptor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Descriptor</em>' attribute.
   * @see #setDescriptor(String)
   * @see com.rockwellcollins.spear.SpearPackage#getFormalConstraint_Descriptor()
   * @model
   * @generated
   */
  String getDescriptor();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.FormalConstraint#getDescriptor <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Descriptor</em>' attribute.
   * @see #getDescriptor()
   * @generated
   */
  void setDescriptor(String value);

} // FormalConstraint
