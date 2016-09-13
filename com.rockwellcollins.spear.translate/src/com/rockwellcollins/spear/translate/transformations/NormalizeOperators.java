package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.language.CreateExpr;
import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;

public class NormalizeOperators {

	private static String normalize(String s) {
		return s.replaceAll("\\s+", " ");
	}
	
	public static void transform(SpearDocument doc) {
		for(Pattern p : doc.patterns.values()) {
			transform(p);
		}
		
		for(Specification s : doc.specifications.values()) {
			transform(s);
		}
	}
	
	public static void transform(PatternDocument doc) {
		for(Pattern p : doc.patterns.values()) {
			transform(p);
		}
	}
	
	private static EObject transform(EObject o) {
		for(UnaryExpr ue : EcoreUtil2.getAllContentsOfType(o, UnaryExpr.class)) {
			String normalizedOp = normalize(ue.getOp());
			
			switch(normalizedOp) {
				case CreateExpr.ALT_HISTORICALLY:
					ue.setOp(CreateExpr.HISTORICALLY);
					break;
					
				case CreateExpr.ALT_ONCE:
					ue.setOp(CreateExpr.ONCE);
					break;
			}
		}
		
		for(BinaryExpr be : EcoreUtil2.getAllContentsOfType(o, BinaryExpr.class)) {
			String normalizedOp = normalize(be.getOp());
			
			switch(normalizedOp) {
				case CreateExpr.ALT_IMPLIES:
					be.setOp(CreateExpr.IMPLIES);
					break;
				
				case CreateExpr.ALT_SINCE:
					be.setOp(CreateExpr.SINCE);
					break;
					
				case CreateExpr.ALT_TRIGGERS:
					be.setOp(CreateExpr.TRIGGERS);
					break;
					
				case CreateExpr.ALT_LESS_THAN:
					be.setOp(CreateExpr.LESS_THAN);
					break;
					
				case CreateExpr.ALT_LESS_THAN_OR_EQUAL_TO:
					be.setOp(CreateExpr.LESS_THAN_OR_EQUAL_TO);
					break;
					
				case CreateExpr.ALT_GREATER_THAN:
					be.setOp(CreateExpr.GREATER_THAN);
					break;
					
				case CreateExpr.ALT_GREATER_THAN_OR_EQUAL_TO:
					be.setOp(CreateExpr.GREATER_THAN_OR_EQUAL_TO);
					break;
					
				case CreateExpr.ALT_EQUAL_TO:
					be.setOp(CreateExpr.EQUAL_TO);
					break;
					
				case CreateExpr.ALT_NOT_EQUAL_TO:
					be.setOp(CreateExpr.NOT_EQUAL_TO);
					break;
					
				case CreateExpr.ALT_ARROW:
					be.setOp(CreateExpr.ARROW);
					break;
			}
		}
		return o;
	}
}
