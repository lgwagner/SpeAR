package com.rockwellcollins.spear.typing;

public class AbstractType extends Type {
	public String id;

	public AbstractType(String id) {
		this.id=id;	
	}
	
	@Override
	public String toString() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractType) {
			AbstractType other = (AbstractType) obj;
			return this.id.equals(other.id);
		}
		return false;
	}
}
