package com.rockwellcollins.spear.translate.references;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.language.Create;

public class IndexReference extends Reference {

	public Reference base;
	public Integer index;
	
	public IndexReference(Reference base, Integer index) {
		this.base=base;
		this.index=index;
	}
	
	@Override
	public Expr toExpr() {
		return Create.createArrayAccessExpr(base.toExpr(), Create.createInteger(index));
	}
}
