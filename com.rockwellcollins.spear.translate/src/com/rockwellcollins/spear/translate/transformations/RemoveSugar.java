package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.language.CreateExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class RemoveSugar extends SpearSwitch<Void> {
	
	public static void transform(SpearDocument doc) {
		for(File f : doc.files) {
			transform(f);
		}
	}
	
	public static void transform(PatternDocument doc) {
		for(Pattern p : doc.patterns) {
			transform(p);
		}
	}
	
	private static EObject transform(EObject o) {
		//remove after/until expressions
		for(AfterUntilExpr afe : EcoreUtil2.getAllContentsOfType(o, AfterUntilExpr.class)) {
			if(afe.getUntil() != null) {
				EcoreUtil2.replace(afe,CreateExpr.createTriggers(afe.getAfter(), CreateExpr.createNot(afe.getUntil())));
			} else {
				EcoreUtil2.replace(afe,CreateExpr.createOnce(afe.getAfter()));
			}
		}
		
		//remove before expressions
		//remove never
		for(UnaryExpr ue : EcoreUtil2.getAllContentsOfType(o, UnaryExpr.class)) {
			if(ue.getOp().equals("before")) {
				EcoreUtil2.replace(ue, CreateExpr.createNot(CreateExpr.createOnce(ue.getExpr())));
			}
			
			if(ue.getOp().equals("never")) {
				EcoreUtil2.replace(ue, CreateExpr.createHistorically(CreateExpr.createNot(ue.getExpr())));
			}
		}

		//remove while
		for(WhileExpr wh : EcoreUtil2.getAllContentsOfType(o, WhileExpr.class)) {
			EcoreUtil2.replace(wh, CreateExpr.createImplication(wh.getCond(), wh.getThen()));
		}
		
		//remove optional ite
		for(IfThenElseExpr ite : EcoreUtil2.getAllContentsOfType(o, IfThenElseExpr.class)) {
			if(ite.getElse() == null) {
				EcoreUtil2.replace(ite, CreateExpr.createImplication(ite.getCond(), ite.getThen()));
			}
		}
		
		return o;
	}

}
