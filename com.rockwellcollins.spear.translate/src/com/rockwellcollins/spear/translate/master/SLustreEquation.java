package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;

import jkind.lustre.Equation;
import jkind.lustre.IdExpr;

public class SLustreEquation {

	public static List<SLustreEquation> build(List<LustreEquation> list, SPattern p) {
		return list.stream().map(le -> new SLustreEquation(le, p)).collect(Collectors.toList());
	}

	public static List<jkind.lustre.Equation> toLustre(List<SLustreEquation> list, SPattern p) {
		return list.stream().map(seq -> seq.toLustre(p)).collect(Collectors.toList());
	}

	public List<String> ids = new ArrayList<>();
	public Expr expression;

	public SLustreEquation(LustreEquation eq, SPattern s) {
		ids.addAll(eq.getIds().stream().map(v -> s.map.lookup(v.getName())).collect(Collectors.toList()));
		this.expression = eq.getRhs();
	}

	public Equation toLustre(SPattern p) {
		return new Equation(ids.stream().map(id -> new IdExpr(id)).collect(Collectors.toList()),
				TranslateExpr.translate(expression, p));
	}
}
