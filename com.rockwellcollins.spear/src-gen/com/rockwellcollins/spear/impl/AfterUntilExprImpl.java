/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.SpearPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>After Until Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.AfterUntilExprImpl#getAfter <em>After</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.AfterUntilExprImpl#getUntil <em>Until</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AfterUntilExprImpl extends ExprImpl implements AfterUntilExpr
{
  /**
   * The cached value of the '{@link #getAfter() <em>After</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfter()
   * @generated
   * @ordered
   */
  protected Expr after;

  /**
   * The cached value of the '{@link #getUntil() <em>Until</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUntil()
   * @generated
   * @ordered
   */
  protected Expr until;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AfterUntilExprImpl()
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
    return SpearPackage.Literals.AFTER_UNTIL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getAfter()
  {
    return after;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAfter(Expr newAfter, NotificationChain msgs)
  {
    Expr oldAfter = after;
    after = newAfter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.AFTER_UNTIL_EXPR__AFTER, oldAfter, newAfter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAfter(Expr newAfter)
  {
    if (newAfter != after)
    {
      NotificationChain msgs = null;
      if (after != null)
        msgs = ((InternalEObject)after).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.AFTER_UNTIL_EXPR__AFTER, null, msgs);
      if (newAfter != null)
        msgs = ((InternalEObject)newAfter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.AFTER_UNTIL_EXPR__AFTER, null, msgs);
      msgs = basicSetAfter(newAfter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.AFTER_UNTIL_EXPR__AFTER, newAfter, newAfter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getUntil()
  {
    return until;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUntil(Expr newUntil, NotificationChain msgs)
  {
    Expr oldUntil = until;
    until = newUntil;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.AFTER_UNTIL_EXPR__UNTIL, oldUntil, newUntil);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUntil(Expr newUntil)
  {
    if (newUntil != until)
    {
      NotificationChain msgs = null;
      if (until != null)
        msgs = ((InternalEObject)until).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.AFTER_UNTIL_EXPR__UNTIL, null, msgs);
      if (newUntil != null)
        msgs = ((InternalEObject)newUntil).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.AFTER_UNTIL_EXPR__UNTIL, null, msgs);
      msgs = basicSetUntil(newUntil, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.AFTER_UNTIL_EXPR__UNTIL, newUntil, newUntil));
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
      case SpearPackage.AFTER_UNTIL_EXPR__AFTER:
        return basicSetAfter(null, msgs);
      case SpearPackage.AFTER_UNTIL_EXPR__UNTIL:
        return basicSetUntil(null, msgs);
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
      case SpearPackage.AFTER_UNTIL_EXPR__AFTER:
        return getAfter();
      case SpearPackage.AFTER_UNTIL_EXPR__UNTIL:
        return getUntil();
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
      case SpearPackage.AFTER_UNTIL_EXPR__AFTER:
        setAfter((Expr)newValue);
        return;
      case SpearPackage.AFTER_UNTIL_EXPR__UNTIL:
        setUntil((Expr)newValue);
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
      case SpearPackage.AFTER_UNTIL_EXPR__AFTER:
        setAfter((Expr)null);
        return;
      case SpearPackage.AFTER_UNTIL_EXPR__UNTIL:
        setUntil((Expr)null);
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
      case SpearPackage.AFTER_UNTIL_EXPR__AFTER:
        return after != null;
      case SpearPackage.AFTER_UNTIL_EXPR__UNTIL:
        return until != null;
    }
    return super.eIsSet(featureID);
  }

} //AfterUntilExprImpl
