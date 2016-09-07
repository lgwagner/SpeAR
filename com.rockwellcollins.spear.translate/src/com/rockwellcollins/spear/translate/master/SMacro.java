package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateCallExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Equation;
import jkind.lustre.VarDecl;

public class SMacro {

	public static List<SMacro> build(List<Macro> list, SSpecification s) {
		List<SMacro> built = new ArrayList<>();
		for(Macro m : list) {
			built.add(SMacro.build(m, s));
		}
		return built;
	}
	
	public static List<VarDecl> toVarDecls(List<SMacro> list, SSpecification s) {
		List<VarDecl> decls = new ArrayList<>();
		for(SMacro smacro : list) {
			decls.add(smacro.toVarDecl(s));
		}
		return decls;
	}
	
	public static List<Equation> toEquations(List<SMacro> list, SSpecification s) {
		List<Equation> equations = new ArrayList<>();
		for(SMacro smacro : list) {
			equations.add(smacro.toEquation(s));
		}
		return equations;
	}
	
	public static SMacro build(Macro m, SSpecification s) {
		return new SMacro(m,s);
	}
	
	public String name;
	public Type type;
	public Expr expression;
	
	public SMacro(Macro m, SSpecification s) {
		this.name=s.map.getName(m.getName());
		this.type=m.getType();
		this.expression=m.getExpr();
	}
	
	public jkind.lustre.VarDecl toVarDecl(SSpecification s) {
		jkind.lustre.Type type = TranslateType.translate(this.type, s.map);
		return new jkind.lustre.VarDecl(this.name,type);
	}
	
	public jkind.lustre.Equation toEquation(SSpecification s) {
		jkind.lustre.IdExpr LHS = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr RHS = TranslateCallExpr.translate(expression, s);
		return new jkind.lustre.Equation(LHS,RHS);
	}
}
