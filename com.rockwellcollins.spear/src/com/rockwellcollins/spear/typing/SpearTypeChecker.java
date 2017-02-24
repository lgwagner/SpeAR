package com.rockwellcollins.spear.typing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.BoolType;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.IntType;
import com.rockwellcollins.spear.IntegerCast;
import com.rockwellcollins.spear.LustreAssertion;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.LustreProperty;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.MultipleExpr;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RealCast;
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
import com.rockwellcollins.spear.utilities.ConstantChecker;
import com.rockwellcollins.spear.utilities.IntConstantFinder;

public class SpearTypeChecker extends SpearSwitch<Type> {

	public static Type typeCheck(EObject o, Set<EObject> errors, ValidationMessageAcceptor acceptor) {
		SpearTypeChecker typecheck = new SpearTypeChecker(errors, acceptor);
		return typecheck.doSwitch(o);
	}
	
	public static Type typeCheck(EObject o) {
		SpearTypeChecker typecheck = new SpearTypeChecker();
		return typecheck.doSwitch(o);
	}

	final private ValidationMessageAcceptor messageAcceptor;
	final private Set<EObject> errors;

	public SpearTypeChecker(Set<EObject> errors, ValidationMessageAcceptor acceptor) {
		this.errors = errors;
		this.messageAcceptor = acceptor;
	}
	
	public SpearTypeChecker() {
		this.errors = new HashSet<>();
		this.messageAcceptor = null;
	}

	public static final Type ERROR = PrimitiveType.ERROR;
	public static final Type BOOL = PrimitiveType.BOOL;
	public static final Type INT = PrimitiveType.INT;
	public static final Type REAL = PrimitiveType.REAL;

	/***************************************************************************************************/
	// TYPES
	/***************************************************************************************************/
	
	@Override
	public Type doSwitch(EObject o) {
		if(errors.contains(o)) {
			return ERROR;
		}
		return super.doSwitch(o);
	}
	
	private Type error(EObject eo) {
		errors.add(eo);
		return ERROR;
	}
	
	@Override
	public Type caseNamedTypeDef(NamedTypeDef nt) {
		return doSwitch(nt.getType());
	}
	
	@Override
	public Type caseAbstractTypeDef(AbstractTypeDef at) {
		return new AbstractType(at);
	}

	@Override
	public Type caseRecordTypeDef(RecordTypeDef rt) {
		if (rt.getName() == null) {
			return error(rt);
		}

		Map<String, Type> fields = new LinkedHashMap<>();
		rt.getFields().stream().forEach(rtf -> fields.put(rtf.getName(), this.doSwitch(rtf.getType())));
		return new RecordType(rt.getName(),fields,rt);
	}

	@Override
	public Type caseArrayTypeDef(ArrayTypeDef at) {
		if (at.getName() == null) {
			return error(at);
		}

		Type sizeType = doSwitch(at.getSize());
		if(!sizeType.equals(PrimitiveType.INT)) {
			error(at.getName() + " must be given an integer size argument.", at, SpearPackage.Literals.ARRAY_TYPE_DEF__SIZE);
			return error(at);
		}
		
		if(!ConstantChecker.isConstant(at.getSize())) {
			error(at.getName() + " must be given a constant size argument.", at, SpearPackage.Literals.ARRAY_TYPE_DEF__SIZE);
			return error(at);
		} 
		
		Integer size = IntConstantFinder.fetch(at);
		if(size == null) {
			error("A concrete size value cannot be determined for " + at.getName(), at, SpearPackage.Literals.ARRAY_TYPE_DEF__SIZE);
			return error(at);
		}
		
		return new ArrayType(at.getName(), doSwitch(at.getBase()), size, at);
	}

	@Override
	public Type caseEnumTypeDef(EnumTypeDef et) {
		if (et.getName() == null) {
			return error(et);
		}
		List<String> values = et.getValues().stream().map(ev -> ev.getName()).collect(Collectors.toList());
		return new EnumType(et.getName(), values, et);
	}
	
