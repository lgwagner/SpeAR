package com.rockwellcollins.spear.translate.master;

import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.PNameMap;

import jkind.lustre.RecordType;
import jkind.lustre.TypeDef;

public class SRecordTypeDef extends STypeDef {
	
	public String definitionName;
	public Map<String,Type> fields = new LinkedHashMap<>();
	
	public SRecordTypeDef(RecordTypeDef rtd, PNameMap map) {
		this.name = map.getName(rtd.getName());
		this.definitionName = map.getName(rtd.getName() + "_definition");
		for(FieldType ft : rtd.getFields()) {
			fields.put(ft.getName(), ft.getType());
		}
	}

	@Override
	public TypeDef toLustre(PNameMap naming) {
		Map<String,jkind.lustre.Type> lustreFields = new LinkedHashMap<>();
		for(String fieldName : fields.keySet()) {
			lustreFields.put(fieldName,TranslateType.translate(fields.get(fieldName), naming));
		}
		jkind.lustre.RecordType rt = new RecordType(this.definitionName,lustreFields);
		return new TypeDef(this.name,rt);
	}
}
