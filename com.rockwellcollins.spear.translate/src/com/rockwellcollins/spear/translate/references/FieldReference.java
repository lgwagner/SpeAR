package com.rockwellcollins.spear.translate.references;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.language.Create;

public class FieldReference extends Reference {

	public Reference base;
	public FieldType field;
	
	public FieldReference(Reference base, FieldType ft) {
		this.base=base;
		this.field=ft;
	}

	@Override
	public Expr toExpr() {
		return Create.createRecordAccessExpr(base.toExpr(), field);
	}
}
