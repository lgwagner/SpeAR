package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.Renaming;

import jkind.lustre.ArrayType;
import jkind.lustre.TypeDef;

public class SArrayTypeDef extends STypeDef {
	
	public Type base;
	public Integer size;
	
	public SArrayTypeDef(ArrayTypeDef atd, Renaming map) {
		this.name = map.getName(atd.getName());
		this.base = atd.getBase();
		this.size = atd.getSize();
	}

	@Override
	public TypeDef toLustre(Renaming map) {
		jkind.lustre.Type baseType = TranslateType.translate(base, map);
		jkind.lustre.Type arrayType = new ArrayType(baseType,size);
		return new TypeDef(name,arrayType);
	}
}
