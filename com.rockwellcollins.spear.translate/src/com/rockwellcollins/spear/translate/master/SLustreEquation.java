package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;

import jkind.lustre.Equation;
import jkind.lustre.IdExpr;

public class SLustreEquation {

	public static List<SLustreEquation> build(List<LustreEquation> list, SPattern s) {
		List<SLustreEquation> built = new ArrayList<>();
		for(LustreEquation eq : list) {
			built.add(SLustreEquation.build(eq, s));
		}
		return built;
	}
	
	public static List<jkind.lustre.Equation> toLustre(List<SLustreEquation> list, SPattern s) {
		List<jkind.lustre.Equation> equations = new ArrayList<>();
		for(SLustreEquation seq : list) {
			equations.add(seq.toLustre(s));
		}
		return equations;
	}
	
	public static SLustreEquation build(LustreEquation eq, SPattern s) {
		return new SLustreEquation(eq,s);
	}
	
	public List<String> ids = new ArrayList<>();
	public Expr expression;

	public SLustreEquation(LustreEquation eq, SPattern s) {
		for(Variable v : eq.getIds()) {
			this.ids.add(s.map.lookupOriginal(v.getName()));
		}
		this.expression = eq.getRhs();
	}
	
	public Equation toLustre(SPattern p) {
		List<IdExpr> lhs = new ArrayList<>();
		for(String id : ids) {
			lhs.add(new IdExpr(id));
		}
		jkind.lustre.Expr rhs = TranslateExpr.translate(expression, p);
		return new Equation(lhs,rhs);
	}
}
