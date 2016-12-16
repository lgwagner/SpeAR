/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Data;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.RecordTypeDef;
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
 * An implementation of the model object '<em><b>Record Type Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.RecordTypeDefImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.RecordTypeDefImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordTypeDefImpl extends TypeDefImpl implements RecordTypeDef
{
  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList<FieldType> fields;

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
  protected RecordTypeDefImpl()
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
    return SpearPackage.Literals.RECORD_TYPE_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FieldType> getFields()
  {
    if (fields == null)
    {
      fields = new EObjectContainmentEList<FieldType>(FieldType.class, this, SpearPackage.RECORD_TYPE_DEF__FIELDS);
    }
    return fields;
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
      data = new EObjectContainmentEList<Data>(Data.class, this, SpearPackage.RECORD_TYPE_DEF__DATA);
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
      case SpearPackage.RECORD_TYPE_DEF__FIELDS:
        return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
      case SpearPackage.RECORD_TYPE_DEF__DATA:
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
      case SpearPackage.RECORD_TYPE_DEF__FIELDS:
        return getFields();
      case SpearPackage.RECORD_TYPE_DEF__DATA:
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
      case SpearPackage.RECORD_TYPE_DEF__FIELDS:
        getFields().clear();
        getFields().addAll((Collection<? extends FieldType>)newValue);
        return;
      case SpearPackage.RECORD_TYPE_DEF__DATA:
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
      case SpearPackage.RECORD_TYPE_DEF__FIELDS:
        getFields().clear();
        return;
      case SpearPackage.RECORD_TYPE_DEF__DATA:
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
      case SpearPackage.RECORD_TYPE_DEF__FIELDS:
        return fields != null && !fields.isEmpty();
      case SpearPackage.RECORD_TYPE_DEF__DATA:
        return data != null && !data.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RecordTypeDefImpl
