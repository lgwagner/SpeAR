package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.TypeDef;

public class SPredicateSubTypeDef extends STypeDef {

	public Type type;

	public SPredicateSubTypeDef(PredicateSubTypeDef pstd, SProgram program) {
		this.name = program.map.addName(pstd.getName());
		this.type = pstd.getPredVar().getType();
	}

	@Override
	public TypeDef toLustre(SProgram program) {
		jkind.lustre.Type t = TranslateType.translate(type, program.map);
		return new TypeDef(this.name, t);
	}
}
