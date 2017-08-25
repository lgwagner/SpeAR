package com.rockwellcollins.spear.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.rockwellcollins.spear.AbstractTypeDef;
import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayExpr;
import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.BaseUnit;
import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BinaryUnitExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.CounterExpr;
import com.rockwellcollins.spear.DerivedUnit;
import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.IntegerCast;
import com.rockwellcollins.spear.IntervalExpr;
import com.rockwellcollins.spear.ListExpr;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.NamedUnitExpr;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RealCast;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.RespondsExpr;
import com.rockwellcollins.spear.SetExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.IntConstantFinder;

public class SpearUnitChecker extends SpearSwitch<Unit> {

	public static Unit unitCheck(EObject o, Set<EObject> errors, ValidationMessageAcceptor acceptor) {
		SpearUnitChecker unitCheck = new SpearUnitChecker(errors, acceptor);
		return unitCheck.doSwitch(o);
	}

	public static Unit unitCheck(EObject o) {
		SpearUnitChecker unitcheck = new SpearUnitChecker();
		return unitcheck.doSwitch(o);
	}

	public SpearUnitChecker() {
		this.errors = new HashSet<>();
		this.messageAcceptor = null;
	}

	final private ValidationMessageAcceptor messageAcceptor;
	private Set<EObject> errors;

	private SpearUnitChecker(Set<EObject> errors, ValidationMessageAcceptor messageAcceptor) {
		this.errors = errors;
		this.messageAcceptor = messageAcceptor;
	}

	private static final Unit ERROR = new ErrorUnit();
	private static final Unit SCALAR = new ScalarUnit();

	@Override
	public Unit doSwitch(EObject o) {
		if (errors.contains(o)) {
			return ERROR;
		}
		return super.doSwitch(o);
	}

	private Unit error(EObject o) {
		errors.add(o);
		return ERROR;
	}

	/***************************************************************************************************/
	// Declarations
	/***************************************************************************************************/
	public Map<IdRef, Unit> map = new HashMap<>();

	@Override
	public Unit caseConstant(Constant c) {
		if (map.containsKey(c)) {
			return map.get(c);
		}
		Unit expected = this.doSwitch(c.getType());
		map.put(c, expected);

		Unit actual = this.doSwitch(c.getExpr());
		if (expected.equals(actual)) {
			return expected;
		}
		error("Expected units: " + expected.toString() + ", but actual units are: " + actual.toString(), c,
				SpearPackage.Literals.CONSTANT__EXPR);
		return error(c);
	}

	@Override
	public Unit caseMacro(Macro m) {
		if (map.containsKey(m)) {
			return map.get(m);
		}
		Unit expected = this.doSwitch(m.getType());
		map.put(m, expected);

		Unit actual = this.doSwitch(m.getExpr());
		if (expected.equals(actual)) {
			return expected;
		}
		error("Expected units: " + expected.toString() + ", but actual units are: " + actual.toString(), m,
				SpearPackage.Literals.MACRO__EXPR);
		return error(m);
	}

	@Override
	public Unit caseVariable(Variable v) {
		Unit result = doSwitch(v.getType());
		return result;
	}

	@Override
	public Unit caseFormalConstraint(FormalConstraint fc) {
		Unit expected = SCALAR;
		Unit actual = doSwitch(fc.getExpr());

		if (actual == ERROR) {
			return ERROR;
		}

		if (!expected.equals(actual)) {
			return error(fc);
		}
		return expected;
	}

	@Override
	public Unit caseLustreEquation(LustreEquation eq) {
		Unit expected = this.processList(new ArrayList<>(eq.getIds()));
		Unit actual = doSwitch(eq.getRhs());

		if (expected == ERROR || actual == ERROR) {
			return ERROR;
		}

		if (!expected.equals(actual)) {
			return error(eq);
		}
		return expected;
	}

