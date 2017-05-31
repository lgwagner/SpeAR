package com.rockwellcollins.spear.utilities;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.BoolType;
import com.rockwellcollins.spear.IntType;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.RealType;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetBaseType extends SpearSwitch<Type> {

	public static Type get(TypeDef td) {
		GetBaseType get = new GetBaseType();
		return get.doSwitch(td);
	}

	private GetBaseType() {
	}

	@Override
	public Type caseIntType(IntType it) {
		return it;
	}

	@Override
	public Type caseBoolType(BoolType bt) {
		return bt;
	}

	@Override
	public Type caseRealType(RealType rt) {
		return rt;
	}

	@Override
	public Type caseUserType(UserType ut) {
		if (ut instanceof PredicateSubTypeDef) {
			PredicateSubTypeDef pstd = (PredicateSubTypeDef) ut;
			return doSwitch(pstd);
		}
		return ut;
	}

	@Override
	public Type casePredicateSubTypeDef(PredicateSubTypeDef pstd) {
		return doSwitch(pstd.getPredVar().getType());
	}

	@Override
	public Type defaultCase(EObject eo) {
		throw new RuntimeException("Expected type or typedef elements, received " + eo.toString());
	}
}
