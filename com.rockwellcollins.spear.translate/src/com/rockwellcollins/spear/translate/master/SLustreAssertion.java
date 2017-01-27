package com.rockwellcollins.spear.translate.master;

import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;

public class SLustreAssertion {

	public static List<SLustreAssertion> build(List<LustreAssertion> list) {
		return list.stream().map(la -> new SLustreAssertion(la)).collect(Collectors.toList());
	}
	
	public static List<jkind.lustre.Expr> toLustre(List<SLustreAssertion> list, SPattern pattern) {
		return list.stream().map(la -> la.toLustre(pattern)).collect(Collectors.toList());
	}
	
	public Expr expression;

	public SLustreAssertion(LustreAssertion assertion) {
		this.expression = assertion.getAssertionExpr();
	}
	
	public jkind.lustre.Expr toLustre(SPattern pattern) {
		return TranslateExpr.translate(this.expression, pattern);
	}
}
