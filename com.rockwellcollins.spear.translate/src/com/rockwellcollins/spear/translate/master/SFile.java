//package com.rockwellcollins.spear.translate.master;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.eclipse.emf.ecore.EObject;
//
//import com.rockwellcollins.spear.Definitions;
//import com.rockwellcollins.spear.File;
//import com.rockwellcollins.spear.Specification;
//import com.rockwellcollins.spear.util.SpearSwitch;
//
//public class SFile {
//	
//	public static SFile build(File f, NameMap map) {
//		SFileBuilder builder = new SFileBuilder(map);
//		return builder.doSwitch(f);
//	}
//	
//	public static List<SFile> build(List<File> list, NameMap map) {
//		List<SFile> converted = new ArrayList<>();
//		SFileBuilder builder = new SFileBuilder(map);
//		for(File f : list) {
//			converted.add(builder.doSwitch(f));
//		}
//		return converted;
//	}
//	
//	public String name;
//	public List<STypeDef> typedefs = new ArrayList<>();
//	public List<SConstant> constants = new ArrayList<>();
//	public List<SPattern> patterns = new ArrayList<>();
//	
//	public NameMap map;
//
//	private static class SFileBuilder extends SpearSwitch<SFile> {
//		private NameMap map;
//		
//		private SFileBuilder(NameMap map) {
//			this.map=map;
//		}
//		
//		@Override
//		public SFile caseSpecification(Specification s) {
//			return new SSpecification(s,map);
//		}
//		
//		@Override
//		public SFile caseDefinitions(Definitions d) {
//			return new SDefinitions(d,map);
//		}
//		
//		@Override
//		public SFile defaultCase(EObject o) {
//			throw new RuntimeException("Expected a File object, received: " + o.toString());
//		}
//	}
//}
//
//