	public Unit caseLustreAssertion(LustreAssertion la) {
		Unit expected = SCALAR;
		Unit actual = doSwitch(la.getAssertionExpr());

		if (actual == ERROR) {
			return ERROR;
		}

		if (!expected.equals(actual)) {
			return error(la);
		}
		return expected;
	}

	@Override
	public Unit caseLustreProperty(LustreProperty lp) {
		Unit expected = SCALAR;
		Unit actual = doSwitch(lp.getPropertyId());

		if (actual == ERROR) {
			return ERROR;
		}

		if (!expected.equals(actual)) {
			return error(lp);
		}
		return expected;
	}

	@Override
	public Unit caseEnglishConstraint(EnglishConstraint ec) {
		return SCALAR;
	}

	/***************************************************************************************************/
	// UnitDefs
	/***************************************************************************************************/
	@Override
	public Unit caseBaseUnit(BaseUnit base) {
		Map<String, Integer> map = new HashMap<>();
		map.put(base.getName(), 1);
		return new ComputedUnit(map);
	}

	@Override
	public Unit caseDerivedUnit(DerivedUnit derived) {
		return doSwitch(derived.getUnit());
	}

	/***************************************************************************************************/
	// UnitExprs
	/***************************************************************************************************/
	@Override
	public Unit caseBinaryUnitExpr(BinaryUnitExpr bue) {
		Unit left = doSwitch(bue.getLeft());
		Unit right = doSwitch(bue.getRight());

		if (left == ERROR || right == ERROR) {
			return error(bue);
		}

		switch (bue.getOp()) {
		case "*":
			if (left == SCALAR && right == SCALAR) {
				return SCALAR;
			}

			if (left instanceof ComputedUnit && right instanceof ComputedUnit) {
				ComputedUnit leftUnit = (ComputedUnit) left;
				ComputedUnit rightUnit = (ComputedUnit) right;
				return leftUnit.multiply(rightUnit);
			}
			break;

		case "/":
			if (left == SCALAR && right == SCALAR) {
				return SCALAR;
			}

			if (left instanceof ComputedUnit && right instanceof ComputedUnit) {
				ComputedUnit leftUnit = (ComputedUnit) left;
				ComputedUnit rightUnit = (ComputedUnit) right;
				return leftUnit.divide(rightUnit);
			}
			break;
		}

		error("Units " + left + ", " + right + " do not agree.", bue);
		return error(bue);
	}

	@Override
	public Unit caseNamedUnitExpr(NamedUnitExpr nue) {
		return doSwitch(nue.getUnit());
	}

	/***************************************************************************************************/
	// TypeDefs
	/***************************************************************************************************/

	@Override
	public Unit caseNamedTypeDef(NamedTypeDef nt) {
		if (nt.getUnit() != null) {
			Unit declared = doSwitch(nt.getUnit());
			return declared;
		}
		Unit actual = doSwitch(nt.getType());
		return actual;
	}

	@Override
	public Unit caseAbstractTypeDef(AbstractTypeDef at) {
		return SCALAR;
	}

	@Override
	public Unit caseRecordTypeDef(RecordTypeDef rt) {
		Map<String, Unit> fields = new HashMap<>();
		rt.getFields().stream().forEach(rtf -> fields.put(rtf.getName(), this.doSwitch(rtf.getType())));
		return new RecordUnit(rt.getName(), fields);
	}

	@Override
	public Unit caseArrayTypeDef(ArrayTypeDef at) {
		// this should just work because typechecking has presumably passed.
		Integer size = IntConstantFinder.fetch(at);
		if (size == null) {
			return error(at);
		}
		return new ArrayUnit(at.getName(), doSwitch(at.getBase()), size);
	}

	@Override
	public Unit caseEnumTypeDef(EnumTypeDef enumtype) {
		return new EnumUnit(enumtype.getName());
	}

	@Override
	public Unit casePredicateSubTypeDef(PredicateSubTypeDef pstd) {
		Unit actual = this.doSwitch(pstd.getPredExpr());
		if (!actual.equals(SCALAR)) {
			return error(pstd);
		}

		if (pstd.getUnit() != null) {
			return this.doSwitch(pstd.getUnit());
		} else {
			return this.doSwitch(pstd.getPredVar().getType());
		}
	}

