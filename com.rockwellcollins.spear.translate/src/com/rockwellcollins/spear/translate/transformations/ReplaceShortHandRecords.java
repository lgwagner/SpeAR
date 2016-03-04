package com.rockwellcollins.spear.translate.transformations;

import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.SpearFactory;

public class ReplaceShortHandRecords {
	
	public static SpearFactory factory = SpearFactory.eINSTANCE;
	
	public static void transform(SpearDocument p) {
		for(File f : p.files) {
			transform(f);
		}
	}
	
	public static File transform(File f) {
		List<FieldlessRecordExpr> fieldlessRecords = EcoreUtil2.getAllContentsOfType(f, FieldlessRecordExpr.class);
		for(FieldlessRecordExpr fre : fieldlessRecords) {
			RecordExpr legit = factory.createRecordExpr();
			legit.setType(fre.getType());
			
			int i=0;
			for(Expr e : fre.getExprs()) {
				FieldType ft = fre.getType().getFields().get(i);
				FieldExpr fe = factory.createFieldExpr();
				fe.setField(ft);
				fe.setExpr(e);
				legit.getFieldExprs().add(fe);
			}
			
			EcoreUtil2.replace(fre, legit);
		}
		return f;
	}

}
