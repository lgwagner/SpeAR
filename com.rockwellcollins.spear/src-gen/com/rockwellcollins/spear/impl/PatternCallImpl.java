/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.SpearPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternCallImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternCallImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternCallImpl extends ExprImpl implements PatternCall
{
  /**
   * The cached value of the '{@link #getPattern() <em>Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected Pattern pattern;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expr> args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternCallImpl()
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
    return SpearPackage.Literals.PATTERN_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern getPattern()
  {
    if (pattern != null && pattern.eIsProxy())
    {
      InternalEObject oldPattern = (InternalEObject)pattern;
      pattern = (Pattern)eResolveProxy(oldPattern);
      if (pattern != oldPattern)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpearPackage.PATTERN_CALL__PATTERN, oldPattern, pattern));
      }
    }
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern basicGetPattern()
  {
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPattern(Pattern newPattern)
  {
    Pattern oldPattern = pattern;
    pattern = newPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.PATTERN_CALL__PATTERN, oldPattern, pattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expr> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expr>(Expr.class, this, SpearPackage.PATTERN_CALL__ARGS);
    }
    return args;
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
      case SpearPackage.PATTERN_CALL__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case SpearPackage.PATTERN_CALL__PATTERN:
        if (resolve) return getPattern();
        return basicGetPattern();
      case SpearPackage.PATTERN_CALL__ARGS:
        return getArgs();
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
      case SpearPackage.PATTERN_CALL__PATTERN:
        setPattern((Pattern)newValue);
        return;
      case SpearPackage.PATTERN_CALL__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expr>)newValue);
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
      case SpearPackage.PATTERN_CALL__PATTERN:
        setPattern((Pattern)null);
        return;
      case SpearPackage.PATTERN_CALL__ARGS:
        getArgs().clear();
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
      case SpearPackage.PATTERN_CALL__PATTERN:
        return pattern != null;
      case SpearPackage.PATTERN_CALL__ARGS:
        return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PatternCallImpl
