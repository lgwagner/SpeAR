/**
 */
package com.rockwellcollins.spear;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Array Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.ConcreteArrayTypeDef#getBase <em>Base</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.ConcreteArrayTypeDef#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getConcreteArrayTypeDef()
 * @model
 * @generated
 */
public interface ConcreteArrayTypeDef extends TypeDef
{
  /**
   * Returns the value of the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference.
   * @see #setBase(Type)
   * @see com.rockwellcollins.spear.SpearPackage#getConcreteArrayTypeDef_Base()
   * @model containment="true"
   * @generated
   */
  Type getBase();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.ConcreteArrayTypeDef#getBase <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' containment reference.
   * @see #getBase()
   * @generated
   */
  void setBase(Type value);

  /**
   * Returns the value of the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' attribute.
   * @see #setSize(int)
   * @see com.rockwellcollins.spear.SpearPackage#getConcreteArrayTypeDef_Size()
   * @model
   * @generated
   */
  int getSize();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.ConcreteArrayTypeDef#getSize <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' attribute.
   * @see #getSize()
   * @generated
   */
  void setSize(int value);

} // ConcreteArrayTypeDef
