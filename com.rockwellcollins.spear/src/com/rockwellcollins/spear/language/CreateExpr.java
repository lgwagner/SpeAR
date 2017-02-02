package com.rockwellcollins.spear.language;

import java.util.List;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.MultipleExpr;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.UnaryExpr;

public class CreateExpr {
	
	private static SpearFactory f = SpearFactory.eINSTANCE;
	
	// the following constants are considered to be "default" versions of their respective operators
	public static final String NOT = "not";
	public static final String MINUS = "-";
	public static final String ONCE = "once";
	public static final String HISTORICALLY = "historically";
	public static final String INITIALLY = "initially";
	public static final String IMPLIES = "implies";
	public static final String TRIGGERS = "triggers";
	public static final String SINCE = "since";
	public static final String LESS_THAN = "<";
	public static final String LESS_THAN_OR_EQUAL_TO = "<=";
	public static final String GREATER_THAN = ">";
	public static final String GREATER_THAN_OR_EQUAL_TO = ">=";
	public static final String EQUAL_TO = "==";
	public static final String NOT_EQUAL_TO = "<>";
	public static final String ARROW = "->";
	
	// these are constants to represent the alternative versions. 
	// These will be transformed into the default operators for simpler processing
	public static final String ALT_ONCE = "O";
	public static final String ALT_HISTORICALLY = "H";
	public static final String ALT_IMPLIES = "=>";
	public static final String ALT_TRIGGERS = "T";
	public static final String ALT_SINCE = "S";
	public static final String ALT_LESS_THAN = "less than";
	public static final String ALT_LESS_THAN_OR_EQUAL_TO = "less than or equal to";
	public static final String ALT_GREATER_THAN = "greater than";
	public static final String ALT_GREATER_THAN_OR_EQUAL_TO = "greater than or equal to";
	public static final String ALT_EQUAL_TO = "equal to";
	public static final String ALT_NOT_EQUAL_TO = "not equal to";
	public static final String ALT_ARROW = "arrow";
	
	private static UnaryExpr createUnaryExpr(String operator, Expr sub) {
		UnaryExpr ue = f.createUnaryExpr();
		ue.setExpr(sub);
		ue.setOp(operator);
		return ue;
	}
	
	private static BinaryExpr createBinaryExpr(Expr left, String operator, Expr right) {
		BinaryExpr be = f.createBinaryExpr();
		be.setLeft(left);
		be.setRight(right);
		be.setOp(operator);
		return be;
	}
	
	public static Macro createMacro(String name, Type t, Expr e) {
		Macro m = f.createMacro();
		m.setName(name);
		m.setType(t);
		m.setExpr(e);
		return m;
	}
	
	public static IdExpr createIdExpr(Macro m) {
		IdExpr ide = f.createIdExpr();
		ide.setId(m);
		return ide;
	}
	
	public static MultipleExpr createMultipleIdExpr(List<Macro> list) {
		MultipleExpr mide = f.createMultipleExpr();
		for(Macro m : list) {
			mide.getExprs().add(createIdExpr(m));
		}
		return mide;
	}
	
	public static UnaryExpr createNot(Expr sub) {
		return createUnaryExpr(NOT,sub);
	}
	
	public static UnaryExpr createMinus(Expr sub) {
		return createUnaryExpr(MINUS,sub);
	}
	
	public static UnaryExpr createOnce(Expr sub) {
		return createUnaryExpr(ONCE,sub);
	}
	
	public static UnaryExpr createHistorically(Expr sub) {
		return createUnaryExpr(HISTORICALLY, sub);
	}
	
	public static UnaryExpr createInitially(Expr sub) {
		return createUnaryExpr(INITIALLY, sub);
	}
	
	public static BinaryExpr createImplication(Expr left, Expr right) {
		return createBinaryExpr(left,IMPLIES,right);
	}
	
	public static BinaryExpr createTriggers(Expr left, Expr right) {
		return createBinaryExpr(left,TRIGGERS,right);
	}
	
	public static FormalConstraint createFormalConstraint(String name, Expr expr) {
		FormalConstraint fc = f.createFormalConstraint();
		fc.setName(name);
		fc.setExpr(expr);
		return fc;
	}
}
