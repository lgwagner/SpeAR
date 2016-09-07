package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;

import jkind.lustre.EnumType;
import jkind.lustre.TypeDef;

public class SEnumTypeDef extends STypeDef {

	public String definitionName;
	public List<String> values = new ArrayList<>();
	
	public SEnumTypeDef(EnumTypeDef etd, SProgram program) {
		this.name = program.map.getName(etd.getName());
		this.definitionName=program.map.getName(etd.getName() + "_definition");
		
		for(EnumValue ev : etd.getValues()) {
			String value = program.map.getName(ev.getName());
			this.values.add(value);
		}
	}

	@Override
	public TypeDef toLustre(SProgram program) {
		jkind.lustre.EnumType type = new EnumType(this.definitionName, values);
		return new TypeDef(this.name, type);
	}
}
