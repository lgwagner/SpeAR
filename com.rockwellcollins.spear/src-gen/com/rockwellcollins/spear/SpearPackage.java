/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.rockwellcollins.spear.SpearFactory
 * @model kind="package"
 * @generated
 */
public interface SpearPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "spear";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.rockwellcollins.com/Spear";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "spear";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SpearPackage eINSTANCE = com.rockwellcollins.spear.impl.SpearPackageImpl.init();

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.FileImpl <em>File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.FileImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFile()
   * @generated
   */
  int FILE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Typedefs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__TYPEDEFS = 2;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__CONSTANTS = 3;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__PATTERNS = 4;

  /**
   * The number of structural features of the '<em>File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.SpecificationImpl <em>Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.SpecificationImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getSpecification()
   * @generated
   */
  int SPECIFICATION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__NAME = FILE__NAME;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__IMPORTS = FILE__IMPORTS;

  /**
   * The feature id for the '<em><b>Typedefs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__TYPEDEFS = FILE__TYPEDEFS;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__CONSTANTS = FILE__CONSTANTS;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__PATTERNS = FILE__PATTERNS;

  /**
   * The feature id for the '<em><b>Units</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__UNITS = FILE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__INPUTS = FILE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__OUTPUTS = FILE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__STATE = FILE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Macros</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__MACROS = FILE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Assumptions Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__ASSUMPTIONS_KEYWORD = FILE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Assumptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__ASSUMPTIONS = FILE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Requirements Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__REQUIREMENTS_KEYWORD = FILE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__REQUIREMENTS = FILE_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Properties Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__PROPERTIES_KEYWORD = FILE_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__BEHAVIORS = FILE_FEATURE_COUNT + 10;

  /**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_FEATURE_COUNT = FILE_FEATURE_COUNT + 11;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ImportImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 2;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.DefinitionsImpl <em>Definitions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.DefinitionsImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getDefinitions()
   * @generated
   */
  int DEFINITIONS = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS__NAME = FILE__NAME;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS__IMPORTS = FILE__IMPORTS;

  /**
   * The feature id for the '<em><b>Typedefs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS__TYPEDEFS = FILE__TYPEDEFS;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS__CONSTANTS = FILE__CONSTANTS;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS__PATTERNS = FILE__PATTERNS;

  /**
   * The feature id for the '<em><b>Unitdefs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS__UNITDEFS = FILE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Definitions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_FEATURE_COUNT = FILE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.PatternImpl <em>Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.PatternImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getPattern()
   * @generated
   */
  int PATTERN = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__NAME = 0;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__INPUTS = 1;

  /**
   * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__OUTPUTS = 2;

  /**
   * The feature id for the '<em><b>Locals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__LOCALS = 3;

  /**
   * The feature id for the '<em><b>Equations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EQUATIONS = 4;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__PROPERTIES = 5;

  /**
   * The feature id for the '<em><b>Assertions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__ASSERTIONS = 6;

  /**
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.LustreEquationImpl <em>Lustre Equation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.LustreEquationImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLustreEquation()
   * @generated
   */
  int LUSTRE_EQUATION = 5;

  /**
   * The feature id for the '<em><b>Ids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LUSTRE_EQUATION__IDS = 0;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LUSTRE_EQUATION__RHS = 1;

  /**
   * The number of structural features of the '<em>Lustre Equation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LUSTRE_EQUATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.LustrePropertyImpl <em>Lustre Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.LustrePropertyImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLustreProperty()
   * @generated
   */
  int LUSTRE_PROPERTY = 6;

  /**
   * The feature id for the '<em><b>Property Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LUSTRE_PROPERTY__PROPERTY_ID = 0;

  /**
   * The number of structural features of the '<em>Lustre Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LUSTRE_PROPERTY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.LustreAssertionImpl <em>Lustre Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.LustreAssertionImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLustreAssertion()
   * @generated
   */
  int LUSTRE_ASSERTION = 7;

  /**
   * The feature id for the '<em><b>Assertion Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LUSTRE_ASSERTION__ASSERTION_EXPR = 0;

  /**
   * The number of structural features of the '<em>Lustre Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LUSTRE_ASSERTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.UnitDefImpl <em>Unit Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.UnitDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUnitDef()
   * @generated
   */
  int UNIT_DEF = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_DEF__NAME = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_DEF__DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Unit Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_DEF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.UnitExprImpl <em>Unit Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.UnitExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUnitExpr()
   * @generated
   */
  int UNIT_EXPR = 9;

  /**
   * The number of structural features of the '<em>Unit Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.TypeDefImpl <em>Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.TypeDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getTypeDef()
   * @generated
   */
  int TYPE_DEF = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF__NAME = 0;

  /**
   * The number of structural features of the '<em>Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.FieldTypeImpl <em>Field Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.FieldTypeImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFieldType()
   * @generated
   */
  int FIELD_TYPE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.IdRefImpl <em>Id Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.IdRefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIdRef()
   * @generated
   */
  int ID_REF = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_REF__NAME = 0;

  /**
   * The number of structural features of the '<em>Id Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_REF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.EnumValueImpl <em>Enum Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.EnumValueImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getEnumValue()
   * @generated
   */
  int ENUM_VALUE = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE__NAME = ID_REF__NAME;

  /**
   * The number of structural features of the '<em>Enum Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE_FEATURE_COUNT = ID_REF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.TypeImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getType()
   * @generated
   */
  int TYPE = 13;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ConstantImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__NAME = ID_REF__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__TYPE = ID_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__EXPR = ID_REF_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__DESCRIPTOR = ID_REF_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = ID_REF_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.VariableImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = ID_REF__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = ID_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = ID_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.MacroImpl <em>Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.MacroImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getMacro()
   * @generated
   */
  int MACRO = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__NAME = ID_REF__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__TYPE = ID_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__EXPR = ID_REF_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__DESCRIPTOR = ID_REF_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_FEATURE_COUNT = ID_REF_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ConstraintImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__NAME = 0;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__IDS = 1;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.FormalConstraintImpl <em>Formal Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.FormalConstraintImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFormalConstraint()
   * @generated
   */
  int FORMAL_CONSTRAINT = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_CONSTRAINT__NAME = CONSTRAINT__NAME;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_CONSTRAINT__IDS = CONSTRAINT__IDS;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_CONSTRAINT__EXPR = CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_CONSTRAINT__DESCRIPTOR = CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Formal Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.EnglishConstraintImpl <em>English Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.EnglishConstraintImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getEnglishConstraint()
   * @generated
   */
  int ENGLISH_CONSTRAINT = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENGLISH_CONSTRAINT__NAME = CONSTRAINT__NAME;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENGLISH_CONSTRAINT__IDS = CONSTRAINT__IDS;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENGLISH_CONSTRAINT__TEXT = CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>English Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENGLISH_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getExpr()
   * @generated
   */
  int EXPR = 20;

  /**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.LiteralExprImpl <em>Literal Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.LiteralExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLiteralExpr()
   * @generated
   */
  int LITERAL_EXPR = 21;

  /**
   * The number of structural features of the '<em>Literal Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.FieldExprImpl <em>Field Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.FieldExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFieldExpr()
   * @generated
   */
  int FIELD_EXPR = 23;

  /**
   * The feature id for the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_EXPR__FIELD = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_EXPR__EXPR = 1;

  /**
   * The number of structural features of the '<em>Field Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_EXPR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.BaseUnitImpl <em>Base Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.BaseUnitImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBaseUnit()
   * @generated
   */
  int BASE_UNIT = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_UNIT__NAME = UNIT_DEF__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_UNIT__DESCRIPTION = UNIT_DEF__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Base Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_UNIT_FEATURE_COUNT = UNIT_DEF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.DerivedUnitImpl <em>Derived Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.DerivedUnitImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getDerivedUnit()
   * @generated
   */
  int DERIVED_UNIT = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_UNIT__NAME = UNIT_DEF__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_UNIT__DESCRIPTION = UNIT_DEF__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_UNIT__UNIT = UNIT_DEF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Derived Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_UNIT_FEATURE_COUNT = UNIT_DEF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.BinaryUnitExprImpl <em>Binary Unit Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.BinaryUnitExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBinaryUnitExpr()
   * @generated
   */
  int BINARY_UNIT_EXPR = 26;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_UNIT_EXPR__LEFT = UNIT_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_UNIT_EXPR__OP = UNIT_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_UNIT_EXPR__RIGHT = UNIT_EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Unit Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_UNIT_EXPR_FEATURE_COUNT = UNIT_EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.NamedUnitExprImpl <em>Named Unit Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.NamedUnitExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getNamedUnitExpr()
   * @generated
   */
  int NAMED_UNIT_EXPR = 27;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_UNIT_EXPR__UNIT = UNIT_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Unit Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_UNIT_EXPR_FEATURE_COUNT = UNIT_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.NamedTypeDefImpl <em>Named Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.NamedTypeDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getNamedTypeDef()
   * @generated
   */
  int NAMED_TYPE_DEF = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_DEF__NAME = TYPE_DEF__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_DEF__TYPE = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_DEF__UNIT = TYPE_DEF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Named Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_DEF_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.AbstractTypeDefImpl <em>Abstract Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.AbstractTypeDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getAbstractTypeDef()
   * @generated
   */
  int ABSTRACT_TYPE_DEF = 29;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_DEF__NAME = TYPE_DEF__NAME;

  /**
   * The number of structural features of the '<em>Abstract Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_DEF_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.RecordTypeDefImpl <em>Record Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.RecordTypeDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordTypeDef()
   * @generated
   */
  int RECORD_TYPE_DEF = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_DEF__NAME = TYPE_DEF__NAME;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_DEF__FIELDS = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Record Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_DEF_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ArrayTypeDefImpl <em>Array Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ArrayTypeDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayTypeDef()
   * @generated
   */
  int ARRAY_TYPE_DEF = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF__NAME = TYPE_DEF__NAME;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF__BASE = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF__SIZE = TYPE_DEF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.EnumTypeDefImpl <em>Enum Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.EnumTypeDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getEnumTypeDef()
   * @generated
   */
  int ENUM_TYPE_DEF = 32;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_DEF__NAME = TYPE_DEF__NAME;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_DEF__VALUES = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_DEF_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ConcreteArrayTypeDefImpl <em>Concrete Array Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ConcreteArrayTypeDefImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getConcreteArrayTypeDef()
   * @generated
   */
  int CONCRETE_ARRAY_TYPE_DEF = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_ARRAY_TYPE_DEF__NAME = TYPE_DEF__NAME;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_ARRAY_TYPE_DEF__BASE = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_ARRAY_TYPE_DEF__SIZE = TYPE_DEF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Concrete Array Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_ARRAY_TYPE_DEF_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.IntTypeImpl <em>Int Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.IntTypeImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIntType()
   * @generated
   */
  int INT_TYPE = 34;

  /**
   * The number of structural features of the '<em>Int Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.BoolTypeImpl <em>Bool Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.BoolTypeImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBoolType()
   * @generated
   */
  int BOOL_TYPE = 35;

  /**
   * The number of structural features of the '<em>Bool Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.RealTypeImpl <em>Real Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.RealTypeImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRealType()
   * @generated
   */
  int REAL_TYPE = 36;

  /**
   * The number of structural features of the '<em>Real Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.UserTypeImpl <em>User Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.UserTypeImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUserType()
   * @generated
   */
  int USER_TYPE = 37;

  /**
   * The feature id for the '<em><b>Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_TYPE__DEF = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>User Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.WhileExprImpl <em>While Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.WhileExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getWhileExpr()
   * @generated
   */
  int WHILE_EXPR = 38;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_EXPR__COND = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_EXPR__THEN = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.BinaryExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBinaryExpr()
   * @generated
   */
  int BINARY_EXPR = 39;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.AfterUntilExprImpl <em>After Until Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.AfterUntilExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getAfterUntilExpr()
   * @generated
   */
  int AFTER_UNTIL_EXPR = 40;

  /**
   * The feature id for the '<em><b>After</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_UNTIL_EXPR__AFTER = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Until</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_UNTIL_EXPR__UNTIL = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>After Until Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_UNTIL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.UnaryExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUnaryExpr()
   * @generated
   */
  int UNARY_EXPR = 41;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OP = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__EXPR = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.PreviousExprImpl <em>Previous Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.PreviousExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getPreviousExpr()
   * @generated
   */
  int PREVIOUS_EXPR = 42;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREVIOUS_EXPR__VAR = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREVIOUS_EXPR__INIT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Previous Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREVIOUS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.RecordAccessExprImpl <em>Record Access Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.RecordAccessExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordAccessExpr()
   * @generated
   */
  int RECORD_ACCESS_EXPR = 43;

  /**
   * The feature id for the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR__RECORD = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR__FIELD = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Record Access Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.RecordUpdateExprImpl <em>Record Update Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.RecordUpdateExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordUpdateExpr()
   * @generated
   */
  int RECORD_UPDATE_EXPR = 44;

  /**
   * The feature id for the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR__RECORD = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR__FIELD = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR__VALUE = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Record Update Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ArrayAccessExprImpl <em>Array Access Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ArrayAccessExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayAccessExpr()
   * @generated
   */
  int ARRAY_ACCESS_EXPR = 45;

  /**
   * The feature id for the '<em><b>Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR__ARRAY = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR__INDEX = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Access Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ArrayUpdateExprImpl <em>Array Update Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ArrayUpdateExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayUpdateExpr()
   * @generated
   */
  int ARRAY_UPDATE_EXPR = 46;

  /**
   * The feature id for the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_UPDATE_EXPR__ACCESS = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_UPDATE_EXPR__VALUE = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Update Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_UPDATE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.IdExprImpl <em>Id Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.IdExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIdExpr()
   * @generated
   */
  int ID_EXPR = 47;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Id Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.MultipleIdExprImpl <em>Multiple Id Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.MultipleIdExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getMultipleIdExpr()
   * @generated
   */
  int MULTIPLE_ID_EXPR = 48;

  /**
   * The feature id for the '<em><b>Ids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLE_ID_EXPR__IDS = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Multiple Id Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLE_ID_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.IfThenElseExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIfThenElseExpr()
   * @generated
   */
  int IF_THEN_ELSE_EXPR = 49;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__COND = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__THEN = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__ELSE = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Then Else Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.RecordExprImpl <em>Record Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.RecordExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordExpr()
   * @generated
   */
  int RECORD_EXPR = 50;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__TYPE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__FIELD_EXPRS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Record Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.FieldlessRecordExprImpl <em>Fieldless Record Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.FieldlessRecordExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFieldlessRecordExpr()
   * @generated
   */
  int FIELDLESS_RECORD_EXPR = 51;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELDLESS_RECORD_EXPR__TYPE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELDLESS_RECORD_EXPR__EXPRS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fieldless Record Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELDLESS_RECORD_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.ArrayExprImpl <em>Array Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.ArrayExprImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayExpr()
   * @generated
   */
  int ARRAY_EXPR = 52;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR__TYPE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR__EXPRS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.PatternCallImpl <em>Pattern Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.PatternCallImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getPatternCall()
   * @generated
   */
  int PATTERN_CALL = 53;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL__PATTERN = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Pattern Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.SpecificationCallImpl <em>Specification Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.SpecificationCallImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getSpecificationCall()
   * @generated
   */
  int SPECIFICATION_CALL = 54;

  /**
   * The feature id for the '<em><b>Spec</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_CALL__SPEC = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_CALL__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Specification Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_CALL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.IntLiteralImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 55;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__VALUE = LITERAL_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__UNIT = LITERAL_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = LITERAL_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.BoolLiteralImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBoolLiteral()
   * @generated
   */
  int BOOL_LITERAL = 56;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL__VALUE = LITERAL_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bool Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL_FEATURE_COUNT = LITERAL_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.RealLiteralImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 57;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__VALUE = LITERAL_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__UNIT = LITERAL_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = LITERAL_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.spear.impl.NormalizedCallImpl <em>Normalized Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.spear.impl.NormalizedCallImpl
   * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getNormalizedCall()
   * @generated
   */
  int NORMALIZED_CALL = 58;

  /**
   * The feature id for the '<em><b>Ids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NORMALIZED_CALL__IDS = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Spec</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NORMALIZED_CALL__SPEC = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NORMALIZED_CALL__ARGS = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Normalized Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NORMALIZED_CALL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.File <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File</em>'.
   * @see com.rockwellcollins.spear.File
   * @generated
   */
  EClass getFile();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.File#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.spear.File#getName()
   * @see #getFile()
   * @generated
   */
  EAttribute getFile_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.File#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see com.rockwellcollins.spear.File#getImports()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.File#getTypedefs <em>Typedefs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Typedefs</em>'.
   * @see com.rockwellcollins.spear.File#getTypedefs()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Typedefs();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.File#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see com.rockwellcollins.spear.File#getConstants()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Constants();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.File#getPatterns <em>Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Patterns</em>'.
   * @see com.rockwellcollins.spear.File#getPatterns()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Patterns();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see com.rockwellcollins.spear.Specification
   * @generated
   */
  EClass getSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Units</em>'.
   * @see com.rockwellcollins.spear.Specification#getUnits()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Units();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see com.rockwellcollins.spear.Specification#getInputs()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Inputs();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getOutputs <em>Outputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Outputs</em>'.
   * @see com.rockwellcollins.spear.Specification#getOutputs()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Outputs();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State</em>'.
   * @see com.rockwellcollins.spear.Specification#getState()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_State();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getMacros <em>Macros</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Macros</em>'.
   * @see com.rockwellcollins.spear.Specification#getMacros()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Macros();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Specification#getAssumptionsKeyword <em>Assumptions Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assumptions Keyword</em>'.
   * @see com.rockwellcollins.spear.Specification#getAssumptionsKeyword()
   * @see #getSpecification()
   * @generated
   */
  EAttribute getSpecification_AssumptionsKeyword();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getAssumptions <em>Assumptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assumptions</em>'.
   * @see com.rockwellcollins.spear.Specification#getAssumptions()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Assumptions();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Specification#getRequirementsKeyword <em>Requirements Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Requirements Keyword</em>'.
   * @see com.rockwellcollins.spear.Specification#getRequirementsKeyword()
   * @see #getSpecification()
   * @generated
   */
  EAttribute getSpecification_RequirementsKeyword();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getRequirements <em>Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirements</em>'.
   * @see com.rockwellcollins.spear.Specification#getRequirements()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Requirements();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Specification#getPropertiesKeyword <em>Properties Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Properties Keyword</em>'.
   * @see com.rockwellcollins.spear.Specification#getPropertiesKeyword()
   * @see #getSpecification()
   * @generated
   */
  EAttribute getSpecification_PropertiesKeyword();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Specification#getBehaviors <em>Behaviors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Behaviors</em>'.
   * @see com.rockwellcollins.spear.Specification#getBehaviors()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Behaviors();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see com.rockwellcollins.spear.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see com.rockwellcollins.spear.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Definitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definitions</em>'.
   * @see com.rockwellcollins.spear.Definitions
   * @generated
   */
  EClass getDefinitions();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Definitions#getUnitdefs <em>Unitdefs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Unitdefs</em>'.
   * @see com.rockwellcollins.spear.Definitions#getUnitdefs()
   * @see #getDefinitions()
   * @generated
   */
  EReference getDefinitions_Unitdefs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see com.rockwellcollins.spear.Pattern
   * @generated
   */
  EClass getPattern();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Pattern#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.spear.Pattern#getName()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Pattern#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see com.rockwellcollins.spear.Pattern#getInputs()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Inputs();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Pattern#getOutputs <em>Outputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Outputs</em>'.
   * @see com.rockwellcollins.spear.Pattern#getOutputs()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Outputs();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Pattern#getLocals <em>Locals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Locals</em>'.
   * @see com.rockwellcollins.spear.Pattern#getLocals()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Locals();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Pattern#getEquations <em>Equations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equations</em>'.
   * @see com.rockwellcollins.spear.Pattern#getEquations()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Equations();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Pattern#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see com.rockwellcollins.spear.Pattern#getProperties()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Properties();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.Pattern#getAssertions <em>Assertions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assertions</em>'.
   * @see com.rockwellcollins.spear.Pattern#getAssertions()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Assertions();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.LustreEquation <em>Lustre Equation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lustre Equation</em>'.
   * @see com.rockwellcollins.spear.LustreEquation
   * @generated
   */
  EClass getLustreEquation();

  /**
   * Returns the meta object for the reference list '{@link com.rockwellcollins.spear.LustreEquation#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ids</em>'.
   * @see com.rockwellcollins.spear.LustreEquation#getIds()
   * @see #getLustreEquation()
   * @generated
   */
  EReference getLustreEquation_Ids();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.LustreEquation#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.rockwellcollins.spear.LustreEquation#getRhs()
   * @see #getLustreEquation()
   * @generated
   */
  EReference getLustreEquation_Rhs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.LustreProperty <em>Lustre Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lustre Property</em>'.
   * @see com.rockwellcollins.spear.LustreProperty
   * @generated
   */
  EClass getLustreProperty();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.LustreProperty#getPropertyId <em>Property Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property Id</em>'.
   * @see com.rockwellcollins.spear.LustreProperty#getPropertyId()
   * @see #getLustreProperty()
   * @generated
   */
  EReference getLustreProperty_PropertyId();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.LustreAssertion <em>Lustre Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lustre Assertion</em>'.
   * @see com.rockwellcollins.spear.LustreAssertion
   * @generated
   */
  EClass getLustreAssertion();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.LustreAssertion#getAssertionExpr <em>Assertion Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assertion Expr</em>'.
   * @see com.rockwellcollins.spear.LustreAssertion#getAssertionExpr()
   * @see #getLustreAssertion()
   * @generated
   */
  EReference getLustreAssertion_AssertionExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.UnitDef <em>Unit Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Def</em>'.
   * @see com.rockwellcollins.spear.UnitDef
   * @generated
   */
  EClass getUnitDef();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.UnitDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.spear.UnitDef#getName()
   * @see #getUnitDef()
   * @generated
   */
  EAttribute getUnitDef_Name();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.UnitDef#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.rockwellcollins.spear.UnitDef#getDescription()
   * @see #getUnitDef()
   * @generated
   */
  EAttribute getUnitDef_Description();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.UnitExpr <em>Unit Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expr</em>'.
   * @see com.rockwellcollins.spear.UnitExpr
   * @generated
   */
  EClass getUnitExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.TypeDef <em>Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Def</em>'.
   * @see com.rockwellcollins.spear.TypeDef
   * @generated
   */
  EClass getTypeDef();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.TypeDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.spear.TypeDef#getName()
   * @see #getTypeDef()
   * @generated
   */
  EAttribute getTypeDef_Name();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.FieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Type</em>'.
   * @see com.rockwellcollins.spear.FieldType
   * @generated
   */
  EClass getFieldType();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.FieldType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.spear.FieldType#getName()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.FieldType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.FieldType#getType()
   * @see #getFieldType()
   * @generated
   */
  EReference getFieldType_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.EnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Value</em>'.
   * @see com.rockwellcollins.spear.EnumValue
   * @generated
   */
  EClass getEnumValue();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see com.rockwellcollins.spear.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see com.rockwellcollins.spear.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.Constant#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.Constant#getType()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.Constant#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.spear.Constant#getExpr()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_Expr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Constant#getDescriptor <em>Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Descriptor</em>'.
   * @see com.rockwellcollins.spear.Constant#getDescriptor()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Descriptor();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see com.rockwellcollins.spear.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Macro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro</em>'.
   * @see com.rockwellcollins.spear.Macro
   * @generated
   */
  EClass getMacro();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.Macro#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.Macro#getType()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.Macro#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.spear.Macro#getExpr()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_Expr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Macro#getDescriptor <em>Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Descriptor</em>'.
   * @see com.rockwellcollins.spear.Macro#getDescriptor()
   * @see #getMacro()
   * @generated
   */
  EAttribute getMacro_Descriptor();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see com.rockwellcollins.spear.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.Constraint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.spear.Constraint#getName()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Name();

  /**
   * Returns the meta object for the attribute list '{@link com.rockwellcollins.spear.Constraint#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see com.rockwellcollins.spear.Constraint#getIds()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Ids();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.FormalConstraint <em>Formal Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Constraint</em>'.
   * @see com.rockwellcollins.spear.FormalConstraint
   * @generated
   */
  EClass getFormalConstraint();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.FormalConstraint#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.spear.FormalConstraint#getExpr()
   * @see #getFormalConstraint()
   * @generated
   */
  EReference getFormalConstraint_Expr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.FormalConstraint#getDescriptor <em>Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Descriptor</em>'.
   * @see com.rockwellcollins.spear.FormalConstraint#getDescriptor()
   * @see #getFormalConstraint()
   * @generated
   */
  EAttribute getFormalConstraint_Descriptor();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.EnglishConstraint <em>English Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>English Constraint</em>'.
   * @see com.rockwellcollins.spear.EnglishConstraint
   * @generated
   */
  EClass getEnglishConstraint();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.EnglishConstraint#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see com.rockwellcollins.spear.EnglishConstraint#getText()
   * @see #getEnglishConstraint()
   * @generated
   */
  EAttribute getEnglishConstraint_Text();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see com.rockwellcollins.spear.Expr
   * @generated
   */
  EClass getExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.LiteralExpr <em>Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Expr</em>'.
   * @see com.rockwellcollins.spear.LiteralExpr
   * @generated
   */
  EClass getLiteralExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.IdRef <em>Id Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Ref</em>'.
   * @see com.rockwellcollins.spear.IdRef
   * @generated
   */
  EClass getIdRef();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.IdRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.spear.IdRef#getName()
   * @see #getIdRef()
   * @generated
   */
  EAttribute getIdRef_Name();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.FieldExpr <em>Field Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Expr</em>'.
   * @see com.rockwellcollins.spear.FieldExpr
   * @generated
   */
  EClass getFieldExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.FieldExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Field</em>'.
   * @see com.rockwellcollins.spear.FieldExpr#getField()
   * @see #getFieldExpr()
   * @generated
   */
  EReference getFieldExpr_Field();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.FieldExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.spear.FieldExpr#getExpr()
   * @see #getFieldExpr()
   * @generated
   */
  EReference getFieldExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.BaseUnit <em>Base Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base Unit</em>'.
   * @see com.rockwellcollins.spear.BaseUnit
   * @generated
   */
  EClass getBaseUnit();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.DerivedUnit <em>Derived Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Derived Unit</em>'.
   * @see com.rockwellcollins.spear.DerivedUnit
   * @generated
   */
  EClass getDerivedUnit();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.DerivedUnit#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see com.rockwellcollins.spear.DerivedUnit#getUnit()
   * @see #getDerivedUnit()
   * @generated
   */
  EReference getDerivedUnit_Unit();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.BinaryUnitExpr <em>Binary Unit Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Unit Expr</em>'.
   * @see com.rockwellcollins.spear.BinaryUnitExpr
   * @generated
   */
  EClass getBinaryUnitExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.BinaryUnitExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.rockwellcollins.spear.BinaryUnitExpr#getLeft()
   * @see #getBinaryUnitExpr()
   * @generated
   */
  EReference getBinaryUnitExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.BinaryUnitExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.rockwellcollins.spear.BinaryUnitExpr#getOp()
   * @see #getBinaryUnitExpr()
   * @generated
   */
  EAttribute getBinaryUnitExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.BinaryUnitExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.rockwellcollins.spear.BinaryUnitExpr#getRight()
   * @see #getBinaryUnitExpr()
   * @generated
   */
  EReference getBinaryUnitExpr_Right();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.NamedUnitExpr <em>Named Unit Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Unit Expr</em>'.
   * @see com.rockwellcollins.spear.NamedUnitExpr
   * @generated
   */
  EClass getNamedUnitExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.NamedUnitExpr#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see com.rockwellcollins.spear.NamedUnitExpr#getUnit()
   * @see #getNamedUnitExpr()
   * @generated
   */
  EReference getNamedUnitExpr_Unit();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.NamedTypeDef <em>Named Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Type Def</em>'.
   * @see com.rockwellcollins.spear.NamedTypeDef
   * @generated
   */
  EClass getNamedTypeDef();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.NamedTypeDef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.NamedTypeDef#getType()
   * @see #getNamedTypeDef()
   * @generated
   */
  EReference getNamedTypeDef_Type();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.NamedTypeDef#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see com.rockwellcollins.spear.NamedTypeDef#getUnit()
   * @see #getNamedTypeDef()
   * @generated
   */
  EReference getNamedTypeDef_Unit();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.AbstractTypeDef <em>Abstract Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Type Def</em>'.
   * @see com.rockwellcollins.spear.AbstractTypeDef
   * @generated
   */
  EClass getAbstractTypeDef();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.RecordTypeDef <em>Record Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Type Def</em>'.
   * @see com.rockwellcollins.spear.RecordTypeDef
   * @generated
   */
  EClass getRecordTypeDef();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.RecordTypeDef#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see com.rockwellcollins.spear.RecordTypeDef#getFields()
   * @see #getRecordTypeDef()
   * @generated
   */
  EReference getRecordTypeDef_Fields();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.ArrayTypeDef <em>Array Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Type Def</em>'.
   * @see com.rockwellcollins.spear.ArrayTypeDef
   * @generated
   */
  EClass getArrayTypeDef();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.ArrayTypeDef#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see com.rockwellcollins.spear.ArrayTypeDef#getBase()
   * @see #getArrayTypeDef()
   * @generated
   */
  EReference getArrayTypeDef_Base();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.ArrayTypeDef#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see com.rockwellcollins.spear.ArrayTypeDef#getSize()
   * @see #getArrayTypeDef()
   * @generated
   */
  EReference getArrayTypeDef_Size();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.EnumTypeDef <em>Enum Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Type Def</em>'.
   * @see com.rockwellcollins.spear.EnumTypeDef
   * @generated
   */
  EClass getEnumTypeDef();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.EnumTypeDef#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see com.rockwellcollins.spear.EnumTypeDef#getValues()
   * @see #getEnumTypeDef()
   * @generated
   */
  EReference getEnumTypeDef_Values();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.ConcreteArrayTypeDef <em>Concrete Array Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concrete Array Type Def</em>'.
   * @see com.rockwellcollins.spear.ConcreteArrayTypeDef
   * @generated
   */
  EClass getConcreteArrayTypeDef();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.ConcreteArrayTypeDef#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see com.rockwellcollins.spear.ConcreteArrayTypeDef#getBase()
   * @see #getConcreteArrayTypeDef()
   * @generated
   */
  EReference getConcreteArrayTypeDef_Base();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.ConcreteArrayTypeDef#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see com.rockwellcollins.spear.ConcreteArrayTypeDef#getSize()
   * @see #getConcreteArrayTypeDef()
   * @generated
   */
  EAttribute getConcreteArrayTypeDef_Size();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.IntType <em>Int Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Type</em>'.
   * @see com.rockwellcollins.spear.IntType
   * @generated
   */
  EClass getIntType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.BoolType <em>Bool Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Type</em>'.
   * @see com.rockwellcollins.spear.BoolType
   * @generated
   */
  EClass getBoolType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.RealType <em>Real Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Type</em>'.
   * @see com.rockwellcollins.spear.RealType
   * @generated
   */
  EClass getRealType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.UserType <em>User Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Type</em>'.
   * @see com.rockwellcollins.spear.UserType
   * @generated
   */
  EClass getUserType();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.UserType#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Def</em>'.
   * @see com.rockwellcollins.spear.UserType#getDef()
   * @see #getUserType()
   * @generated
   */
  EReference getUserType_Def();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.WhileExpr <em>While Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Expr</em>'.
   * @see com.rockwellcollins.spear.WhileExpr
   * @generated
   */
  EClass getWhileExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.WhileExpr#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see com.rockwellcollins.spear.WhileExpr#getCond()
   * @see #getWhileExpr()
   * @generated
   */
  EReference getWhileExpr_Cond();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.WhileExpr#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see com.rockwellcollins.spear.WhileExpr#getThen()
   * @see #getWhileExpr()
   * @generated
   */
  EReference getWhileExpr_Then();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.BinaryExpr <em>Binary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Expr</em>'.
   * @see com.rockwellcollins.spear.BinaryExpr
   * @generated
   */
  EClass getBinaryExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.BinaryExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.rockwellcollins.spear.BinaryExpr#getLeft()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.BinaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.rockwellcollins.spear.BinaryExpr#getOp()
   * @see #getBinaryExpr()
   * @generated
   */
  EAttribute getBinaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.BinaryExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.rockwellcollins.spear.BinaryExpr#getRight()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Right();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.AfterUntilExpr <em>After Until Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>After Until Expr</em>'.
   * @see com.rockwellcollins.spear.AfterUntilExpr
   * @generated
   */
  EClass getAfterUntilExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.AfterUntilExpr#getAfter <em>After</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>After</em>'.
   * @see com.rockwellcollins.spear.AfterUntilExpr#getAfter()
   * @see #getAfterUntilExpr()
   * @generated
   */
  EReference getAfterUntilExpr_After();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.AfterUntilExpr#getUntil <em>Until</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Until</em>'.
   * @see com.rockwellcollins.spear.AfterUntilExpr#getUntil()
   * @see #getAfterUntilExpr()
   * @generated
   */
  EReference getAfterUntilExpr_Until();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr</em>'.
   * @see com.rockwellcollins.spear.UnaryExpr
   * @generated
   */
  EClass getUnaryExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.UnaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.rockwellcollins.spear.UnaryExpr#getOp()
   * @see #getUnaryExpr()
   * @generated
   */
  EAttribute getUnaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.UnaryExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.spear.UnaryExpr#getExpr()
   * @see #getUnaryExpr()
   * @generated
   */
  EReference getUnaryExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.PreviousExpr <em>Previous Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Previous Expr</em>'.
   * @see com.rockwellcollins.spear.PreviousExpr
   * @generated
   */
  EClass getPreviousExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.PreviousExpr#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see com.rockwellcollins.spear.PreviousExpr#getVar()
   * @see #getPreviousExpr()
   * @generated
   */
  EReference getPreviousExpr_Var();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.PreviousExpr#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see com.rockwellcollins.spear.PreviousExpr#getInit()
   * @see #getPreviousExpr()
   * @generated
   */
  EReference getPreviousExpr_Init();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.RecordAccessExpr <em>Record Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Access Expr</em>'.
   * @see com.rockwellcollins.spear.RecordAccessExpr
   * @generated
   */
  EClass getRecordAccessExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.RecordAccessExpr#getRecord <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Record</em>'.
   * @see com.rockwellcollins.spear.RecordAccessExpr#getRecord()
   * @see #getRecordAccessExpr()
   * @generated
   */
  EReference getRecordAccessExpr_Record();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.RecordAccessExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Field</em>'.
   * @see com.rockwellcollins.spear.RecordAccessExpr#getField()
   * @see #getRecordAccessExpr()
   * @generated
   */
  EReference getRecordAccessExpr_Field();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.RecordUpdateExpr <em>Record Update Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Update Expr</em>'.
   * @see com.rockwellcollins.spear.RecordUpdateExpr
   * @generated
   */
  EClass getRecordUpdateExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.RecordUpdateExpr#getRecord <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Record</em>'.
   * @see com.rockwellcollins.spear.RecordUpdateExpr#getRecord()
   * @see #getRecordUpdateExpr()
   * @generated
   */
  EReference getRecordUpdateExpr_Record();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.RecordUpdateExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Field</em>'.
   * @see com.rockwellcollins.spear.RecordUpdateExpr#getField()
   * @see #getRecordUpdateExpr()
   * @generated
   */
  EReference getRecordUpdateExpr_Field();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.RecordUpdateExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.rockwellcollins.spear.RecordUpdateExpr#getValue()
   * @see #getRecordUpdateExpr()
   * @generated
   */
  EReference getRecordUpdateExpr_Value();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.ArrayAccessExpr <em>Array Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Access Expr</em>'.
   * @see com.rockwellcollins.spear.ArrayAccessExpr
   * @generated
   */
  EClass getArrayAccessExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.ArrayAccessExpr#getArray <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array</em>'.
   * @see com.rockwellcollins.spear.ArrayAccessExpr#getArray()
   * @see #getArrayAccessExpr()
   * @generated
   */
  EReference getArrayAccessExpr_Array();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.ArrayAccessExpr#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see com.rockwellcollins.spear.ArrayAccessExpr#getIndex()
   * @see #getArrayAccessExpr()
   * @generated
   */
  EReference getArrayAccessExpr_Index();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.ArrayUpdateExpr <em>Array Update Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Update Expr</em>'.
   * @see com.rockwellcollins.spear.ArrayUpdateExpr
   * @generated
   */
  EClass getArrayUpdateExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.ArrayUpdateExpr#getAccess <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Access</em>'.
   * @see com.rockwellcollins.spear.ArrayUpdateExpr#getAccess()
   * @see #getArrayUpdateExpr()
   * @generated
   */
  EReference getArrayUpdateExpr_Access();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.ArrayUpdateExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.rockwellcollins.spear.ArrayUpdateExpr#getValue()
   * @see #getArrayUpdateExpr()
   * @generated
   */
  EReference getArrayUpdateExpr_Value();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Expr</em>'.
   * @see com.rockwellcollins.spear.IdExpr
   * @generated
   */
  EClass getIdExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.IdExpr#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see com.rockwellcollins.spear.IdExpr#getId()
   * @see #getIdExpr()
   * @generated
   */
  EReference getIdExpr_Id();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.MultipleIdExpr <em>Multiple Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiple Id Expr</em>'.
   * @see com.rockwellcollins.spear.MultipleIdExpr
   * @generated
   */
  EClass getMultipleIdExpr();

  /**
   * Returns the meta object for the reference list '{@link com.rockwellcollins.spear.MultipleIdExpr#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ids</em>'.
   * @see com.rockwellcollins.spear.MultipleIdExpr#getIds()
   * @see #getMultipleIdExpr()
   * @generated
   */
  EReference getMultipleIdExpr_Ids();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.IfThenElseExpr <em>If Then Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Then Else Expr</em>'.
   * @see com.rockwellcollins.spear.IfThenElseExpr
   * @generated
   */
  EClass getIfThenElseExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.IfThenElseExpr#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see com.rockwellcollins.spear.IfThenElseExpr#getCond()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_Cond();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.IfThenElseExpr#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see com.rockwellcollins.spear.IfThenElseExpr#getThen()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_Then();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.spear.IfThenElseExpr#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see com.rockwellcollins.spear.IfThenElseExpr#getElse()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_Else();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.RecordExpr <em>Record Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Expr</em>'.
   * @see com.rockwellcollins.spear.RecordExpr
   * @generated
   */
  EClass getRecordExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.RecordExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.RecordExpr#getType()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_Type();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.RecordExpr#getFieldExprs <em>Field Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Field Exprs</em>'.
   * @see com.rockwellcollins.spear.RecordExpr#getFieldExprs()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_FieldExprs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.FieldlessRecordExpr <em>Fieldless Record Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fieldless Record Expr</em>'.
   * @see com.rockwellcollins.spear.FieldlessRecordExpr
   * @generated
   */
  EClass getFieldlessRecordExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.FieldlessRecordExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.FieldlessRecordExpr#getType()
   * @see #getFieldlessRecordExpr()
   * @generated
   */
  EReference getFieldlessRecordExpr_Type();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.FieldlessRecordExpr#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see com.rockwellcollins.spear.FieldlessRecordExpr#getExprs()
   * @see #getFieldlessRecordExpr()
   * @generated
   */
  EReference getFieldlessRecordExpr_Exprs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.ArrayExpr <em>Array Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Expr</em>'.
   * @see com.rockwellcollins.spear.ArrayExpr
   * @generated
   */
  EClass getArrayExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.ArrayExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.rockwellcollins.spear.ArrayExpr#getType()
   * @see #getArrayExpr()
   * @generated
   */
  EReference getArrayExpr_Type();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.ArrayExpr#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see com.rockwellcollins.spear.ArrayExpr#getExprs()
   * @see #getArrayExpr()
   * @generated
   */
  EReference getArrayExpr_Exprs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.PatternCall <em>Pattern Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Call</em>'.
   * @see com.rockwellcollins.spear.PatternCall
   * @generated
   */
  EClass getPatternCall();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.PatternCall#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pattern</em>'.
   * @see com.rockwellcollins.spear.PatternCall#getPattern()
   * @see #getPatternCall()
   * @generated
   */
  EReference getPatternCall_Pattern();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.PatternCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.spear.PatternCall#getArgs()
   * @see #getPatternCall()
   * @generated
   */
  EReference getPatternCall_Args();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.SpecificationCall <em>Specification Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification Call</em>'.
   * @see com.rockwellcollins.spear.SpecificationCall
   * @generated
   */
  EClass getSpecificationCall();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.SpecificationCall#getSpec <em>Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Spec</em>'.
   * @see com.rockwellcollins.spear.SpecificationCall#getSpec()
   * @see #getSpecificationCall()
   * @generated
   */
  EReference getSpecificationCall_Spec();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.SpecificationCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.spear.SpecificationCall#getArgs()
   * @see #getSpecificationCall()
   * @generated
   */
  EReference getSpecificationCall_Args();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see com.rockwellcollins.spear.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.IntLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.rockwellcollins.spear.IntLiteral#getValue()
   * @see #getIntLiteral()
   * @generated
   */
  EAttribute getIntLiteral_Value();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.IntLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see com.rockwellcollins.spear.IntLiteral#getUnit()
   * @see #getIntLiteral()
   * @generated
   */
  EReference getIntLiteral_Unit();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.BoolLiteral <em>Bool Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Literal</em>'.
   * @see com.rockwellcollins.spear.BoolLiteral
   * @generated
   */
  EClass getBoolLiteral();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.BoolLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.rockwellcollins.spear.BoolLiteral#getValue()
   * @see #getBoolLiteral()
   * @generated
   */
  EAttribute getBoolLiteral_Value();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see com.rockwellcollins.spear.RealLiteral
   * @generated
   */
  EClass getRealLiteral();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.spear.RealLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.rockwellcollins.spear.RealLiteral#getValue()
   * @see #getRealLiteral()
   * @generated
   */
  EAttribute getRealLiteral_Value();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.RealLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see com.rockwellcollins.spear.RealLiteral#getUnit()
   * @see #getRealLiteral()
   * @generated
   */
  EReference getRealLiteral_Unit();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.spear.NormalizedCall <em>Normalized Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Normalized Call</em>'.
   * @see com.rockwellcollins.spear.NormalizedCall
   * @generated
   */
  EClass getNormalizedCall();

  /**
   * Returns the meta object for the reference list '{@link com.rockwellcollins.spear.NormalizedCall#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ids</em>'.
   * @see com.rockwellcollins.spear.NormalizedCall#getIds()
   * @see #getNormalizedCall()
   * @generated
   */
  EReference getNormalizedCall_Ids();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.spear.NormalizedCall#getSpec <em>Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Spec</em>'.
   * @see com.rockwellcollins.spear.NormalizedCall#getSpec()
   * @see #getNormalizedCall()
   * @generated
   */
  EReference getNormalizedCall_Spec();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.spear.NormalizedCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.spear.NormalizedCall#getArgs()
   * @see #getNormalizedCall()
   * @generated
   */
  EReference getNormalizedCall_Args();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SpearFactory getSpearFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.FileImpl <em>File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.FileImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFile()
     * @generated
     */
    EClass FILE = eINSTANCE.getFile();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE__NAME = eINSTANCE.getFile_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__IMPORTS = eINSTANCE.getFile_Imports();

    /**
     * The meta object literal for the '<em><b>Typedefs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__TYPEDEFS = eINSTANCE.getFile_Typedefs();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__CONSTANTS = eINSTANCE.getFile_Constants();

    /**
     * The meta object literal for the '<em><b>Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__PATTERNS = eINSTANCE.getFile_Patterns();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.SpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.SpecificationImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getSpecification()
     * @generated
     */
    EClass SPECIFICATION = eINSTANCE.getSpecification();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__UNITS = eINSTANCE.getSpecification_Units();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__INPUTS = eINSTANCE.getSpecification_Inputs();

    /**
     * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__OUTPUTS = eINSTANCE.getSpecification_Outputs();

    /**
     * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__STATE = eINSTANCE.getSpecification_State();

    /**
     * The meta object literal for the '<em><b>Macros</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__MACROS = eINSTANCE.getSpecification_Macros();

    /**
     * The meta object literal for the '<em><b>Assumptions Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPECIFICATION__ASSUMPTIONS_KEYWORD = eINSTANCE.getSpecification_AssumptionsKeyword();

    /**
     * The meta object literal for the '<em><b>Assumptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__ASSUMPTIONS = eINSTANCE.getSpecification_Assumptions();

    /**
     * The meta object literal for the '<em><b>Requirements Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPECIFICATION__REQUIREMENTS_KEYWORD = eINSTANCE.getSpecification_RequirementsKeyword();

    /**
     * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__REQUIREMENTS = eINSTANCE.getSpecification_Requirements();

    /**
     * The meta object literal for the '<em><b>Properties Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPECIFICATION__PROPERTIES_KEYWORD = eINSTANCE.getSpecification_PropertiesKeyword();

    /**
     * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__BEHAVIORS = eINSTANCE.getSpecification_Behaviors();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ImportImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.DefinitionsImpl <em>Definitions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.DefinitionsImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getDefinitions()
     * @generated
     */
    EClass DEFINITIONS = eINSTANCE.getDefinitions();

    /**
     * The meta object literal for the '<em><b>Unitdefs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITIONS__UNITDEFS = eINSTANCE.getDefinitions_Unitdefs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.PatternImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getPattern()
     * @generated
     */
    EClass PATTERN = eINSTANCE.getPattern();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__NAME = eINSTANCE.getPattern_Name();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__INPUTS = eINSTANCE.getPattern_Inputs();

    /**
     * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__OUTPUTS = eINSTANCE.getPattern_Outputs();

    /**
     * The meta object literal for the '<em><b>Locals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__LOCALS = eINSTANCE.getPattern_Locals();

    /**
     * The meta object literal for the '<em><b>Equations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__EQUATIONS = eINSTANCE.getPattern_Equations();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__PROPERTIES = eINSTANCE.getPattern_Properties();

    /**
     * The meta object literal for the '<em><b>Assertions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__ASSERTIONS = eINSTANCE.getPattern_Assertions();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.LustreEquationImpl <em>Lustre Equation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.LustreEquationImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLustreEquation()
     * @generated
     */
    EClass LUSTRE_EQUATION = eINSTANCE.getLustreEquation();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LUSTRE_EQUATION__IDS = eINSTANCE.getLustreEquation_Ids();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LUSTRE_EQUATION__RHS = eINSTANCE.getLustreEquation_Rhs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.LustrePropertyImpl <em>Lustre Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.LustrePropertyImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLustreProperty()
     * @generated
     */
    EClass LUSTRE_PROPERTY = eINSTANCE.getLustreProperty();

    /**
     * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LUSTRE_PROPERTY__PROPERTY_ID = eINSTANCE.getLustreProperty_PropertyId();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.LustreAssertionImpl <em>Lustre Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.LustreAssertionImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLustreAssertion()
     * @generated
     */
    EClass LUSTRE_ASSERTION = eINSTANCE.getLustreAssertion();

    /**
     * The meta object literal for the '<em><b>Assertion Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LUSTRE_ASSERTION__ASSERTION_EXPR = eINSTANCE.getLustreAssertion_AssertionExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.UnitDefImpl <em>Unit Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.UnitDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUnitDef()
     * @generated
     */
    EClass UNIT_DEF = eINSTANCE.getUnitDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_DEF__NAME = eINSTANCE.getUnitDef_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_DEF__DESCRIPTION = eINSTANCE.getUnitDef_Description();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.UnitExprImpl <em>Unit Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.UnitExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUnitExpr()
     * @generated
     */
    EClass UNIT_EXPR = eINSTANCE.getUnitExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.TypeDefImpl <em>Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.TypeDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getTypeDef()
     * @generated
     */
    EClass TYPE_DEF = eINSTANCE.getTypeDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DEF__NAME = eINSTANCE.getTypeDef_Name();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.FieldTypeImpl <em>Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.FieldTypeImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFieldType()
     * @generated
     */
    EClass FIELD_TYPE = eINSTANCE.getFieldType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_TYPE__NAME = eINSTANCE.getFieldType_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_TYPE__TYPE = eINSTANCE.getFieldType_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.EnumValueImpl <em>Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.EnumValueImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getEnumValue()
     * @generated
     */
    EClass ENUM_VALUE = eINSTANCE.getEnumValue();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.TypeImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ConstantImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__TYPE = eINSTANCE.getConstant_Type();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__EXPR = eINSTANCE.getConstant_Expr();

    /**
     * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__DESCRIPTOR = eINSTANCE.getConstant_Descriptor();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.VariableImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.MacroImpl <em>Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.MacroImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getMacro()
     * @generated
     */
    EClass MACRO = eINSTANCE.getMacro();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__TYPE = eINSTANCE.getMacro_Type();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__EXPR = eINSTANCE.getMacro_Expr();

    /**
     * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO__DESCRIPTOR = eINSTANCE.getMacro_Descriptor();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ConstraintImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__IDS = eINSTANCE.getConstraint_Ids();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.FormalConstraintImpl <em>Formal Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.FormalConstraintImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFormalConstraint()
     * @generated
     */
    EClass FORMAL_CONSTRAINT = eINSTANCE.getFormalConstraint();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_CONSTRAINT__EXPR = eINSTANCE.getFormalConstraint_Expr();

    /**
     * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORMAL_CONSTRAINT__DESCRIPTOR = eINSTANCE.getFormalConstraint_Descriptor();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.EnglishConstraintImpl <em>English Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.EnglishConstraintImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getEnglishConstraint()
     * @generated
     */
    EClass ENGLISH_CONSTRAINT = eINSTANCE.getEnglishConstraint();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENGLISH_CONSTRAINT__TEXT = eINSTANCE.getEnglishConstraint_Text();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getExpr()
     * @generated
     */
    EClass EXPR = eINSTANCE.getExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.LiteralExprImpl <em>Literal Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.LiteralExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getLiteralExpr()
     * @generated
     */
    EClass LITERAL_EXPR = eINSTANCE.getLiteralExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.IdRefImpl <em>Id Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.IdRefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIdRef()
     * @generated
     */
    EClass ID_REF = eINSTANCE.getIdRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ID_REF__NAME = eINSTANCE.getIdRef_Name();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.FieldExprImpl <em>Field Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.FieldExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFieldExpr()
     * @generated
     */
    EClass FIELD_EXPR = eINSTANCE.getFieldExpr();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_EXPR__FIELD = eINSTANCE.getFieldExpr_Field();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_EXPR__EXPR = eINSTANCE.getFieldExpr_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.BaseUnitImpl <em>Base Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.BaseUnitImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBaseUnit()
     * @generated
     */
    EClass BASE_UNIT = eINSTANCE.getBaseUnit();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.DerivedUnitImpl <em>Derived Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.DerivedUnitImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getDerivedUnit()
     * @generated
     */
    EClass DERIVED_UNIT = eINSTANCE.getDerivedUnit();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DERIVED_UNIT__UNIT = eINSTANCE.getDerivedUnit_Unit();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.BinaryUnitExprImpl <em>Binary Unit Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.BinaryUnitExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBinaryUnitExpr()
     * @generated
     */
    EClass BINARY_UNIT_EXPR = eINSTANCE.getBinaryUnitExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_UNIT_EXPR__LEFT = eINSTANCE.getBinaryUnitExpr_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_UNIT_EXPR__OP = eINSTANCE.getBinaryUnitExpr_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_UNIT_EXPR__RIGHT = eINSTANCE.getBinaryUnitExpr_Right();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.NamedUnitExprImpl <em>Named Unit Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.NamedUnitExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getNamedUnitExpr()
     * @generated
     */
    EClass NAMED_UNIT_EXPR = eINSTANCE.getNamedUnitExpr();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_UNIT_EXPR__UNIT = eINSTANCE.getNamedUnitExpr_Unit();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.NamedTypeDefImpl <em>Named Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.NamedTypeDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getNamedTypeDef()
     * @generated
     */
    EClass NAMED_TYPE_DEF = eINSTANCE.getNamedTypeDef();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_TYPE_DEF__TYPE = eINSTANCE.getNamedTypeDef_Type();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_TYPE_DEF__UNIT = eINSTANCE.getNamedTypeDef_Unit();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.AbstractTypeDefImpl <em>Abstract Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.AbstractTypeDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getAbstractTypeDef()
     * @generated
     */
    EClass ABSTRACT_TYPE_DEF = eINSTANCE.getAbstractTypeDef();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.RecordTypeDefImpl <em>Record Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.RecordTypeDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordTypeDef()
     * @generated
     */
    EClass RECORD_TYPE_DEF = eINSTANCE.getRecordTypeDef();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_TYPE_DEF__FIELDS = eINSTANCE.getRecordTypeDef_Fields();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ArrayTypeDefImpl <em>Array Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ArrayTypeDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayTypeDef()
     * @generated
     */
    EClass ARRAY_TYPE_DEF = eINSTANCE.getArrayTypeDef();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE_DEF__BASE = eINSTANCE.getArrayTypeDef_Base();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE_DEF__SIZE = eINSTANCE.getArrayTypeDef_Size();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.EnumTypeDefImpl <em>Enum Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.EnumTypeDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getEnumTypeDef()
     * @generated
     */
    EClass ENUM_TYPE_DEF = eINSTANCE.getEnumTypeDef();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_TYPE_DEF__VALUES = eINSTANCE.getEnumTypeDef_Values();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ConcreteArrayTypeDefImpl <em>Concrete Array Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ConcreteArrayTypeDefImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getConcreteArrayTypeDef()
     * @generated
     */
    EClass CONCRETE_ARRAY_TYPE_DEF = eINSTANCE.getConcreteArrayTypeDef();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCRETE_ARRAY_TYPE_DEF__BASE = eINSTANCE.getConcreteArrayTypeDef_Base();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONCRETE_ARRAY_TYPE_DEF__SIZE = eINSTANCE.getConcreteArrayTypeDef_Size();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.IntTypeImpl <em>Int Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.IntTypeImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIntType()
     * @generated
     */
    EClass INT_TYPE = eINSTANCE.getIntType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.BoolTypeImpl <em>Bool Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.BoolTypeImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBoolType()
     * @generated
     */
    EClass BOOL_TYPE = eINSTANCE.getBoolType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.RealTypeImpl <em>Real Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.RealTypeImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRealType()
     * @generated
     */
    EClass REAL_TYPE = eINSTANCE.getRealType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.UserTypeImpl <em>User Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.UserTypeImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUserType()
     * @generated
     */
    EClass USER_TYPE = eINSTANCE.getUserType();

    /**
     * The meta object literal for the '<em><b>Def</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USER_TYPE__DEF = eINSTANCE.getUserType_Def();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.WhileExprImpl <em>While Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.WhileExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getWhileExpr()
     * @generated
     */
    EClass WHILE_EXPR = eINSTANCE.getWhileExpr();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_EXPR__COND = eINSTANCE.getWhileExpr_Cond();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_EXPR__THEN = eINSTANCE.getWhileExpr_Then();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.BinaryExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBinaryExpr()
     * @generated
     */
    EClass BINARY_EXPR = eINSTANCE.getBinaryExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__LEFT = eINSTANCE.getBinaryExpr_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_EXPR__OP = eINSTANCE.getBinaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__RIGHT = eINSTANCE.getBinaryExpr_Right();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.AfterUntilExprImpl <em>After Until Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.AfterUntilExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getAfterUntilExpr()
     * @generated
     */
    EClass AFTER_UNTIL_EXPR = eINSTANCE.getAfterUntilExpr();

    /**
     * The meta object literal for the '<em><b>After</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AFTER_UNTIL_EXPR__AFTER = eINSTANCE.getAfterUntilExpr_After();

    /**
     * The meta object literal for the '<em><b>Until</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AFTER_UNTIL_EXPR__UNTIL = eINSTANCE.getAfterUntilExpr_Until();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.UnaryExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getUnaryExpr()
     * @generated
     */
    EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPR__OP = eINSTANCE.getUnaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPR__EXPR = eINSTANCE.getUnaryExpr_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.PreviousExprImpl <em>Previous Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.PreviousExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getPreviousExpr()
     * @generated
     */
    EClass PREVIOUS_EXPR = eINSTANCE.getPreviousExpr();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREVIOUS_EXPR__VAR = eINSTANCE.getPreviousExpr_Var();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREVIOUS_EXPR__INIT = eINSTANCE.getPreviousExpr_Init();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.RecordAccessExprImpl <em>Record Access Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.RecordAccessExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordAccessExpr()
     * @generated
     */
    EClass RECORD_ACCESS_EXPR = eINSTANCE.getRecordAccessExpr();

    /**
     * The meta object literal for the '<em><b>Record</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ACCESS_EXPR__RECORD = eINSTANCE.getRecordAccessExpr_Record();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ACCESS_EXPR__FIELD = eINSTANCE.getRecordAccessExpr_Field();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.RecordUpdateExprImpl <em>Record Update Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.RecordUpdateExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordUpdateExpr()
     * @generated
     */
    EClass RECORD_UPDATE_EXPR = eINSTANCE.getRecordUpdateExpr();

    /**
     * The meta object literal for the '<em><b>Record</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_UPDATE_EXPR__RECORD = eINSTANCE.getRecordUpdateExpr_Record();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_UPDATE_EXPR__FIELD = eINSTANCE.getRecordUpdateExpr_Field();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_UPDATE_EXPR__VALUE = eINSTANCE.getRecordUpdateExpr_Value();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ArrayAccessExprImpl <em>Array Access Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ArrayAccessExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayAccessExpr()
     * @generated
     */
    EClass ARRAY_ACCESS_EXPR = eINSTANCE.getArrayAccessExpr();

    /**
     * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS_EXPR__ARRAY = eINSTANCE.getArrayAccessExpr_Array();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS_EXPR__INDEX = eINSTANCE.getArrayAccessExpr_Index();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ArrayUpdateExprImpl <em>Array Update Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ArrayUpdateExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayUpdateExpr()
     * @generated
     */
    EClass ARRAY_UPDATE_EXPR = eINSTANCE.getArrayUpdateExpr();

    /**
     * The meta object literal for the '<em><b>Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_UPDATE_EXPR__ACCESS = eINSTANCE.getArrayUpdateExpr_Access();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_UPDATE_EXPR__VALUE = eINSTANCE.getArrayUpdateExpr_Value();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.IdExprImpl <em>Id Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.IdExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIdExpr()
     * @generated
     */
    EClass ID_EXPR = eINSTANCE.getIdExpr();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ID_EXPR__ID = eINSTANCE.getIdExpr_Id();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.MultipleIdExprImpl <em>Multiple Id Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.MultipleIdExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getMultipleIdExpr()
     * @generated
     */
    EClass MULTIPLE_ID_EXPR = eINSTANCE.getMultipleIdExpr();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLE_ID_EXPR__IDS = eINSTANCE.getMultipleIdExpr_Ids();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.IfThenElseExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIfThenElseExpr()
     * @generated
     */
    EClass IF_THEN_ELSE_EXPR = eINSTANCE.getIfThenElseExpr();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__COND = eINSTANCE.getIfThenElseExpr_Cond();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__THEN = eINSTANCE.getIfThenElseExpr_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__ELSE = eINSTANCE.getIfThenElseExpr_Else();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.RecordExprImpl <em>Record Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.RecordExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRecordExpr()
     * @generated
     */
    EClass RECORD_EXPR = eINSTANCE.getRecordExpr();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__TYPE = eINSTANCE.getRecordExpr_Type();

    /**
     * The meta object literal for the '<em><b>Field Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__FIELD_EXPRS = eINSTANCE.getRecordExpr_FieldExprs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.FieldlessRecordExprImpl <em>Fieldless Record Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.FieldlessRecordExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getFieldlessRecordExpr()
     * @generated
     */
    EClass FIELDLESS_RECORD_EXPR = eINSTANCE.getFieldlessRecordExpr();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELDLESS_RECORD_EXPR__TYPE = eINSTANCE.getFieldlessRecordExpr_Type();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELDLESS_RECORD_EXPR__EXPRS = eINSTANCE.getFieldlessRecordExpr_Exprs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.ArrayExprImpl <em>Array Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.ArrayExprImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getArrayExpr()
     * @generated
     */
    EClass ARRAY_EXPR = eINSTANCE.getArrayExpr();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_EXPR__TYPE = eINSTANCE.getArrayExpr_Type();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_EXPR__EXPRS = eINSTANCE.getArrayExpr_Exprs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.PatternCallImpl <em>Pattern Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.PatternCallImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getPatternCall()
     * @generated
     */
    EClass PATTERN_CALL = eINSTANCE.getPatternCall();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_CALL__PATTERN = eINSTANCE.getPatternCall_Pattern();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_CALL__ARGS = eINSTANCE.getPatternCall_Args();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.SpecificationCallImpl <em>Specification Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.SpecificationCallImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getSpecificationCall()
     * @generated
     */
    EClass SPECIFICATION_CALL = eINSTANCE.getSpecificationCall();

    /**
     * The meta object literal for the '<em><b>Spec</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION_CALL__SPEC = eINSTANCE.getSpecificationCall_Spec();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION_CALL__ARGS = eINSTANCE.getSpecificationCall_Args();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.IntLiteralImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_LITERAL__UNIT = eINSTANCE.getIntLiteral_Unit();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.BoolLiteralImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getBoolLiteral()
     * @generated
     */
    EClass BOOL_LITERAL = eINSTANCE.getBoolLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_LITERAL__VALUE = eINSTANCE.getBoolLiteral_Value();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.RealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.RealLiteralImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getRealLiteral()
     * @generated
     */
    EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_LITERAL__VALUE = eINSTANCE.getRealLiteral_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REAL_LITERAL__UNIT = eINSTANCE.getRealLiteral_Unit();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.spear.impl.NormalizedCallImpl <em>Normalized Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.spear.impl.NormalizedCallImpl
     * @see com.rockwellcollins.spear.impl.SpearPackageImpl#getNormalizedCall()
     * @generated
     */
    EClass NORMALIZED_CALL = eINSTANCE.getNormalizedCall();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NORMALIZED_CALL__IDS = eINSTANCE.getNormalizedCall_Ids();

    /**
     * The meta object literal for the '<em><b>Spec</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NORMALIZED_CALL__SPEC = eINSTANCE.getNormalizedCall_Spec();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NORMALIZED_CALL__ARGS = eINSTANCE.getNormalizedCall_Args();

  }

} //SpearPackage
