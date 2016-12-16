/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple Id Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.MultipleIdExpr#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getMultipleIdExpr()
 * @model
 * @generated
 */
public interface MultipleIdExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.IdRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getMultipleIdExpr_Ids()
   * @model
   * @generated
   */
  EList<IdRef> getIds();

} // MultipleIdExpr
