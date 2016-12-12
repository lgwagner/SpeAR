/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.UnitDef;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.DefinitionsImpl#getUnitdefs <em>Unitdefs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefinitionsImpl extends FileImpl implements Definitions
{
  /**
   * The cached value of the '{@link #getUnitdefs() <em>Unitdefs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnitdefs()
   * @generated
   * @ordered
   */
  protected EList<UnitDef> unitdefs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefinitionsImpl()
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
    return SpearPackage.Literals.DEFINITIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UnitDef> getUnitdefs()
  {
    if (unitdefs == null)
    {
      unitdefs = new EObjectContainmentEList<UnitDef>(UnitDef.class, this, SpearPackage.DEFINITIONS__UNITDEFS);
    }
    return unitdefs;
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
      case SpearPackage.DEFINITIONS__UNITDEFS:
        return ((InternalEList<?>)getUnitdefs()).basicRemove(otherEnd, msgs);
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
      case SpearPackage.DEFINITIONS__UNITDEFS:
        return getUnitdefs();
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
      case SpearPackage.DEFINITIONS__UNITDEFS:
        getUnitdefs().clear();
        getUnitdefs().addAll((Collection<? extends UnitDef>)newValue);
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
      case SpearPackage.DEFINITIONS__UNITDEFS:
        getUnitdefs().clear();
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
      case SpearPackage.DEFINITIONS__UNITDEFS:
        return unitdefs != null && !unitdefs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DefinitionsImpl
