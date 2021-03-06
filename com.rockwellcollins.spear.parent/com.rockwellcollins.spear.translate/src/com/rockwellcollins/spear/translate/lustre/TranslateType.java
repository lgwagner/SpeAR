package com.rockwellcollins.spear.translate.lustre;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.BoolType;
import com.rockwellcollins.spear.IntType;
import com.rockwellcollins.spear.RealType;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.naming.Scope;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.NamedType;
import jkind.lustre.Type;

public class TranslateType extends SpearSwitch<Type> {

	public static Type translate(com.rockwellcollins.spear.Type t, Scope map) {
		return new TranslateType(map).doSwitch(t);
	}

	private Scope map;

	private TranslateType(Scope map) {
		this.map = map;
	}

	@Override
	public Type caseUserType(UserType ut) {
		String name = map.lookup(ut.getDef().getName());
		return new NamedType(name);
	}

	@Override
	public Type caseBoolType(BoolType bt) {
		return NamedType.BOOL;
	}

	@Override
	public Type caseIntType(IntType it) {
		return NamedType.INT;
	}

	@Override
	public Type caseRealType(RealType rt) {
		return NamedType.REAL;
	}

	@Override
	public Type defaultCase(EObject o) {
		throw new RuntimeException("Expected a type, but received " + o);
	}
}
