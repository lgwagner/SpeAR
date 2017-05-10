package com.rockwellcollins.spear.translate.master;

import java.util.List;
import java.util.stream.Collectors;

import com.rockwellcollins.spear.LustreProperty;

public class SLustreProperty {

  public static List<SLustreProperty> build(List<LustreProperty> list, SPattern p) {
    return list.stream().map(lp -> new SLustreProperty(lp, p)).collect(Collectors.toList());
  }

  public static List<String> toLustre(List<SLustreProperty> list) {
    return list.stream().map(slp -> slp.propertyId).collect(Collectors.toList());
  }

  private String propertyId;

  public SLustreProperty(LustreProperty lp, SPattern pattern) {
    this.propertyId = pattern.map.lookupOriginalModule(lp.getPropertyId().getName());
  }

  public String toLustre() {
    return this.propertyId;
  }
}
