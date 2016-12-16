/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.MultipleIdExpr;
import com.rockwellcollins.spear.SpearPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Id Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.MultipleIdExprImpl#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultipleIdExprImpl extends ExprImpl implements MultipleIdExpr
{
  /**
   * The cached value of the '{@link #getIds() <em>Ids</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIds()
   * @generated
   * @ordered
   */
  protected EList<IdRef> ids;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultipleIdExprImpl()
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
    return SpearPackage.Literals.MULTIPLE_ID_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IdRef> getIds()
  {
    if (ids == null)
    {
      ids = new EObjectResolvingEList<IdRef>(IdRef.class, this, SpearPackage.MULTIPLE_ID_EXPR__IDS);
    }
    return ids;
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
      case SpearPackage.MULTIPLE_ID_EXPR__IDS:
        return getIds();
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
      case SpearPackage.MULTIPLE_ID_EXPR__IDS:
        getIds().clear();
        getIds().addAll((Collection<? extends IdRef>)newValue);
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
      case SpearPackage.MULTIPLE_ID_EXPR__IDS:
        getIds().clear();
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
      case SpearPackage.MULTIPLE_ID_EXPR__IDS:
        return ids != null && !ids.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MultipleIdExprImpl
