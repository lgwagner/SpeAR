package com.rockwellcollins.spear.translate.lustre;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.naming.Renaming;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.ArrayExpr;
import jkind.lustre.BoolExpr;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.RealExpr;
import jkind.lustre.RecordExpr;

public class TranslateExpr extends SpearSwitch<Expr> {

	public static Expr translate(EObject o, Renaming map) {
		return new TranslateExpr(map).doSwitch(o);
	}
	
	private Renaming map;

	public TranslateExpr(Renaming map) {
		this.map=map;
	}
	
	@Override
	public Expr caseBoolLiteral(com.rockwellcollins.spear.BoolLiteral bl) {
		switch(bl.getValue()) {
			case "TRUE":
			case "true":
				return new BoolExpr(true);
				
			case "FALSE":
			case "false":
				return new BoolExpr(false);
				
			default:
				throw new RuntimeException("Unexpected boolean literal encountered.");
		}
	}
	
	@Override
	public Expr caseIdExpr(com.rockwellcollins.spear.IdExpr ide) {
		return doSwitch(ide.getId());
	}
	
	@Override
	public Expr caseMacro(Macro m) {
		return new IdExpr(map.lookupOriginal(m.getName()));
	}

	@Override
	public Expr caseIntLiteral(com.rockwellcollins.spear.IntLiteral il) {
		return new IntExpr(il.getValue());
	}
	
	@Override
	public Expr caseRealLiteral(com.rockwellcollins.spear.RealLiteral rl) {
		return new RealExpr(new BigDecimal(rl.getValue()));
	}
	
	@Override
	public Expr caseConstant(Constant c) {
		return new IdExpr(map.lookupOriginal(c.getName()));
	}
	
	@Override
	public Expr caseEnumValue(EnumValue ev) {
		return new IdExpr(map.lookupOriginal(ev.getName()));
	}
	
	@Override
	public Expr caseRecordExpr(com.rockwellcollins.spear.RecordExpr re) {
		Map<String,Expr> fields = new LinkedHashMap<>();
		for(com.rockwellcollins.spear.FieldExpr fe : re.getFieldExprs()) {
			fields.put(fe.getField().getName(), doSwitch(fe.getExpr()));
		}
		return new RecordExpr(map.lookupOriginal(re.getType().getName()),fields);
	}
	
	@Override
	public Expr caseArrayExpr(com.rockwellcollins.spear.ArrayExpr ae) {
		List<Expr> list = new ArrayList<>();
		for(com.rockwellcollins.spear.Expr expr : ae.getExprs()) {
			list.add(doSwitch(expr));
		}
		return new ArrayExpr(list);
	}
	
	@Override
	public Expr caseVariable(Variable v) {
		String name = map.lookupOriginal(v.getName());
		return new IdExpr(name);
	}
	
	@Override
	public Expr defaultCase(EObject o) {
		throw new RuntimeException("Unexpected element provided: " + o.toString());
	}
}
