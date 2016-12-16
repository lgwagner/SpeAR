/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.NamedUnitExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.UnitDef;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Unit Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.NamedUnitExprImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedUnitExprImpl extends UnitExprImpl implements NamedUnitExpr
{
  /**
   * The cached value of the '{@link #getUnit() <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected UnitDef unit;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedUnitExprImpl()
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
    return SpearPackage.Literals.NAMED_UNIT_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitDef getUnit()
  {
    if (unit != null && unit.eIsProxy())
    {
      InternalEObject oldUnit = (InternalEObject)unit;
      unit = (UnitDef)eResolveProxy(oldUnit);
      if (unit != oldUnit)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpearPackage.NAMED_UNIT_EXPR__UNIT, oldUnit, unit));
      }
    }
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitDef basicGetUnit()
  {
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(UnitDef newUnit)
  {
    UnitDef oldUnit = unit;
    unit = newUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.NAMED_UNIT_EXPR__UNIT, oldUnit, unit));
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
      case SpearPackage.NAMED_UNIT_EXPR__UNIT:
        if (resolve) return getUnit();
        return basicGetUnit();
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
      case SpearPackage.NAMED_UNIT_EXPR__UNIT:
        setUnit((UnitDef)newValue);
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
      case SpearPackage.NAMED_UNIT_EXPR__UNIT:
        setUnit((UnitDef)null);
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
      case SpearPackage.NAMED_UNIT_EXPR__UNIT:
        return unit != null;
    }
    return super.eIsSet(featureID);
  }

} //NamedUnitExprImpl
