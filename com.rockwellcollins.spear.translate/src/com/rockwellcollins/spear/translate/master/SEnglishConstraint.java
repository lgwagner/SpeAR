package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.translate.naming.Renaming;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;

public class SEnglishConstraint extends SConstraint {

	public static SEnglishConstraint build(EnglishConstraint ec, Renaming map) {
		return new SEnglishConstraint(ec,map);
	}
	
	public String text;

	
	public SEnglishConstraint(EnglishConstraint ec, Renaming map) {
		this.name = map.getName(ec.getName());
		this.text = ec.getText();
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(Renaming map) {
		return new jkind.lustre.VarDecl(this.name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(Renaming map) {
		jkind.lustre.IdExpr lhs = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr rhs = new jkind.lustre.BoolExpr(true);
		return new jkind.lustre.Equation(lhs,rhs);
	}

	@Override
	public jkind.lustre.Equation getPropertyEquation(String assertion, Renaming map) {
		IdExpr lhs = new IdExpr(this.name);
		jkind.lustre.Expr rhs = new BinaryExpr(new IdExpr(assertion),BinaryOp.IMPLIES, new jkind.lustre.BoolExpr(true));
		return new jkind.lustre.Equation(lhs,rhs);		
	}
}
