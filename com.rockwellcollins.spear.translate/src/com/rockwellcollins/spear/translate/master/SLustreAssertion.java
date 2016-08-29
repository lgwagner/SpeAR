package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.naming.Renaming;

public class SLustreAssertion {

	public static List<SLustreAssertion> build(List<LustreAssertion> list) {
		List<SLustreAssertion> built = new ArrayList<>();
		for(LustreAssertion assertion : list) {
			built.add(SLustreAssertion.build(assertion));
		}
		return built;
	}
	
	public static List<jkind.lustre.Expr> toLustre(List<SLustreAssertion> list, Renaming map) {
		List<jkind.lustre.Expr> lustre = new ArrayList<>();
		for(SLustreAssertion assertion : list) {
			lustre.add(assertion.toLustre(map));
		}
		return lustre;
	}
	
	public static SLustreAssertion build(LustreAssertion assertion) {
		return new SLustreAssertion(assertion);
	}
	
	public Expr expression;

	public SLustreAssertion(LustreAssertion assertion) {
		this.expression = assertion.getAssertionExpr();
	}
	
	public jkind.lustre.Expr toLustre(Renaming map) {
		return TranslateExpr.translate(this.expression, map);
	}
}
