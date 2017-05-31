package com.rockwellcollins.spear.translate.master;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

public class SConstant {

	public static List<SConstant> build(Collection<Constant> list, SProgram program) {
		return list.stream().map(c -> new SConstant(c, program)).collect(Collectors.toList());
	}

	public static List<jkind.lustre.Constant> toLustre(List<SConstant> list, SProgram program) {
		return list.stream().map(sc -> sc.toLustre(program)).collect(Collectors.toList());
	}

	public String name;
	public Type type;
	public Expr expr;

	public SConstant(Constant c, SProgram program) {
		this.name = program.map.getProgramName(c.getName());
		this.type = c.getType();
		this.expr = c.getExpr();
	}

	public jkind.lustre.Constant toLustre(SProgram program) {
		jkind.lustre.Type type = TranslateType.translate(this.type, program.map);
		jkind.lustre.Expr expression = TranslateExpr.translate(this.expr, program);
		return new jkind.lustre.Constant(this.name, type, expression);
	}
}
