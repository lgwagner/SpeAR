/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.SpearPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Access Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.ArrayAccessExprImpl#getArray <em>Array</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.ArrayAccessExprImpl#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayAccessExprImpl extends ExprImpl implements ArrayAccessExpr
{
  /**
   * The cached value of the '{@link #getArray() <em>Array</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArray()
   * @generated
   * @ordered
   */
  protected Expr array;

  /**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected Expr index;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrayAccessExprImpl()
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
    return SpearPackage.Literals.ARRAY_ACCESS_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getArray()
  {
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArray(Expr newArray, NotificationChain msgs)
  {
    Expr oldArray = array;
    array = newArray;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_ACCESS_EXPR__ARRAY, oldArray, newArray);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArray(Expr newArray)
  {
    if (newArray != array)
    {
      NotificationChain msgs = null;
      if (array != null)
        msgs = ((InternalEObject)array).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_ACCESS_EXPR__ARRAY, null, msgs);
      if (newArray != null)
        msgs = ((InternalEObject)newArray).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_ACCESS_EXPR__ARRAY, null, msgs);
      msgs = basicSetArray(newArray, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_ACCESS_EXPR__ARRAY, newArray, newArray));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getIndex()
  {
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndex(Expr newIndex, NotificationChain msgs)
  {
    Expr oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_ACCESS_EXPR__INDEX, oldIndex, newIndex);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex(Expr newIndex)
  {
    if (newIndex != index)
    {
      NotificationChain msgs = null;
      if (index != null)
        msgs = ((InternalEObject)index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_ACCESS_EXPR__INDEX, null, msgs);
      if (newIndex != null)
        msgs = ((InternalEObject)newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpearPackage.ARRAY_ACCESS_EXPR__INDEX, null, msgs);
      msgs = basicSetIndex(newIndex, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.ARRAY_ACCESS_EXPR__INDEX, newIndex, newIndex));
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
      case SpearPackage.ARRAY_ACCESS_EXPR__ARRAY:
        return basicSetArray(null, msgs);
      case SpearPackage.ARRAY_ACCESS_EXPR__INDEX:
        return basicSetIndex(null, msgs);
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
      case SpearPackage.ARRAY_ACCESS_EXPR__ARRAY:
        return getArray();
      case SpearPackage.ARRAY_ACCESS_EXPR__INDEX:
        return getIndex();
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
      case SpearPackage.ARRAY_ACCESS_EXPR__ARRAY:
        setArray((Expr)newValue);
        return;
      case SpearPackage.ARRAY_ACCESS_EXPR__INDEX:
        setIndex((Expr)newValue);
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
      case SpearPackage.ARRAY_ACCESS_EXPR__ARRAY:
        setArray((Expr)null);
        return;
      case SpearPackage.ARRAY_ACCESS_EXPR__INDEX:
        setIndex((Expr)null);
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
      case SpearPackage.ARRAY_ACCESS_EXPR__ARRAY:
        return array != null;
      case SpearPackage.ARRAY_ACCESS_EXPR__INDEX:
        return index != null;
    }
    return super.eIsSet(featureID);
  }

} //ArrayAccessExprImpl
