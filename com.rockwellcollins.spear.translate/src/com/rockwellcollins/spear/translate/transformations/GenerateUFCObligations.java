package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.UFC;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GenerateUFCObligations extends SpearSwitch<List<Expr>> {

	public static void crunch(Document d) {
		if (d.main instanceof Specification) {
			Specification s = (Specification) d.main;
			Map<String,String> renaming = d.renamed.get(s);
			GenerateUFCObligations obs = new GenerateUFCObligations();
			List<Constraint> newConstraints = new ArrayList<>();

			for (Constraint c : s.getBehaviors()) {
				newConstraints.add(EcoreUtil2.copy(c));
				if (c instanceof FormalConstraint) {
					FormalConstraint fc = (FormalConstraint) c;
					if (fc.getFlag() instanceof UFC) {
						int counter = 0;
						for (Expr e : obs.doSwitch(fc.getExpr())) {
							String original = renaming.get(fc.getName());
							newConstraints.add(createTestObligation(original + "_ufc_c" + counter, e));
							counter++;
						}
					}
				}
			}

			s.getBehaviors().clear();
			s.getBehaviors().addAll(newConstraints);
		}
	}

	public static FormalConstraint createTestObligation(String name, Expr e) {
		FormalConstraint fc = Create.createFormalConstraint(name, e);
		fc.setFlag(Create.Observe());
		return fc;
	}

	public boolean positive = true;

	private void flip() {
		positive = !positive;
	}

	@Override
	public List<Expr> caseBinaryExpr(BinaryExpr be) {
		List<Expr> result = new ArrayList<>();
		switch (be.getOp()) {

		case "and":
			for (Expr e : doSwitch(be.getLeft())) {
				result.add(Create.createAnd(e, EcoreUtil2.copy(be.getRight())));
			}
			for (Expr e : doSwitch(be.getRight())) {
				result.add(Create.createAnd(EcoreUtil2.copy(be.getLeft()), e));
			}
			break;

		case "or":
		case "xor": //not a complete handling, but for now, it'll do
			for (Expr e : doSwitch(be.getLeft())) {
				result.add(Create.createAnd(e, Create.createNot(EcoreUtil2.copy(be.getRight()))));
			}
			for (Expr e : doSwitch(be.getRight())) {
				result.add(Create.createAnd(Create.createNot(EcoreUtil2.copy(be.getLeft())), e));
			}
			break;
			
		case "implies":
			Expr left = EcoreUtil2.copy(be.getLeft());
			Expr right = EcoreUtil2.copy(be.getRight());
			return doSwitch(Create.createOr(Create.createNot(left),right));

		// atomic
		case ">":
		case ">=":
		case "<":
		case "<=":
		case "==":
		case "<>":
			return null;

		// not sure
		case "triggers":
		case "since":
		case "once":
		case "historically":
		default:
			throw new IllegalArgumentException();
		}
		return result;
	}

	@Override
	public List<Expr> caseUnaryExpr(UnaryExpr ue) {
		switch (ue.getOp()) {
		case "not":
			flip();
			List<Expr> result = doSwitch(ue.getExpr());
			flip();
			return result;
			
		default:
			throw new IllegalArgumentException("TODO");
		}
	}

	@Override
	public List<Expr> casePreviousExpr(PreviousExpr pre) {
		throw new IllegalArgumentException("TODO");
	}

	@Override
	public List<Expr> caseIfThenElseExpr(IfThenElseExpr ite) {
		doSwitch(ite.getCond());
		doSwitch(ite.getThen());
		doSwitch(ite.getElse());
		throw new IllegalArgumentException("TODO");
	}

	@Override
	public List<Expr> caseExpr(Expr e) {
		if (positive) {
			return Collections.singletonList(EcoreUtil2.copy(e));
		} else {
			return Collections.singletonList(Create.createNot(EcoreUtil2.copy(e)));
		}
	}
}
