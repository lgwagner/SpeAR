package com.rockwellcollins.spear.translate.master;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public abstract class STypeDef {

	public static List<STypeDef> build(Collection<TypeDef> list, SProgram p) {
		return list.stream().map(td -> STypeDef.build(td, p)).collect(Collectors.toList());
	}

	public static List<jkind.lustre.TypeDef> toLustre(List<STypeDef> list, SProgram p) {
		return list.stream().map(std -> std.toLustre(p)).collect(Collectors.toList());
	}

	public static STypeDef build(TypeDef td, SProgram program) {
		return new STypeDefBuilder(program).doSwitch(td);
	}

	public String name;

	public abstract jkind.lustre.TypeDef toLustre(SProgram p);

	private static class STypeDefBuilder extends SpearSwitch<STypeDef> {
		private SProgram program;

		private STypeDefBuilder(SProgram program) {
			this.program = program;
		}

		@Override
		public STypeDef caseNamedTypeDef(NamedTypeDef ntd) {
			return new SNamedTypeDef(ntd, program);
		}

		@Override
		public STypeDef caseRecordTypeDef(RecordTypeDef rtd) {
			return new SRecordTypeDef(rtd, program);
		}

		@Override
		public STypeDef caseArrayTypeDef(ArrayTypeDef atd) {
			return new SArrayTypeDef(atd, program);
		}

		@Override
		public STypeDef caseEnumTypeDef(EnumTypeDef etd) {
			return new SEnumTypeDef(etd, program);
		}

		@Override
		public STypeDef casePredicateSubTypeDef(PredicateSubTypeDef pstd) {
			return new SPredicateSubTypeDef(pstd, program);
		}
	}
}
