package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.util.SpearSwitch;

public class RemoveSugar extends SpearSwitch<Void> {

	public static void transform(Document doc) {
		doc.files.stream().forEach(f -> transform(f));
	}

	private static EObject transform(EObject o) {
		// remove after/until expressions
		for (AfterUntilExpr afe : EcoreUtil2.getAllContentsOfType(o, AfterUntilExpr.class)) {
			if (afe.getUntil() != null) {
				EcoreUtil2.replace(afe, Create.createTriggers(afe.getAfter(), Create.createNot(afe.getUntil())));
			} else {
				EcoreUtil2.replace(afe, Create.createOnce(afe.getAfter()));
			}
		}

		// remove before expressions
		// remove never
		for (UnaryExpr ue : EcoreUtil2.getAllContentsOfType(o, UnaryExpr.class)) {
			if (ue.getOp().equals("before")) {
				EcoreUtil2.replace(ue, Create.createNot(Create.createOnce(ue.getExpr())));
			}

			if (ue.getOp().equals("never")) {
				EcoreUtil2.replace(ue, Create.createHistorically(Create.createNot(ue.getExpr())));
			}
		}

		// remove while
		for (WhileExpr wh : EcoreUtil2.getAllContentsOfType(o, WhileExpr.class)) {
			EcoreUtil2.replace(wh, Create.createImplication(wh.getCond(), wh.getThen()));
		}

		// remove optional ite
		for (IfThenElseExpr ite : EcoreUtil2.getAllContentsOfType(o, IfThenElseExpr.class)) {
			if (ite.getElse() == null) {
				EcoreUtil2.replace(ite, Create.createImplication(ite.getCond(), ite.getThen()));
			}
		}
		return o;
	}
}
