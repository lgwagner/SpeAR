package com.rockwellcollins.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;
import com.rockwellcollins.spear.ArrayExpr;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.NamedUnitExpr;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UnitDef;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.utilities.Utilities;

public class VariablesAreUsedValidator extends AbstractSpearJavaValidator {
	
	@Inject
	protected IValidatorAdvisor options;
	
	private String errorMessage(EObject o) {
		String name = Utilities.getName(o);
		return name + " is defined, but never referenced.";
	}
	
	@Check
	public void checkSpecificationVariables(Specification s) {
		Set<String> used = new HashSet<>();
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(s, IdExpr.class)) {
			used.add(ide.getId().getName());
		}
		
		for(Constant c : s.getConstants()) {
			if(!used.contains(c.getName())) {
				unusedWarning(errorMessage(c),c,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Macro m : s.getMacros()) {
			if(!used.contains(m.getName())) {
				unusedWarning(errorMessage(m),m,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Variable v : s.getInputs()) {
			if(!used.contains(v.getName())) {
				unusedWarning(errorMessage(v),v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Variable v : s.getOutputs()) {
			if(!used.contains(v.getName())) {
				unusedWarning(errorMessage(v),v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Variable v : s.getState()) {
			if(!used.contains(v.getName())) {
				unusedWarning(errorMessage(v),v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
	}
	
	@Check
	public void checkSpecificationTypes(Specification s) {
		Set<String> used = new HashSet<>();
		for(UserType ut : EcoreUtil2.getAllContentsOfType(s, UserType.class)) {
			used.add(ut.getDef().getName());
		}
		
		for(RecordExpr re : EcoreUtil2.getAllContentsOfType(s, RecordExpr.class)) {
			used.add(re.getType().getName());
		}
		
		for(ArrayExpr ae : EcoreUtil2.getAllContentsOfType(s, ArrayExpr.class)) {
			used.add(ae.getType().getName());
		}
		
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(s, IdExpr.class)) {
			if (ide.getId() instanceof EnumValue) {
				EnumValue ev = (EnumValue) ide.getId();
				EnumTypeDef etd = (EnumTypeDef) ev.eContainer();
				used.add(etd.getName());
			}
		}
		
		for(TypeDef td : s.getTypedefs()) {
			if(!used.contains(td.getName())) {
				unusedWarning(errorMessage(td),td,SpearPackage.Literals.TYPE_DEF__NAME);
			}
		}
	}
	
	@Check
	public void checkSpecificationUnits(Specification s) {
		Set<String> used = new HashSet<>();
		for(NamedTypeDef nt : EcoreUtil2.getAllContentsOfType(s, NamedTypeDef.class)) {
			if(nt.getUnit() != null) {
				used.add(nt.getUnit().getName());
			}
		}
		
		for(NamedUnitExpr nue : EcoreUtil2.getAllContentsOfType(s, NamedUnitExpr.class)) {
			used.add(nue.getUnit().getName());
		}
		
		for(UnitDef ud : s.getUnits()) {
			if(!used.contains(ud.getName())) {
				unusedWarning(errorMessage(ud),ud,SpearPackage.Literals.UNIT_DEF__NAME);
			}
		}
	}
	
	@Check
	public void checkPatternsAreUsed(Specification s) {
		Set<String> used = new HashSet<>();
		for(PatternCall call : EcoreUtil2.getAllContentsOfType(s, PatternCall.class)) {
			used.add(call.getPattern().getName());
		}
		
		for(Pattern p : s.getPatterns()) {
			if(!used.contains(p.getName())) {
				unusedWarning(errorMessage(p),p,SpearPackage.Literals.PATTERN__NAME);
			}
		}
	}
	
	@Check
	public void checkPatternVariablesAreUsed(Pattern p) {
		Set<String> used = new HashSet<>();
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(p, IdExpr.class)) {
			used.add(ide.getId().getName());
		}
		
		for(LustreEquation eq : EcoreUtil2.getAllContentsOfType(p, LustreEquation.class)) {
			for(Variable v : eq.getIds()) {
				used.add(v.getName());
			}
		}
		
		for(Variable v : p.getInputs()) {
			if(!used.contains(v.getName())) {
				unusedWarning(errorMessage(v),v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Variable v : p.getOutputs()) {
			if(!used.contains(v.getName())) {
				unusedWarning(errorMessage(v),v,SpearPackage.Literals.ID_REF__NAME);
			}
		}

		for(Variable v : p.getLocals()) {
			if(!used.contains(v.getName())) {
				unusedWarning(errorMessage(v),v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
	}
	
	private void unusedWarning(String message, EObject source, EStructuralFeature feature) {
		if(options.isUnusedValidationsDisabled()) {
			warning(message,source,feature);	
		}
	}
}
