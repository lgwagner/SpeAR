package com.rockwellcollins.spear.typing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.rockwellcollins.spear.AbstractTypeDef;
import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayExpr;
import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.BoolType;
import com.rockwellcollins.spear.Constant;
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
import com.rockwellcollins.spear.IntType;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.MultipleIdExpr;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.RealType;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class SpearTypeChecker extends SpearSwitch<Type> {

	public static Type typeCheck(EObject o) {
		SpearTypeChecker typecheck = new SpearTypeChecker();
		return typecheck.doSwitch(o);
	}

	final private ValidationMessageAcceptor messageAcceptor;

	public SpearTypeChecker() {
		this.messageAcceptor = null;
	}

	public SpearTypeChecker(ValidationMessageAcceptor messageAcceptor) {
		this.messageAcceptor = messageAcceptor;
	}

	public static final Type ERROR = PrimitiveType.ERROR;
	public static final Type BOOL = PrimitiveType.BOOL;
	public static final Type INT = PrimitiveType.INT;
	public static final Type REAL = PrimitiveType.REAL;

	/***************************************************************************************************/
	// Checks
	/***************************************************************************************************/
	public Type checkNamedType(NamedTypeDef nt) {
		return doSwitch(nt);
	}

	public boolean checkConstant(Constant c) {
		return expectAssignableType(doSwitch(c.getType()), c.getExpr());
	}

	public boolean checkMacro(Macro m) {
		return expectAssignableType(doSwitch(m.getType()), m.getExpr());
	}

	public boolean checkFormalConstraint(FormalConstraint fc) {
		return expectAssignableType(BOOL, fc.getExpr());
	}

	public boolean checkLustreEquation(LustreEquation eq) {
		TupleType tuple = this.processList(new ArrayList<>(eq.getIds()));
		return expectAssignableType(this.compressTuple(tuple), eq.getRhs());
	}

	/***************************************************************************************************/
	// TYPES
	/***************************************************************************************************/
	
	@Override
	public Type caseNamedTypeDef(NamedTypeDef nt) {
		return doSwitch(nt.getType());
	}
	
	@Override
	public Type caseAbstractTypeDef(AbstractTypeDef at) {
		return new AbstractType(at.getName());
	}

	@Override
	public Type caseRecordTypeDef(RecordTypeDef rt) {
		if (rt.getName() == null) {
			return ERROR;
		}

		Map<String, Type> fields = new LinkedHashMap<>();
		for (FieldType rtf : rt.getFields()) {
			fields.put(rtf.getName(), doSwitch(rtf.getType()));
		}
		return new RecordType(rt.getName(), fields);
	}

	@Override
	public Type caseArrayTypeDef(ArrayTypeDef at) {
		if (at.getName() == null) {
			return ERROR;
		}

		return new ArrayType(at.getName(), doSwitch(at.getBase()), at.getSize());
	}

	@Override
	public Type caseEnumTypeDef(EnumTypeDef et) {
		if (et.getName() == null) {
			return ERROR;
		}

		List<String> values = new ArrayList<>();
		for (EnumValue ev : et.getValues()) {
			values.add(ev.getName());
		}
		return new EnumType(et.getName(), values);
	}

	public final Deque<TypeDef> stack = new ArrayDeque<>();

	@Override
	public Type caseUserType(UserType ut) {
		if (stack.contains(ut.getDef())) {
			return ERROR;
		}

		stack.push(ut.getDef());
		Type type = doSwitch(ut.getDef());
		stack.pop();
		return type;
	}

	@Override
	public Type caseBoolType(BoolType bt) {
		return BOOL;
	}

	@Override
	public Type caseRealType(RealType rt) {
		return REAL;
	}

	@Override
	public Type caseIntType(IntType it) {
		return INT;
	}

	/***************************************************************************************************/
	// DECLARATIONS
	/***************************************************************************************************/
	@Override
	public Type caseVariable(Variable v) {
		return doSwitch(v.getType());
	}

	@Override
	public Type caseConstant(Constant c) {
		return doSwitch(c.getType());
	}

	@Override
	public Type caseMacro(Macro m) {
		return doSwitch(m.getType());
	}

	/***************************************************************************************************/
	// EXPRESSIONS
	/***************************************************************************************************/

	@Override
	public Type caseBinaryExpr(BinaryExpr be) {
		Type left = doSwitch(be.getLeft());
		Type right = doSwitch(be.getRight());

		if (left == ERROR || right == ERROR) {
			return ERROR;
		}

		switch (be.getOp()) {
		case "->":
		case "arrow":
			if (left.equals(right)) {
				return left;
			}
		
		case "+":
		case "-":
		case "*":
		case "/":
			if (left == REAL && right == REAL) {
				return REAL;
			}

			if (left == INT && right == INT) {
				return INT;
			}
			
			break;

		case "mod":
			if (left == INT && right == INT) {
				return INT;
			}
			break;

		case "==":
		case "equal to":
		case "<>":
		case "not equal to":
			if (left.equals(right)) {
				return BOOL;
			}
			break;

		case ">":
		case "greater than":
		case "<":
		case "less than":
		case ">=":
		case "greater than or equal to":
		case "<=":
		case "less than or equal to":
			if (left == REAL && right == REAL) {
				return BOOL;
			}

			if (left == INT && right == INT) {
				return BOOL;
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
			if (left == BOOL && right == BOOL) {
				return BOOL;
			}
			break;
		}

		error("Operator '" + be.getOp() + "' not defined on types " + left + ", " + right, be);
		return ERROR;
	}

	@Override
	public Type caseUnaryExpr(UnaryExpr ue) {
		Type type = doSwitch(ue.getExpr());
		if (type == ERROR) {
			return ERROR;
		}

		switch (ue.getOp()) {
		case "-":
			if (type == INT) {
				return INT;
			}

			if (type == REAL) {
				return REAL;
			}
			break;

		case "not":
		case "once":
		case "O":
		case "historically":
		case "H":
		case "initially":
			// the following ops are syntactic sugar
		case "never":
		case "before":
			if (type == BOOL) {
				return BOOL;
			}
			break;
		}

		error("Operator '" + ue.getOp() + "' not defined on type " + type, ue);
		return ERROR;
	}

	@Override
	public Type caseRecordAccessExpr(RecordAccessExpr rae) {
		Type type = doSwitch(rae.getRecord());
		if (type == ERROR) {
			return ERROR;
		}

		if (type instanceof RecordType) {
			RecordType recordType = (RecordType) type;
			return recordType.fields.get(rae.getField().getName());
		} else {
			error("Expected record type, but found " + type, rae.getRecord());
			return ERROR;
		}
	}

	@Override
	public Type caseRecordUpdateExpr(RecordUpdateExpr rue) {
		Type type = doSwitch(rue.getRecord());

		if (type == ERROR) {
			return ERROR;
		}

		if (type instanceof RecordType) {
			RecordType recordType = (RecordType) type;
			Type fieldType = recordType.fields.get(rue.getField().getName());
			expectAssignableType(fieldType, rue.getValue());
			return recordType;
		} else {
			error("Expected record type, but found " + type, rue.getRecord());
			return ERROR;
		}
	}

	@Override
	public Type caseRecordExpr(RecordExpr re) {
		Map<String, Expr> fields = new LinkedHashMap<>();
		for (FieldExpr fe : re.getFieldExprs()) {
			fields.put(fe.getField().getName(), fe.getExpr());
		}

		Type result = doSwitch(re.getType());
		if (!(result instanceof RecordType)) {
			return ERROR;
		}
		RecordType expectedRecord = (RecordType) result;

		for (Entry<String, Type> entry : expectedRecord.fields.entrySet()) {
			String expectedField = entry.getKey();
			Type expectedType = entry.getValue();

			if (!fields.containsKey(expectedField)) {
				error("Missing field " + expectedField, re, SpearPackage.Literals.RECORD_EXPR__TYPE);
			} else {
				Expr actualExpr = fields.get(expectedField);
				expectAssignableType(expectedType, actualExpr);
			}
		}

		return result;
	}

	@Override
	public Type caseFieldlessRecordExpr(FieldlessRecordExpr re) {
		Map<String, Expr> fields = new LinkedHashMap<>();
		if (re.getExprs().size() == re.getType().getFields().size()) {
			for (int i = 0; i < re.getExprs().size(); i++) {
				Expr actual = re.getExprs().get(i);
				fields.put(re.getType().getFields().get(i).getName(), actual);
			}
		} else {
			error("Record shorthand was " + re.getExprs().size() + " elements, expected "
					+ re.getType().getFields().size(), re, null);
			return ERROR;
		}

		Type result = this.doSwitch(re.getType());
		RecordType expectedRecord = (RecordType) result;
		for (Entry<String, Type> entry : expectedRecord.fields.entrySet()) {
			String expectedField = entry.getKey();
			Type expectedType = entry.getValue();

			if (!fields.containsKey(expectedField)) {
				error("Missing field " + expectedField, re, SpearPackage.Literals.RECORD_EXPR__TYPE);
			} else {
				Expr actualExpr = fields.get(expectedField);
				expectAssignableType(expectedType, actualExpr);
			}
		}
		return result;
	}

	@Override
	public Type caseArrayAccessExpr(ArrayAccessExpr aae) {
		Type type = doSwitch(aae.getArray());
		if (type == ERROR) {
			return ERROR;
		}

		Type indexType = doSwitch(aae.getIndex());
		if (indexType != INT) {
			error("Expected type int, but found " + indexType, aae.getIndex());
		}

		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;
			return arrayType.base;
		} else {
			error("Expected array type, but found " + type, aae.getArray());
			return ERROR;
		}
	}

	@Override
	public Type caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		Type type = doSwitch(aue.getAccess().getArray());
		if (type == ERROR) {
			return ERROR;
		}

		Type index = doSwitch(aue.getAccess().getIndex());
		if (index != INT) {
			error("Expected type int, but found " + index, aue.getAccess().getIndex());
		}

		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;
			expectAssignableType(arrayType.base, aue.getValue());
			return arrayType;
		} else {
			error("Expected array type, but found " + type, aue.getAccess().getArray());
			return ERROR;
		}
	}

	@Override
	public Type caseArrayExpr(ArrayExpr ae) {
		Type type = doSwitch(ae.getType());

		if (type == ERROR) {
			return ERROR;
		}

		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;

			if (arrayType.size != ae.getExprs().size()) {
				error("Array expected " + arrayType.size + " elements, but received " + ae.getExprs().size()
						+ " instead.", ae);
				return ERROR;
			}

			for (Expr e : ae.getExprs()) {
				expectAssignableType(arrayType.base, e);
			}
			return arrayType;
		} else {
			error("Expected array type, but found " + type, ae);
			return ERROR;
		}
	}

	@Override
	public Type caseIntLiteral(IntLiteral ile) {
		return INT;
	}

	@Override
	public Type caseBoolLiteral(BoolLiteral ble) {
		return BOOL;
	}

	@Override
	public Type caseRealLiteral(RealLiteral rle) {
		return REAL;
	}

	@Override
	public Type caseIdExpr(IdExpr ide) {
		return doSwitch(ide.getId());
	}

	@Override
	public Type casePreviousExpr(PreviousExpr prev) {
		Type var = doSwitch(prev.getVar());

		if (var == ERROR) {
			return ERROR;
		}

		if (prev.getInit() != null) {
			Type init = doSwitch(prev.getInit());
			if (init == ERROR) {
				return ERROR;
			}

			if (!var.equals(init)) {
				error("Previous must be supplied expressions of the same type.", prev.getInit());
				return ERROR;
			}
		}

		return var;
	}

	@Override
	public Type caseIfThenElseExpr(IfThenElseExpr ite) {
		expectAssignableType(BOOL, ite.getCond());
		Type thenType = doSwitch(ite.getThen());

		if (ite.getElse() == null) {
			if (thenType != BOOL) {
				error("Then branch must be of type boolean when else branch is unspecified.", ite.getThen());
				return ERROR;
			}
			return thenType;
		}

		Type elseType = doSwitch(ite.getElse());

		if (thenType == ERROR || elseType == ERROR) {
			return ERROR;
		}

		if (!thenType.equals(elseType)) {
			error("Branches have inconsistent types " + thenType + ", " + elseType, ite);
			return ERROR;
		} else {
			return thenType;
		}
	}

	@Override
	public Type caseAfterUntilExpr(AfterUntilExpr afe) {
		expectAssignableType(BOOL, afe.getAfter());
		if (afe.getUntil() != null) {
			if (!expectAssignableType(BOOL, afe.getUntil())) {
				return ERROR;
			}
		}
		return BOOL;
	}

	@Override
	public Type caseWhileExpr(WhileExpr wh) {
		if (!expectAssignableType(BOOL, wh.getCond())) {
			return ERROR;
		}

		if (!expectAssignableType(BOOL, wh.getThen())) {
			return ERROR;
		}
		return BOOL;
	}

	@Override
	public Type caseEnumValue(EnumValue ev) {
		return doSwitch(ev.eContainer());
	}

	@Override
	public Type caseSpecificationCall(SpecificationCall call) {
		TupleType args = this.processList(new ArrayList<>(call.getArgs()));
		TupleType inputs = this.processList(new ArrayList<>(call.getSpec().getInputs()));

		if (!args.equals(inputs)) {
			error("Provided args of type " + args + ", but " + call.getSpec().getName() + " expected type " + inputs
					+ ".", call, SpearPackage.Literals.SPECIFICATION_CALL__ARGS);
			return ERROR;
		}

		TupleType outputs = this.processList(new ArrayList<>(call.getSpec().getOutputs()));
		return compressTuple(outputs);
	}

	@Override
	public Type caseMultipleIdExpr(MultipleIdExpr mide) {
		return this.processList(new ArrayList<>(mide.getIds()));
	}

	@Override
	public Type casePatternCall(PatternCall call) {
		TupleType args = this.processList(new ArrayList<>(call.getArgs()));
		TupleType inputs = this.processList(new ArrayList<>(call.getPattern().getInputs()));

		if (!args.equals(inputs)) {
			error("Provided args of type " + args + ", but " + call.getPattern().getName() + " expected type " + inputs
					+ ".", call, SpearPackage.Literals.PATTERN_CALL__ARGS);
			return ERROR;
		}

		return compressTuple(this.processList(new ArrayList<>(call.getPattern().getOutputs())));
	}

	/***************************************************************************************************/
	// HELPER FUNCTIONS
	/***************************************************************************************************/
	private TupleType processList(List<EObject> list) {
		List<Type> types = new ArrayList<>();
		for (EObject o : list) {
			types.add(this.doSwitch(o));
		}
		return new TupleType(types);
	}

	private Type compressTuple(TupleType tuple) {
		if (tuple.types.size() == 1) {
			return tuple.types.get(0);
		} else {
			return tuple;
		}
	}

	private boolean expectAssignableType(Type expected, EObject actual) {
		return expectAssignableType(expected, doSwitch(actual), actual);
	}

	private boolean expectAssignableType(Type expected, Type actual, EObject source) {
		if (!isAssignable(expected, actual)) {
			error("Expected type " + expected.toString() + ", but found type " + actual, source);
			return false;
		} else {
			return true;
		}
	}

	private boolean isAssignable(Type expected, Type actual) {
		if (expected == ERROR || actual == ERROR || expected == null || actual == null) {
			return true;
		}

		return expected.equals(actual);
	}

	private void error(String message, EObject e, EStructuralFeature feature) {
		if (messageAcceptor != null) {
			messageAcceptor.acceptError(message, e, feature, 0, null);
		}
	}

	private void error(String message, EObject e) {
		if (messageAcceptor != null) {
			messageAcceptor.acceptError(message, e, null, 0, null);
		}
	}
}
