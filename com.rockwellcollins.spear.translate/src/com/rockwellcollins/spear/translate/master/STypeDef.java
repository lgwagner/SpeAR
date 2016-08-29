package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.naming.Renaming;
import com.rockwellcollins.spear.util.SpearSwitch;

public abstract class STypeDef {

	public static List<STypeDef> build(List<TypeDef> list, Renaming map) {
		List<STypeDef> processed = new ArrayList<>();
		for(TypeDef td : list) {
			processed.add(STypeDef.build(td, map));
		}
		return processed;
	}
	
	public static List<jkind.lustre.TypeDef> toLustre(List<STypeDef> list, Renaming map) {
		List<jkind.lustre.TypeDef> lustre = new ArrayList<>();
		for(STypeDef std : list) {
			lustre.add(std.toLustre(map));
		}
		return lustre;
	}
	
	public static STypeDef build(TypeDef td, Renaming map) {
		STypeDefBuilder builder = new STypeDefBuilder(map);
		return builder.doSwitch(td);
	}
	
	public String name;
	public abstract jkind.lustre.TypeDef toLustre(Renaming map);
	
	private static class STypeDefBuilder extends SpearSwitch<STypeDef> {
		private Renaming map;
		
		private STypeDefBuilder(Renaming map) {
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
