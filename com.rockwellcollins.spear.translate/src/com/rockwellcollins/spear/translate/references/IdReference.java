package com.rockwellcollins.spear.translate.references;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.language.Create;

public class IdReference extends Reference {

	public IdRef idref;

	public IdReference(IdRef ref) {
		this.idref = ref;
	}

	@Override
	public Expr toExpr() {
		return Create.createIdExpr(idref);
	}
}
