/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.RecordExpr;
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
 * An implementation of the model object '<em><b>Record Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.RecordExprImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.RecordExprImpl#getFieldExprs <em>Field Exprs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordExprImpl extends ExprImpl implements RecordExpr
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
   * The cached value of the '{@link #getFieldExprs() <em>Field Exprs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldExprs()
   * @generated
   * @ordered
   */
  protected EList<FieldExpr> fieldExprs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordExprImpl()
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
    return SpearPackage.Literals.RECORD_EXPR;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpearPackage.RECORD_EXPR__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.RECORD_EXPR__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FieldExpr> getFieldExprs()
  {
    if (fieldExprs == null)
    {
      fieldExprs = new EObjectContainmentEList<FieldExpr>(FieldExpr.class, this, SpearPackage.RECORD_EXPR__FIELD_EXPRS);
    }
    return fieldExprs;
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
      case SpearPackage.RECORD_EXPR__FIELD_EXPRS:
        return ((InternalEList<?>)getFieldExprs()).basicRemove(otherEnd, msgs);
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
      case SpearPackage.RECORD_EXPR__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case SpearPackage.RECORD_EXPR__FIELD_EXPRS:
        return getFieldExprs();
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
      case SpearPackage.RECORD_EXPR__TYPE:
        setType((RecordTypeDef)newValue);
        return;
      case SpearPackage.RECORD_EXPR__FIELD_EXPRS:
        getFieldExprs().clear();
        getFieldExprs().addAll((Collection<? extends FieldExpr>)newValue);
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
      case SpearPackage.RECORD_EXPR__TYPE:
        setType((RecordTypeDef)null);
        return;
      case SpearPackage.RECORD_EXPR__FIELD_EXPRS:
        getFieldExprs().clear();
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
      case SpearPackage.RECORD_EXPR__TYPE:
        return type != null;
      case SpearPackage.RECORD_EXPR__FIELD_EXPRS:
        return fieldExprs != null && !fieldExprs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RecordExprImpl
