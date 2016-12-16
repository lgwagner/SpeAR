/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.SpearPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Update Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.ArrayUpdateExprImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.ArrayUpdateExprImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayUpdateExprImpl extends ExprImpl implements ArrayUpdateExpr
{
  /**
   * The cached value of the '{@link #getAccess() <em>Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccess()
   * @generated
   * @ordered
   */
  protected ArrayAccessExpr access;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Expr value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrayUpdateExprImpl()
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
    return SpearPackage.Literals.ARRAY_UPDATE_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayAccessExpr getAccess()
  {
    return access;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccess(ArrayAccessExpr newAccess, NotificationChain msgs)
  {
    ArrayAccessExpr oldAccess = access;
    access = newAccess;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_UPDATE_EXPR__ACCESS, oldAccess, newAccess);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccess(ArrayAccessExpr newAccess)
  {
    if (newAccess != access)
    {
      NotificationChain msgs = null;
      if (access != null)
        msgs = ((InternalEObject)access).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_UPDATE_EXPR__ACCESS, null, msgs);
      if (newAccess != null)
        msgs = ((InternalEObject)newAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_UPDATE_EXPR__ACCESS, null, msgs);
      msgs = basicSetAccess(newAccess, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_UPDATE_EXPR__ACCESS, newAccess, newAccess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Expr newValue, NotificationChain msgs)
  {
    Expr oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_UPDATE_EXPR__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Expr newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_UPDATE_EXPR__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_UPDATE_EXPR__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_UPDATE_EXPR__VALUE, newValue, newValue));
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
      case SpearPackage.ARRAY_UPDATE_EXPR__ACCESS:
        return basicSetAccess(null, msgs);
      case SpearPackage.ARRAY_UPDATE_EXPR__VALUE:
        return basicSetValue(null, msgs);
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
      case SpearPackage.ARRAY_UPDATE_EXPR__ACCESS:
        return getAccess();
      case SpearPackage.ARRAY_UPDATE_EXPR__VALUE:
        return getValue();
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
      case SpearPackage.ARRAY_UPDATE_EXPR__ACCESS:
        setAccess((ArrayAccessExpr)newValue);
        return;
      case SpearPackage.ARRAY_UPDATE_EXPR__VALUE:
        setValue((Expr)newValue);
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
      case SpearPackage.ARRAY_UPDATE_EXPR__ACCESS:
        setAccess((ArrayAccessExpr)null);
        return;
      case SpearPackage.ARRAY_UPDATE_EXPR__VALUE:
        setValue((Expr)null);
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
      case SpearPackage.ARRAY_UPDATE_EXPR__ACCESS:
        return access != null;
      case SpearPackage.ARRAY_UPDATE_EXPR__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //ArrayUpdateExprImpl
