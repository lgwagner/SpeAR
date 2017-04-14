package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.translate.intermediate.Document;

public class NormalizeOperators {

	private static String normalize(String s) {
		return s.replaceAll("\\s+", " ");
	}
	
	public static void transform(Document doc) {
		doc.files.forEach(f -> transform(f));
	}
	
	private static EObject transform(EObject o) {
		for(UnaryExpr ue : EcoreUtil2.getAllContentsOfType(o, UnaryExpr.class)) {
			String normalizedOp = normalize(ue.getOp());
			
			switch(normalizedOp) {
				case Create.ALT_HISTORICALLY:
					ue.setOp(Create.HISTORICALLY);
					break;
					
				case Create.ALT_ONCE:
					ue.setOp(Create.ONCE);
					break;
			}
		}
		
		for(BinaryExpr be : EcoreUtil2.getAllContentsOfType(o, BinaryExpr.class)) {
			String normalizedOp = normalize(be.getOp());
			
			switch(normalizedOp) {
				case Create.ALT_IMPLIES:
					be.setOp(Create.IMPLIES);
					break;
				
				case Create.ALT_SINCE:
					be.setOp(Create.SINCE);
					break;
					
				case Create.ALT_TRIGGERS:
					be.setOp(Create.TRIGGERS);
					break;
					
				case Create.ALT_LESS_THAN:
					be.setOp(Create.LESS_THAN);
					break;
					
				case Create.ALT_LESS_THAN_OR_EQUAL_TO:
					be.setOp(Create.LESS_THAN_OR_EQUAL_TO);
					break;
					
				case Create.ALT_GREATER_THAN:
					be.setOp(Create.GREATER_THAN);
					break;
					
				case Create.ALT_GREATER_THAN_OR_EQUAL_TO:
					be.setOp(Create.GREATER_THAN_OR_EQUAL_TO);
					break;
					
				case Create.ALT_EQUAL_TO:
					be.setOp(Create.EQUAL_TO);
					break;
					
				case Create.ALT_NOT_EQUAL_TO:
					be.setOp(Create.NOT_EQUAL_TO);
					break;
					
				case Create.ALT_ARROW:
					be.setOp(Create.ARROW);
					break;
			}
		}
		return o;
	}
}
