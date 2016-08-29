package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.translate.naming.PNameMap;

import jkind.lustre.EnumType;
import jkind.lustre.TypeDef;

public class SEnumTypeDef extends STypeDef {

	public String definitionName;
	public List<String> values = new ArrayList<>();
	
	public SEnumTypeDef(EnumTypeDef etd, PNameMap map) {
		this.name = map.getName(etd.getName());
		this.definitionName=map.getName(etd.getName() + "_definition");
		
		for(EnumValue ev : etd.getValues()) {
			String value = map.getName(ev.getName());
			this.values.add(value);
		}
	}

	@Override
	public TypeDef toLustre(PNameMap naming) {
		jkind.lustre.EnumType type = new EnumType(this.definitionName, values);
		return new TypeDef(this.name, type);
	}
}
