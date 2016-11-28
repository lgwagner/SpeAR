package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.ConcreteArrayTypeDef;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public abstract class STypeDef {

	public static List<STypeDef> build(Collection<TypeDef> list, SProgram p) {
		List<STypeDef> processed = new ArrayList<>();
		for(TypeDef td : list) {
			processed.add(STypeDef.build(td, p));
		}
		return processed;
	}
	
	public static List<jkind.lustre.TypeDef> toLustre(List<STypeDef> list, SProgram p) {
		List<jkind.lustre.TypeDef> lustre = new ArrayList<>();
		for(STypeDef std : list) {
			lustre.add(std.toLustre(p));
		}
		return lustre;
	}
	
	public static STypeDef build(TypeDef td, SProgram program) {
		STypeDefBuilder builder = new STypeDefBuilder(program);
		return builder.doSwitch(td);
	}
	
	public String name;
	public abstract jkind.lustre.TypeDef toLustre(SProgram p);
	
	private static class STypeDefBuilder extends SpearSwitch<STypeDef> {
		private SProgram program;
		
		private STypeDefBuilder(SProgram program) {
			this.program=program;
		}
		
		@Override
		public STypeDef caseNamedTypeDef(NamedTypeDef ntd) {
			return new SNamedTypeDef(ntd,program);
		}
		
		@Override
		public STypeDef caseRecordTypeDef(RecordTypeDef rtd) {
			return new SRecordTypeDef(rtd,program);
		}
		
		@Override
		public STypeDef caseArrayTypeDef(ArrayTypeDef atd) {
			throw new RuntimeException("Unallowed element encountered during translation.");
		}
		
		@Override
		public STypeDef caseConcreteArrayTypeDef(ConcreteArrayTypeDef atd) {
			return new SArrayTypeDef(atd,program);
		}
		
		@Override
		public STypeDef caseEnumTypeDef(EnumTypeDef etd) {
			return new SEnumTypeDef(etd,program);
		}
	}
	

}
