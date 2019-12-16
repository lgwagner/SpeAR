package com.rockwellcollins.spear.translate.master;

import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.RecordType;
import jkind.lustre.TypeDef;

public class SRecordTypeDef extends STypeDef {

	public String definitionName;
	public Map<String, Type> fields = new LinkedHashMap<>();

	public SRecordTypeDef(RecordTypeDef rtd, SProgram program) {
		this.name = program.map.addName(rtd.getName());
		this.definitionName = program.map.addName(rtd.getName() + "_definition");
		for (FieldType ft : rtd.getFields()) {
			fields.put(ft.getName(), ft.getType());
		}
	}

	@Override
	public TypeDef toLustre(SProgram program) {
		Map<String, jkind.lustre.Type> lustreFields = new LinkedHashMap<>();
		for (String fieldName : fields.keySet()) {
			lustreFields.put(fieldName, TranslateType.translate(fields.get(fieldName), program.map));
		}
		jkind.lustre.RecordType rt = new RecordType(this.definitionName, lustreFields);
		return new TypeDef(this.name, rt);
	}
}