	@Override
	public Type casePredicateSubTypeDef(PredicateSubTypeDef pstd) {
		Type expected = PrimitiveType.BOOL;
		expectAssignableType(expected,pstd.getPredExpr());
		
		return this.doSwitch(pstd.getPredVar());
	}

	public final Deque<TypeDef> stack = new ArrayDeque<>();

	@Override
	public Type caseUserType(UserType ut) {
		if (stack.contains(ut.getDef())) {
			return error(ut);
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
	
	@Override
	public Type caseFormalConstraint(FormalConstraint fc) {
		Type expected = BOOL;
		if(!expectAssignableType(expected, fc.getExpr())) {
			return error(fc);
		}
		return expected;
	}

	/***************************************************************************************************/
	// Pattern Components
	/***************************************************************************************************/
	@Override
	public Type caseLustreAssertion(LustreAssertion la) {
		Type expected = BOOL;
		if(!expectAssignableType(expected, la.getAssertionExpr())) {
			return error(la);
		}
		return expected;
	}
	
	@Override
	public Type caseLustreEquation(LustreEquation le) {
		Type expected = this.processList(new ArrayList<>(le.getIds()));
		
		if(expected == ERROR) {
			return ERROR;
		}
		
		if(!expectAssignableType(expected, le.getRhs())) {
			return error(le);
		}
		return expected;
	}
	
	@Override
	public Type caseLustreProperty(LustreProperty lp) {
		Type expected = BOOL;
		Type actual = doSwitch(lp.getPropertyId());
		if(!expectAssignableType(expected, actual, lp)) {
			return error(lp);
		}
		return expected;
	}
	
	/***************************************************************************************************/
	// EXPRESSIONS
	/***************************************************************************************************/

	@Override
	public Type caseBinaryExpr(BinaryExpr be) {
		Type left = doSwitch(be.getLeft());
		Type right = doSwitch(be.getRight());

		if (left == ERROR || right == ERROR) {
			return error(be);
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
		case "mod":
			if (left == REAL && right == REAL) {
				return REAL;
			}

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
		return error(be);
	}

	@Override
	public Type caseUnaryExpr(UnaryExpr ue) {
		Type type = doSwitch(ue.getExpr());
		if (type == ERROR) {
			return error(ue);
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
		return error(ue);
	}

	@Override
	public Type caseRecordAccessExpr(RecordAccessExpr rae) {
		Type type = doSwitch(rae.getRecord());
		if (type == ERROR) {
			return error(rae);
		}

		if (type instanceof RecordType) {
			RecordType recordType = (RecordType) type;
			return recordType.fields.get(rae.getField().getName());
		} else {
			error("Expected record type, but found " + type, rae.getRecord());
			return error(rae);
		}
	}

	@Override
	public Type caseRecordUpdateExpr(RecordUpdateExpr rue) {
		Type type = doSwitch(rue.getRecord());

		if (type == ERROR) {
			return error(rue);
		}

		if (type instanceof RecordType) {
			RecordType recordType = (RecordType) type;
			Type fieldType = recordType.fields.get(rue.getField().getName());
			expectAssignableType(fieldType, rue.getValue());
			return recordType;
		} else {
			error("Expected record type, but found " + type, rue.getRecord());
			return error(rue);
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
			return error(re);
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
			return error(re);
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
			return error(aae);
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
			return error(aae);
		}
	}

	@Override
	public Type caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		Type type = doSwitch(aue.getAccess().getArray());
		if (type == ERROR) {
			return error(aue);
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
			return error(aue);
		}
	}

	@Override
	public Type caseArrayExpr(ArrayExpr ae) {
		Type type = doSwitch(ae.getType());

		if (type == ERROR) {
			return error(ae);
		}

		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;

			if (arrayType.size != ae.getExprs().size()) {
				error("Array expected " + arrayType.size + " elements, but received " + ae.getExprs().size()
						+ " instead.", ae);
				return error(ae);
			}

			for (Expr e : ae.getExprs()) {
				expectAssignableType(arrayType.base, e);
			}
			return arrayType;
		} else {
			error("Expected array type, but found " + type, ae);
			return error(ae);
		}
	}

	@Override
	public Type caseIntegerCast(IntegerCast cast) {
		Type sub = doSwitch(cast.getExpr());
		if(!sub.equals(REAL)) {
			error("Integer cast expressions can only be applied to real types.",cast,SpearPackage.Literals.INTEGER_CAST__EXPR);
			return ERROR;
		}
		return INT;
	}
	
	@Override
	public Type caseRealCast(RealCast cast) {
		Type sub = doSwitch(cast.getExpr());
		if(!sub.equals(INT)) {
			error("Real cast expressions can only be applied to integer types.",cast,SpearPackage.Literals.REAL_CAST__EXPR);
			return ERROR;
		}
		return REAL;
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
			return error(prev);
		}

		if (prev.getInit() != null) {
			Type init = doSwitch(prev.getInit());
			if (init == ERROR) {
				return error(prev);
			}

			if (!var.equals(init)) {
				error("Previous must be supplied expressions of the same type.", prev.getInit());
				return error(prev);
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
				return error(ite);
			}
			return thenType;
		}

		Type elseType = doSwitch(ite.getElse());

		if (thenType == ERROR || elseType == ERROR) {
			return error(ite);
		}

		if (!thenType.equals(elseType)) {
			error("Branches have inconsistent types " + thenType + ", " + elseType, ite);
			return error(ite);
		} else {
			return thenType;
		}
	}

	@Override
	public Type caseAfterUntilExpr(AfterUntilExpr afe) {
		expectAssignableType(BOOL, afe.getAfter());
		if (afe.getUntil() != null) {
			if (!expectAssignableType(BOOL, afe.getUntil())) {
				return error(afe);
			}
		}
		return BOOL;
	}

	@Override
	public Type caseWhileExpr(WhileExpr wh) {
		if (!expectAssignableType(BOOL, wh.getCond())) {
			return error(wh);
		}

		if (!expectAssignableType(BOOL, wh.getThen())) {
			return error(wh);
		}
		return BOOL;
	}

	@Override
	public Type caseEnumValue(EnumValue ev) {
		return doSwitch(ev.eContainer());
	}

	@Override
	public Type caseSpecificationCall(SpecificationCall call) {
		Type args = this.processList(new ArrayList<>(call.getArgs()));
		Type inputs = this.processList(new ArrayList<>(call.getSpec().getInputs()));
		
		if(args == ERROR || inputs == ERROR) {
			return ERROR;
		}

		if (!args.equals(inputs)) {
			error("Provided args of type " + args + ", but spec " + call.getSpec().getName() + " expected type " + inputs
					+ ".", call, SpearPackage.Literals.SPECIFICATION_CALL__ARGS);
			return error(call);
		}

		return this.processList(new ArrayList<>(call.getSpec().getOutputs()));
	}

	@Override
	public Type caseMultipleExpr(MultipleExpr mide) {
		return this.processList(new ArrayList<>(mide.getExprs()));
	}

	@Override
	public Type casePatternCall(PatternCall call) {
		Type args = this.processList(new ArrayList<>(call.getArgs()));
		Type inputs = this.processList(new ArrayList<>(call.getPattern().getInputs()));
		
		if(args == ERROR || inputs == ERROR) {
			return ERROR;
		}
		
		if (!args.equals(inputs)) {
			if (call.getPattern().getName() == null) {
				error("Possible omission of 'spec' keyword in specification call.", call, SpearPackage.Literals.PATTERN_CALL__ARGS);
			} else {
				error("Provided args of type " + args + ", but spec " + call.getPattern().getName() + " expected type " + inputs + ".", call, SpearPackage.Literals.PATTERN_CALL__ARGS);
			}
			return error(call);
		}
		return this.processList(new ArrayList<>(call.getPattern().getOutputs()));
	}

	/***************************************************************************************************/
	// HELPER FUNCTIONS
	/***************************************************************************************************/
	private Type processList(List<EObject> list) {
		TupleType tt = new TupleType(list.stream().map(o -> this.doSwitch(o)).collect(Collectors.toList()));
		if(tt.types.contains(ERROR)) {
			return ERROR;
		}
		return compressTuple(tt);
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
