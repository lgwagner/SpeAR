/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.RecordTypeDef;
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
 * An implementation of the model object '<em><b>Fieldless Record Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.FieldlessRecordExprImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.FieldlessRecordExprImpl#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FieldlessRecordExprImpl extends ExprImpl implements FieldlessRecordExpr
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected RecordTypeDef type;

  /**
   * The cached value of the '{@link #getExprs() <em>Exprs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprs()
   * @generated
   * @ordered
   */
  protected EList<Expr> exprs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldlessRecordExprImpl()
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
    return SpearPackage.Literals.FIELDLESS_RECORD_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTypeDef getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (RecordTypeDef)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpearPackage.FIELDLESS_RECORD_EXPR__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTypeDef basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(RecordTypeDef newType)
  {
    RecordTypeDef oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.FIELDLESS_RECORD_EXPR__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expr> getExprs()
  {
    if (exprs == null)
    {
      exprs = new EObjectContainmentEList<Expr>(Expr.class, this, SpearPackage.FIELDLESS_RECORD_EXPR__EXPRS);
    }
    return exprs;
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
      case SpearPackage.FIELDLESS_RECORD_EXPR__EXPRS:
        return ((InternalEList<?>)getExprs()).basicRemove(otherEnd, msgs);
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
      case SpearPackage.FIELDLESS_RECORD_EXPR__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case SpearPackage.FIELDLESS_RECORD_EXPR__EXPRS:
        return getExprs();
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
      case SpearPackage.FIELDLESS_RECORD_EXPR__TYPE:
        setType((RecordTypeDef)newValue);
        return;
      case SpearPackage.FIELDLESS_RECORD_EXPR__EXPRS:
        getExprs().clear();
        getExprs().addAll((Collection<? extends Expr>)newValue);
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
      case SpearPackage.FIELDLESS_RECORD_EXPR__TYPE:
        setType((RecordTypeDef)null);
        return;
      case SpearPackage.FIELDLESS_RECORD_EXPR__EXPRS:
        getExprs().clear();
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
      case SpearPackage.FIELDLESS_RECORD_EXPR__TYPE:
        return type != null;
      case SpearPackage.FIELDLESS_RECORD_EXPR__EXPRS:
        return exprs != null && !exprs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FieldlessRecordExprImpl
