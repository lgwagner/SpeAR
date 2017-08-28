package com.rockwellcollins.spear.translate.lustre;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.IntegerCast;
import com.rockwellcollins.spear.ListExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.RealCast;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.master.SCall;
import com.rockwellcollins.spear.translate.master.SMapElement;
import com.rockwellcollins.spear.translate.master.SSpecification;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.typing.Type;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.LustreLibrary;

import jkind.lustre.ArrayAccessExpr;
import jkind.lustre.ArrayExpr;
import jkind.lustre.ArrayUpdateExpr;
import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.CastExpr;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IfThenElseExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.NamedType;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RealExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordExpr;
import jkind.lustre.RecordUpdateExpr;
import jkind.lustre.TupleExpr;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;

public class TranslateExpr extends SpearSwitch<Expr> {

	public static Expr translate(EObject e, SMapElement spec) {
		return new TranslateExpr(spec).doSwitch(e);
	}

	private SMapElement module;

	private TranslateExpr(SMapElement s) {
		this.module = s;
	}

	@Override
	public Expr casePatternCall(com.rockwellcollins.spear.PatternCall call) {
		List<Expr> args = new ArrayList<>();
		args.addAll(call.getArgs().stream().map(e -> this.doSwitch(e)).collect(Collectors.toList()));
		return new NodeCallExpr(call.getPattern().getName(), args);
	}

	@Override
	public Expr caseNormalizedCall(com.rockwellcollins.spear.NormalizedCall call) {
		if (!(module instanceof SSpecification)) {
			throw new RuntimeException("Unexpected element encountered.");
		}
		SSpecification s = (SSpecification) module;
		List<Expr> args = new ArrayList<>();
		args.addAll(call.getArgs().stream().map(e -> this.doSwitch(e)).collect(Collectors.toList()));
		args.addAll(call.getIds().stream().map(idr -> this.doSwitch(idr)).collect(Collectors.toList()));

		String nodeName = s.map.lookupOriginalProgram(call.getSpec().getName());
		SCall scall = SCall.get(call, s.calls);
		args.addAll(scall.getCallArgs());
		return new NodeCallExpr(nodeName, args);
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
		case "count":
		case "ccount":
			List<Expr> args = new ArrayList<>();
			args.add(sub);
			return new NodeCallExpr(unary.getOp(), args);

		default:
			throw new RuntimeException("Unsupported unary operator " + unary.getOp() + " provided.");
		}
	}

	@Override
	public Expr caseRecordAccessExpr(com.rockwellcollins.spear.RecordAccessExpr rae) {
		return new RecordAccessExpr(doSwitch(rae.getRecord()), rae.getField().getName());
	}

	@Override
	public Expr caseRecordUpdateExpr(com.rockwellcollins.spear.RecordUpdateExpr rue) {
		return new RecordUpdateExpr(doSwitch(rue.getRecord()), rue.getField().getName(), doSwitch(rue.getValue()));
	}

	@Override
	public Expr caseArrayAccessExpr(com.rockwellcollins.spear.ArrayAccessExpr aae) {
		return new ArrayAccessExpr(doSwitch(aae.getArray()), doSwitch(aae.getIndex()));
	}

	@Override
	public Expr caseArrayUpdateExpr(com.rockwellcollins.spear.ArrayUpdateExpr aue) {
		return new ArrayUpdateExpr(doSwitch(aue.getAccess().getArray()), doSwitch(aue.getAccess().getIndex()),
				doSwitch(aue.getValue()));
	}

	@Override
	public Expr casePreviousExpr(com.rockwellcollins.spear.PreviousExpr prev) {
		Expr pre = new UnaryExpr(UnaryOp.PRE, doSwitch(prev.getVar()));
		if (prev.getInit() == null) {
			return pre;
		} else {
			return new BinaryExpr(doSwitch(prev.getInit()), BinaryOp.ARROW, pre);
		}
	}

	@Override
	public Expr caseBinaryExpr(com.rockwellcollins.spear.BinaryExpr binary) {
		Type leftType = SpearTypeChecker.typeCheck(binary.getLeft());
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
			BinaryOp op = BinaryOp.fromString(binary.getOp());
			return new BinaryExpr(left, op, right);

		case "mod":
			if (leftType.equals(SpearTypeChecker.REAL)) {
				return new NodeCallExpr(LustreLibrary.fmod().id, left, right);
			}
			return new BinaryExpr(left, BinaryOp.MODULUS, right);

		case "/":
			if (leftType.equals(SpearTypeChecker.INT)) {
				return new BinaryExpr(left, BinaryOp.INT_DIVIDE, right);
			}
			return new BinaryExpr(left, BinaryOp.DIVIDE, right);

		case "implies":
			return new BinaryExpr(left, BinaryOp.IMPLIES, right);

		case "==":
			return new BinaryExpr(left, BinaryOp.EQUAL, right);

		case "since":
		case "triggers":
		case "precedes":
			List<Expr> args = new ArrayList<>();
			args.add(left);
			args.add(right);
			return new NodeCallExpr(binary.getOp(), args);

		default:
			throw new RuntimeException("Unsupported binary operator " + binary.getOp() + " provided.");
		}
	}

