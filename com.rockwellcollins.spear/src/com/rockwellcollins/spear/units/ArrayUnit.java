package com.rockwellcollins.spear.units;

public class ArrayUnit extends Unit {

	public String name;
	public Unit base;
	public int size;

	public ArrayUnit(String name, Unit base, int size) {
		this.name = name;
		this.base = base;
		this.size = size;
	}

	@Override
	public String toString() {
		return base.toString() + "[" + size + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ArrayUnit) {
			ArrayUnit other = (ArrayUnit) obj;
			return size == other.size && base.equals(other.base);
		}
		return false;
	}
}
