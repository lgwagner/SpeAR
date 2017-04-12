package com.rockwellcollins.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.typing.PrimitiveType;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.units.SpearUnitChecker;
import com.rockwellcollins.spear.units.Unit;
import com.rockwellcollins.spear.utilities.Utilities;

public class SpecificationValidator extends AbstractSpearJavaValidator {
	
	private boolean acyclicCheck(Import im, File root) {
		 HashSet<File> imported = new HashSet<>();
		 Utilities.getImportedFiles(im, imported);

		 if(imported.contains(root)) {
			 error("Cycle detected: " + root.getName() + " imports itself.", im, SpearPackage.Literals.IMPORT__IMPORT_URI);
			 return true;
		 }
		 return false;
	}
	
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
	
	private boolean acyclicCheck(Pattern p) {
		List<EObject> deps = AcyclicValidator.validate(p);
		if(deps.contains(p)) {
			String message = "Cycle detected: " + p.getName() + " -> " + AcyclicValidator.getMessage(p,deps);
			error(message, p, SpearPackage.Literals.PATTERN__NAME);
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
		
		//acyclic imports
		errors.addAll(s.getImports().stream().filter(im -> acyclicCheck(im,s)).collect(Collectors.toList()));
		
		//do imports have validation errors?
				
		//acyclic checks
		errors.addAll(s.getTypedefs().stream().filter(td -> acyclicCheck(td)).collect(Collectors.toList()));
		errors.addAll(s.getConstants().stream().filter(c -> acyclicCheck(c)).collect(Collectors.toList()));
		errors.addAll(s.getMacros().stream().filter(m -> acyclicCheck(m)).collect(Collectors.toList()));
		errors.addAll(s.getPatterns().stream().filter(p -> acyclicCheck(p)).collect(Collectors.toList()));
		
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
	public void validate(Definitions d) {
		Set<EObject> errors = new HashSet<>();
		
		//acyclic checks
		errors.addAll(d.getImports().stream().filter(im -> acyclicCheck(im,d)).collect(Collectors.toList()));
		errors.addAll(d.getTypedefs().stream().filter(td -> acyclicCheck(td)).collect(Collectors.toList()));
		errors.addAll(d.getConstants().stream().filter(c -> acyclicCheck(c)).collect(Collectors.toList()));
		errors.addAll(d.getPatterns().stream().filter(p -> acyclicCheck(p)).collect(Collectors.toList()));
		
		//if none, type check
		errors.addAll(d.getTypedefs().stream().filter(td -> typeCheck(td, errors)).collect(Collectors.toList()));
		errors.addAll(d.getConstants().stream().filter(c -> typeCheck(c,errors)).collect(Collectors.toList()));
		
		//if none, units check
		errors.addAll(d.getTypedefs().stream().filter(td -> unitCheck(td, errors)).collect(Collectors.toList()));
		errors.addAll(d.getConstants().stream().filter(c -> unitCheck(c,errors)).collect(Collectors.toList()));
	}
	
	@Check
	public void validate(Pattern p) {
		Set<EObject> errors = new HashSet<>();
		
		//type-check
		errors.addAll(p.getAssertions().stream().filter(la -> typeCheck(la, errors)).collect(Collectors.toList()));
		errors.addAll(p.getEquations().stream().filter(eq -> typeCheck(eq, errors)).collect(Collectors.toList()));
		errors.addAll(p.getProperties().stream().filter(lp -> typeCheck(lp, errors)).collect(Collectors.toList()));
		
		//unit-check
		errors.addAll(p.getAssertions().stream().filter(la -> unitCheck(la, errors)).collect(Collectors.toList()));
		errors.addAll(p.getEquations().stream().filter(eq -> unitCheck(eq, errors)).collect(Collectors.toList()));
		errors.addAll(p.getProperties().stream().filter(lp -> unitCheck(lp, errors)).collect(Collectors.toList()));
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {}
}
