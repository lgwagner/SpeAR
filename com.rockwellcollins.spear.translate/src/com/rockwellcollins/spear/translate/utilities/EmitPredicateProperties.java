package com.rockwellcollins.spear.translate.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.ExprReplacement;

public class EmitPredicateProperties extends SpearSwitch<Integer> {
	
	public static Expr crunch(IdRef ref) {
		EmitPredicateProperties emit = new EmitPredicateProperties();
		emit.doSwitch(ref);
		Expr result = Create.createAnd(emit.exprs.iterator());
		return result;
	}
	
	private IdRef current;
	private List<Expr> exprs = new ArrayList<>();

	@Override
	public Integer caseConstant(Constant c) {
		IdRef prev = current;
		current = c;
		doSwitch(c.getType());
		current = prev;
		return 0;
	}
	
	@Override
	public Integer caseVariable(Variable v) {
		IdRef prev = current;
		current = v;
		this.doSwitch(v.getType());
		current = prev;
		return 0;
	}
	
	@Override
	public Integer caseMacro(Macro m) {
		IdRef prev = current;
		current = m;
		this.doSwitch(m.getType());
		current = prev;
		return 0;
	}
	
	@Override
	public Integer casePredicateSubTypeDef(PredicateSubTypeDef pstd) {
		exprs.add(ExprReplacement.replace(current, pstd));
		doSwitch(pstd.getPredVar().getType());
		return 0;
	}
	
	@Override
	public Integer caseUserType(UserType ut) {
		this.doSwitch(ut.getDef());
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject e) {
		e.eContents().stream().forEach(o -> this.doSwitch(o));
		e.eCrossReferences().stream().forEach(ref -> this.doSwitch(ref));
		return 0;
	}
}
