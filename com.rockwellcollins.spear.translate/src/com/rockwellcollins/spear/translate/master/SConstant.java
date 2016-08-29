package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.PNameMap;

public class SConstant {
	
	public static SConstant build(Constant c, PNameMap map) {
		return new SConstant(c,map);
	}
	
	public static List<SConstant> build(List<Constant> list, PNameMap map) {
		List<SConstant> built = new ArrayList<>();
		for(Constant c : list) {
			built.add(SConstant.build(c, map));
		}
		return built;
	}
	
	public static List<jkind.lustre.Constant> toLustre(List<SConstant> list, PNameMap map) {
		List<jkind.lustre.Constant> lustre = new ArrayList<>();
		for(SConstant sc : list) {
			lustre.add(sc.toLustre(map));
		}
		return lustre;
	}
	
	public String name;
	public Type type;
	public Expr expr;
	
	public SConstant(Constant c, PNameMap map) {
		this.name=map.getName(c.getName());
		this.type=c.getType();
		this.expr=c.getExpr();
	}
	
	public jkind.lustre.Constant toLustre(PNameMap map) {
		jkind.lustre.Type type = TranslateType.translate(this.type, map);
		jkind.lustre.Expr expression = TranslateExpr.translate(this.expr,map);
		return new jkind.lustre.Constant(this.name,type,expression);
	}
}
