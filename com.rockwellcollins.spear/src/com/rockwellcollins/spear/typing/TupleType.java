package com.rockwellcollins.spear.typing;

import java.util.Iterator;
import java.util.List;

public class TupleType extends Type {

	public final List<Type> types;
	
	public TupleType(List<Type> types) {
		this.types=types;
	}
	
	@Override
	public String toString() {
		if(types.isEmpty()) {
			return "()";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		Iterator<Type> iterator = types.iterator();
		sb.append(iterator.next());
		while(iterator.hasNext()) {
			sb.append(", ");
			sb.append(iterator.next());
		}
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return types.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TupleType) {
			TupleType other = (TupleType) obj;
			return types.equals(other.types);
		}
		return false;
	}
	
	@Override
	public com.rockwellcollins.spear.Type getType() {
		return null;
	}
}
