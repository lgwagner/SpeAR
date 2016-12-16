/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.DerivedUnit;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.UnitExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.DerivedUnitImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DerivedUnitImpl extends UnitDefImpl implements DerivedUnit
{
  /**
   * The cached value of the '{@link #getUnit() <em>Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected UnitExpr unit;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DerivedUnitImpl()
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
    return SpearPackage.Literals.DERIVED_UNIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpr getUnit()
  {
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnit(UnitExpr newUnit, NotificationChain msgs)
  {
    UnitExpr oldUnit = unit;
    unit = newUnit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.DERIVED_UNIT__UNIT, oldUnit, newUnit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(UnitExpr newUnit)
  {
    if (newUnit != unit)
    {
      NotificationChain msgs = null;
      if (unit != null)
        msgs = ((InternalEObject)unit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.DERIVED_UNIT__UNIT, null, msgs);
      if (newUnit != null)
        msgs = ((InternalEObject)newUnit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.DERIVED_UNIT__UNIT, null, msgs);
      msgs = basicSetUnit(newUnit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.DERIVED_UNIT__UNIT, newUnit, newUnit));
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
      case SpearPackage.DERIVED_UNIT__UNIT:
        return basicSetUnit(null, msgs);
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
      case SpearPackage.DERIVED_UNIT__UNIT:
        return getUnit();
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
      case SpearPackage.DERIVED_UNIT__UNIT:
        setUnit((UnitExpr)newValue);
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
      case SpearPackage.DERIVED_UNIT__UNIT:
        setUnit((UnitExpr)null);
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
      case SpearPackage.DERIVED_UNIT__UNIT:
        return unit != null;
    }
    return super.eIsSet(featureID);
  }

} //DerivedUnitImpl
