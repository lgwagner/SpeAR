package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;
import jkind.lustre.UnaryOp;

public class SFormalConstraint extends SConstraint {

	public static SFormalConstraint build(FormalConstraint fc, SSpecification s) {
		return new SFormalConstraint(fc, s);
	}

	public Expr expression;
	public boolean isObserver;

	public SFormalConstraint(FormalConstraint fc, SSpecification s) {
		this.name = s.map.getModuleName(fc.getName());
		this.expression = fc.getExpr();
		this.isObserver = fc.getFlagAsWitness() != null && fc.getFlagAsWitness().equals("observe");
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(SSpecification s) {
		return new jkind.lustre.VarDecl(this.name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(SSpecification s) {
		jkind.lustre.IdExpr lhs = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr rhs = TranslateExpr.translate(this.expression, s);
		return new jkind.lustre.Equation(lhs, rhs);
	}

	@Override
	public jkind.lustre.Equation getPropertyEquation(String assertion, SSpecification spec) {
		IdExpr lhs = new IdExpr(this.name);
		jkind.lustre.Expr base = TranslateExpr.translate(this.expression,spec);
		jkind.lustre.Expr rhs = this.isObserver ? new jkind.lustre.UnaryExpr(UnaryOp.NOT,base) : base;
		return new jkind.lustre.Equation(lhs,new BinaryExpr(new IdExpr(assertion),BinaryOp.IMPLIES,rhs));
	}
}
