package com.rockwellcollins.spear.utilities;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class IntConstantFinder extends SpearSwitch<Integer> {

	public static Integer fetch(Expr e) {
		IntConstantFinder finder = new IntConstantFinder();
		return finder.doSwitch(e);
	}

	@Override
	public Integer caseConstant(Constant c) {
		if(c.getExpr() != null) {
			return this.doSwitch(c.getExpr());
		} else {
			return null;
		}
	}

	@Override
	public Integer caseMacro(Macro m) {
		return this.doSwitch(m.getExpr());
	}

	@Override
	public Integer caseBinaryExpr(BinaryExpr be) {
		Integer left = doSwitch(be.getLeft());
		Integer right = doSwitch(be.getRight());

		switch (be.getOp()) {
		case "+":
			return left + right;

		case "-":
			return left - right;

		case "*":
			return left * right;

		case "/":
			return left / right;

		case "mod":
			return left % right;

		default:
			System.err.println("Operator not supported.");
			return null;
		}
	}

	@Override
	public Integer caseUnaryExpr(UnaryExpr ue) {
		Integer sub = this.doSwitch(ue.getExpr());

		switch (ue.getOp()) {
		case "-":
			return -1 * sub;

		default:
			System.err.println("Operator not supported.");
			return null;
		}
	}

	@Override
	public Integer caseIdExpr(IdExpr e) {
		return this.doSwitch(e.getId());
	}

	@Override
	public Integer caseIntLiteral(IntLiteral e) {
		return e.getValue();
	}

	@Override
	public Integer defaultCase(EObject e) {
		return null;
	}
}
