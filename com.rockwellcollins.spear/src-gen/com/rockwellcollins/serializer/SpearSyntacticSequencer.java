/*
 * generated by Xtext
 */
package com.rockwellcollins.serializer;

import com.google.inject.Inject;
import com.rockwellcollins.services.SpearGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SpearSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SpearGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AtomicExpr_LeftParenthesisKeyword_10_0_a;
	protected AbstractElementAlias match_AtomicExpr_LeftParenthesisKeyword_10_0_p;
	protected AbstractElementAlias match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_Definitions_ConstantsKeyword_5_0_q;
	protected AbstractElementAlias match_Definitions_ImportsKeyword_2_0_q;
	protected AbstractElementAlias match_Definitions_PatternsKeyword_6_0_q;
	protected AbstractElementAlias match_Definitions_TypesKeyword_4_0_q;
	protected AbstractElementAlias match_Definitions_UnitsKeyword_3_0_q;
	protected AbstractElementAlias match_Pattern_VarKeyword_9_0_q;
	protected AbstractElementAlias match_Specification_ConstantsKeyword_5_0_q;
	protected AbstractElementAlias match_Specification_ImportsKeyword_2_0_q;
	protected AbstractElementAlias match_Specification_MacrosKeyword_12_0_q;
	protected AbstractElementAlias match_Specification_PatternsKeyword_6_0_q;
	protected AbstractElementAlias match_Specification_StateKeyword_11_0_q;
	protected AbstractElementAlias match_Specification_TypesKeyword_4_0_q;
	protected AbstractElementAlias match_Specification_UnitsKeyword_3_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SpearGrammarAccess) access;
		match_AtomicExpr_LeftParenthesisKeyword_10_0_a = new TokenAlias(true, true, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_10_0());
		match_AtomicExpr_LeftParenthesisKeyword_10_0_p = new TokenAlias(true, false, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_10_0());
		match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
		match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
		match_Definitions_ConstantsKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getConstantsKeyword_5_0());
		match_Definitions_ImportsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getImportsKeyword_2_0());
		match_Definitions_PatternsKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getPatternsKeyword_6_0());
		match_Definitions_TypesKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getTypesKeyword_4_0());
		match_Definitions_UnitsKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getUnitsKeyword_3_0());
		match_Pattern_VarKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getPatternAccess().getVarKeyword_9_0());
		match_Specification_ConstantsKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getConstantsKeyword_5_0());
		match_Specification_ImportsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getImportsKeyword_2_0());
		match_Specification_MacrosKeyword_12_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getMacrosKeyword_12_0());
		match_Specification_PatternsKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getPatternsKeyword_6_0());
		match_Specification_StateKeyword_11_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getStateKeyword_11_0());
		match_Specification_TypesKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getTypesKeyword_4_0());
		match_Specification_UnitsKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getUnitsKeyword_3_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getIdTypeDelimiterRule())
			return getIdTypeDelimiterToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * IdTypeDelimiter:
	 * 	':'
	 * 	| 'is a'
	 * 	| 'is an';
	 */
	protected String getIdTypeDelimiterToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ":";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_AtomicExpr_LeftParenthesisKeyword_10_0_a.equals(syntax))
				emit_AtomicExpr_LeftParenthesisKeyword_10_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AtomicExpr_LeftParenthesisKeyword_10_0_p.equals(syntax))
				emit_AtomicExpr_LeftParenthesisKeyword_10_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_ConstantsKeyword_5_0_q.equals(syntax))
				emit_Definitions_ConstantsKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_ImportsKeyword_2_0_q.equals(syntax))
				emit_Definitions_ImportsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_PatternsKeyword_6_0_q.equals(syntax))
				emit_Definitions_PatternsKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_TypesKeyword_4_0_q.equals(syntax))
				emit_Definitions_TypesKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_UnitsKeyword_3_0_q.equals(syntax))
				emit_Definitions_UnitsKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Pattern_VarKeyword_9_0_q.equals(syntax))
				emit_Pattern_VarKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_ConstantsKeyword_5_0_q.equals(syntax))
				emit_Specification_ConstantsKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_ImportsKeyword_2_0_q.equals(syntax))
				emit_Specification_ImportsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_MacrosKeyword_12_0_q.equals(syntax))
				emit_Specification_MacrosKeyword_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_PatternsKeyword_6_0_q.equals(syntax))
				emit_Specification_PatternsKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_StateKeyword_11_0_q.equals(syntax))
				emit_Specification_StateKeyword_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_TypesKeyword_4_0_q.equals(syntax))
				emit_Specification_TypesKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_UnitsKeyword_3_0_q.equals(syntax))
				emit_Specification_UnitsKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' ids+=[IdRef|ID]
	 *     (rule start) (ambiguity) 'after' after=TriggersExpr
	 *     (rule start) (ambiguity) 'if' cond=Expr
	 *     (rule start) (ambiguity) 'new' type=[ArrayTypeDef|ID]
	 *     (rule start) (ambiguity) 'new' type=[RecordTypeDef|ID]
	 *     (rule start) (ambiguity) 'previous' var=PrefixExpr
	 *     (rule start) (ambiguity) 'spec' spec=[Specification|ID]
	 *     (rule start) (ambiguity) 'while' cond=Expr
	 *     (rule start) (ambiguity) '|' ids+=[IdRef|ID]
	 *     (rule start) (ambiguity) id=[IdRef|ID]
	 *     (rule start) (ambiguity) op='-'
	 *     (rule start) (ambiguity) op='H'
	 *     (rule start) (ambiguity) op='O'
	 *     (rule start) (ambiguity) op='before'
	 *     (rule start) (ambiguity) op='historically'
	 *     (rule start) (ambiguity) op='initially'
	 *     (rule start) (ambiguity) op='never'
	 *     (rule start) (ambiguity) op='not'
	 *     (rule start) (ambiguity) op='once'
	 *     (rule start) (ambiguity) pattern=[Pattern|ID]
	 *     (rule start) (ambiguity) value=BOOL
	 *     (rule start) (ambiguity) value=INT
	 *     (rule start) (ambiguity) value=REAL
	 *     (rule start) (ambiguity) {ArrayAccessExpr.array=}
	 *     (rule start) (ambiguity) {ArrayUpdateExpr.access=}
	 *     (rule start) (ambiguity) {BinaryExpr.left=}
	 *     (rule start) (ambiguity) {RecordAccessExpr.record=}
	 *     (rule start) (ambiguity) {RecordUpdateExpr.record=}
	 */
	protected void emit_AtomicExpr_LeftParenthesisKeyword_10_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'after' after=TriggersExpr
	 *     (rule start) (ambiguity) 'previous' var=PrefixExpr
	 *     (rule start) (ambiguity) 'while' cond=Expr
	 *     (rule start) (ambiguity) op='-'
	 *     (rule start) (ambiguity) op='H'
	 *     (rule start) (ambiguity) op='O'
	 *     (rule start) (ambiguity) op='before'
	 *     (rule start) (ambiguity) op='historically'
	 *     (rule start) (ambiguity) op='initially'
	 *     (rule start) (ambiguity) op='never'
	 *     (rule start) (ambiguity) op='not'
	 *     (rule start) (ambiguity) op='once'
	 *     (rule start) (ambiguity) {ArrayAccessExpr.array=}
	 *     (rule start) (ambiguity) {ArrayUpdateExpr.access=}
	 *     (rule start) (ambiguity) {BinaryExpr.left=}
	 *     (rule start) (ambiguity) {RecordAccessExpr.record=}
	 *     (rule start) (ambiguity) {RecordUpdateExpr.record=}
	 */
	protected void emit_AtomicExpr_LeftParenthesisKeyword_10_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) unit=[UnitDef|ID]
	 *     (rule start) (ambiguity) {BinaryUnitExpr.left=}
	 */
	protected void emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {BinaryUnitExpr.left=}
	 */
	protected void emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Constants:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:' patterns+=Pattern
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? (rule end)
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:' patterns+=Pattern
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? (rule end)
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:' patterns+=Pattern
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:'? (rule end)
	 *     unitdefs+=UnitDef 'Types:'? (ambiguity) 'Patterns:' patterns+=Pattern
	 *     unitdefs+=UnitDef 'Types:'? (ambiguity) 'Patterns:'? (rule end)
	 */
	protected void emit_Definitions_ConstantsKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Imports:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) 'Units:' unitdefs+=UnitDef
	 *     name=ID (ambiguity) 'Units:'? 'Types:' typedefs+=TypeDef
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:' constants+=Constant
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? (rule end)
	 */
	protected void emit_Definitions_ImportsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Patterns:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     constants+=Constant (ambiguity) (rule end)
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? (ambiguity) (rule end)
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? (ambiguity) (rule end)
	 *     typedefs+=TypeDef 'Constants:'? (ambiguity) (rule end)
	 *     unitdefs+=UnitDef 'Types:'? 'Constants:'? (ambiguity) (rule end)
	 */
	protected void emit_Definitions_PatternsKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Types:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:' constants+=Constant
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? (rule end)
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:' constants+=Constant
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? (rule end)
	 *     unitdefs+=UnitDef (ambiguity) 'Constants:' constants+=Constant
	 *     unitdefs+=UnitDef (ambiguity) 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     unitdefs+=UnitDef (ambiguity) 'Constants:'? 'Patterns:'? (rule end)
	 */
	protected void emit_Definitions_TypesKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Units:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import (ambiguity) 'Types:' typedefs+=TypeDef
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:' constants+=Constant
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? (rule end)
	 *     name=ID 'Imports:'? (ambiguity) 'Types:' typedefs+=TypeDef
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:' constants+=Constant
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? (rule end)
	 */
	protected void emit_Definitions_UnitsKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'var'?
	 *
	 * This ambiguous syntax occurs at:
	 *     inputs+=Variable ')' 'returns' '(' ')' (ambiguity) 'let' 'tel' (rule end)
	 *     inputs+=Variable ')' 'returns' '(' ')' (ambiguity) 'let' assertions+=LustreAssertion
	 *     inputs+=Variable ')' 'returns' '(' ')' (ambiguity) 'let' equations+=LustreEquation
	 *     inputs+=Variable ')' 'returns' '(' ')' (ambiguity) 'let' properties+=LustreProperty
	 *     name=ID '(' ')' 'returns' '(' ')' (ambiguity) 'let' 'tel' (rule end)
	 *     name=ID '(' ')' 'returns' '(' ')' (ambiguity) 'let' assertions+=LustreAssertion
	 *     name=ID '(' ')' 'returns' '(' ')' (ambiguity) 'let' equations+=LustreEquation
	 *     name=ID '(' ')' 'returns' '(' ')' (ambiguity) 'let' properties+=LustreProperty
	 *     outputs+=Variable ')' (ambiguity) 'let' 'tel' (rule end)
	 *     outputs+=Variable ')' (ambiguity) 'let' assertions+=LustreAssertion
	 *     outputs+=Variable ')' (ambiguity) 'let' equations+=LustreEquation
	 *     outputs+=Variable ')' (ambiguity) 'let' properties+=LustreProperty
	 */
	protected void emit_Pattern_VarKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Constants:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:' patterns+=Pattern
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' inputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:' patterns+=Pattern
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' inputs+=Variable
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:' patterns+=Pattern
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     typedefs+=TypeDef (ambiguity) 'Patterns:'? 'Inputs:' inputs+=Variable
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Patterns:' patterns+=Pattern
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Patterns:'? 'Inputs:' inputs+=Variable
	 */
	protected void emit_Specification_ConstantsKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Imports:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) 'Units:' units+=UnitDef
	 *     name=ID (ambiguity) 'Units:'? 'Types:' typedefs+=TypeDef
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:' constants+=Constant
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' inputs+=Variable
	 */
	protected void emit_Specification_ImportsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Macros:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     constants+=Constant 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     constants+=Constant 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 *     inputs+=Variable 'Outputs:' 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     inputs+=Variable 'Outputs:' 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 *     outputs+=Variable 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     outputs+=Variable 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 *     patterns+=Pattern 'Inputs:' 'Outputs:' 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     patterns+=Pattern 'Inputs:' 'Outputs:' 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 *     state+=Variable (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     state+=Variable (ambiguity) requirementsKeyword=RequirementsHeader
	 *     typedefs+=TypeDef 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     typedefs+=TypeDef 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) assumptionsKeyword=AssumptionsHeader
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) requirementsKeyword=RequirementsHeader
	 */
	protected void emit_Specification_MacrosKeyword_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Patterns:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     constants+=Constant (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     constants+=Constant (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     constants+=Constant (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     constants+=Constant (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     constants+=Constant (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     constants+=Constant (ambiguity) 'Inputs:' inputs+=Variable
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' inputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' inputs+=Variable
	 *     typedefs+=TypeDef 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     typedefs+=TypeDef 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     typedefs+=TypeDef 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     typedefs+=TypeDef 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     typedefs+=TypeDef 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     typedefs+=TypeDef 'Constants:'? (ambiguity) 'Inputs:' inputs+=Variable
	 *     units+=UnitDef 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     units+=UnitDef 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     units+=UnitDef 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     units+=UnitDef 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     units+=UnitDef 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     units+=UnitDef 'Types:'? 'Constants:'? (ambiguity) 'Inputs:' inputs+=Variable
	 */
	protected void emit_Specification_PatternsKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'State:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     constants+=Constant 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     constants+=Constant 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     constants+=Constant 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     outputs+=Variable (ambiguity) 'Macros:' macros+=Macro
	 *     outputs+=Variable (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     outputs+=Variable (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     patterns+=Pattern 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     patterns+=Pattern 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     patterns+=Pattern 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     typedefs+=TypeDef 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     typedefs+=TypeDef 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     typedefs+=TypeDef 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? requirementsKeyword=RequirementsHeader
	 */
	protected void emit_Specification_StateKeyword_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Types:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:' constants+=Constant
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' inputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:' constants+=Constant
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' inputs+=Variable
	 *     units+=UnitDef (ambiguity) 'Constants:' constants+=Constant
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Patterns:'? 'Inputs:' inputs+=Variable
	 */
	protected void emit_Specification_TypesKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Units:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import (ambiguity) 'Types:' typedefs+=TypeDef
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:' constants+=Constant
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' inputs+=Variable
	 *     name=ID 'Imports:'? (ambiguity) 'Types:' typedefs+=TypeDef
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:' constants+=Constant
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:' patterns+=Pattern
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? assumptionsKeyword=AssumptionsHeader
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? requirementsKeyword=RequirementsHeader
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Patterns:'? 'Inputs:' inputs+=Variable
	 */
	protected void emit_Specification_UnitsKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
