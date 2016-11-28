package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.ConcreteArrayTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.ArrayType;
import jkind.lustre.TypeDef;

public class SArrayTypeDef extends STypeDef {
	
	public Type base;
	public Integer size;
	
	public SArrayTypeDef(ConcreteArrayTypeDef atd, SProgram program) {
		this.name = program.map.getProgramName(atd.getName());
		this.base = atd.getBase();
		this.size = atd.getSize();
	}

	@Override
	public TypeDef toLustre(SProgram program) {
		jkind.lustre.Type baseType = TranslateType.translate(base, program.map);
		jkind.lustre.Type arrayType = new ArrayType(baseType,size);
		return new TypeDef(name,arrayType);
	}
}
