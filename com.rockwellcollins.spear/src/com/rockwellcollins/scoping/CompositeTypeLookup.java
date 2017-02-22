package com.rockwellcollins.scoping;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayExpr;
import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.util.SpearSwitch;

public class CompositeTypeLookup extends SpearSwitch<TypeDef> {

	public static RecordTypeDef getRecordType(Expr e) {
		return (RecordTypeDef) new CompositeTypeLookup().doSwitch(e);
	}
	
	public static TypeDef getTypeDef(Expr e) {
		return new CompositeTypeLookup().doSwitch(e);
	}

	@Override
	public TypeDef caseUserType(UserType ut) {
		return doSwitch(ut.getDef());
	}
	
	@Override
	public TypeDef caseNamedTypeDef(NamedTypeDef nt) {
		return doSwitch(nt.getType());
	}
	
	@Override
	public RecordTypeDef caseRecordTypeDef(RecordTypeDef rt) {
		return rt;
	}
	
	@Override
	public ArrayTypeDef caseArrayTypeDef(ArrayTypeDef at) {
		return at;
	}
	
	@Override
	public EnumTypeDef caseEnumTypeDef(EnumTypeDef etd) {
		return etd;
	}
	
	@Override
	public TypeDef casePredicateSubTypeDef(PredicateSubTypeDef pstd) {
		return doSwitch(pstd.getPredVar());
	}
	
	@Override
	public TypeDef caseFieldType(FieldType ft) {
		return doSwitch(ft.getType());
	}
	
	@Override
	public TypeDef caseConstant(Constant c) {
		return doSwitch(c.getType());
	}
	
	@Override
	public TypeDef caseMacro(Macro m) {
		return doSwitch(m.getType());
	}
	
	@Override
	public TypeDef caseVariable(Variable v) {
		return doSwitch(v.getType());
	}
	
	@Override
	public TypeDef caseIdExpr(IdExpr ide) {
		return doSwitch(ide.getId());
	}
	
	@Override
	public TypeDef caseArrayExpr(ArrayExpr ae) {
		return doSwitch(ae.getType());
	}
	
	@Override
	public TypeDef caseArrayAccessExpr(ArrayAccessExpr aae) {
		ArrayTypeDef at = (ArrayTypeDef) doSwitch(aae.getArray());
		return doSwitch(at.getBase());
	}
	
	@Override
	public TypeDef caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		return this.doSwitch(aue.getAccess());
	}
	
	@Override
	public TypeDef caseRecordUpdateExpr(RecordUpdateExpr rue) {
		return doSwitch(rue.getRecord());
	}
	
	@Override
	public TypeDef caseRecordAccessExpr(RecordAccessExpr rae) {
		return doSwitch(rae.getField());
	}
	
	@Override
	public TypeDef caseFieldlessRecordExpr(FieldlessRecordExpr fre) {
		return doSwitch(fre.getType());
	}
	
	@Override
	public TypeDef caseRecordExpr(RecordExpr re) {
		return doSwitch(re.getType());
	}
	
	@Override
	public TypeDef caseIfThenElseExpr(IfThenElseExpr ite) {
		return doSwitch(ite.getThen());
	}
	
	@Override
	public TypeDef casePreviousExpr(PreviousExpr pre) {
		return doSwitch(pre.getVar());
	}
	
	@Override
	public TypeDef caseFieldExpr(FieldExpr fe) {
		return doSwitch(fe.getField());
	}
	
	@Override
	public TypeDef defaultCase(EObject o) {
//		System.out.println("Unsupported element " + o);
		return null;
	}
}
