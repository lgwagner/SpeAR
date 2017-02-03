package com.rockwellcollins.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.typing.PrimitiveType;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.typing.Type;

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
		
		
		//if none, units check
	}

}
