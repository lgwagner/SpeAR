package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.translate.master.SCall;
import com.rockwellcollins.spear.translate.master.SSpecification;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.typing.Type;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.ArrayAccessExpr;
import jkind.lustre.ArrayUpdateExpr;
import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.Expr;
import jkind.lustre.IfThenElseExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordUpdateExpr;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;

public class TranslateCallExpr extends SpearSwitch<Expr> {

	public static Expr translate(EObject e, SSpecification spec) {
		return new TranslateCallExpr(spec).doSwitch(e);
	}
	
	private SSpecification specification;

	public TranslateCallExpr(SSpecification s) {
		this.specification=s;
	}
	
	@Override
	public Expr caseNormalizedCall(com.rockwellcollins.spear.NormalizedCall call) {
		List<Expr> args = new ArrayList<>();
		for(com.rockwellcollins.spear.Expr e : call.getArgs()) {
			args.add(this.doSwitch(e));
		}
		
		for(IdRef idr : call.getIds()) {
			args.add(this.doSwitch(idr));
		}

		String nodeName = specification.map.lookupOriginal(call.getSpec().getName());
		SCall scall = SCall.get(call,specification.calls);
		args.addAll(scall.getCallArgs());
		return new NodeCallExpr(nodeName,args);
	}
	
	@Override
	public Expr caseUnaryExpr(com.rockwellcollins.spear.UnaryExpr unary) {
		Expr sub = doSwitch(unary.getExpr());
		switch (unary.getOp()) {
			case "not":
			case "-":
				return new UnaryExpr(UnaryOp.fromString(unary.getOp()), sub);

			case "once":
			case "historically":
			case "initially":
				List<Expr> args = new ArrayList<>();
				args.add(sub);
				return new NodeCallExpr(unary.getOp(),args);
				
			default:
				throw new RuntimeException("Unsupported unary operator " + unary.getOp() + " provided.");
		}
	}
	
	@Override
	public Expr caseRecordAccessExpr(com.rockwellcollins.spear.RecordAccessExpr rae) {
		return new RecordAccessExpr(doSwitch(rae.getRecord()),rae.getField().getName());
	}
	
	@Override
	public Expr caseRecordUpdateExpr(com.rockwellcollins.spear.RecordUpdateExpr rue) {
		return new RecordUpdateExpr(doSwitch(rue.getRecord()),rue.getField().getName(),doSwitch(rue.getValue()));
	}
	
	@Override
	public Expr caseArrayAccessExpr(com.rockwellcollins.spear.ArrayAccessExpr aae) {
		return new ArrayAccessExpr(doSwitch(aae.getArray()), doSwitch(aae.getIndex()));
	}
	
	@Override
	public Expr caseArrayUpdateExpr(com.rockwellcollins.spear.ArrayUpdateExpr aue) {
		return new ArrayUpdateExpr(doSwitch(aue.getAccess().getArray()),doSwitch(aue.getAccess().getIndex()),doSwitch(aue.getValue()));
	}
	
	@Override
	public Expr casePreviousExpr(com.rockwellcollins.spear.PreviousExpr prev) {
		Expr pre = new UnaryExpr(UnaryOp.PRE, doSwitch(prev.getVar()));
		if(prev.getInit() == null) {
			return pre;
		} else {
			return new BinaryExpr(doSwitch(prev.getInit()), BinaryOp.ARROW, pre);	
		}
	}
	
	@Override
	public Expr casePatternCall(com.rockwellcollins.spear.PatternCall call) {
		List<Expr> args = new ArrayList<>();
		for(com.rockwellcollins.spear.Expr e : call.getArgs()) {
			args.add(TranslateExpr.translate(e, this.specification.map));
		}
		return new NodeCallExpr(call.getPattern().getName(), args);
	}
	
	@Override
	public Expr caseBinaryExpr(com.rockwellcollins.spear.BinaryExpr binary) {
		Expr left = doSwitch(binary.getLeft());
		Expr right = doSwitch(binary.getRight());
		
		switch (binary.getOp()) {
			case "->":
			case "and":
			case "or":
			case "xor":
			case ">":
			case ">=":
			case "<":
			case "<=":
			case "<>":
			case "+":
			case "-":
			case "*":
			case "mod":
				BinaryOp op = BinaryOp.fromString(binary.getOp());
				return new BinaryExpr(left, op, right);

			case "/":
				Type leftType = SpearTypeChecker.typeCheck(binary.getLeft());
				if(leftType.equals(SpearTypeChecker.INT)) {
					return new BinaryExpr(left, BinaryOp.INT_DIVIDE, right);
				}
				return new BinaryExpr(left, BinaryOp.DIVIDE, right);
				
			case "implies":
				return new BinaryExpr(left, BinaryOp.IMPLIES, right);
				
			case "==":
				return new BinaryExpr(left, BinaryOp.EQUAL, right);
				
			case "since":
			case "triggers":
				List<Expr> args = new ArrayList<>();
				args.add(left);
				args.add(right);
				return new NodeCallExpr(binary.getOp(),args);
				
			default:
				throw new RuntimeException("Unsupported binary operator " + binary.getOp() + " provided.");
		}
	}
	
	@Override
	public Expr caseIfThenElseExpr(com.rockwellcollins.spear.IfThenElseExpr ite) {
		Expr condExpr = this.doSwitch(ite.getCond());
		Expr thenExpr = this.doSwitch(ite.getThen());
		Expr elseExpr = this.doSwitch(ite.getElse());
		return new IfThenElseExpr(condExpr,thenExpr,elseExpr);
	}
	
	@Override
	public Expr defaultCase(EObject o) {
		return TranslateExpr.translate(o, specification.map);
	}
}
