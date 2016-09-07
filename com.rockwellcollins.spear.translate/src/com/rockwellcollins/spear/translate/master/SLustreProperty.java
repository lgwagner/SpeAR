package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.LustreProperty;

public class SLustreProperty {

	public static List<SLustreProperty> build(List<LustreProperty> list, SPattern pattern) {
		List<SLustreProperty> built = new ArrayList<>();
		for(LustreProperty lp : list) {
			built.add(SLustreProperty.build(lp,pattern));
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
	
	public static SLustreProperty build(LustreProperty lp, SPattern pattern) {
		return new SLustreProperty(lp,pattern);
	}
	
	private String propertyId;

	public SLustreProperty(LustreProperty lp, SPattern pattern) {
		this.propertyId = pattern.map.lookupOriginal(lp.getPropertyId().getName());
	}
	
	public String toLustre() {
		return this.propertyId;
	}
}
