package com.rockwellcollins.spear.utilities;

import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayExpr;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ConstantChecker extends SpearSwitch<Boolean> {

	public static Boolean isConstant(Constant c) {
		if(c.getExpr() != null) {
			return isConstant(c.getExpr());	
		}
		return true;
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
	public Boolean caseArrayExpr(ArrayExpr ae) {
		for (Expr e : ae.getExprs()) {
			boolean current = this.doSwitch(e);
			if (!current) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean caseArrayAccessExpr(ArrayAccessExpr aae) {
		return this.doSwitch(aae.getArray());
	}

	@Override
	public Boolean caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		boolean array = this.doSwitch(aue.getAccess().getArray());
		boolean update = this.doSwitch(aue.getValue());
		return array && update;
	}

	@Override
	public Boolean caseRecordExpr(RecordExpr re) {
		for (FieldExpr fe : re.getFieldExprs()) {
			boolean current = this.doSwitch(fe.getExpr());
			if (!current) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean caseRecordAccessExpr(RecordAccessExpr rae) {
		return this.doSwitch(rae.getRecord());
	}

	@Override
	public Boolean caseRecordUpdateExpr(RecordUpdateExpr rue) {
		boolean record = this.doSwitch(rue.getRecord());
		boolean update = this.doSwitch(rue.getValue());
		return record && update;
	}

	@Override
	public Boolean caseFieldlessRecordExpr(FieldlessRecordExpr fre) {
		for (Expr e : fre.getExprs()) {
			boolean current = this.doSwitch(e);
			if (!current) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean caseBinaryExpr(BinaryExpr be) {
		boolean left = this.doSwitch(be.getLeft());
		boolean right = this.doSwitch(be.getRight());

		switch (be.getOp()) {
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
