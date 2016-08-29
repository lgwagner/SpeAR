package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.naming.PNameMap;
import com.rockwellcollins.spear.util.SpearSwitch;

public abstract class STypeDef {

	public static List<STypeDef> build(List<TypeDef> list, PNameMap map) {
		List<STypeDef> processed = new ArrayList<>();
		for(TypeDef td : list) {
			processed.add(STypeDef.build(td, map));
		}
		return processed;
	}
	
	public static List<jkind.lustre.TypeDef> toLustre(List<STypeDef> list, PNameMap map) {
		List<jkind.lustre.TypeDef> lustre = new ArrayList<>();
		for(STypeDef std : list) {
			lustre.add(std.toLustre(map));
		}
		return lustre;
	}
	
	public static STypeDef build(TypeDef td, PNameMap map) {
		STypeDefBuilder builder = new STypeDefBuilder(map);
		return builder.doSwitch(td);
	}
	
	public String name;
	public abstract jkind.lustre.TypeDef toLustre(PNameMap map);
	
	private static class STypeDefBuilder extends SpearSwitch<STypeDef> {
		private PNameMap map;
		
		private STypeDefBuilder(PNameMap map) {
			this.map=map;
		}
		
		@Override
		public STypeDef caseNamedTypeDef(NamedTypeDef ntd) {
			return new SNamedTypeDef(ntd,map);
		}
		
		@Override
		public STypeDef caseRecordTypeDef(RecordTypeDef rtd) {
			return new SRecordTypeDef(rtd,map);
		}
		
		@Override
		public STypeDef caseArrayTypeDef(ArrayTypeDef atd) {
			return new SArrayTypeDef(atd,map);
		}
		
		@Override
		public STypeDef caseEnumTypeDef(EnumTypeDef etd) {
			return new SEnumTypeDef(etd,map);
		}
	}
	

}
