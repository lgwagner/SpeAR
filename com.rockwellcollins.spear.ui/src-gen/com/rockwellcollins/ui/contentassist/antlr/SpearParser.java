/*
 * generated by Xtext
 */
package com.rockwellcollins.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import com.rockwellcollins.services.SpearGrammarAccess;

public class SpearParser extends AbstractContentAssistParser {
	
	@Inject
	private SpearGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected com.rockwellcollins.ui.contentassist.antlr.internal.InternalSpearParser createParser() {
		com.rockwellcollins.ui.contentassist.antlr.internal.InternalSpearParser result = new com.rockwellcollins.ui.contentassist.antlr.internal.InternalSpearParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getFileAccess().getAlternatives(), "rule__File__Alternatives");
					put(grammarAccess.getUnitDefAccess().getAlternatives(), "rule__UnitDef__Alternatives");
					put(grammarAccess.getAtomicUnitExprAccess().getAlternatives(), "rule__AtomicUnitExpr__Alternatives");
					put(grammarAccess.getTypeDefAccess().getAlternatives(), "rule__TypeDef__Alternatives");
					put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
					put(grammarAccess.getIdTypeDelimiterAccess().getAlternatives(), "rule__IdTypeDelimiter__Alternatives");
					put(grammarAccess.getConstraintAccess().getAlternatives(), "rule__Constraint__Alternatives");
					put(grammarAccess.getImpliesExprAccess().getOpAlternatives_1_0_0_1_0(), "rule__ImpliesExpr__OpAlternatives_1_0_0_1_0");
					put(grammarAccess.getOrExprAccess().getOpAlternatives_1_0_0_1_0(), "rule__OrExpr__OpAlternatives_1_0_0_1_0");
					put(grammarAccess.getTriggersExprAccess().getOpAlternatives_1_0_0_1_0(), "rule__TriggersExpr__OpAlternatives_1_0_0_1_0");
					put(grammarAccess.getSinceExprAccess().getOpAlternatives_1_0_0_1_0(), "rule__SinceExpr__OpAlternatives_1_0_0_1_0");
					put(grammarAccess.getTemporalPrefixExprAccess().getAlternatives(), "rule__TemporalPrefixExpr__Alternatives");
					put(grammarAccess.getTemporalPrefixExprAccess().getOpAlternatives_0_1_0(), "rule__TemporalPrefixExpr__OpAlternatives_0_1_0");
					put(grammarAccess.getRelationalOpAccess().getAlternatives(), "rule__RelationalOp__Alternatives");
					put(grammarAccess.getPlusExprAccess().getOpAlternatives_1_0_0_1_0(), "rule__PlusExpr__OpAlternatives_1_0_0_1_0");
					put(grammarAccess.getMultiplyExprAccess().getOpAlternatives_1_0_0_1_0(), "rule__MultiplyExpr__OpAlternatives_1_0_0_1_0");
					put(grammarAccess.getPrefixExprAccess().getAlternatives(), "rule__PrefixExpr__Alternatives");
					put(grammarAccess.getPrefixExprAccess().getOpAlternatives_0_1_0(), "rule__PrefixExpr__OpAlternatives_0_1_0");
					put(grammarAccess.getAccessExprAccess().getAlternatives_1(), "rule__AccessExpr__Alternatives_1");
					put(grammarAccess.getAtomicExprAccess().getAlternatives(), "rule__AtomicExpr__Alternatives");
					put(grammarAccess.getLiteralExprAccess().getAlternatives(), "rule__LiteralExpr__Alternatives");
					put(grammarAccess.getIdRefAccess().getAlternatives(), "rule__IdRef__Alternatives");
					put(grammarAccess.getBOOLAccess().getAlternatives(), "rule__BOOL__Alternatives");
					put(grammarAccess.getBOOLEAN_TRUEAccess().getAlternatives(), "rule__BOOLEAN_TRUE__Alternatives");
					put(grammarAccess.getBOOLEAN_FALSEAccess().getAlternatives(), "rule__BOOLEAN_FALSE__Alternatives");
					put(grammarAccess.getSpecificationAccess().getGroup(), "rule__Specification__Group__0");
					put(grammarAccess.getSpecificationAccess().getGroup_2(), "rule__Specification__Group_2__0");
					put(grammarAccess.getSpecificationAccess().getGroup_3(), "rule__Specification__Group_3__0");
					put(grammarAccess.getSpecificationAccess().getGroup_4(), "rule__Specification__Group_4__0");
					put(grammarAccess.getSpecificationAccess().getGroup_5(), "rule__Specification__Group_5__0");
					put(grammarAccess.getSpecificationAccess().getGroup_10(), "rule__Specification__Group_10__0");
					put(grammarAccess.getSpecificationAccess().getGroup_11(), "rule__Specification__Group_11__0");
					put(grammarAccess.getSpecificationAccess().getGroup_12(), "rule__Specification__Group_12__0");
					put(grammarAccess.getSpecificationAccess().getGroup_15(), "rule__Specification__Group_15__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getDefinitionsAccess().getGroup(), "rule__Definitions__Group__0");
					put(grammarAccess.getDefinitionsAccess().getGroup_2(), "rule__Definitions__Group_2__0");
					put(grammarAccess.getDefinitionsAccess().getGroup_3(), "rule__Definitions__Group_3__0");
					put(grammarAccess.getDefinitionsAccess().getGroup_4(), "rule__Definitions__Group_4__0");
					put(grammarAccess.getPatternsAccess().getGroup(), "rule__Patterns__Group__0");
					put(grammarAccess.getPatternAccess().getGroup(), "rule__Pattern__Group__0");
					put(grammarAccess.getUnitDefAccess().getGroup_0(), "rule__UnitDef__Group_0__0");
					put(grammarAccess.getUnitDefAccess().getGroup_1(), "rule__UnitDef__Group_1__0");
					put(grammarAccess.getProductUnitExprAccess().getGroup(), "rule__ProductUnitExpr__Group__0");
					put(grammarAccess.getProductUnitExprAccess().getGroup_1(), "rule__ProductUnitExpr__Group_1__0");
					put(grammarAccess.getProductUnitExprAccess().getGroup_1_0(), "rule__ProductUnitExpr__Group_1_0__0");
					put(grammarAccess.getProductUnitExprAccess().getGroup_1_0_0(), "rule__ProductUnitExpr__Group_1_0_0__0");
					put(grammarAccess.getDivisionUnitExprAccess().getGroup(), "rule__DivisionUnitExpr__Group__0");
					put(grammarAccess.getDivisionUnitExprAccess().getGroup_1(), "rule__DivisionUnitExpr__Group_1__0");
					put(grammarAccess.getDivisionUnitExprAccess().getGroup_1_0(), "rule__DivisionUnitExpr__Group_1_0__0");
					put(grammarAccess.getDivisionUnitExprAccess().getGroup_1_0_0(), "rule__DivisionUnitExpr__Group_1_0_0__0");
					put(grammarAccess.getAtomicUnitExprAccess().getGroup_0(), "rule__AtomicUnitExpr__Group_0__0");
					put(grammarAccess.getAtomicUnitExprAccess().getGroup_1(), "rule__AtomicUnitExpr__Group_1__0");
					put(grammarAccess.getTypeDefAccess().getGroup_0(), "rule__TypeDef__Group_0__0");
					put(grammarAccess.getTypeDefAccess().getGroup_1(), "rule__TypeDef__Group_1__0");
					put(grammarAccess.getTypeDefAccess().getGroup_1_6(), "rule__TypeDef__Group_1_6__0");
					put(grammarAccess.getTypeDefAccess().getGroup_2(), "rule__TypeDef__Group_2__0");
					put(grammarAccess.getTypeDefAccess().getGroup_3(), "rule__TypeDef__Group_3__0");
					put(grammarAccess.getTypeDefAccess().getGroup_3_6(), "rule__TypeDef__Group_3_6__0");
					put(grammarAccess.getRecordTypeFieldAccess().getGroup(), "rule__RecordTypeField__Group__0");
					put(grammarAccess.getTypeAccess().getGroup_0(), "rule__Type__Group_0__0");
					put(grammarAccess.getTypeAccess().getGroup_1(), "rule__Type__Group_1__0");
					put(grammarAccess.getTypeAccess().getGroup_2(), "rule__Type__Group_2__0");
					put(grammarAccess.getTypeAccess().getGroup_3(), "rule__Type__Group_3__0");
					put(grammarAccess.getConstantAccess().getGroup(), "rule__Constant__Group__0");
					put(grammarAccess.getVariableAccess().getGroup(), "rule__Variable__Group__0");
					put(grammarAccess.getMacroAccess().getGroup(), "rule__Macro__Group__0");
					put(grammarAccess.getFormalConstraintAccess().getGroup(), "rule__FormalConstraint__Group__0");
					put(grammarAccess.getFormalConstraintAccess().getGroup_3(), "rule__FormalConstraint__Group_3__0");
					put(grammarAccess.getEnglishConstraintAccess().getGroup(), "rule__EnglishConstraint__Group__0");
					put(grammarAccess.getImpliesExprAccess().getGroup(), "rule__ImpliesExpr__Group__0");
					put(grammarAccess.getImpliesExprAccess().getGroup_1(), "rule__ImpliesExpr__Group_1__0");
					put(grammarAccess.getImpliesExprAccess().getGroup_1_0(), "rule__ImpliesExpr__Group_1_0__0");
					put(grammarAccess.getImpliesExprAccess().getGroup_1_0_0(), "rule__ImpliesExpr__Group_1_0_0__0");
					put(grammarAccess.getOrExprAccess().getGroup(), "rule__OrExpr__Group__0");
					put(grammarAccess.getOrExprAccess().getGroup_1(), "rule__OrExpr__Group_1__0");
					put(grammarAccess.getOrExprAccess().getGroup_1_0(), "rule__OrExpr__Group_1_0__0");
					put(grammarAccess.getOrExprAccess().getGroup_1_0_0(), "rule__OrExpr__Group_1_0_0__0");
					put(grammarAccess.getAndExprAccess().getGroup(), "rule__AndExpr__Group__0");
					put(grammarAccess.getAndExprAccess().getGroup_1(), "rule__AndExpr__Group_1__0");
					put(grammarAccess.getAndExprAccess().getGroup_1_0(), "rule__AndExpr__Group_1_0__0");
					put(grammarAccess.getAndExprAccess().getGroup_1_0_0(), "rule__AndExpr__Group_1_0_0__0");
					put(grammarAccess.getTriggersExprAccess().getGroup(), "rule__TriggersExpr__Group__0");
					put(grammarAccess.getTriggersExprAccess().getGroup_1(), "rule__TriggersExpr__Group_1__0");
					put(grammarAccess.getTriggersExprAccess().getGroup_1_0(), "rule__TriggersExpr__Group_1_0__0");
					put(grammarAccess.getTriggersExprAccess().getGroup_1_0_0(), "rule__TriggersExpr__Group_1_0_0__0");
					put(grammarAccess.getSinceExprAccess().getGroup(), "rule__SinceExpr__Group__0");
					put(grammarAccess.getSinceExprAccess().getGroup_1(), "rule__SinceExpr__Group_1__0");
					put(grammarAccess.getSinceExprAccess().getGroup_1_0(), "rule__SinceExpr__Group_1_0__0");
					put(grammarAccess.getSinceExprAccess().getGroup_1_0_0(), "rule__SinceExpr__Group_1_0_0__0");
					put(grammarAccess.getTemporalPrefixExprAccess().getGroup_0(), "rule__TemporalPrefixExpr__Group_0__0");
					put(grammarAccess.getRelationalExprAccess().getGroup(), "rule__RelationalExpr__Group__0");
					put(grammarAccess.getRelationalExprAccess().getGroup_1(), "rule__RelationalExpr__Group_1__0");
					put(grammarAccess.getRelationalExprAccess().getGroup_1_0(), "rule__RelationalExpr__Group_1_0__0");
					put(grammarAccess.getRelationalExprAccess().getGroup_1_0_0(), "rule__RelationalExpr__Group_1_0_0__0");
					put(grammarAccess.getPlusExprAccess().getGroup(), "rule__PlusExpr__Group__0");
					put(grammarAccess.getPlusExprAccess().getGroup_1(), "rule__PlusExpr__Group_1__0");
					put(grammarAccess.getPlusExprAccess().getGroup_1_0(), "rule__PlusExpr__Group_1_0__0");
					put(grammarAccess.getPlusExprAccess().getGroup_1_0_0(), "rule__PlusExpr__Group_1_0_0__0");
					put(grammarAccess.getMultiplyExprAccess().getGroup(), "rule__MultiplyExpr__Group__0");
					put(grammarAccess.getMultiplyExprAccess().getGroup_1(), "rule__MultiplyExpr__Group_1__0");
					put(grammarAccess.getMultiplyExprAccess().getGroup_1_0(), "rule__MultiplyExpr__Group_1_0__0");
					put(grammarAccess.getMultiplyExprAccess().getGroup_1_0_0(), "rule__MultiplyExpr__Group_1_0_0__0");
					put(grammarAccess.getPrefixExprAccess().getGroup_0(), "rule__PrefixExpr__Group_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup(), "rule__AccessExpr__Group__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_0(), "rule__AccessExpr__Group_1_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_0_0(), "rule__AccessExpr__Group_1_0_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_0_0_0(), "rule__AccessExpr__Group_1_0_0_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_1(), "rule__AccessExpr__Group_1_1__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_1_0(), "rule__AccessExpr__Group_1_1_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_1_0_0(), "rule__AccessExpr__Group_1_1_0_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_2(), "rule__AccessExpr__Group_1_2__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_2_0(), "rule__AccessExpr__Group_1_2_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_2_0_0(), "rule__AccessExpr__Group_1_2_0_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_2_2(), "rule__AccessExpr__Group_1_2_2__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_2_2_0(), "rule__AccessExpr__Group_1_2_2_0__0");
					put(grammarAccess.getAccessExprAccess().getGroup_1_2_2_0_0(), "rule__AccessExpr__Group_1_2_2_0_0__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_1(), "rule__AtomicExpr__Group_1__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_2(), "rule__AtomicExpr__Group_2__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_2_3(), "rule__AtomicExpr__Group_2_3__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_3(), "rule__AtomicExpr__Group_3__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_4(), "rule__AtomicExpr__Group_4__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_5(), "rule__AtomicExpr__Group_5__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_5_5(), "rule__AtomicExpr__Group_5_5__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_6(), "rule__AtomicExpr__Group_6__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_6_5(), "rule__AtomicExpr__Group_6_5__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_7(), "rule__AtomicExpr__Group_7__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_7_5(), "rule__AtomicExpr__Group_7_5__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_8(), "rule__AtomicExpr__Group_8__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_8_5(), "rule__AtomicExpr__Group_8_5__0");
					put(grammarAccess.getAtomicExprAccess().getGroup_9(), "rule__AtomicExpr__Group_9__0");
					put(grammarAccess.getLiteralExprAccess().getGroup_0(), "rule__LiteralExpr__Group_0__0");
					put(grammarAccess.getLiteralExprAccess().getGroup_1(), "rule__LiteralExpr__Group_1__0");
					put(grammarAccess.getLiteralExprAccess().getGroup_2(), "rule__LiteralExpr__Group_2__0");
					put(grammarAccess.getRecordFieldExprAccess().getGroup(), "rule__RecordFieldExpr__Group__0");
					put(grammarAccess.getREALAccess().getGroup(), "rule__REAL__Group__0");
					put(grammarAccess.getSpecificationAccess().getNameAssignment_1(), "rule__Specification__NameAssignment_1");
					put(grammarAccess.getSpecificationAccess().getImportsAssignment_2_1(), "rule__Specification__ImportsAssignment_2_1");
					put(grammarAccess.getSpecificationAccess().getUnitsAssignment_3_1(), "rule__Specification__UnitsAssignment_3_1");
					put(grammarAccess.getSpecificationAccess().getTypedefsAssignment_4_1(), "rule__Specification__TypedefsAssignment_4_1");
					put(grammarAccess.getSpecificationAccess().getConstantsAssignment_5_1(), "rule__Specification__ConstantsAssignment_5_1");
					put(grammarAccess.getSpecificationAccess().getInputsAssignment_7(), "rule__Specification__InputsAssignment_7");
					put(grammarAccess.getSpecificationAccess().getOutputsAssignment_9(), "rule__Specification__OutputsAssignment_9");
					put(grammarAccess.getSpecificationAccess().getStateAssignment_10_1(), "rule__Specification__StateAssignment_10_1");
					put(grammarAccess.getSpecificationAccess().getMacrosAssignment_11_1(), "rule__Specification__MacrosAssignment_11_1");
					put(grammarAccess.getSpecificationAccess().getAssumptionsAssignment_12_1(), "rule__Specification__AssumptionsAssignment_12_1");
					put(grammarAccess.getSpecificationAccess().getRequirementsAssignment_14(), "rule__Specification__RequirementsAssignment_14");
					put(grammarAccess.getSpecificationAccess().getBehaviorsAssignment_15_1(), "rule__Specification__BehaviorsAssignment_15_1");
					put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
					put(grammarAccess.getDefinitionsAccess().getNameAssignment_1(), "rule__Definitions__NameAssignment_1");
					put(grammarAccess.getDefinitionsAccess().getUnitdefsAssignment_2_1(), "rule__Definitions__UnitdefsAssignment_2_1");
					put(grammarAccess.getDefinitionsAccess().getTypedefsAssignment_3_1(), "rule__Definitions__TypedefsAssignment_3_1");
					put(grammarAccess.getDefinitionsAccess().getConstantsAssignment_4_1(), "rule__Definitions__ConstantsAssignment_4_1");
					put(grammarAccess.getPatternsAccess().getNameAssignment_1(), "rule__Patterns__NameAssignment_1");
					put(grammarAccess.getPatternsAccess().getPatternsAssignment_2(), "rule__Patterns__PatternsAssignment_2");
					put(grammarAccess.getPatternAccess().getNameAssignment_1(), "rule__Pattern__NameAssignment_1");
					put(grammarAccess.getUnitDefAccess().getNameAssignment_0_1(), "rule__UnitDef__NameAssignment_0_1");
					put(grammarAccess.getUnitDefAccess().getDescriptionAssignment_0_2(), "rule__UnitDef__DescriptionAssignment_0_2");
					put(grammarAccess.getUnitDefAccess().getNameAssignment_1_1(), "rule__UnitDef__NameAssignment_1_1");
					put(grammarAccess.getUnitDefAccess().getUnitAssignment_1_3(), "rule__UnitDef__UnitAssignment_1_3");
					put(grammarAccess.getUnitDefAccess().getDescriptionAssignment_1_4(), "rule__UnitDef__DescriptionAssignment_1_4");
					put(grammarAccess.getProductUnitExprAccess().getOpAssignment_1_0_0_1(), "rule__ProductUnitExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getProductUnitExprAccess().getRightAssignment_1_1(), "rule__ProductUnitExpr__RightAssignment_1_1");
					put(grammarAccess.getDivisionUnitExprAccess().getOpAssignment_1_0_0_1(), "rule__DivisionUnitExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getDivisionUnitExprAccess().getRightAssignment_1_1(), "rule__DivisionUnitExpr__RightAssignment_1_1");
					put(grammarAccess.getAtomicUnitExprAccess().getUnitAssignment_0_1(), "rule__AtomicUnitExpr__UnitAssignment_0_1");
					put(grammarAccess.getTypeDefAccess().getNameAssignment_0_1(), "rule__TypeDef__NameAssignment_0_1");
					put(grammarAccess.getTypeDefAccess().getTypeAssignment_0_3(), "rule__TypeDef__TypeAssignment_0_3");
					put(grammarAccess.getTypeDefAccess().getUnitAssignment_0_4(), "rule__TypeDef__UnitAssignment_0_4");
					put(grammarAccess.getTypeDefAccess().getNameAssignment_1_1(), "rule__TypeDef__NameAssignment_1_1");
					put(grammarAccess.getTypeDefAccess().getFieldsAssignment_1_5(), "rule__TypeDef__FieldsAssignment_1_5");
					put(grammarAccess.getTypeDefAccess().getFieldsAssignment_1_6_1(), "rule__TypeDef__FieldsAssignment_1_6_1");
					put(grammarAccess.getTypeDefAccess().getNameAssignment_2_1(), "rule__TypeDef__NameAssignment_2_1");
					put(grammarAccess.getTypeDefAccess().getBaseAssignment_2_3(), "rule__TypeDef__BaseAssignment_2_3");
					put(grammarAccess.getTypeDefAccess().getSizeAssignment_2_5(), "rule__TypeDef__SizeAssignment_2_5");
					put(grammarAccess.getTypeDefAccess().getNameAssignment_3_1(), "rule__TypeDef__NameAssignment_3_1");
					put(grammarAccess.getTypeDefAccess().getValuesAssignment_3_5(), "rule__TypeDef__ValuesAssignment_3_5");
					put(grammarAccess.getTypeDefAccess().getValuesAssignment_3_6_1(), "rule__TypeDef__ValuesAssignment_3_6_1");
					put(grammarAccess.getRecordTypeFieldAccess().getNameAssignment_0(), "rule__RecordTypeField__NameAssignment_0");
					put(grammarAccess.getRecordTypeFieldAccess().getTypeAssignment_2(), "rule__RecordTypeField__TypeAssignment_2");
					put(grammarAccess.getEnumValueAccess().getNameAssignment(), "rule__EnumValue__NameAssignment");
					put(grammarAccess.getTypeAccess().getDefAssignment_3_1(), "rule__Type__DefAssignment_3_1");
					put(grammarAccess.getConstantAccess().getNameAssignment_0(), "rule__Constant__NameAssignment_0");
					put(grammarAccess.getConstantAccess().getTypeAssignment_2(), "rule__Constant__TypeAssignment_2");
					put(grammarAccess.getConstantAccess().getExprAssignment_4(), "rule__Constant__ExprAssignment_4");
					put(grammarAccess.getVariableAccess().getNameAssignment_0(), "rule__Variable__NameAssignment_0");
					put(grammarAccess.getVariableAccess().getTypeAssignment_2(), "rule__Variable__TypeAssignment_2");
					put(grammarAccess.getMacroAccess().getNameAssignment_0(), "rule__Macro__NameAssignment_0");
					put(grammarAccess.getMacroAccess().getTypeAssignment_2(), "rule__Macro__TypeAssignment_2");
					put(grammarAccess.getMacroAccess().getExprAssignment_4(), "rule__Macro__ExprAssignment_4");
					put(grammarAccess.getFormalConstraintAccess().getNameAssignment_0(), "rule__FormalConstraint__NameAssignment_0");
					put(grammarAccess.getFormalConstraintAccess().getExprAssignment_2(), "rule__FormalConstraint__ExprAssignment_2");
					put(grammarAccess.getFormalConstraintAccess().getDescriptorAssignment_3_2(), "rule__FormalConstraint__DescriptorAssignment_3_2");
					put(grammarAccess.getEnglishConstraintAccess().getNameAssignment_0(), "rule__EnglishConstraint__NameAssignment_0");
					put(grammarAccess.getEnglishConstraintAccess().getTextAssignment_2(), "rule__EnglishConstraint__TextAssignment_2");
					put(grammarAccess.getImpliesExprAccess().getOpAssignment_1_0_0_1(), "rule__ImpliesExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getImpliesExprAccess().getRightAssignment_1_1(), "rule__ImpliesExpr__RightAssignment_1_1");
					put(grammarAccess.getOrExprAccess().getOpAssignment_1_0_0_1(), "rule__OrExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getOrExprAccess().getRightAssignment_1_1(), "rule__OrExpr__RightAssignment_1_1");
					put(grammarAccess.getAndExprAccess().getOpAssignment_1_0_0_1(), "rule__AndExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getAndExprAccess().getRightAssignment_1_1(), "rule__AndExpr__RightAssignment_1_1");
					put(grammarAccess.getTriggersExprAccess().getOpAssignment_1_0_0_1(), "rule__TriggersExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getTriggersExprAccess().getRightAssignment_1_1(), "rule__TriggersExpr__RightAssignment_1_1");
					put(grammarAccess.getSinceExprAccess().getOpAssignment_1_0_0_1(), "rule__SinceExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getSinceExprAccess().getRightAssignment_1_1(), "rule__SinceExpr__RightAssignment_1_1");
					put(grammarAccess.getTemporalPrefixExprAccess().getOpAssignment_0_1(), "rule__TemporalPrefixExpr__OpAssignment_0_1");
					put(grammarAccess.getTemporalPrefixExprAccess().getExprAssignment_0_2(), "rule__TemporalPrefixExpr__ExprAssignment_0_2");
					put(grammarAccess.getRelationalExprAccess().getOpAssignment_1_0_0_1(), "rule__RelationalExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getRelationalExprAccess().getRightAssignment_1_1(), "rule__RelationalExpr__RightAssignment_1_1");
					put(grammarAccess.getPlusExprAccess().getOpAssignment_1_0_0_1(), "rule__PlusExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getPlusExprAccess().getRightAssignment_1_1(), "rule__PlusExpr__RightAssignment_1_1");
					put(grammarAccess.getMultiplyExprAccess().getOpAssignment_1_0_0_1(), "rule__MultiplyExpr__OpAssignment_1_0_0_1");
					put(grammarAccess.getMultiplyExprAccess().getRightAssignment_1_1(), "rule__MultiplyExpr__RightAssignment_1_1");
					put(grammarAccess.getPrefixExprAccess().getOpAssignment_0_1(), "rule__PrefixExpr__OpAssignment_0_1");
					put(grammarAccess.getPrefixExprAccess().getExprAssignment_0_2(), "rule__PrefixExpr__ExprAssignment_0_2");
					put(grammarAccess.getAccessExprAccess().getFieldAssignment_1_0_1(), "rule__AccessExpr__FieldAssignment_1_0_1");
					put(grammarAccess.getAccessExprAccess().getFieldAssignment_1_1_0_0_2(), "rule__AccessExpr__FieldAssignment_1_1_0_0_2");
					put(grammarAccess.getAccessExprAccess().getValueAssignment_1_1_1(), "rule__AccessExpr__ValueAssignment_1_1_1");
					put(grammarAccess.getAccessExprAccess().getIndexAssignment_1_2_1(), "rule__AccessExpr__IndexAssignment_1_2_1");
					put(grammarAccess.getAccessExprAccess().getValueAssignment_1_2_2_1(), "rule__AccessExpr__ValueAssignment_1_2_2_1");
					put(grammarAccess.getAtomicExprAccess().getIdAssignment_1_1(), "rule__AtomicExpr__IdAssignment_1_1");
					put(grammarAccess.getAtomicExprAccess().getIdsAssignment_2_2(), "rule__AtomicExpr__IdsAssignment_2_2");
					put(grammarAccess.getAtomicExprAccess().getIdsAssignment_2_3_1(), "rule__AtomicExpr__IdsAssignment_2_3_1");
					put(grammarAccess.getAtomicExprAccess().getVarAssignment_3_3(), "rule__AtomicExpr__VarAssignment_3_3");
					put(grammarAccess.getAtomicExprAccess().getInitAssignment_3_5(), "rule__AtomicExpr__InitAssignment_3_5");
					put(grammarAccess.getAtomicExprAccess().getCondAssignment_4_2(), "rule__AtomicExpr__CondAssignment_4_2");
					put(grammarAccess.getAtomicExprAccess().getThenAssignment_4_4(), "rule__AtomicExpr__ThenAssignment_4_4");
					put(grammarAccess.getAtomicExprAccess().getElseAssignment_4_6(), "rule__AtomicExpr__ElseAssignment_4_6");
					put(grammarAccess.getAtomicExprAccess().getTypeAssignment_5_2(), "rule__AtomicExpr__TypeAssignment_5_2");
					put(grammarAccess.getAtomicExprAccess().getFieldExprsAssignment_5_4(), "rule__AtomicExpr__FieldExprsAssignment_5_4");
					put(grammarAccess.getAtomicExprAccess().getFieldExprsAssignment_5_5_1(), "rule__AtomicExpr__FieldExprsAssignment_5_5_1");
					put(grammarAccess.getAtomicExprAccess().getTypeAssignment_6_2(), "rule__AtomicExpr__TypeAssignment_6_2");
					put(grammarAccess.getAtomicExprAccess().getExprsAssignment_6_4(), "rule__AtomicExpr__ExprsAssignment_6_4");
					put(grammarAccess.getAtomicExprAccess().getExprsAssignment_6_5_1(), "rule__AtomicExpr__ExprsAssignment_6_5_1");
					put(grammarAccess.getAtomicExprAccess().getPatternAssignment_7_2(), "rule__AtomicExpr__PatternAssignment_7_2");
					put(grammarAccess.getAtomicExprAccess().getArgsAssignment_7_4(), "rule__AtomicExpr__ArgsAssignment_7_4");
					put(grammarAccess.getAtomicExprAccess().getArgsAssignment_7_5_1(), "rule__AtomicExpr__ArgsAssignment_7_5_1");
					put(grammarAccess.getAtomicExprAccess().getSpecAssignment_8_2(), "rule__AtomicExpr__SpecAssignment_8_2");
					put(grammarAccess.getAtomicExprAccess().getArgsAssignment_8_4(), "rule__AtomicExpr__ArgsAssignment_8_4");
					put(grammarAccess.getAtomicExprAccess().getArgsAssignment_8_5_1(), "rule__AtomicExpr__ArgsAssignment_8_5_1");
					put(grammarAccess.getLiteralExprAccess().getValueAssignment_0_1(), "rule__LiteralExpr__ValueAssignment_0_1");
					put(grammarAccess.getLiteralExprAccess().getUnitAssignment_0_2(), "rule__LiteralExpr__UnitAssignment_0_2");
					put(grammarAccess.getLiteralExprAccess().getValueAssignment_1_1(), "rule__LiteralExpr__ValueAssignment_1_1");
					put(grammarAccess.getLiteralExprAccess().getValueAssignment_2_1(), "rule__LiteralExpr__ValueAssignment_2_1");
					put(grammarAccess.getLiteralExprAccess().getUnitAssignment_2_2(), "rule__LiteralExpr__UnitAssignment_2_2");
					put(grammarAccess.getRecordFieldExprAccess().getNameAssignment_0(), "rule__RecordFieldExpr__NameAssignment_0");
					put(grammarAccess.getRecordFieldExprAccess().getExprAssignment_2(), "rule__RecordFieldExpr__ExprAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			com.rockwellcollins.ui.contentassist.antlr.internal.InternalSpearParser typedParser = (com.rockwellcollins.ui.contentassist.antlr.internal.InternalSpearParser) parser;
			typedParser.entryRuleFile();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public SpearGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SpearGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
