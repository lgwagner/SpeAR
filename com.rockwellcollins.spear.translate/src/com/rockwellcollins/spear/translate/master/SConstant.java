package com.rockwellcollins.spear.translate.master;

import static jkind.lustre.LustreUtil.varDecl;

import java.util.Collection;
import java.util.Collections;
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

	public String name;
	public Type type;
	public Expr expr;
	public String fnName;

	public SConstant(Constant c, SProgram program) {
		this.name = program.map.addName(c.getName());
		this.type = c.getType();
		this.expr = c.getExpr();
	}
	
	public jkind.lustre.Constant toLustreConstant(SProgram program) {
		jkind.lustre.Type lustreType = TranslateType.translate(this.type, program.map);
		return new jkind.lustre.Constant(name, lustreType, TranslateExpr.translate(expr, program));
	}
	
	public jkind.lustre.Function toLustreFunction(SProgram program) {
		jkind.lustre.Type lustreType = TranslateType.translate(this.type, program.map);
		return new jkind.lustre.Function(name, Collections.emptyList(), varDecl("out",lustreType));
	}
}
