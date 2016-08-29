//package com.rockwellcollins.spear.translate.master;
//
//import com.rockwellcollins.spear.Definitions;
//import com.rockwellcollins.spear.translate.naming.PNameMap;
//
//public class SDefinitions extends SFile {
//
//	public SDefinitions(Definitions d, PNameMap map) {
//		//this will initialize the map to include a file map
//		map.addFile(d, this);
//		
//		//register the definitions name in the global scope
//		this.name = map.getName(d);
//		
//		typedefs.addAll(STypeDef.build(d.getTypedefs(), map));
//		constants.addAll(SConstant.build(d.getConstants(), map));
//		patterns.addAll(SPattern.build(d.getPatterns(), map));
//	}
//}
