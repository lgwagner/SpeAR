package com.rockwellcollins.spear.translate.transformations;

import static com.rockwellcollins.spear.language.Create.createAnd;
import static com.rockwellcollins.spear.language.Create.createFalse;
import static com.rockwellcollins.spear.language.Create.createNot;
import static com.rockwellcollins.spear.language.Create.createOr;
import static com.rockwellcollins.spear.language.Create.createPrevious;
import static org.eclipse.emf.ecore.util.EcoreUtil.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
			Map<String, String> renaming = d.renamed.get(s);
			GenerateUFCObligations obs = new GenerateUFCObligations();
			List<Constraint> newConstraints = new ArrayList<>();

			for (Constraint c : s.getRequirements()) {
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

			for (Constraint c : s.getBehaviors()) {
				newConstraints.add(copy(c));
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
				result.add(createAnd(e, copy(be.getRight())));
			}
			
			for (Expr e : doSwitch(be.getRight())) {
				result.add(createAnd(copy(be.getLeft()), e));
			}
			
			break;

		case "or": // not a complete handling, but for now, it'll do
			for (Expr e : doSwitch(be.getLeft())) {
				result.add(createAnd(e, createNot(copy(be.getRight()))));
			}
			
			for (Expr e : doSwitch(be.getRight())) {
				result.add(createAnd(createNot(copy(be.getLeft())), e));
			}
			
			break;

		case "xor":
			for (Expr e : doSwitch(be.getLeft())) {
				result.add(createAnd(e, createNot(copy(be.getRight()))));
			}
			
			for (Expr e : doSwitch(be.getRight())) {
				result.add(createAnd(createNot(copy(be.getLeft())), e));
			}
			
			flip();
			for (Expr e : doSwitch(be.getLeft())) {
				result.add(createAnd(e, copy(be.getRight())));
			}
			
			for (Expr e : doSwitch(be.getRight())) {
				result.add(createAnd(copy(be.getLeft()), e));
			}

			flip();
			break;

		case "implies":
			Expr left = copy(be.getLeft());
			Expr right = copy(be.getRight());
			return doSwitch(createOr(createNot(left), right));

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
		default:
			throw new IllegalArgumentException("Should not be reached.");
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

		/*
		 * Questions:
		 * 	Do we go inside of PLTL expressions?
		 * 		H(a or b) implies x
		 * 			in this case do we need two test cases?
		 * 			
		 * 		O(a and b) implies y
		 * 
		 *  Do we add a counter variable to have minimum length for expressions that satisfy H,O,S,T?
		 *  
		 *  H(x) could be 1 step, 5 steps, 100 steps. 
		 *  	- one is not very interesting
		 *  	- 100 is probably prohibitively expensive
		 *  	- 3-5 is likely the best range
		 *  
		 */
		case "once":
		case "historically":
		default:
			throw new IllegalArgumentException("Should not be reached.");
		}
	}

	@Override
	public List<Expr> casePreviousExpr(PreviousExpr pre) {
		List<Expr> result = new ArrayList<>();
		for (Expr e : doSwitch(pre.getVar())) {
			result.add(createPrevious(e, createFalse()));
		}

		if (pre.getInit() != null) {
			for (Expr e : doSwitch(pre.getInit())) {
				result.add(createPrevious(createFalse(), e));
			}
		}
		return result;
	}

	@Override
	public List<Expr> caseIfThenElseExpr(IfThenElseExpr ite) {
		List<Expr> result = new ArrayList<>();

		// cond
		for (Expr e : doSwitch(ite.getCond())) {
			result.add(createAnd(e, copy(ite.getThen()), createNot(copy(ite.getElse()))));
		}

		flip();
		for (Expr e : doSwitch(ite.getCond())) {
			result.add(createAnd(e, createNot(copy(ite.getThen())), copy(ite.getElse())));
		}
		flip();

		// then
		for (Expr e : doSwitch(ite.getThen())) {
			result.add(createAnd(copy(ite.getCond()), e));
		}

		// else
		for (Expr e : doSwitch(ite.getElse())) {
			result.add(createAnd(createNot(copy(ite.getCond())), e));
		}
		return result;
	}

	@Override
	public List<Expr> caseExpr(Expr e) {
		if (positive) {
			return Collections.singletonList(copy(e));
		} else {
			return Collections.singletonList(createNot(copy(e)));
		}
	}
}
