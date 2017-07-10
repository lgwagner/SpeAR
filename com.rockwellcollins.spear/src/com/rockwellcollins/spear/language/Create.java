package com.rockwellcollins.spear.language;

import java.util.Iterator;
import java.util.List;

import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.FormalConstraintFlag;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.MultipleExpr;
import com.rockwellcollins.spear.Observe;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;

public class Create {

	private static SpearFactory f = SpearFactory.eINSTANCE;

	// the following constants are considered to be "default" versions of their
	// respective operators
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
	// These will be transformed into the default operators for simpler
	// processing
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

	private static Expr createUnaryExpr(String operator, Expr sub) {
		UnaryExpr ue = f.createUnaryExpr();
		ue.setExpr(sub);
		ue.setOp(operator);
		return ue;
	}

	private static Expr createBinaryExpr(Expr left, String operator, Expr right) {
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
		for (Macro m : list) {
			mide.getExprs().add(createIdExpr(m));
		}
		return mide;
	}

	public static BoolLiteral createTrue() {
		BoolLiteral bl = f.createBoolLiteral();
		bl.setValue("true");
		return bl;
	}

	public static BoolLiteral createFalse() {
		BoolLiteral bl = f.createBoolLiteral();
		bl.setValue("false");
		return bl;
	}

	public static IntLiteral createInteger(Integer value) {
		IntLiteral il = f.createIntLiteral();
		il.setValue(value);
		return il;
	}

	public static Expr createNot(Expr sub) {
		return createUnaryExpr(NOT, sub);
	}

	public static Expr createMinus(Expr sub) {
		return createUnaryExpr(MINUS, sub);
	}

	public static Expr createOnce(Expr sub) {
		return createUnaryExpr(ONCE, sub);
	}

	public static Expr createHistorically(Expr sub) {
		return createUnaryExpr(HISTORICALLY, sub);
	}

	public static Expr createInitially(Expr sub) {
		return createUnaryExpr(INITIALLY, sub);
	}

	public static Expr createImplication(Expr left, Expr right) {
		return createBinaryExpr(left, IMPLIES, right);
	}

	public static Expr createTriggers(Expr left, Expr right) {
		return createBinaryExpr(left, TRIGGERS, right);
	}

	public static FormalConstraint createFormalConstraint(String name, Expr expr) {
		FormalConstraint fc = f.createFormalConstraint();
		fc.setName(name);
		fc.setExpr(expr);
		return fc;
	}

//	public static Expr createAnd(Expr left, Expr right) {
//		return createBinaryExpr(left, "and", right);
//	}

	public static Expr createAnd(Expr first, Expr... rest) {
		Expr result = first;
		for(Expr e : rest) {
			result = createBinaryExpr(result, "and", e);
		}
		return result;
	}
	
	public static Expr createAnd(Iterator<Expr> exprs) {
		if (exprs.hasNext()) {
			Expr next = exprs.next();
			if (exprs.hasNext()) {
				return createAnd(next, createAnd(exprs));
			} else {
				return next;
			}
		}
		return createTrue();
	}

	public static Expr createOr(Expr left, Expr right) {
		return createBinaryExpr(left, "or", right);
	}
	
	public static Expr createIdExpr(IdRef c) {
		IdExpr ide = f.createIdExpr();
		ide.setId(c);
		return ide;
	}

	public static Expr createPrevious(Expr previous, Expr init) {
		PreviousExpr prev = f.createPreviousExpr();
		prev.setVar(previous);
		if(init != null) {
			prev.setInit(init);
		}
		return prev;
	}
	
	public static Expr createRecordAccessExpr(Expr record, FieldType ft) {
		RecordAccessExpr rae = f.createRecordAccessExpr();
		rae.setRecord(record);
		rae.setField(ft);
		return rae;
	}

	public static Expr createArrayAccessExpr(Expr array, Expr index) {
		ArrayAccessExpr aae = f.createArrayAccessExpr();
		aae.setArray(array);
		aae.setIndex(index);
		return aae;
	}

	public static LustreAssertion createLustreAssertion(Expr expr) {
		LustreAssertion la = f.createLustreAssertion();
		la.setAssertionExpr(expr);
		return la;
	}

	public static LustreAssertion createLustreAssertion(Variable prop) {
		return createLustreAssertion(Create.createIdExpr(prop));
	}

	public static Variable createVariable(String name, Type t) {
		Variable v = f.createVariable();
		v.setName(name);
		v.setType(t);
		return v;
	}

	public static Variable createBoolVariable(String name) {
		Type t = f.createBoolType();
		return createVariable(name, t);
	}

	public static LustreEquation createLustreEquation(List<Variable> ids, Expr e) {
		LustreEquation leq = f.createLustreEquation();
		leq.getIds().addAll(ids);
		leq.setRhs(e);
		return leq;
	}

	public static LustreProperty createLustreProperty(Variable prop) {
		LustreProperty lp = f.createLustreProperty();
		lp.setPropertyId(prop);
		return lp;
	}

	public static Pattern createPattern(String string) {
		Pattern p = f.createPattern();
		p.setName(string);
		return p;
	}

	public static Type createUserType(TypeDef td) {
		UserType ut = f.createUserType();
		ut.setDef(td);
		return ut;
	}

	public static FormalConstraintFlag Observe() {
		Observe ob = f.createObserve();
		return ob;
	}
}
