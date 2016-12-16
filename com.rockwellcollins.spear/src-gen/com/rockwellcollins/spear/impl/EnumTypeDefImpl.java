/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Data;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.SpearPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Type Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.EnumTypeDefImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.EnumTypeDefImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumTypeDefImpl extends TypeDefImpl implements EnumTypeDef
{
  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<EnumValue> values;

  /**
   * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getData()
   * @generated
   * @ordered
   */
  protected EList<Data> data;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumTypeDefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SpearPackage.Literals.ENUM_TYPE_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnumValue> getValues()
  {
    if (values == null)
    {
      values = new EObjectContainmentEList<EnumValue>(EnumValue.class, this, SpearPackage.ENUM_TYPE_DEF__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Data> getData()
  {
    if (data == null)
    {
      data = new EObjectContainmentEList<Data>(Data.class, this, SpearPackage.ENUM_TYPE_DEF__DATA);
    }
    return data;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SpearPackage.ENUM_TYPE_DEF__VALUES:
        return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
      case SpearPackage.ENUM_TYPE_DEF__DATA:
        return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SpearPackage.ENUM_TYPE_DEF__VALUES:
        return getValues();
      case SpearPackage.ENUM_TYPE_DEF__DATA:
        return getData();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SpearPackage.ENUM_TYPE_DEF__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends EnumValue>)newValue);
        return;
      case SpearPackage.ENUM_TYPE_DEF__DATA:
        getData().clear();
        getData().addAll((Collection<? extends Data>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SpearPackage.ENUM_TYPE_DEF__VALUES:
        getValues().clear();
        return;
      case SpearPackage.ENUM_TYPE_DEF__DATA:
        getData().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SpearPackage.ENUM_TYPE_DEF__VALUES:
        return values != null && !values.isEmpty();
      case SpearPackage.ENUM_TYPE_DEF__DATA:
        return data != null && !data.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EnumTypeDefImpl
