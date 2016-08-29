package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.naming.PNameMap;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;

public class SFormalConstraint extends SConstraint {

	public static SFormalConstraint build(FormalConstraint fc, PNameMap map) {
		return new SFormalConstraint(fc, map);
	}

	public Expr expression;

	public SFormalConstraint(FormalConstraint fc, PNameMap map) {
		this.name = map.getName(fc.getName());
		this.expression = fc.getExpr();
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(PNameMap map) {
		return new jkind.lustre.VarDecl(this.name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(PNameMap map) {
		jkind.lustre.IdExpr lhs = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr rhs = TranslateExpr.translate(this.expression, map);
		return new jkind.lustre.Equation(lhs, rhs);
	}

	@Override
	public jkind.lustre.Equation getPropertyEquation(String assertion, PNameMap map) {
		IdExpr lhs = new IdExpr(this.name);
		jkind.lustre.Expr rhs = new BinaryExpr(new IdExpr(assertion),BinaryOp.IMPLIES,TranslateExpr.translate(this.expression, map));
		return new jkind.lustre.Equation(lhs,rhs);
	}
}
