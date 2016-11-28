package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

public class SConstant {
	
	public static List<SConstant> build(Collection<Constant> list, SProgram program) {
		List<SConstant> built = new ArrayList<>();
		for(Constant c : list) {
			built.add(SConstant.build(c, program));
		}
		return built;
	}
	
	public static SConstant build(Constant c, SProgram program) {
		return new SConstant(c,program);
	}
	
	public static List<jkind.lustre.Constant> toLustre(List<SConstant> list, SProgram program) {
		List<jkind.lustre.Constant> lustre = new ArrayList<>();
		for(SConstant sc : list) {
			lustre.add(sc.toLustre(program));
		}
		return lustre;
	}
	
	public String name;
	public Type type;
	public Expr expr;
	
	public SConstant(Constant c, SProgram program) {
		this.name=program.map.getProgramName(c.getName());
		this.type=c.getType();
		this.expr=c.getExpr();
	}
	
	public jkind.lustre.Constant toLustre(SProgram program) {
		jkind.lustre.Type type = TranslateType.translate(this.type, program.map);
		jkind.lustre.Expr expression = TranslateExpr.translate(this.expr, program);
		return new jkind.lustre.Constant(this.name,type,expression);
	}
}
