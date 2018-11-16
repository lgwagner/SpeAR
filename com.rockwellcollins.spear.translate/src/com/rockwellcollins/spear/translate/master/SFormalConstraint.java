package com.rockwellcollins.spear.translate.master;

import static jkind.lustre.LustreUtil.eq;
import static jkind.lustre.LustreUtil.id;
import static jkind.lustre.LustreUtil.implies;
import static jkind.lustre.LustreUtil.not;
import static jkind.lustre.LustreUtil.varDecl;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Observe;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;

import jkind.lustre.NamedType;

public class SFormalConstraint extends SConstraint {

	public static SFormalConstraint build(FormalConstraint fc, SSpecification s) {
		return new SFormalConstraint(fc, s);
	}

	public Expr expression;
	public boolean isObserver;

	public SFormalConstraint(FormalConstraint fc, SSpecification s) {
		this.name = s.map.addName(fc.getName());
		this.expression = fc.getExpr();
		this.isObserver = fc.getFlag() != null && (fc.getFlag() instanceof Observe);
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(SSpecification s) {
		return varDecl(name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(SSpecification s) {
		return eq(id(name), TranslateExpr.translate(expression, s));
	}
	
	@Override
	public jkind.lustre.Equation getPropertyEquation(String assertion, SSpecification spec) {
		jkind.lustre.Expr base = TranslateExpr.translate(this.expression, spec);
		return eq(id(name), implies(id(assertion), this.isObserver ? not(base) : base));
	}
}
