package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IntervalExpr;
import com.rockwellcollins.spear.SetExpr;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.typing.ArrayType;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.typing.Type;

public class ExpandInExpressions {

	public static void transform(Document doc) {
		doc.files.forEach(f -> transform(f));
	}

	public static void transform(EObject o) {
		for(BinaryExpr be : EcoreUtil2.getAllContentsOfType(o, BinaryExpr.class)) {
			if(!be.getOp().equals("in")) {
				continue;
			}
			
			Expr left = be.getLeft();
			Expr right = be.getRight();
			
			if (right instanceof SetExpr) {
				SetExpr set = (SetExpr) right;
				List<Expr> list = new ArrayList<>();
				for(Expr e : set.getExprs()) {
					list.add(Create.createEquals(EcoreUtil2.copy(left), EcoreUtil2.copy(e)));
				}
				
				Expr replace = Create.createOr(list.iterator());
				EcoreUtil2.replace(be, replace);
				continue;
			}
			
			if (right instanceof IntervalExpr) {
				IntervalExpr ive = (IntervalExpr) right;
				Expr lower = Create.createBinaryExpr(EcoreUtil2.copy(left), getLowerOp(ive), EcoreUtil2.copy(ive.getLow()));
				Expr upper = Create.createBinaryExpr(EcoreUtil2.copy(left), getUpperOp(ive), EcoreUtil2.copy(ive.getHigh()));
				Expr replace = Create.createAnd(lower, upper);
				EcoreUtil2.replace(be,replace);
				continue;
			}
			
			Type type = SpearTypeChecker.typeCheck(right);
			if (type instanceof ArrayType) {
				ArrayType arrayType = (ArrayType) type;
				List<Expr> list = new ArrayList<>();
				for(int i=0; i<arrayType.size; i++) {
					Expr index = Create.createInteger(i);
					list.add(Create.createEquals(EcoreUtil2.copy(left), Create.createArrayAccessExpr(EcoreUtil2.copy(right), index)));
				}
				Expr replace = Create.createOr(list.iterator());
				EcoreUtil2.replace(be, replace);
				continue;
			}
		}
	}

	private static String getLowerOp(IntervalExpr ive) {
		switch(ive.getStyle()) {
			case "<..":
			case "<..<":
				return ">";
				
			default:
				return ">=";
		}
	}

	private static String getUpperOp(IntervalExpr ive) {
		switch(ive.getStyle()) {
		case "..<":
		case "<..<":
			return "<";
			
		default:
			return "<=";
		}
	}
}
