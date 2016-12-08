/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getEquations <em>Equations</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternImpl extends MinimalEObjectImpl.Container implements Pattern
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<Variable> inputs;

  /**
   * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputs()
   * @generated
   * @ordered
   */
  protected EList<Variable> outputs;

  /**
   * The cached value of the '{@link #getLocals() <em>Locals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocals()
   * @generated
   * @ordered
   */
  protected EList<Variable> locals;

  /**
   * The cached value of the '{@link #getEquations() <em>Equations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEquations()
   * @generated
   * @ordered
   */
  protected EList<LustreEquation> equations;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<LustreProperty> properties;

  /**
   * The cached value of the '{@link #getAssertions() <em>Assertions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssertions()
   * @generated
   * @ordered
   */
  protected EList<LustreAssertion> assertions;

  /**
   * The default value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescriptor()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescriptor()
   * @generated
   * @ordered
   */
  protected String descriptor = DESCRIPTOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getIds() <em>Ids</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIds()
   * @generated
   * @ordered
   */
  protected EList<String> ids;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternImpl()
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
    return SpearPackage.Literals.PATTERN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.PATTERN__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Variable> getInputs()
  {
    if (inputs == null)
    {
      inputs = new EObjectContainmentEList<Variable>(Variable.class, this, SpearPackage.PATTERN__INPUTS);
    }
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Variable> getOutputs()
  {
    if (outputs == null)
    {
      outputs = new EObjectContainmentEList<Variable>(Variable.class, this, SpearPackage.PATTERN__OUTPUTS);
    }
    return outputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Variable> getLocals()
  {
    if (locals == null)
    {
      locals = new EObjectContainmentEList<Variable>(Variable.class, this, SpearPackage.PATTERN__LOCALS);
    }
    return locals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LustreEquation> getEquations()
  {
    if (equations == null)
    {
      equations = new EObjectContainmentEList<LustreEquation>(LustreEquation.class, this, SpearPackage.PATTERN__EQUATIONS);
    }
    return equations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LustreProperty> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<LustreProperty>(LustreProperty.class, this, SpearPackage.PATTERN__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LustreAssertion> getAssertions()
  {
    if (assertions == null)
    {
      assertions = new EObjectContainmentEList<LustreAssertion>(LustreAssertion.class, this, SpearPackage.PATTERN__ASSERTIONS);
    }
    return assertions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescriptor()
  {
    return descriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescriptor(String newDescriptor)
  {
    String oldDescriptor = descriptor;
    descriptor = newDescriptor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.PATTERN__DESCRIPTOR, oldDescriptor, descriptor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIds()
  {
    if (ids == null)
    {
      ids = new EDataTypeEList<String>(String.class, this, SpearPackage.PATTERN__IDS);
    }
    return ids;
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
      case SpearPackage.PATTERN__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__OUTPUTS:
        return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__LOCALS:
        return ((InternalEList<?>)getLocals()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__EQUATIONS:
        return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__ASSERTIONS:
        return ((InternalEList<?>)getAssertions()).basicRemove(otherEnd, msgs);
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
      case SpearPackage.PATTERN__NAME:
        return getName();
      case SpearPackage.PATTERN__INPUTS:
        return getInputs();
      case SpearPackage.PATTERN__OUTPUTS:
        return getOutputs();
      case SpearPackage.PATTERN__LOCALS:
        return getLocals();
      case SpearPackage.PATTERN__EQUATIONS:
        return getEquations();
      case SpearPackage.PATTERN__PROPERTIES:
        return getProperties();
      case SpearPackage.PATTERN__ASSERTIONS:
        return getAssertions();
      case SpearPackage.PATTERN__DESCRIPTOR:
        return getDescriptor();
      case SpearPackage.PATTERN__IDS:
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
      case SpearPackage.PATTERN__NAME:
        setName((String)newValue);
        return;
      case SpearPackage.PATTERN__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends Variable>)newValue);
        return;
      case SpearPackage.PATTERN__OUTPUTS:
        getOutputs().clear();
        getOutputs().addAll((Collection<? extends Variable>)newValue);
        return;
      case SpearPackage.PATTERN__LOCALS:
        getLocals().clear();
        getLocals().addAll((Collection<? extends Variable>)newValue);
        return;
      case SpearPackage.PATTERN__EQUATIONS:
        getEquations().clear();
        getEquations().addAll((Collection<? extends LustreEquation>)newValue);
        return;
      case SpearPackage.PATTERN__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends LustreProperty>)newValue);
        return;
      case SpearPackage.PATTERN__ASSERTIONS:
        getAssertions().clear();
        getAssertions().addAll((Collection<? extends LustreAssertion>)newValue);
        return;
      case SpearPackage.PATTERN__DESCRIPTOR:
        setDescriptor((String)newValue);
        return;
      case SpearPackage.PATTERN__IDS:
        getIds().clear();
        getIds().addAll((Collection<? extends String>)newValue);
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
      case SpearPackage.PATTERN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SpearPackage.PATTERN__INPUTS:
        getInputs().clear();
        return;
      case SpearPackage.PATTERN__OUTPUTS:
        getOutputs().clear();
        return;
      case SpearPackage.PATTERN__LOCALS:
        getLocals().clear();
        return;
      case SpearPackage.PATTERN__EQUATIONS:
        getEquations().clear();
        return;
      case SpearPackage.PATTERN__PROPERTIES:
        getProperties().clear();
        return;
      case SpearPackage.PATTERN__ASSERTIONS:
        getAssertions().clear();
        return;
      case SpearPackage.PATTERN__DESCRIPTOR:
        setDescriptor(DESCRIPTOR_EDEFAULT);
        return;
      case SpearPackage.PATTERN__IDS:
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
      case SpearPackage.PATTERN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SpearPackage.PATTERN__INPUTS:
        return inputs != null && !inputs.isEmpty();
      case SpearPackage.PATTERN__OUTPUTS:
        return outputs != null && !outputs.isEmpty();
      case SpearPackage.PATTERN__LOCALS:
        return locals != null && !locals.isEmpty();
      case SpearPackage.PATTERN__EQUATIONS:
        return equations != null && !equations.isEmpty();
      case SpearPackage.PATTERN__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case SpearPackage.PATTERN__ASSERTIONS:
        return assertions != null && !assertions.isEmpty();
      case SpearPackage.PATTERN__DESCRIPTOR:
        return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals(descriptor);
      case SpearPackage.PATTERN__IDS:
        return ids != null && !ids.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", descriptor: ");
    result.append(descriptor);
    result.append(", ids: ");
    result.append(ids);
    result.append(')');
    return result.toString();
  }

} //PatternImpl
