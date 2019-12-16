package com.rockwellcollins.spear.units;

public class EnumUnit extends Unit {

	public String id;

	public EnumUnit(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + " enum";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnumUnit) {
			EnumUnit other = (EnumUnit) obj;
			return id == other.id;
		}

		return false;
	}
}
