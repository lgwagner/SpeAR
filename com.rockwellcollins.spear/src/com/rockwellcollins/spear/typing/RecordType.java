package com.rockwellcollins.spear.typing;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.UserType;

public class RecordType extends Type {

	public final String id;
	public final Map<String, Type> fields;
	private RecordTypeDef typedef;

	public RecordType(String name, Map<String, Type> fields, RecordTypeDef rtd) {
		this.id = name;
		this.fields = Collections.unmodifiableSortedMap(new TreeMap<>(fields));
		this.typedef = rtd;
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
		if (obj instanceof RecordType) {
			RecordType other = (RecordType) obj;
			return id.equals(other.id);
		}
		return false;
	}

	@Override
	public com.rockwellcollins.spear.Type getType() {
		UserType ut = SpearFactory.eINSTANCE.createUserType();
		ut.setDef(typedef);
		return ut;
	}
}
