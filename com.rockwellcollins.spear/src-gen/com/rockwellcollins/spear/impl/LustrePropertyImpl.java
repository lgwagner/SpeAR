/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Variable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lustre Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.LustrePropertyImpl#getPropertyId <em>Property Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LustrePropertyImpl extends MinimalEObjectImpl.Container implements LustreProperty
{
  /**
   * The cached value of the '{@link #getPropertyId() <em>Property Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyId()
   * @generated
   * @ordered
   */
  protected Variable propertyId;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LustrePropertyImpl()
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
    return SpearPackage.Literals.LUSTRE_PROPERTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable getPropertyId()
  {
    if (propertyId != null && propertyId.eIsProxy())
    {
      InternalEObject oldPropertyId = (InternalEObject)propertyId;
      propertyId = (Variable)eResolveProxy(oldPropertyId);
      if (propertyId != oldPropertyId)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpearPackage.LUSTRE_PROPERTY__PROPERTY_ID, oldPropertyId, propertyId));
      }
    }
    return propertyId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable basicGetPropertyId()
  {
    return propertyId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPropertyId(Variable newPropertyId)
  {
    Variable oldPropertyId = propertyId;
    propertyId = newPropertyId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.LUSTRE_PROPERTY__PROPERTY_ID, oldPropertyId, propertyId));
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
      case SpearPackage.LUSTRE_PROPERTY__PROPERTY_ID:
        if (resolve) return getPropertyId();
        return basicGetPropertyId();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SpearPackage.LUSTRE_PROPERTY__PROPERTY_ID:
        setPropertyId((Variable)newValue);
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
      case SpearPackage.LUSTRE_PROPERTY__PROPERTY_ID:
        setPropertyId((Variable)null);
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
      case SpearPackage.LUSTRE_PROPERTY__PROPERTY_ID:
        return propertyId != null;
    }
    return super.eIsSet(featureID);
  }

} //LustrePropertyImpl