	/***************************************************************************************************/
	// Types
	/***************************************************************************************************/
	@Override
	public Unit caseUserType(UserType ut) {
		Unit result = doSwitch(ut.getDef());
		return result;
	}

	@Override
	public Unit caseType(Type t) {
		return SCALAR;
	}

	/***************************************************************************************************/
	// Expressions
	/***************************************************************************************************/

	@Override
	public Unit caseBinaryExpr(BinaryExpr be) {
		Unit left = doSwitch(be.getLeft());
		Unit right = doSwitch(be.getRight());

		if (left == ERROR || right == ERROR) {
			return error(be);
		}

		if (left == SCALAR && right == SCALAR) {
			return SCALAR;
		}

		switch (be.getOp()) {
		case "+":
		case "-":
		case "->":
			if (left.equals(right)) {
				return left;
			}
			break;

		case "*":
		case "/":
		case "mod":
			if (left instanceof ComputedUnit) {
				ComputedUnit leftUnit = (ComputedUnit) left;
				if (right instanceof ComputedUnit) {
					ComputedUnit rightUnit = (ComputedUnit) right;
					if (be.getOp().equals("*")) {
						return leftUnit.multiply(rightUnit);
					} else {
						return leftUnit.divide(rightUnit);
					}
				}

				if (right == SCALAR) {
					return leftUnit;
				}
			}

			if (left == SCALAR) {
				if (right instanceof ComputedUnit) {
					ComputedUnit rightUnit = (ComputedUnit) right;
					return rightUnit;
				}
			}
			break;

		case "==":
		case "equal to":
		case "<>":
		case "not equal to":
		case ">":
		case "greater than":
		case ">=":
		case "greater than or equal to":
		case "<":
		case "less than":
		case "<=":
		case "less than or equal to":
		case "or":
		case "xor":
		case "and":
		case "implies":
		case "=>":
		case "triggers":
		case "T":
		case "since":
		case "S":
		case "precedes":
			if (left.equals(right)) {
				return SCALAR;
			}
			break;
		
		case "in":
			if (left.equals(right)) {
				return SCALAR;
			}
			
			if (right instanceof ArrayUnit) {
				ArrayUnit array = (ArrayUnit) right;
				if(left.equals(array.base)) {
					return SCALAR;
				}
			}
			break;			
		}			

		error("Operator '" + be.getOp() + "' not defined on units " + left + ", " + right, be);
		return error(be);
	}
	
	@Override
	public Unit caseRespondsExpr(RespondsExpr responds) {
		Unit stimulus = doSwitch(responds.getStimulus());
		Unit response = doSwitch(responds.getResponse());
		
		if(stimulus == ERROR || response == ERROR) {
			return error(responds);
		}
		
		if(response == SCALAR && stimulus == SCALAR) {
			return SCALAR;
		}
		
		if(response != SCALAR) {
			error("Expected scalar units, found units of " + stimulus, SpearPackage.Literals.RESPONDS_EXPR__STIMULUS);
		}
		
		if(response != SCALAR) {
			error("Expected scalar units, found units of " + response, SpearPackage.Literals.RESPONDS_EXPR__RESPONSE);
		}
		return error(responds);
	}

	@Override
	public Unit caseUnaryExpr(UnaryExpr ue) {
		Unit unit = doSwitch(ue.getExpr());

		if (unit == ERROR) {
			return error(ue);
		}

		switch (ue.getOp()) {

		case "-":
			return unit;

		case "not":
		case "once":
		case "O":
		case "historically":
		case "H":
		case "initially":
			// the following ops are syntactic sugar
		case "never":
		case "before":
		case "count":
		case "ccount":
			if (unit == SCALAR) {
				return SCALAR;
			}
			break;
		}

		error("Operator '" + ue.getOp() + "' not defined on unit " + unit, ue);
		return error(ue);
	}

