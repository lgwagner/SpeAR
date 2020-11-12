package com.rockwellcollins.spear.translate.master;

import static jkind.lustre.LustreUtil.TRUE;
import static jkind.lustre.LustreUtil.eq;
import static jkind.lustre.LustreUtil.id;
import static jkind.lustre.LustreUtil.implies;

import com.rockwellcollins.spear.EnglishConstraint;

import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;

public class SEnglishConstraint extends SConstraint {

	public static SEnglishConstraint build(EnglishConstraint ec, SSpecification s) {
		return new SEnglishConstraint(ec, s);
	}

	public String text;

	private SEnglishConstraint(EnglishConstraint ec, SSpecification s) {
		this.name = s.map.addName(ec.getName());
		this.text = ec.getText();
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(SSpecification s) {
		return new jkind.lustre.VarDecl(this.name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(SSpecification s) {
		return new jkind.lustre.Equation(id(name), TRUE);
	}

	@Override
	public jkind.lustre.Equation getPropertyEquation(String assertion, SSpecification s) {
		IdExpr lhs = new IdExpr(this.name);
		jkind.lustre.Expr rhs = implies(id(assertion), TRUE);
		return eq(lhs, rhs);
	}
}
