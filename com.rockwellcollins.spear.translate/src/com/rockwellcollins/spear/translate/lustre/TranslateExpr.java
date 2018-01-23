package com.rockwellcollins.spear.translate.lustre;

import static jkind.lustre.LustreUtil.FALSE;
import static jkind.lustre.LustreUtil.TRUE;
import static jkind.lustre.LustreUtil.arrow;
import static jkind.lustre.LustreUtil.divide;
import static jkind.lustre.LustreUtil.equal;
import static jkind.lustre.LustreUtil.id;
import static jkind.lustre.LustreUtil.implies;
import static jkind.lustre.LustreUtil.intDivide;
import static jkind.lustre.LustreUtil.integer;
import static jkind.lustre.LustreUtil.ite;
import static jkind.lustre.LustreUtil.mod;
import static jkind.lustre.LustreUtil.negative;
import static jkind.lustre.LustreUtil.not;
import static jkind.lustre.LustreUtil.pre;
import static jkind.lustre.LustreUtil.real;

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
import com.rockwellcollins.spear.RespondsExpr;
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
import jkind.lustre.CastExpr;
import jkind.lustre.Expr;
import jkind.lustre.NamedType;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordExpr;
import jkind.lustre.RecordUpdateExpr;
import jkind.lustre.TupleExpr;

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
		args.addAll(call.getArgs().stream().map(e -> doSwitch(e)).collect(Collectors.toList()));
		return new NodeCallExpr(call.getPattern().getName(), args);
	}

	@Override
	public Expr caseNormalizedCall(com.rockwellcollins.spear.NormalizedCall call) {
		if (!(module instanceof SSpecification)) {
			throw new RuntimeException("Unexpected element encountered.");
		}
		SSpecification s = (SSpecification) module;
		List<Expr> args = new ArrayList<>();
		args.addAll(call.getArgs().stream().map(e -> doSwitch(e)).collect(Collectors.toList()));
		args.addAll(call.getIds().stream().map(idr -> doSwitch(idr)).collect(Collectors.toList()));

		String nodeName = s.map.lookup(call.getSpec().getName());
		SCall scall = SCall.get(call, s.calls);
		args.addAll(scall.getCallArgs());
		return new NodeCallExpr(nodeName, args);
	}

	@Override
	public Expr caseUnaryExpr(com.rockwellcollins.spear.UnaryExpr unary) {
		Expr sub = doSwitch(unary.getExpr());
		switch (unary.getOp()) {
		case "not":
			return not(sub);
		case "-":
			return negative(sub);

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
		Expr sub = pre(doSwitch(prev.getVar()));
		return prev.getInit() == null ? sub : arrow(doSwitch(prev.getInit()), sub);
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
			return new BinaryExpr(left, BinaryOp.fromString(binary.getOp()), right);

		case "mod":
			if (leftType.equals(SpearTypeChecker.REAL)) {
				return new NodeCallExpr(LustreLibrary.fmod().id, left, right);
			}
			return mod(left, right);

		case "/":
			if (leftType.equals(SpearTypeChecker.INT)) {
				return intDivide(left, right);
			}
			return divide(left, right);

		case "implies":
			return implies(left, right);

		case "==":
			return equal(left, right);

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

	@Override
	public Expr caseRespondsExpr(RespondsExpr responds) {
		Expr response = doSwitch(responds.getResponse());
		Expr stimulus = doSwitch(responds.getStimulus());

		List<Expr> args = new ArrayList<>();
		args.add(response);
		args.add(stimulus);

		if(responds.getDelay() != null) {
			Expr delay = doSwitch(responds.getDelay());
			args.add(delay);	
		} else {
			args.add(integer(1));
		}
		return new NodeCallExpr("responds",args);
	}
	
	@Override
	public Expr caseIfThenElseExpr(com.rockwellcollins.spear.IfThenElseExpr ite) {
		return ite(doSwitch(ite.getCond()), doSwitch(ite.getThen()), doSwitch(ite.getElse()));
	}

	@Override
	public Expr caseBoolLiteral(com.rockwellcollins.spear.BoolLiteral bl) {
		switch (bl.getValue()) {
		case "TRUE":
		case "true":
			return TRUE;

		case "FALSE":
		case "false":
			return FALSE;

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
		return id(module.counterName);
	}

	@Override
	public Expr caseMacro(Macro m) {
		return id(module.map.lookup(m.getName()));
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
		return integer(il.getValue());
	}

	@Override
	public Expr caseRealLiteral(com.rockwellcollins.spear.RealLiteral rl) {
		return real(rl.getValue());
	}

	@Override
	public Expr caseConstant(Constant c) {
		return id(this.module.map.lookup(c.getName()));
	}

	@Override
	public Expr caseEnumValue(EnumValue ev) {
		return id(module.map.lookup(ev.getName()));
	}

	@Override
	public Expr caseRecordExpr(com.rockwellcollins.spear.RecordExpr re) {
		Map<String, Expr> fields = new LinkedHashMap<>();
		for (com.rockwellcollins.spear.FieldExpr fe : re.getFieldExprs()) {
			fields.put(fe.getField().getName(), doSwitch(fe.getExpr()));
		}
		return new RecordExpr(module.map.lookup(re.getType().getName()), fields);
	}

	@Override
	public Expr caseArrayExpr(com.rockwellcollins.spear.ArrayExpr ae) {
		List<Expr> list = new ArrayList<>();
		list.addAll(ae.getExprs().stream().map(e -> this.doSwitch(e)).collect(Collectors.toList()));
		return new ArrayExpr(list);
	}

	@Override
	public Expr caseVariable(Variable v) {
		String name = module.map.lookup(v.getName());
		return id(name);
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
