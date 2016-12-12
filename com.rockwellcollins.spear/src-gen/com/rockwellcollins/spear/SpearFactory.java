/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.rockwellcollins.spear.SpearPackage
 * @generated
 */
public interface SpearFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SpearFactory eINSTANCE = com.rockwellcollins.spear.impl.SpearFactoryImpl.init();

  /**
   * Returns a new object of class '<em>File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>File</em>'.
   * @generated
   */
  File createFile();

  /**
   * Returns a new object of class '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification</em>'.
   * @generated
   */
  Specification createSpecification();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Definitions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Definitions</em>'.
   * @generated
   */
  Definitions createDefinitions();

  /**
   * Returns a new object of class '<em>Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern</em>'.
   * @generated
   */
  Pattern createPattern();

  /**
   * Returns a new object of class '<em>Lustre Equation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lustre Equation</em>'.
   * @generated
   */
  LustreEquation createLustreEquation();

  /**
   * Returns a new object of class '<em>Lustre Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lustre Property</em>'.
   * @generated
   */
  LustreProperty createLustreProperty();

  /**
   * Returns a new object of class '<em>Lustre Assertion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lustre Assertion</em>'.
   * @generated
   */
  LustreAssertion createLustreAssertion();

  /**
   * Returns a new object of class '<em>Unit Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Def</em>'.
   * @generated
   */
  UnitDef createUnitDef();

  /**
   * Returns a new object of class '<em>Unit Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Expr</em>'.
   * @generated
   */
  UnitExpr createUnitExpr();

  /**
   * Returns a new object of class '<em>Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Def</em>'.
   * @generated
   */
  TypeDef createTypeDef();

  /**
   * Returns a new object of class '<em>Field Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Type</em>'.
   * @generated
   */
  FieldType createFieldType();

  /**
   * Returns a new object of class '<em>Enum Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Value</em>'.
   * @generated
   */
  EnumValue createEnumValue();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant</em>'.
   * @generated
   */
  Constant createConstant();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Macro</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro</em>'.
   * @generated
   */
  Macro createMacro();

  /**
   * Returns a new object of class '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint</em>'.
   * @generated
   */
  Constraint createConstraint();

  /**
   * Returns a new object of class '<em>Formal Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Constraint</em>'.
   * @generated
   */
  FormalConstraint createFormalConstraint();

  /**
   * Returns a new object of class '<em>English Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>English Constraint</em>'.
   * @generated
   */
  EnglishConstraint createEnglishConstraint();

  /**
   * Returns a new object of class '<em>Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expr</em>'.
   * @generated
   */
  Expr createExpr();

  /**
   * Returns a new object of class '<em>Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Expr</em>'.
   * @generated
   */
  LiteralExpr createLiteralExpr();

  /**
   * Returns a new object of class '<em>Id Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Id Ref</em>'.
   * @generated
   */
  IdRef createIdRef();

  /**
   * Returns a new object of class '<em>Field Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Expr</em>'.
   * @generated
   */
  FieldExpr createFieldExpr();

  /**
   * Returns a new object of class '<em>Base Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Base Unit</em>'.
   * @generated
   */
  BaseUnit createBaseUnit();

  /**
   * Returns a new object of class '<em>Derived Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Derived Unit</em>'.
   * @generated
   */
  DerivedUnit createDerivedUnit();

  /**
   * Returns a new object of class '<em>Binary Unit Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Unit Expr</em>'.
   * @generated
   */
  BinaryUnitExpr createBinaryUnitExpr();

  /**
   * Returns a new object of class '<em>Named Unit Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Unit Expr</em>'.
   * @generated
   */
  NamedUnitExpr createNamedUnitExpr();

  /**
   * Returns a new object of class '<em>Named Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Type Def</em>'.
   * @generated
   */
  NamedTypeDef createNamedTypeDef();

  /**
   * Returns a new object of class '<em>Abstract Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Type Def</em>'.
   * @generated
   */
  AbstractTypeDef createAbstractTypeDef();

  /**
   * Returns a new object of class '<em>Record Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Type Def</em>'.
   * @generated
   */
  RecordTypeDef createRecordTypeDef();

  /**
   * Returns a new object of class '<em>Array Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Type Def</em>'.
   * @generated
   */
  ArrayTypeDef createArrayTypeDef();

  /**
   * Returns a new object of class '<em>Enum Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Type Def</em>'.
   * @generated
   */
  EnumTypeDef createEnumTypeDef();

  /**
   * Returns a new object of class '<em>Concrete Array Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concrete Array Type Def</em>'.
   * @generated
   */
  ConcreteArrayTypeDef createConcreteArrayTypeDef();

  /**
   * Returns a new object of class '<em>Int Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Type</em>'.
   * @generated
   */
  IntType createIntType();

  /**
   * Returns a new object of class '<em>Bool Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Type</em>'.
   * @generated
   */
  BoolType createBoolType();

  /**
   * Returns a new object of class '<em>Real Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Type</em>'.
   * @generated
   */
  RealType createRealType();

  /**
   * Returns a new object of class '<em>User Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User Type</em>'.
   * @generated
   */
  UserType createUserType();

  /**
   * Returns a new object of class '<em>While Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Expr</em>'.
   * @generated
   */
  WhileExpr createWhileExpr();

  /**
   * Returns a new object of class '<em>Binary Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Expr</em>'.
   * @generated
   */
  BinaryExpr createBinaryExpr();

  /**
   * Returns a new object of class '<em>After Until Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>After Until Expr</em>'.
   * @generated
   */
  AfterUntilExpr createAfterUntilExpr();

  /**
   * Returns a new object of class '<em>Unary Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expr</em>'.
   * @generated
   */
  UnaryExpr createUnaryExpr();

  /**
   * Returns a new object of class '<em>Previous Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Previous Expr</em>'.
   * @generated
   */
  PreviousExpr createPreviousExpr();

  /**
   * Returns a new object of class '<em>Record Access Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Access Expr</em>'.
   * @generated
   */
  RecordAccessExpr createRecordAccessExpr();

  /**
   * Returns a new object of class '<em>Record Update Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Update Expr</em>'.
   * @generated
   */
  RecordUpdateExpr createRecordUpdateExpr();

  /**
   * Returns a new object of class '<em>Array Access Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Access Expr</em>'.
   * @generated
   */
  ArrayAccessExpr createArrayAccessExpr();

  /**
   * Returns a new object of class '<em>Array Update Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Update Expr</em>'.
   * @generated
   */
  ArrayUpdateExpr createArrayUpdateExpr();

  /**
   * Returns a new object of class '<em>Id Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Id Expr</em>'.
   * @generated
   */
  IdExpr createIdExpr();

  /**
   * Returns a new object of class '<em>Multiple Id Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiple Id Expr</em>'.
   * @generated
   */
  MultipleIdExpr createMultipleIdExpr();

  /**
   * Returns a new object of class '<em>If Then Else Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Then Else Expr</em>'.
   * @generated
   */
  IfThenElseExpr createIfThenElseExpr();

  /**
   * Returns a new object of class '<em>Record Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Expr</em>'.
   * @generated
   */
  RecordExpr createRecordExpr();

  /**
   * Returns a new object of class '<em>Fieldless Record Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fieldless Record Expr</em>'.
   * @generated
   */
  FieldlessRecordExpr createFieldlessRecordExpr();

  /**
   * Returns a new object of class '<em>Array Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Expr</em>'.
   * @generated
   */
  ArrayExpr createArrayExpr();

  /**
   * Returns a new object of class '<em>Pattern Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Call</em>'.
   * @generated
   */
  PatternCall createPatternCall();

  /**
   * Returns a new object of class '<em>Specification Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification Call</em>'.
   * @generated
   */
  SpecificationCall createSpecificationCall();

  /**
   * Returns a new object of class '<em>Int Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Literal</em>'.
   * @generated
   */
  IntLiteral createIntLiteral();

  /**
   * Returns a new object of class '<em>Bool Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Literal</em>'.
   * @generated
   */
  BoolLiteral createBoolLiteral();

  /**
   * Returns a new object of class '<em>Real Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Literal</em>'.
   * @generated
   */
  RealLiteral createRealLiteral();

  /**
   * Returns a new object of class '<em>Normalized Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Normalized Call</em>'.
   * @generated
   */
  NormalizedCall createNormalizedCall();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SpearPackage getSpearPackage();

} //SpearFactory
