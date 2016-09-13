package com.rockwellcollins.spear.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.rockwellcollins.spear.DerivedUnit;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.MultipleIdExpr;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.NamedUnitExpr;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.ConstantFinder;

public class SpearUnitChecker extends SpearSwitch<Unit> {

	final private ValidationMessageAcceptor messageAcceptor;

	public SpearUnitChecker(ValidationMessageAcceptor messageAcceptor) {
		this.messageAcceptor = messageAcceptor;
	}

	private static final Unit ERROR = new ErrorUnit();
	private static final Unit SCALAR = new ScalarUnit();

	/***************************************************************************************************/
	// Checks
	/***************************************************************************************************/
	public void checkNamedTypeDef(NamedTypeDef nt) {
		doSwitch(nt);
	}

	public void checkConstant(Constant c) {
		Unit declared = doSwitch(c.getType());
		Unit expressed = doSwitch(c.getExpr());

		if (declared == ERROR || expressed == ERROR) {
			return;
		}

		if (!declared.equals(expressed)) {
			error("Expected unit " + declared + ", " + "but received " + expressed, c.getExpr());
		}
	}

	public void checkMacro(Macro m) {
		Unit declared = doSwitch(m.getType());
		Unit expressed = doSwitch(m.getExpr());

		if (declared == ERROR || expressed == ERROR) {
			return;
		}

		if (!declared.equals(expressed)) {
			error("Expected unit " + declared + ", " + "but received " + expressed, m);
		}
	}

	public void checkFormalConstraint(FormalConstraint fc) {
		doSwitch(fc.getExpr());
	}

	/***************************************************************************************************/
	// Declarations
	/***************************************************************************************************/
	@Override
	public Unit caseConstant(Constant c) {
		return doSwitch(c.getType());
	}

	@Override
	public Unit caseMacro(Macro m) {
		return doSwitch(m.getType());
	}

	@Override
	public Unit caseVariable(Variable v) {
		return doSwitch(v.getType());
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
			return ERROR;
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
		return ERROR;
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
		if (nt.getUnit() == null) {
			return SCALAR;
		} else {
			return doSwitch(nt.getUnit());
		}
	}

	@Override
	public Unit caseAbstractTypeDef(AbstractTypeDef at) {
		return SCALAR;
	}
	
	@Override
	public Unit caseRecordTypeDef(RecordTypeDef rt) {
		Map<String, Unit> fields = new HashMap<>();
		for (FieldType rtf : rt.getFields()) {
			fields.put(rtf.getName(), doSwitch(rtf.getType()));
		}
		return new RecordUnit(rt.getName(), fields);
	}

	@Override
	public Unit caseArrayTypeDef(ArrayTypeDef at) {
		//this should just work because typechecking has presumably passed.
		Integer size = ConstantFinder.fetch(at);
		if(size == null) {
			return ERROR;
		}
		return new ArrayUnit(at.getName(), doSwitch(at.getBase()), size);
	}

	@Override
	public Unit caseEnumTypeDef(EnumTypeDef enumtype) {
		return new EnumUnit(enumtype.getName());
	}

	/***************************************************************************************************/
	// Types
	/***************************************************************************************************/
	@Override
	public Unit caseUserType(UserType ut) {
		return doSwitch(ut.getDef());
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
			return ERROR;
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
			if (left.equals(right)) {
				return SCALAR;
			}
			break;

		case "or":
		case "xor":
		case "and":
		case "implies":
		case "=>":
		case "triggers":
		case "T":
		case "since":
		case "S":
			if (left == SCALAR && right == SCALAR) {
				return SCALAR;
			}
			break;
		}

