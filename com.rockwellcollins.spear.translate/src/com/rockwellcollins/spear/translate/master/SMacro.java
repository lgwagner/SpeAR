package com.rockwellcollins.spear.translate.master;

import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Equation;
import jkind.lustre.VarDecl;

public class SMacro {

	public static List<SMacro> build(List<Macro> list, SSpecification s) {
		return list.stream().map(m -> new SMacro(m, s)).collect(Collectors.toList());
	}

	public static List<VarDecl> toVarDecls(List<SMacro> list, SSpecification s) {
		return list.stream().map(sm -> sm.toVarDecl(s)).collect(Collectors.toList());
	}

	public static List<Equation> toEquations(List<SMacro> list, SSpecification s) {
		return list.stream().map(sm -> sm.toEquation(s)).collect(Collectors.toList());
	}

	public String name;
	public Type type;
	public Expr expression;

	public SMacro(Macro m, SSpecification s) {
		this.name = s.map.getModuleName(m.getName());
		this.type = m.getType();
		this.expression = m.getExpr();
	}

	public jkind.lustre.VarDecl toVarDecl(SSpecification s) {
		jkind.lustre.Type type = TranslateType.translate(this.type, s.map);
		return new jkind.lustre.VarDecl(this.name, type);
	}

	public jkind.lustre.Equation toEquation(SSpecification s) {
		jkind.lustre.IdExpr LHS = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr RHS = TranslateExpr.translate(expression, s);
		return new jkind.lustre.Equation(LHS, RHS);
	}
}
