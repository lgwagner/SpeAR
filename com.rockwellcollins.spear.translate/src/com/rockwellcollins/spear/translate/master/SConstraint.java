package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Equation;
import jkind.lustre.VarDecl;

public abstract class SConstraint {

	public static final String PROPERTY_SUFFIX = "_property";
	public static List<SConstraint> build(List<Constraint> list, SSpecification s) {
		List<SConstraint> built = new ArrayList<>();
		for(Constraint c : list) {
			built.add(SConstraint.build(c, s));
		}
		return built;
	}
	
	public static List<VarDecl> toVarDecl(List<SConstraint> list, SSpecification map) {
		List<VarDecl> decls = new ArrayList<>();
		for(SConstraint c : list) {
			decls.add(c.toVarDecl(map));
		}
		return decls;
	}

	public static List<Equation> toEquation(List<SConstraint> list, SSpecification map) {
		List<Equation> equations = new ArrayList<>();
		for(SConstraint c : list) {
			equations.add(c.toEquation(map));
		}
		return equations;
	}
	
	public static List<Equation> toPropertyEquations(List<SConstraint> list, String name, SSpecification s) {
		List<Equation> equations = new ArrayList<>();
		for(SConstraint sc : list) {
			equations.add(sc.getPropertyEquation(name,s));
		}
		return equations;
	}
	
	public static List<String> toPropertyIds(List<SConstraint> list, SSpecification map) {
		List<String> strings = new ArrayList<>();
		for(SConstraint sc : list) {
			strings.add(sc.name);
		}
		return strings;
	}
	
	public static SConstraint build(Constraint c, SSpecification s) {
		SConstraintBuilder builder = new SConstraintBuilder(s);
		return builder.doSwitch(c);
	}
	
	public String name;
	public abstract jkind.lustre.VarDecl toVarDecl(SSpecification map);
	public abstract jkind.lustre.Equation toEquation(SSpecification map);
	public abstract jkind.lustre.Equation getPropertyEquation(String assertion, SSpecification s);
	
	private static class SConstraintBuilder extends SpearSwitch<SConstraint> {
		
		private SSpecification specification;
		
		private SConstraintBuilder(SSpecification s) {
			this.specification=s;
		}
		
		@Override
		public SConstraint caseFormalConstraint(FormalConstraint fc) {
			return SFormalConstraint.build(fc, this.specification);
		}
		
		@Override
		public SConstraint caseEnglishConstraint(EnglishConstraint ec) {
			return SEnglishConstraint.build(ec, this.specification);
		}
		
		@Override
		public SConstraint defaultCase(EObject o) {
			throw new RuntimeException("Expected a Constraint object, received: " + o.toString());
		}
	}
}
