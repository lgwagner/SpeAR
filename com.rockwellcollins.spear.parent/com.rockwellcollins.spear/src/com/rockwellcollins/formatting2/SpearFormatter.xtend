/*
 * Information: Initially generated by Xtext 2.18.0.M3
 */
package com.rockwellcollins.formatting2

import com.google.inject.Inject
import com.rockwellcollins.services.SpearGrammarAccess
import com.rockwellcollins.spear.Constant
import com.rockwellcollins.spear.Constraint
import com.rockwellcollins.spear.Import
import com.rockwellcollins.spear.Macro
import com.rockwellcollins.spear.Pattern
import com.rockwellcollins.spear.Specification
import com.rockwellcollins.spear.TypeDef
import com.rockwellcollins.spear.UnitDef
import com.rockwellcollins.spear.Variable
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

class SpearFormatter extends AbstractFormatter2 {
	
	@Inject extension SpearGrammarAccess

	def dispatch void format(Specification s, extension IFormattableDocument document) {
		for (Import im : s.getImports()) {
			im.append[autowrap; newLine];
			format(im, document);
		}

		for (UnitDef unit : s.getUnits()) {
			unit.append[autowrap; newLine];
			format(unit, document);
		}
		
		for (TypeDef typedef : s.getTypedefs()) {
			typedef.append[autowrap; newLine];
			format(typedef, document);
		}
		
		for (Constant constants : s.getConstants()) {
			constants.append[autowrap; newLine];
			format(constants, document);
		}
		
		for (Pattern patterns : s.getPatterns()) {
			patterns.append[autowrap; newLine];
			format(patterns, document);
		}
		
		for (Variable inputs : s.getInputs()) {
			inputs.append[autowrap; newLine];
			format(inputs, document);
		}
		
		for (Variable outputs : s.getOutputs()) {
			outputs.append[autowrap; newLine];
			format(outputs, document);
		}
		
		for (Variable state : s.getState()) {
			state.append[autowrap; newLine];
			format(state, document);
		}
		
		for (Macro macros : s.getMacros()) {
			macros.append[autowrap; newLine];
			format(macros, document);
		}
		
		for (Constraint assumptions : s.getAssumptions()) {
			assumptions.append[autowrap; newLine];
			format(assumptions, document);
		}
		
		for (Constraint requirements : s.getRequirements()) {
			requirements.append[autowrap; newLine];
			format(requirements, document);
		}
		
		for (Constraint behaviors : s.getBehaviors()) {
			behaviors.append[autowrap; newLine];
			format(behaviors, document);
		}
	}
}
