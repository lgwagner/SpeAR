package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.naming.Renaming;

import jkind.lustre.Equation;
import jkind.lustre.IdExpr;

public class SLustreEquation {

	public static List<SLustreEquation> build(List<LustreEquation> list, Renaming map) {
		List<SLustreEquation> built = new ArrayList<>();
		for(LustreEquation eq : list) {
			built.add(SLustreEquation.build(eq, map));
		}
		return built;
	}
	
	public static List<jkind.lustre.Equation> toLustre(List<SLustreEquation> list, Renaming map) {
		List<jkind.lustre.Equation> equations = new ArrayList<>();
		for(SLustreEquation seq : list) {
			equations.add(seq.toLustre(map));
		}
		return equations;
	}
	
	public static SLustreEquation build(LustreEquation eq, Renaming map) {
		return new SLustreEquation(eq,map);
	}
	
	public List<String> ids = new ArrayList<>();
	public Expr expression;

	public SLustreEquation(LustreEquation eq, Renaming map) {
		for(Variable v : eq.getIds()) {
			this.ids.add(map.lookupOriginal(v.getName()));
		}
		this.expression = eq.getRhs();
	}
	
	public Equation toLustre(Renaming map) {
		List<IdExpr> lhs = new ArrayList<>();
		for(String id : ids) {
			lhs.add(new IdExpr(id));
		}
		jkind.lustre.Expr rhs = TranslateExpr.translate(expression, map);
		return new Equation(lhs,rhs);
	}
}
