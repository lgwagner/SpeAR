/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.File#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.File#getImports <em>Imports</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.File#getTypedefs <em>Typedefs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.File#getConstants <em>Constants</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.File#getPatterns <em>Patterns</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.rockwellcollins.spear.SpearPackage#getFile_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.File#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getFile_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Typedefs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.TypeDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Typedefs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typedefs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getFile_Typedefs()
   * @model containment="true"
   * @generated
   */
  EList<TypeDef> getTypedefs();

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Constant}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getFile_Constants()
   * @model containment="true"
   * @generated
   */
  EList<Constant> getConstants();

  /**
   * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Pattern}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Patterns</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Patterns</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getFile_Patterns()
   * @model containment="true"
   * @generated
   */
  EList<Pattern> getPatterns();

} // File
