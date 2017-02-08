package com.rockwellcollins.spear.optional;

import com.rockwellcollins.spear.Expr;

public class SomeExpr extends OptionalExpr {

	public Expr expr;

	public SomeExpr(Expr e) {
		this.expr=e;
	}
}
