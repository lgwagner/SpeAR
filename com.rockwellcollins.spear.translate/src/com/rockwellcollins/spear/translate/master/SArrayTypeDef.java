package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.utilities.IntConstantFinder;

import jkind.lustre.ArrayType;
import jkind.lustre.TypeDef;

public class SArrayTypeDef extends STypeDef {

	public Type base;
	public Integer size;

	public SArrayTypeDef(ArrayTypeDef atd, SProgram program) {
		this.name = program.map.addName(atd.getName());
		this.base = atd.getBase();
		this.size = IntConstantFinder.fetch(atd);
	}

	@Override
	public TypeDef toLustre(SProgram program) {
		jkind.lustre.Type baseType = TranslateType.translate(base, program.map);
		jkind.lustre.Type arrayType = new ArrayType(baseType, size);
		return new TypeDef(name, arrayType);
	}
}
