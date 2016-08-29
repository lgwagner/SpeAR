package com.rockwellcollins.spear.translate.transformations;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.SpearFactory;

public class ReplaceShortHandRecords {
	
	public static SpearFactory factory = SpearFactory.eINSTANCE;
	
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
	
	public static EObject transform(EObject o) {
		List<FieldlessRecordExpr> fieldlessRecords = EcoreUtil2.getAllContentsOfType(o, FieldlessRecordExpr.class);
		for(FieldlessRecordExpr fre : fieldlessRecords) {
			RecordExpr legit = factory.createRecordExpr();
			legit.setType(fre.getType());
			
			int i=0;
			for(Expr e : fre.getExprs()) {
				FieldType ft = fre.getType().getFields().get(i);
				FieldExpr fe = factory.createFieldExpr();
				fe.setField(ft);
				fe.setExpr(EcoreUtil2.copy(e));
				legit.getFieldExprs().add(fe);
				i++;
			}
			EcoreUtil2.replace(fre, legit);
		}
		return o;
	}
}