	@Override
	public Unit caseRecordAccessExpr(RecordAccessExpr rae) {
		Unit record = doSwitch(rae.getRecord());
		if (record == ERROR) {
			return error(rae);
		}

		if (record instanceof RecordUnit) {
			RecordUnit recordUnit = (RecordUnit) record;
			return recordUnit.fields.get(rae.getField().getName());
		}

		error("Expected record unit but found " + record, rae.getRecord());
		return error(rae);
	}

	@Override
	public Unit caseRecordUpdateExpr(RecordUpdateExpr rue) {
		Unit record = doSwitch(rue.getRecord());
		Unit value = doSwitch(rue.getValue());

		if (record == ERROR || value == ERROR) {
			return error(rue);
		}

		if (record instanceof RecordUnit) {
			RecordUnit recordUnit = (RecordUnit) record;
			Unit fieldUnit = recordUnit.fields.get(rue.getField().getName());
			if (!fieldUnit.equals(value)) {
				error("RecordField expected unit " + fieldUnit + ", but received " + value, rue);
				return error(rue);
			} else {
				return record;
			}
		} else {
			error("Expected record unit but found " + record, rue.getRecord());
			return error(rue);
		}
	}

	@Override
	public Unit caseRecordExpr(RecordExpr re) {
		Map<String, Unit> fields = new HashMap<>();
		for (FieldExpr fe : re.getFieldExprs()) {
			fields.put(fe.getField().getName(), doSwitch(fe.getExpr()));
		}
		return new RecordUnit(re.getType().getName(), fields);
	}

	@Override
	public Unit caseFieldlessRecordExpr(FieldlessRecordExpr re) {
		Map<String, Unit> fields = new HashMap<>();
		int i = 0;
		for (Expr e : re.getExprs()) {
			fields.put(re.getType().getFields().get(i).getName(), doSwitch(e));
			i++;
		}
		return new RecordUnit(re.getType().getName(), fields);
	}

	@Override
	public Unit caseArrayAccessExpr(ArrayAccessExpr aae) {
		Unit array = doSwitch(aae.getArray());

		if (array == ERROR) {
			return error(aae);
		}

		if (array instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) array;
			return arrayUnit.base;
		}

