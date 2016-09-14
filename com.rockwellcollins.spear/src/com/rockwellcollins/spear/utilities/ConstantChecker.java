package com.rockwellcollins.spear.utilities;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ConstantChecker extends SpearSwitch<Boolean> {

	public static Boolean isConstant(Constant c) {
		return isConstant(c.getExpr());
	}
	
	public static Boolean isConstant(Expr e) {
		ConstantChecker cc = new ConstantChecker();
		return cc.doSwitch(e);
	}
	
	@Override
	public Boolean caseRealLiteral(RealLiteral e) {
		return true;
	}
	
	@Override
	public Boolean caseIntLiteral(IntLiteral e) {
		return true;
	}
	
	@Override
	public Boolean caseBoolLiteral(BoolLiteral e) {
		return true;
	}
	
	@Override
	public Boolean caseIfThenElseExpr(IfThenElseExpr ite) {
		return false;
	}
	
	@Override
	public Boolean caseWhileExpr(WhileExpr we) {
		boolean cond = this.doSwitch(we.getCond());
		boolean when = this.doSwitch(we.getThen());
		return cond && when;
	}
	
	@Override
	public Boolean caseBinaryExpr(BinaryExpr be) {
		boolean left = this.doSwitch(be.getLeft());
		boolean right = this.doSwitch(be.getRight());
		
		switch(be.getOp()) {
			case "+":
			case "-":
			case "*":
			case "/":
			case "mod":
			case "=>":
			case "implies":
			case "or":
			case "and":
			case "xor":
			case ">":
			case "greater than":
			case "<":
			case "less than":
			case ">=":
			case "greater than or equal to":
			case "<=":
			case "less than or equal to":
			case "==":
			case "equal to":
			case "<>":
			case "not equal to":
				return left && right;
				
			default:
				return false;
		}
	}
	
	@Override
	public Boolean caseUnaryExpr(UnaryExpr ue) {
		return this.doSwitch(ue.getExpr());
	}
	
	@Override
	public Boolean caseIdExpr(IdExpr e) {
		if (e.getId() instanceof Constant || e.getId() instanceof EnumValue) {
			return true;
		}
		
		if (e.getId() instanceof Macro) {
			Macro macro = (Macro) e.getId();
			return doSwitch(macro);
		}
		
		// variable is the last case
		return false;
	}
	
	@Override
	public Boolean caseExpr(Expr e) {
		return false;
	}
}
