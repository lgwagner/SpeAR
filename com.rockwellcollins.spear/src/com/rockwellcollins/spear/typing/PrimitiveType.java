package com.rockwellcollins.spear.typing;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.BoolType;
import com.rockwellcollins.spear.IntType;
import com.rockwellcollins.spear.RealType;
import com.rockwellcollins.spear.SpearFactory;

public class PrimitiveType extends Type {
	
	public static final PrimitiveType BOOL = new PrimitiveType("bool");
	public static final PrimitiveType REAL = new PrimitiveType("real");
	public static final PrimitiveType INT = new PrimitiveType("int");
	public static final PrimitiveType ERROR = new PrimitiveType("<ERROR>");
	
	private final String name;
	
	public static boolean isPrimitive(EObject eo) {
		Type st = SpearTypeChecker.typeCheck(eo);
		return st.equals(BOOL) || st.equals(REAL) || st.equals(INT);
	}
	
	private PrimitiveType(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public com.rockwellcollins.spear.Type getType() {
		if(this.equals(BOOL)) {
			BoolType bt = SpearFactory.eINSTANCE.createBoolType();
			return bt;
		}
		
		if(this.equals(REAL)) {
			RealType rt = SpearFactory.eINSTANCE.createRealType();
			return rt;
		}
		
		if(this.equals(INT)) {
			IntType it = SpearFactory.eINSTANCE.createIntType();
			return it;
		}
		
		return null;
	}
	
	
}