		error("Expected array of units but " + array + " was provided instead", aae.getArray(), null);
		return error(aae);
	}

	@Override
	public Unit caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		Unit array = doSwitch(aue.getAccess().getArray());
		Unit value = doSwitch(aue.getValue());

		if (array == ERROR || value == ERROR) {
			return error(aue);
		}

		if (array instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) array;
			if (!arrayUnit.base.equals(value)) {
				error("Array update unit is " + value + ", but array expects " + arrayUnit.base, aue,
						SpearPackage.Literals.ARRAY_UPDATE_EXPR__VALUE);
				return error(aue);
			} else {
				return array;
			}
		}
		error("Expected array, but received " + array, aue, null);
		return error(aue);
	}

	@Override
	public Unit caseArrayExpr(ArrayExpr array) {
		Unit expected = doSwitch(array.getType());
		if (expected == ERROR) {
			return error(array);
		}

		if (expected instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) expected;
			boolean error = false;
			for (int i = 0; i < array.getExprs().size(); i++) {
				Unit current = doSwitch(array.getExprs().get(i));
				if (!arrayUnit.base.equals(current)) {
					error("Expected unit " + arrayUnit.base + ", but received " + current, array,
							SpearPackage.Literals.ARRAY_EXPR__EXPRS, i);
					error = true;
				}
			}
			if (error) {
				return error(array);
			} else {
				return arrayUnit;
			}
		}

		error("Expected an array of units but received " + expected, array);
		return error(array);
	}

	@Override
	public Unit caseIdExpr(IdExpr ide) {
		Unit result = doSwitch(ide.getId());
		return result;
	}
	
	@Override
	public Unit caseCounterExpr(CounterExpr ce) {
		return SCALAR;
	}

	@Override
	public Unit casePreviousExpr(PreviousExpr prev) {
		Unit var = doSwitch(prev.getVar());
		if (prev.getInit() == null) {
			return var;
		}

		Unit init = doSwitch(prev.getInit());

		if (init == ERROR || var == ERROR) {
			return error(prev);
		}

		if (init.equals(var)) {
			return var;
		}

		error("Previous has variable unit of " + var + ", but initial expression has unit of " + init, prev);
		return error(prev);
	}

	private Unit processIfThen(IfThenElseExpr ite) {
		Unit testUnit = doSwitch(ite.getCond());
		Unit thenUnit = doSwitch(ite.getThen());

		if (testUnit == ERROR | thenUnit == ERROR) {
			return error(ite);
		}

		if (testUnit != SCALAR) {
			error("Condition of If-Then must be scalar.", ite, SpearPackage.Literals.IF_THEN_ELSE_EXPR__COND);
		}

		if (thenUnit != SCALAR) {
			error("If-Then expressions must be scalar.", ite, SpearPackage.Literals.IF_THEN_ELSE_EXPR__THEN);
		}

		return thenUnit;
	}

	private Unit processIfThenElse(IfThenElseExpr ite) {
		Unit testUnit = doSwitch(ite.getCond());
		Unit thenUnit = doSwitch(ite.getThen());
		Unit elseUnit = doSwitch(ite.getElse());

		if (testUnit == ERROR | thenUnit == ERROR | elseUnit == ERROR) {
			return error(ite);
		}

		if (testUnit != SCALAR) {
			error("Condition of If-Then must be scalar.", ite, SpearPackage.Literals.IF_THEN_ELSE_EXPR__COND);
		}

		if (thenUnit.equals(elseUnit)) {
			return thenUnit;
		}
		error("Then branch of If-Then-Else has units " + thenUnit + ", but else branch has units " + elseUnit, ite,
				null);
		return error(ite);
	}

	@Override
	public Unit caseIfThenElseExpr(IfThenElseExpr ite) {
		if (ite.getElse() == null) {
			return processIfThen(ite);
		} else {
			return processIfThenElse(ite);
		}
	}

	@Override
	public Unit caseAfterUntilExpr(AfterUntilExpr afe) {
		Unit afterUnit = doSwitch(afe.getAfter());
		if (afterUnit != SCALAR) {
			error("After expressions must have scalar units.", afe.getAfter(), null);
			return error(afe);
		}

		if (afe.getUntil() != null) {
			Unit untilUnit = doSwitch(afe.getUntil());
			if (untilUnit != SCALAR) {
				error("Until expressions must have scalar units.", afe.getUntil(), null);
				return error(afe);
			}
		}
		return SCALAR;
	}

	@Override
	public Unit caseWhileExpr(WhileExpr wh) {
		Unit cond = doSwitch(wh.getCond());
		Unit then = doSwitch(wh.getThen());

		if (cond != SCALAR) {
			error("While expressions must have scalar units.", wh.getCond(), null);
			return error(wh);
		}

		if (then != SCALAR) {
			error("Then expression must have scalar units.", wh.getThen(), null);
			return error(wh);
		}
		return SCALAR;
	}

	@Override
	public Unit caseListExpr(ListExpr list) {
		return this.processList(new ArrayList<>(list.getExprs()));
	}

	@Override
	public Unit caseSpecificationCall(SpecificationCall sc) {
		Unit args = this.processList(new ArrayList<>(sc.getArgs()));
		Unit inputs = this.processList(new ArrayList<>(sc.getSpec().getInputs()));

		if (args == ERROR || inputs == ERROR) {
			return ERROR;
		}

		if (!args.equals(inputs)) {
			error("Provided units of type " + args + ", but spec " + sc.getSpec().getName() + " expected units "
					+ inputs + ".", sc, SpearPackage.Literals.SPECIFICATION_CALL__ARGS);
			return error(sc);
		}
		return this.processList(new ArrayList<>(sc.getSpec().getOutputs()));
	}

	@Override
	public Unit casePatternCall(PatternCall pc) {
		Unit args = this.processList(new ArrayList<>(pc.getArgs()));
		Unit inputs = this.processList(new ArrayList<>(pc.getPattern().getInputs()));

		if (args == ERROR || inputs == ERROR) {
			return ERROR;
		}

		if (!args.equals(inputs)) {
			if (pc.getPattern().getName() == null) {
				error("Possible omission of 'spec' keyword in specification call.", pc,
						SpearPackage.Literals.PATTERN_CALL__ARGS);
				return error(pc);
			} else {
				error("Provided units of type " + args + ", but pattern " + pc.getPattern().getName()
						+ " expected units " + inputs + ".", pc, SpearPackage.Literals.PATTERN_CALL__ARGS);
				return error(pc);
			}
		}
		return this.processList(new ArrayList<>(pc.getPattern().getOutputs()));
	}

	@Override
	public Unit caseIntegerCast(IntegerCast cast) {
		return doSwitch(cast.getExpr());
	}

	@Override
	public Unit caseRealCast(RealCast cast) {
		return doSwitch(cast.getExpr());
	}

	@Override
	public Unit caseIntervalExpr(IntervalExpr ive) {
		Unit low = doSwitch(ive.getLow());
		Unit high = doSwitch(ive.getHigh());
		
		if(low.equals(high)) {
			return low;
		}
		return ERROR;
	}
	
	@Override
	public Unit caseSetExpr(SetExpr set) {
		Unit first = null;
		boolean error = false;
		for(Expr e : set.getExprs()) {
			Unit current = doSwitch(e);
			int i=0;
			if(first != null) {
				if(!current.equals(first)) {
					error("All set members must be of type " + first.toString() + ".",set,SpearPackage.Literals.SET_EXPR__EXPRS,i);
					error=true;
				}
				i++;
			} else {
				first = current;
			}
		}
		
		if(error) {
			return ERROR;
		} else {
			return first;			
		}
	}
	
	@Override
	public Unit caseRealLiteral(RealLiteral rle) {
		if (rle.getUnit() != null) {
			return doSwitch(rle.getUnit());
		} else {
			return SCALAR;
		}
	}

	@Override
	public Unit caseIntLiteral(IntLiteral ile) {
		if (ile.getUnit() != null) {
			return doSwitch(ile.getUnit());
		} else {
			return SCALAR;
		}
	}

	@Override
	public Unit caseBoolLiteral(BoolLiteral ble) {
		return SCALAR;
	}

	@Override
	public Unit caseEnumValue(EnumValue ev) {
		Unit result = doSwitch(ev.eContainer());
		return result;
	}

	@Override
	public Unit caseExpr(Expr e) {
		warning("Unit Checker not implemented for " + e, e);
		return SCALAR;
	}

	/***************************************************************************************************/
	// Error Functions
	/***************************************************************************************************/
	private Unit processList(List<EObject> elements) {
		TupleUnit tu = new TupleUnit(elements.stream().map(o -> this.doSwitch(o)).collect(Collectors.toList()));
		if (tu.units.contains(ERROR)) {
			return ERROR;
		}
		return compressTuple(tu);
	}

	private Unit compressTuple(TupleUnit tupleUnit) {
		if (tupleUnit.units.size() == 1) {
			return tupleUnit.units.get(0);
		} else {
			return tupleUnit;
		}
	}

	private void error(String message, EObject e, EStructuralFeature feature) {
		messageAcceptor.acceptError(message, e, feature, 0, null);
	}

	private void error(String message, EObject e, EStructuralFeature feature, int index) {
		messageAcceptor.acceptError(message, e, feature, index, null);
	}

	private void error(String message, EObject e) {
		messageAcceptor.acceptError(message, e, null, 0, null);
	}

	private void warning(String message, EObject e) {
		messageAcceptor.acceptWarning(message, e, null, 0, null);
	}
}
