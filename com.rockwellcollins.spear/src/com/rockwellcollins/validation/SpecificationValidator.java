package com.rockwellcollins.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.typing.PrimitiveType;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.units.SpearUnitChecker;
import com.rockwellcollins.spear.units.Unit;

public class SpecificationValidator extends SpearJavaValidator {
	
	private boolean acyclicCheck(TypeDef td) {
		List<EObject> deps = AcyclicValidator.validate(td);
		if(deps.contains(td)) {
			String message = "Cycle detected: " + td.getName() + " -> " + AcyclicValidator.getMessage(td,deps);
			error(message, td, SpearPackage.Literals.TYPE_DEF__NAME);
			return true;
		}
		return false;
	}
	
	private boolean acyclicCheck(Constant c) {
		List<EObject> deps = AcyclicValidator.validate(c);
		if(deps.contains(c)) {
			String message = "Cycle detected: " + c.getName() + " -> " + AcyclicValidator.getMessage(c,deps);
			error(message, c, SpearPackage.Literals.ID_REF__NAME);
			return true;
		}
		return false;
	}
	
	private boolean acyclicCheck(Macro m) {
		List<EObject> deps = AcyclicValidator.validate(m);
		if(deps.contains(m)) {
			String message = "Cycle detected: " + m.getName() + " -> " + AcyclicValidator.getMessage(m,deps);
			error(message, m, SpearPackage.Literals.ID_REF__NAME);
			return true;
		}
		return false;
	}
	
	private boolean typeCheck(EObject o, Set<EObject> errors) {
		return SpearTypeChecker.typeCheck(o, errors, this.getMessageAcceptor()).equals(PrimitiveType.ERROR);
	}
	
	private boolean unitCheck(EObject o, Set<EObject> errors) {
		return SpearUnitChecker.unitCheck(o, errors, this.getMessageAcceptor()).equals(Unit.ERROR);
	}
	
	@Check
	public void validate(Specification s) {
		Set<EObject> errors = new HashSet<>();
		
		//acyclic checks
		errors.addAll(s.getTypedefs().stream().filter(td -> acyclicCheck(td)).collect(Collectors.toList()));
		errors.addAll(s.getConstants().stream().filter(c -> acyclicCheck(c)).collect(Collectors.toList()));
		errors.addAll(s.getMacros().stream().filter(m -> acyclicCheck(m)).collect(Collectors.toList()));
		
		//if none, type check
		errors.addAll(s.getTypedefs().stream().filter(td -> typeCheck(td, errors)).collect(Collectors.toList()));
		errors.addAll(s.getConstants().stream().filter(c -> typeCheck(c,errors)).collect(Collectors.toList()));
		errors.addAll(s.getMacros().stream().filter(m -> typeCheck(m,errors)).collect(Collectors.toList()));
		errors.addAll(s.getAssumptions().stream().filter(a -> typeCheck(a,errors)).collect(Collectors.toList()));
		errors.addAll(s.getRequirements().stream().filter(r -> typeCheck(r,errors)).collect(Collectors.toList()));
		errors.addAll(s.getBehaviors().stream().filter(b -> typeCheck(b,errors)).collect(Collectors.toList()));
		
		//if none, units check
		errors.addAll(s.getTypedefs().stream().filter(td -> unitCheck(td, errors)).collect(Collectors.toList()));
		errors.addAll(s.getConstants().stream().filter(c -> unitCheck(c,errors)).collect(Collectors.toList()));
		errors.addAll(s.getMacros().stream().filter(m -> unitCheck(m,errors)).collect(Collectors.toList()));
		errors.addAll(s.getAssumptions().stream().filter(a -> unitCheck(a,errors)).collect(Collectors.toList()));
		errors.addAll(s.getRequirements().stream().filter(r -> unitCheck(r,errors)).collect(Collectors.toList()));
		errors.addAll(s.getBehaviors().stream().filter(b -> unitCheck(b,errors)).collect(Collectors.toList()));
	}
	
	@Check
	public void validate(Definitions s) {
		Set<EObject> errors = new HashSet<>();
		
		//acyclic checks
		errors.addAll(s.getTypedefs().stream().filter(td -> acyclicCheck(td)).collect(Collectors.toList()));
		errors.addAll(s.getConstants().stream().filter(c -> acyclicCheck(c)).collect(Collectors.toList()));
	
		//if none, type check
		errors.addAll(s.getTypedefs().stream().filter(td -> typeCheck(td, errors)).collect(Collectors.toList()));
		errors.addAll(s.getConstants().stream().filter(c -> typeCheck(c,errors)).collect(Collectors.toList()));
		
		//if none, units check
		errors.addAll(s.getTypedefs().stream().filter(td -> unitCheck(td, errors)).collect(Collectors.toList()));
		errors.addAll(s.getConstants().stream().filter(c -> unitCheck(c,errors)).collect(Collectors.toList()));
	}
	
	@Check
	public void validate(Pattern p) {
		Set<EObject> errors = new HashSet<>();
		
		//acyclic checks
		//type check
		errors.addAll(p.getEquations().stream().filter(eq -> typeCheck(eq,errors)).collect(Collectors.toList()));
		
		//unit check
		errors.addAll(p.getEquations().stream().filter(eq -> unitCheck(eq,errors)).collect(Collectors.toList()));
	}
}