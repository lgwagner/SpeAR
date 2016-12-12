/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.SpearPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lustre Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.LustreAssertionImpl#getAssertionExpr <em>Assertion Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LustreAssertionImpl extends MinimalEObjectImpl.Container implements LustreAssertion
{
  /**
   * The cached value of the '{@link #getAssertionExpr() <em>Assertion Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssertionExpr()
   * @generated
   * @ordered
   */
  protected Expr assertionExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LustreAssertionImpl()
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
    return SpearPackage.Literals.LUSTRE_ASSERTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getAssertionExpr()
  {
    return assertionExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssertionExpr(Expr newAssertionExpr, NotificationChain msgs)
  {
    Expr oldAssertionExpr = assertionExpr;
    assertionExpr = newAssertionExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR, oldAssertionExpr, newAssertionExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssertionExpr(Expr newAssertionExpr)
  {
    if (newAssertionExpr != assertionExpr)
    {
      NotificationChain msgs = null;
      if (assertionExpr != null)
        msgs = ((InternalEObject)assertionExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR, null, msgs);
      if (newAssertionExpr != null)
        msgs = ((InternalEObject)newAssertionExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR, null, msgs);
      msgs = basicSetAssertionExpr(newAssertionExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR, newAssertionExpr, newAssertionExpr));
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
      case SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR:
        return basicSetAssertionExpr(null, msgs);
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
      case SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR:
        return getAssertionExpr();
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
      case SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR:
        setAssertionExpr((Expr)newValue);
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
      case SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR:
        setAssertionExpr((Expr)null);
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
      case SpearPackage.LUSTRE_ASSERTION__ASSERTION_EXPR:
        return assertionExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //LustreAssertionImpl
