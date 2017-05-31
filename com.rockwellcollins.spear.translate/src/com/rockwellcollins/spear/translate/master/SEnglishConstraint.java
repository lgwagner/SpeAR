package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.EnglishConstraint;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;

public class SEnglishConstraint extends SConstraint {

	public static SEnglishConstraint build(EnglishConstraint ec, SSpecification s) {
		return new SEnglishConstraint(ec, s);
	}

	public String text;

	private SEnglishConstraint(EnglishConstraint ec, SSpecification s) {
		this.name = s.map.getModuleName(ec.getName());
		this.text = ec.getText();
	}

	private jkind.lustre.BoolExpr getTrue() {
		return new jkind.lustre.BoolExpr(true);
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(SSpecification s) {
		return new jkind.lustre.VarDecl(this.name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(SSpecification s) {
		jkind.lustre.IdExpr lhs = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr rhs = getTrue();
		return new jkind.lustre.Equation(lhs, rhs);
	}

	@Override
	public jkind.lustre.Equation getPropertyEquation(String assertion, SSpecification s) {
		IdExpr lhs = new IdExpr(this.name);
		jkind.lustre.Expr rhs = new BinaryExpr(new IdExpr(assertion), BinaryOp.IMPLIES, getTrue());
		return new jkind.lustre.Equation(lhs, rhs);
	}
}
