package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.translate.naming.Renaming;

public class SLustreProperty {

	public static List<SLustreProperty> build(List<LustreProperty> list, Renaming map) {
		List<SLustreProperty> built = new ArrayList<>();
		for(LustreProperty lp : list) {
			built.add(SLustreProperty.build(lp,map));
		}
		return built;
	}
	
	public static List<String> toLustre(List<SLustreProperty> list) {
		List<String> lustre = new ArrayList<>();
		for(SLustreProperty prop : list) {
			lustre.add(prop.propertyId);
		}
		return lustre;
	}
	
	public static SLustreProperty build(LustreProperty lp, Renaming map) {
		return new SLustreProperty(lp,map);
	}
	
	private String propertyId;

	public SLustreProperty(LustreProperty lp, Renaming map) {
		this.propertyId = map.lookupOriginal(lp.getPropertyId().getName());
	}
	
	public String toLustre() {
		return this.propertyId;
	}
}
