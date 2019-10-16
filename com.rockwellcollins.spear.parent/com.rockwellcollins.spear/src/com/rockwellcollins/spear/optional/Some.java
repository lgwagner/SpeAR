package com.rockwellcollins.spear.optional;

public class Some<T1> extends Optional<T1> {

	public T1 value;

	public Some(T1 t1) {
		this.value = t1;
	}
}