		error("Operator '" + be.getOp() + "' not defined on units " + left + ", " + right, be);
		return ERROR;
	}

	@Override
	public Unit caseUnaryExpr(UnaryExpr ue) {
		Unit unit = doSwitch(ue.getExpr());

		if (unit == ERROR) {
			return ERROR;
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
			if (unit == SCALAR) {
				return SCALAR;
			}
			break;
		}

		error("Operator '" + ue.getOp() + "' not defined on unit " + unit, ue);
		return ERROR;
	}

	@Override
	public Unit caseRecordAccessExpr(RecordAccessExpr rae) {
		Unit record = doSwitch(rae.getRecord());
		if (record == ERROR) {
			return ERROR;
		}

		if (record instanceof RecordUnit) {
			RecordUnit recordUnit = (RecordUnit) record;
			return recordUnit.fields.get(rae.getField().getName());
		}

		error("Expected record unit but found " + record, rae.getRecord());
		return ERROR;
	}

	@Override
	public Unit caseRecordUpdateExpr(RecordUpdateExpr rue) {
		Unit record = doSwitch(rue.getRecord());
		Unit value = doSwitch(rue.getValue());

		if (record == ERROR || value == ERROR) {
			return ERROR;
		}

		if (record instanceof RecordUnit) {
			RecordUnit recordUnit = (RecordUnit) record;
			Unit fieldUnit = recordUnit.fields.get(rue.getField().getName());
			if (!fieldUnit.equals(value)) {
				error("RecordField expected unit " + fieldUnit + ", but received " + value, rue);
				return ERROR;
			} else {
				return record;
			}
		} else {
			error("Expected record unit but found " + record, rue.getRecord());
			return ERROR;
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
			return ERROR;
		}

		if (array instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) array;
			return arrayUnit.base;
		}

		error("Expected array of units but " + array + " was provided instead", aae.getArray(), null);
		return ERROR;
	}

	@Override
	public Unit caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		Unit array = doSwitch(aue.getAccess().getArray());
		Unit value = doSwitch(aue.getValue());

		if (array == ERROR || value == ERROR) {
			return ERROR;
		}

		if (array instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) array;
			if (!arrayUnit.base.equals(value)) {
				error("Array update unit is " + value + ", but array expects " + arrayUnit.base, aue,
						SpearPackage.Literals.ARRAY_UPDATE_EXPR__VALUE);
				return ERROR;
			} else {
				return array;
			}
		}
		error("Expected array, but received " + array, aue, null);
		return ERROR;
	}

	@Override
	public Unit caseArrayExpr(ArrayExpr array) {
		Unit expected = doSwitch(array.getType());
		if (expected == ERROR) {
			return ERROR;
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
				return ERROR;
			} else {
				return arrayUnit;
			}
		}

		error("Expected an array of units but received " + expected, array);
		return ERROR;
	}

	@Override
	public Unit caseIdExpr(IdExpr ide) {
		return doSwitch(ide.getId());
	}

	@Override
	public Unit casePreviousExpr(PreviousExpr prev) {
		Unit init = doSwitch(prev.getInit());
		Unit var = doSwitch(prev.getVar());

		if (init == ERROR || var == ERROR) {
			return ERROR;
		}

		if (init.equals(var)) {
			return var;
		}

		error("Previous has variable unit of " + var + ", but initial expression has unit of " + init, prev);
		return ERROR;
	}

	@Override
	public Unit caseIfThenElseExpr(IfThenElseExpr ite) {
		Unit testUnit = doSwitch(ite.getCond());
		Unit thenUnit = doSwitch(ite.getThen());

		if (ite.getElse() == null) {
			return thenUnit;
		}

		Unit elseUnit = doSwitch(ite.getElse());

		if (thenUnit == ERROR || elseUnit == ERROR) {
			return ERROR;
		}

		if (testUnit != SCALAR) {
			error("Condition of If-Then-Else must be scalar.", ite, SpearPackage.Literals.IF_THEN_ELSE_EXPR__COND);
		}

		if (thenUnit.equals(elseUnit)) {
			return thenUnit;
		}

		error("Then branch of If-Then-Else has units " + thenUnit + ", but else branch has units " + elseUnit, ite,
				null);
		return ERROR;
	}

	@Override
	public Unit caseAfterUntilExpr(AfterUntilExpr afe) {
		Unit afterUnit = doSwitch(afe.getAfter());
		if (afterUnit != SCALAR) {
			error("After expressions must have scalar units.", afe.getAfter(), null);
		}

		if (afe.getUntil() != null) {
			Unit untilUnit = doSwitch(afe.getUntil());
			if (untilUnit != SCALAR) {
				error("Until expressions must have scalar units.", afe.getUntil(), null);
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
			return ERROR;
		}

		if (then != SCALAR) {
			error("Then expression must have scalar units.", wh.getThen(), null);
			return ERROR;
		}
		return SCALAR;
	}

	@Override
	public Unit caseMultipleIdExpr(MultipleIdExpr mide) {
		return this.processList(new ArrayList<>(mide.getIds()));
	}

	@Override
	public Unit caseSpecificationCall(SpecificationCall sc) {
		TupleUnit args = this.processList(new ArrayList<>(sc.getArgs()));
		TupleUnit inputs = this.processList(new ArrayList<>(sc.getSpec().getInputs()));

		if (!args.equals(inputs)) {
			error("Provided units of type " + args + ", but " + sc.getSpec().getName() + " expected units "
					+ inputs + ".", sc, SpearPackage.Literals.SPECIFICATION_CALL__ARGS);
			return ERROR;
		}
		return compressTuple(this.processList(new ArrayList<>(sc.getSpec().getOutputs())));
	}

	@Override
	public Unit casePatternCall(PatternCall pc) {
		TupleUnit args = this.processList(new ArrayList<>(pc.getArgs()));
		TupleUnit inputs = this.processList(new ArrayList<>(pc.getPattern().getInputs()));

		if (!args.equals(inputs)) {
			error("Provided units of type " + args + ", but " + pc.getPattern().getName() + " expected units " + inputs
					+ ".", pc, SpearPackage.Literals.PATTERN_CALL__ARGS);
		}

		return compressTuple(this.processList(new ArrayList<>(pc.getPattern().getOutputs())));
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
		return doSwitch(ev.eContainer());
	}

	@Override
	public Unit caseExpr(Expr e) {
		warning("Unit Checker not implemented for " + e, e);
		return SCALAR;
	}

	/***************************************************************************************************/
	// Error Functions
	/***************************************************************************************************/
	private TupleUnit processList(List<EObject> elements) {
		List<Unit> list = new ArrayList<>();
		for (EObject o : elements) {
			list.add(this.doSwitch(o));
		}
		return new TupleUnit(list);
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
