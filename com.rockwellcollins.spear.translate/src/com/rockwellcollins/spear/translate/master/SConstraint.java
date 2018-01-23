package com.rockwellcollins.spear.translate.master;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Equation;
import jkind.lustre.VarDecl;

public abstract class SConstraint {

	public static List<SConstraint> build(List<Constraint> list, SSpecification s) {
		return list.stream().map(c -> SConstraint.build(c, s)).collect(Collectors.toList());
	}

	public static List<VarDecl> toVarDecl(List<SConstraint> list, SSpecification s) {
		return list.stream().map(c -> c.toVarDecl(s)).collect(Collectors.toList());
	}

	public static List<Equation> toEquation(List<SConstraint> list, SSpecification s) {
		return list.stream().map(c -> c.toEquation(s)).collect(Collectors.toList());
	}

	public static List<Equation> toPropertyEquations(List<SConstraint> list, String name, SSpecification s) {
		return list.stream().map(c -> c.getPropertyEquation(name, s)).collect(Collectors.toList());
	}

	public static List<String> toPropertyIds(List<SConstraint> list, SSpecification map) {
		return list.stream().map(c -> c.name).collect(Collectors.toList());
	}

	private static SConstraint build(Constraint c, SSpecification s) {
		return new SConstraintBuilder(s).doSwitch(c);
	}

	public String name;

	public abstract jkind.lustre.VarDecl toVarDecl(SSpecification map);

	public abstract jkind.lustre.Equation toEquation(SSpecification map);

	public abstract jkind.lustre.Equation getPropertyEquation(String assertion, SSpecification s);

	private static class SConstraintBuilder extends SpearSwitch<SConstraint> {

		private SSpecification specification;

		private SConstraintBuilder(SSpecification s) {
			this.specification = s;
		}

		@Override
		public SConstraint caseFormalConstraint(FormalConstraint fc) {
			return SFormalConstraint.build(fc, specification);
		}

		@Override
		public SConstraint caseEnglishConstraint(EnglishConstraint ec) {
			return SEnglishConstraint.build(ec, specification);
		}

		@Override
		public SConstraint defaultCase(EObject o) {
			throw new RuntimeException("Expected a Constraint object, received: " + o.toString());
		}
	}
}
