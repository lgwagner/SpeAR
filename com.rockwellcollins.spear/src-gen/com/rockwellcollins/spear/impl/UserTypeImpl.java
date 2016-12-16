/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UserType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.UserTypeImpl#getDef <em>Def</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserTypeImpl extends TypeImpl implements UserType
{
  /**
   * The cached value of the '{@link #getDef() <em>Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDef()
   * @generated
   * @ordered
   */
  protected TypeDef def;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UserTypeImpl()
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
    return SpearPackage.Literals.USER_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDef getDef()
  {
    if (def != null && def.eIsProxy())
    {
      InternalEObject oldDef = (InternalEObject)def;
      def = (TypeDef)eResolveProxy(oldDef);
      if (def != oldDef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpearPackage.USER_TYPE__DEF, oldDef, def));
      }
    }
    return def;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDef basicGetDef()
  {
    return def;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDef(TypeDef newDef)
  {
    TypeDef oldDef = def;
    def = newDef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.USER_TYPE__DEF, oldDef, def));
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
      case SpearPackage.USER_TYPE__DEF:
        if (resolve) return getDef();
        return basicGetDef();
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
      case SpearPackage.USER_TYPE__DEF:
        setDef((TypeDef)newValue);
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
      case SpearPackage.USER_TYPE__DEF:
        setDef((TypeDef)null);
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
      case SpearPackage.USER_TYPE__DEF:
        return def != null;
    }
    return super.eIsSet(featureID);
  }

} //UserTypeImpl