//	@Override
//	public Expr caseRespondsExpr(RespondsExpr responds) {
//		Expr response = doSwitch(responds.getResponse());
//		Expr stimulus = doSwitch(responds.getStimulus());
//		Expr delay = doSwitch(responds.getDelay());
//		
//		List<Expr> args = new ArrayList<>();
//		args.add(response);
//		args.add(stimulus);
//		args.add(delay);
//		return new NodeCallExpr("responds",args);
//	}
	
	@Override
	public Expr caseIfThenElseExpr(com.rockwellcollins.spear.IfThenElseExpr ite) {
		Expr condExpr = this.doSwitch(ite.getCond());
		Expr thenExpr = this.doSwitch(ite.getThen());
		Expr elseExpr = this.doSwitch(ite.getElse());
		return new IfThenElseExpr(condExpr, thenExpr, elseExpr);
	}

	@Override
	public Expr caseBoolLiteral(com.rockwellcollins.spear.BoolLiteral bl) {
		switch (bl.getValue()) {
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
	public Expr caseCounterExpr(com.rockwellcollins.spear.CounterExpr ce) {
		return new IdExpr(module.counterName);
	}

	@Override
	public Expr caseMacro(Macro m) {
		String x = this.module.map.lookupOriginalModule(m.getName());
		return new IdExpr(x);
	}

	@Override
	public Expr caseIntegerCast(IntegerCast cast) {
		if(cast.getOp().equals("floor")) {
			return new CastExpr(NamedType.INT, doSwitch(cast.getExpr()));
		} else if(cast.getOp().equals("btoi")) {
			return new NodeCallExpr("btoi",Collections.singletonList(doSwitch(cast.getExpr())));
		} 
		
		throw new RuntimeException("Unexpected cast operator provided: " + cast.getOp().toString());
	}

	@Override
	public Expr caseRealCast(RealCast cast) {
		return new CastExpr(NamedType.REAL, doSwitch(cast.getExpr()));
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
		return new IdExpr(this.module.map.lookupOriginalProgram(c.getName()));
	}

	@Override
	public Expr caseEnumValue(EnumValue ev) {
		return new IdExpr(this.module.map.lookupOriginalProgram(ev.getName()));
	}

	@Override
	public Expr caseRecordExpr(com.rockwellcollins.spear.RecordExpr re) {
		Map<String, Expr> fields = new LinkedHashMap<>();
		for (com.rockwellcollins.spear.FieldExpr fe : re.getFieldExprs()) {
			fields.put(fe.getField().getName(), doSwitch(fe.getExpr()));
		}
		return new RecordExpr(this.module.map.lookupOriginalProgram(re.getType().getName()), fields);
	}

	@Override
	public Expr caseArrayExpr(com.rockwellcollins.spear.ArrayExpr ae) {
		List<Expr> list = new ArrayList<>();
		list.addAll(ae.getExprs().stream().map(e -> this.doSwitch(e)).collect(Collectors.toList()));
		return new ArrayExpr(list);
	}

	@Override
	public Expr caseVariable(Variable v) {
		String name = this.module.map.lookupOriginalModule(v.getName());
		return new IdExpr(name);
	}

	@Override
	public Expr caseListExpr(ListExpr list) {
		List<Expr> elements = new ArrayList<>();
		elements.addAll(list.getExprs().stream().map(e -> this.doSwitch(e)).collect(Collectors.toList()));
		return new TupleExpr(elements);
	}

	@Override
	public Expr defaultCase(EObject o) {
		throw new RuntimeException("Unexpected element provided: " + o.toString());
	}
}
