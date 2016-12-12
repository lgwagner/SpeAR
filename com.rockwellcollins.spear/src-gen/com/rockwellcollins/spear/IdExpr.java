/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.IdExpr#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getIdExpr()
 * @model
 * @generated
 */
public interface IdExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' reference.
   * @see #setId(IdRef)
   * @see com.rockwellcollins.spear.SpearPackage#getIdExpr_Id()
   * @model
   * @generated
   */
  IdRef getId();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.IdExpr#getId <em>Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' reference.
   * @see #getId()
   * @generated
   */
  void setId(IdRef value);

} // IdExpr
