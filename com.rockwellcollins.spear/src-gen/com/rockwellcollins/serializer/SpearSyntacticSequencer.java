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
	protected AbstractElementAlias match_AtomicExpr_LeftParenthesisKeyword_11_0_a;
	protected AbstractElementAlias match_AtomicExpr_LeftParenthesisKeyword_11_0_p;
	protected AbstractElementAlias match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_Definitions_ConstantsKeyword_4_0_q;
	protected AbstractElementAlias match_Definitions_TypesKeyword_3_0_q;
	protected AbstractElementAlias match_Definitions_UnitsKeyword_2_0_q;
	protected AbstractElementAlias match_Specification_AssumptionsKeyword_12_0_q;
	protected AbstractElementAlias match_Specification_ConstantsKeyword_5_0_q;
	protected AbstractElementAlias match_Specification_ImportsKeyword_2_0_q;
	protected AbstractElementAlias match_Specification_MacrosKeyword_11_0_q;
	protected AbstractElementAlias match_Specification_RequirementsKeyword_15_0_q;
	protected AbstractElementAlias match_Specification_StateKeyword_10_0_q;
	protected AbstractElementAlias match_Specification_TypesKeyword_4_0_q;
	protected AbstractElementAlias match_Specification_UnitsKeyword_3_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SpearGrammarAccess) access;
		match_AtomicExpr_LeftParenthesisKeyword_11_0_a = new TokenAlias(true, true, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_11_0());
		match_AtomicExpr_LeftParenthesisKeyword_11_0_p = new TokenAlias(true, false, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_11_0());
		match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
		match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
		match_Definitions_ConstantsKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getConstantsKeyword_4_0());
		match_Definitions_TypesKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getTypesKeyword_3_0());
		match_Definitions_UnitsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getUnitsKeyword_2_0());
		match_Specification_AssumptionsKeyword_12_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getAssumptionsKeyword_12_0());
		match_Specification_ConstantsKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getConstantsKeyword_5_0());
		match_Specification_ImportsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getImportsKeyword_2_0());
		match_Specification_MacrosKeyword_11_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getMacrosKeyword_11_0());
		match_Specification_RequirementsKeyword_15_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getRequirementsKeyword_15_0());
		match_Specification_StateKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getStateKeyword_10_0());
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
	 * |	'is a'
	 * |	'is an'
	 * ;
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
			if (match_AtomicExpr_LeftParenthesisKeyword_11_0_a.equals(syntax))
				emit_AtomicExpr_LeftParenthesisKeyword_11_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AtomicExpr_LeftParenthesisKeyword_11_0_p.equals(syntax))
				emit_AtomicExpr_LeftParenthesisKeyword_11_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_ConstantsKeyword_4_0_q.equals(syntax))
				emit_Definitions_ConstantsKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_TypesKeyword_3_0_q.equals(syntax))
				emit_Definitions_TypesKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Definitions_UnitsKeyword_2_0_q.equals(syntax))
				emit_Definitions_UnitsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_AssumptionsKeyword_12_0_q.equals(syntax))
				emit_Specification_AssumptionsKeyword_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_ConstantsKeyword_5_0_q.equals(syntax))
				emit_Specification_ConstantsKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_ImportsKeyword_2_0_q.equals(syntax))
				emit_Specification_ImportsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_MacrosKeyword_11_0_q.equals(syntax))
				emit_Specification_MacrosKeyword_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_RequirementsKeyword_15_0_q.equals(syntax))
				emit_Specification_RequirementsKeyword_15_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Specification_StateKeyword_10_0_q.equals(syntax))
				emit_Specification_StateKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     (rule start) (ambiguity) 'after' after=Expr
	 *     (rule start) (ambiguity) 'if' cond=Expr
	 *     (rule start) (ambiguity) 'new' type=[ArrayType|ID]
	 *     (rule start) (ambiguity) 'new' type=[RecordType|ID]
	 *     (rule start) (ambiguity) 'pattern' pattern=[Pattern|ID]
	 *     (rule start) (ambiguity) 'prev' '(' var=Expr
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
	 *     (rule start) (ambiguity) value=BOOL
	 *     (rule start) (ambiguity) value=INT
	 *     (rule start) (ambiguity) value=REAL
	 *     (rule start) (ambiguity) {ArrayAccessExpr.array=}
	 *     (rule start) (ambiguity) {ArrayUpdateExpr.access=}
	 *     (rule start) (ambiguity) {BinaryExpr.left=}
	 *     (rule start) (ambiguity) {RecordAccessExpr.record=}
	 *     (rule start) (ambiguity) {RecordUpdateExpr.record=}
	 */
	protected void emit_AtomicExpr_LeftParenthesisKeyword_11_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
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
	protected void emit_AtomicExpr_LeftParenthesisKeyword_11_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     name=ID 'Units:'? 'Types:'? (ambiguity) (rule end)
	 *     typedefs+=TypeDef (ambiguity) (rule end)
	 *     unitdefs+=UnitDef 'Types:'? (ambiguity) (rule end)
	 */
	protected void emit_Definitions_ConstantsKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Types:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID 'Units:'? (ambiguity) 'Constants:' constants+=Constant
	 *     name=ID 'Units:'? (ambiguity) 'Constants:'? (rule end)
	 *     unitdefs+=UnitDef (ambiguity) 'Constants:' constants+=Constant
	 *     unitdefs+=UnitDef (ambiguity) 'Constants:'? (rule end)
	 */
	protected void emit_Definitions_TypesKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Units:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) 'Types:' typedefs+=TypeDef
	 *     name=ID (ambiguity) 'Types:'? 'Constants:' constants+=Constant
	 *     name=ID (ambiguity) 'Types:'? 'Constants:'? (rule end)
	 */
	protected void emit_Definitions_UnitsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Assumptions:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     inputs+=Variable 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     inputs+=Variable 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     inputs+=Variable 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     macros+=Macro (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     macros+=Macro (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     macros+=Macro (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     outputs+=Variable 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     outputs+=Variable 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     outputs+=Variable 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     state+=Variable 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     state+=Variable 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     state+=Variable 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? (ambiguity) 'DerivedRequirements:' requirements+=Constraint
	 */
	protected void emit_Specification_AssumptionsKeyword_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Constants:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     imports+=Import 'Units:'? 'Types:'? (ambiguity) 'Inputs:' inputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? (ambiguity) 'Inputs:' inputs+=Variable
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     typedefs+=TypeDef (ambiguity) 'Inputs:' inputs+=Variable
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' 'Outputs:' outputs+=Variable
	 *     units+=UnitDef 'Types:'? (ambiguity) 'Inputs:' inputs+=Variable
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
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID (ambiguity) 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' inputs+=Variable
	 */
	protected void emit_Specification_ImportsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Macros:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     inputs+=Variable 'Outputs:' 'State:'? (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     inputs+=Variable 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     inputs+=Variable 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     inputs+=Variable 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     outputs+=Variable 'State:'? (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     outputs+=Variable 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     outputs+=Variable 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     outputs+=Variable 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     state+=Variable (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     state+=Variable (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     state+=Variable (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     state+=Variable (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:' assumptions+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? (ambiguity) 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 */
	protected void emit_Specification_MacrosKeyword_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Requirements:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     assumptions+=Constraint 'DerivedRequirements:' (ambiguity) (rule end)
	 *     constants+=Constant 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     inputs+=Variable 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     macros+=Macro 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     outputs+=Variable 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     requirements+=Constraint (ambiguity) (rule end)
	 *     state+=Variable 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' (ambiguity) (rule end)
	 */
	protected void emit_Specification_RequirementsKeyword_15_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'State:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     constants+=Constant 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     constants+=Constant 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     constants+=Constant 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     constants+=Constant 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     constants+=Constant 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     imports+=Import 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     inputs+=Variable 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     name=ID 'Imports:'? 'Units:'? 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     outputs+=Variable (ambiguity) 'Macros:' macros+=Macro
	 *     outputs+=Variable (ambiguity) 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     outputs+=Variable (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     outputs+=Variable (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     outputs+=Variable (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     typedefs+=TypeDef 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:' macros+=Macro
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     units+=UnitDef 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' (ambiguity) 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 */
	protected void emit_Specification_StateKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'Types:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:' constants+=Constant
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     imports+=Import 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' inputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:' constants+=Constant
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID 'Imports:'? 'Units:'? (ambiguity) 'Constants:'? 'Inputs:' inputs+=Variable
	 *     units+=UnitDef (ambiguity) 'Constants:' constants+=Constant
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     units+=UnitDef (ambiguity) 'Constants:'? 'Inputs:' inputs+=Variable
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
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     imports+=Import (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' inputs+=Variable
	 *     name=ID 'Imports:'? (ambiguity) 'Types:' typedefs+=TypeDef
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:' constants+=Constant
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:' state+=Variable
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:' macros+=Macro
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:' assumptions+=Constraint
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:' behaviors+=Constraint
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' 'Requirements:'? (rule end)
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' 'State:'? 'Macros:'? 'Assumptions:'? 'DerivedRequirements:' requirements+=Constraint
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' 'Outputs:' outputs+=Variable
	 *     name=ID 'Imports:'? (ambiguity) 'Types:'? 'Constants:'? 'Inputs:' inputs+=Variable
	 */
	protected void emit_Specification_UnitsKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
