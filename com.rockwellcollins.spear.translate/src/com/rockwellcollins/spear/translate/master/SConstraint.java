package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.naming.Renaming;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Equation;
import jkind.lustre.VarDecl;

public abstract class SConstraint {

	public static final String PROPERTY_SUFFIX = "_property";
	public static List<SConstraint> build(List<Constraint> list, Renaming map) {
		List<SConstraint> built = new ArrayList<>();
		for(Constraint c : list) {
			built.add(SConstraint.build(c, map));
		}
		return built;
	}
	
	public static List<VarDecl> toVarDecl(List<SConstraint> list, Renaming map) {
		List<VarDecl> decls = new ArrayList<>();
		for(SConstraint c : list) {
			decls.add(c.toVarDecl(map));
		}
		return decls;
	}

	public static List<Equation> toEquation(List<SConstraint> list, Renaming map) {
		List<Equation> equations = new ArrayList<>();
		for(SConstraint c : list) {
			equations.add(c.toEquation(map));
		}
		return equations;
	}
	
	public static List<Equation> toPropertyEquations(List<SConstraint> list, String name, Renaming map) {
		List<Equation> equations = new ArrayList<>();
		for(SConstraint sc : list) {
			equations.add(sc.getPropertyEquation(name,map));
		}
		return equations;
	}
	
	public static List<String> toPropertyIds(List<SConstraint> list, Renaming map) {
		List<String> strings = new ArrayList<>();
		for(SConstraint sc : list) {
			strings.add(sc.name);
		}
		return strings;
	}
	
	public static SConstraint build(Constraint c, Renaming map) {
		SConstraintBuilder builder = new SConstraintBuilder(map);
		return builder.doSwitch(c);
	}
	
	public String name;
	public abstract jkind.lustre.VarDecl toVarDecl(Renaming map);
	public abstract jkind.lustre.Equation toEquation(Renaming map);
	public abstract jkind.lustre.Equation getPropertyEquation(String assertion, Renaming map);
	
	private static class SConstraintBuilder extends SpearSwitch<SConstraint> {
		
		private Renaming map;
		
		private SConstraintBuilder(Renaming map) {
			this.map=map;
		}
		
		@Override
		public SConstraint caseFormalConstraint(FormalConstraint fc) {
			return SFormalConstraint.build(fc, map);
		}
		
		@Override
		public SConstraint caseEnglishConstraint(EnglishConstraint ec) {
			return SEnglishConstraint.build(ec, map);
		}
		
		@Override
		public SConstraint defaultCase(EObject o) {
			throw new RuntimeException("Expected a Constraint object, received: " + o.toString());
		}
	}
}
