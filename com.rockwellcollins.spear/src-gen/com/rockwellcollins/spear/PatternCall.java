/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.PatternCall#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.PatternCall#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getPatternCall()
 * @model
 * @generated
 */
public interface PatternCall extends Expr
{
  /**
   * Returns the value of the '<em><b>Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' reference.
   * @see #setPattern(Pattern)
   * @see com.rockwellcollins.spear.SpearPackage#getPatternCall_Pattern()
   * @model
   * @generated
   */
  Pattern getPattern();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.PatternCall#getPattern <em>Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' reference.
   * @see #getPattern()
   * @generated
   */
  void setPattern(Pattern value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPatternCall_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getArgs();

} // PatternCall
