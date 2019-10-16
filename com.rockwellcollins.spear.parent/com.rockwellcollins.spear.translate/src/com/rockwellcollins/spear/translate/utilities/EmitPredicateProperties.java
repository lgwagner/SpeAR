package com.rockwellcollins.spear.translate.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.optional.None;
import com.rockwellcollins.spear.optional.Optional;
import com.rockwellcollins.spear.optional.Some;
import com.rockwellcollins.spear.translate.references.FieldReference;
import com.rockwellcollins.spear.translate.references.IdReference;
import com.rockwellcollins.spear.translate.references.IndexReference;
import com.rockwellcollins.spear.translate.references.Reference;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.IntConstantFinder;

public class EmitPredicateProperties extends SpearSwitch<Integer> {

	public static Optional<Expr> crunch(IdRef ref) {
		EmitPredicateProperties emit = new EmitPredicateProperties();
		emit.doSwitch(ref);
		if (emit.exprs.isEmpty()) {
			return new None<Expr>();
		} else {
			Expr result = Create.createAnd(emit.exprs.iterator());
			return new Some<Expr>(result);
		}
	}

	private Reference current;
	private List<Expr> exprs = new ArrayList<>();

	@Override
	public Integer caseConstant(Constant c) {
		Reference prev = current;
		current = new IdReference(c);
		doSwitch(c.getType());
		current = prev;
		return 0;
	}

	@Override
	public Integer caseVariable(Variable v) {
		Reference prev = current;
		current = new IdReference(v);
		this.doSwitch(v.getType());
		current = prev;
		return 0;
	}

	@Override
	public Integer caseMacro(Macro m) {
		Reference prev = current;
		current = new IdReference(m);
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
	public Integer caseRecordTypeDef(RecordTypeDef rt) {
		Reference base = current;
		for (FieldType ft : rt.getFields()) {
			current = new FieldReference(base, ft);
			doSwitch(ft.getType());
		}
		current = base;
		return 0;
	}

	@Override
	public Integer caseArrayTypeDef(ArrayTypeDef at) {
		Reference base = current;
		Integer size = IntConstantFinder.fetch(at.getSize());
		for (int i = 0; i < size; i++) {
			current = new IndexReference(base, i);
			doSwitch(at.getBase());
		}
		current = base;
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
