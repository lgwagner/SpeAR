package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.translate.intermediate.Document;

public class ReplaceShortHandRecords {

  public static SpearFactory factory = SpearFactory.eINSTANCE;

  public static void transform(Document doc) {
    doc.files.stream().forEach(f -> transform(f));
  }

  public static EObject transform(EObject o) {
    for (FieldlessRecordExpr fre : EcoreUtil2.getAllContentsOfType(o, FieldlessRecordExpr.class)) {
      RecordExpr legit = create(fre);
      EcoreUtil2.replace(fre, legit);
    }
    return o;
  }

  private static RecordExpr create(FieldlessRecordExpr fre) {
    RecordExpr legit = factory.createRecordExpr();
    legit.setType(fre.getType());

    int i = 0;
    for (Expr e : fre.getExprs()) {
      Expr copied = EcoreUtil2.copy(e);
      FieldType ft = fre.getType().getFields().get(i);
      FieldExpr fe = factory.createFieldExpr();
      fe.setField(ft);
      fe.setExpr(copied);
      legit.getFieldExprs().add(fe);
      i++;
    }
    return legit;
  }
}
