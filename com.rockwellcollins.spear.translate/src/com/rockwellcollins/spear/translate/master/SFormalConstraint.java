package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.lustre.TranslateCallExpr;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;

public class SFormalConstraint extends SConstraint {

	public static SFormalConstraint build(FormalConstraint fc, SSpecification s) {
		return new SFormalConstraint(fc, s);
	}

	public Expr expression;

	public SFormalConstraint(FormalConstraint fc, SSpecification s) {
		this.name = s.map.getName(fc.getName());
		this.expression = fc.getExpr();
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(SSpecification s) {
		return new jkind.lustre.VarDecl(this.name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(SSpecification s) {
		jkind.lustre.IdExpr lhs = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr rhs = TranslateCallExpr.translate(this.expression, s);
		return new jkind.lustre.Equation(lhs, rhs);
	}

	@Override
	public jkind.lustre.Equation getPropertyEquation(String assertion, SSpecification spec) {
		IdExpr lhs = new IdExpr(this.name);
		jkind.lustre.Expr rhs = new BinaryExpr(new IdExpr(assertion),BinaryOp.IMPLIES,TranslateCallExpr.translate(this.expression,spec));
		return new jkind.lustre.Equation(lhs,rhs);
	}
}
