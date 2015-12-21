package com.rockwellcollins.spear.units;

public class EnumUnit extends SpearUnit {

	public String id;
	
	public EnumUnit(String id) {
		this.id=id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnumUnit) {
			EnumUnit other = (EnumUnit) obj;
			return id==other.id;
		}
		
		return false;
	}
}
