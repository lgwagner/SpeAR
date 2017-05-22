package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.TypeDef;

public class SNamedTypeDef extends STypeDef {

	public Type type;

	public SNamedTypeDef(NamedTypeDef ntd, SProgram program) {
		this.name = program.map.getProgramName(ntd.getName());
		this.type = ntd.getType();
	}

	@Override
	public TypeDef toLustre(SProgram program) {
		jkind.lustre.Type t = TranslateType.translate(type, program.map);
		return new TypeDef(this.name, t);
	}
}
