package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.language.CreateExpr;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.util.SpearSwitch;

public class RemoveCompositeReferences extends SpearSwitch<Integer> {
	
	private Integer key = 0;
	
	public static void transform(SpearDocument doc) {
		RemoveCompositeReferences transformer = new RemoveCompositeReferences();
		doc.specifications.values().stream().forEach(s -> transformer.transform(s));
	}

	private ArrayList<Macro> generated;
	
	public void transform(Specification s) {
		generated = new ArrayList<>();
		EcoreUtil2.getAllContentsOfType(s, FormalConstraint.class).stream().forEach(fc -> this.doSwitch(fc));
		s.getMacros().addAll(generated);
	}
	
	private String getMacroName() {
		String value = "generated_macro_" + key;
		key++;
		return value;
	}
	
	@Override
	public Integer caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		//we intentionally do not do the access as it will mess up the array update
		this.doSwitch(aue.getValue());
		
		com.rockwellcollins.spear.typing.Type t = SpearTypeChecker.typeCheck(aue);
		Macro m = CreateExpr.createMacro(getMacroName(), t.getType(), EcoreUtil2.copy(aue));
		EcoreUtil2.replace(aue, CreateExpr.createIdExpr(m));
		generated.add(m);
		
		return 0;
	}
	
	@Override
	public Integer caseArrayAccessExpr(ArrayAccessExpr aae) {
		this.doSwitch(aae.getIndex());
		this.doSwitch(aae.getArray());
		
		com.rockwellcollins.spear.typing.Type t = SpearTypeChecker.typeCheck(aae);
		Macro m = CreateExpr.createMacro(getMacroName(), t.getType(), EcoreUtil2.copy(aae));
		EcoreUtil2.replace(aae, CreateExpr.createIdExpr(m));
		generated.add(m);
		
		return 0;
	}
	
	@Override
	public Integer caseRecordUpdateExpr(RecordUpdateExpr rue) {
		this.doSwitch(rue.getRecord());
		this.doSwitch(rue.getValue());
		
		com.rockwellcollins.spear.typing.Type t = SpearTypeChecker.typeCheck(rue);
		Macro m = CreateExpr.createMacro(getMacroName(), t.getType(), EcoreUtil2.copy(rue));
		EcoreUtil2.replace(rue, CreateExpr.createIdExpr(m));
		generated.add(m);
		
		return 0;
	}
	
	@Override
	public Integer caseRecordAccessExpr(RecordAccessExpr rae) {
		this.doSwitch(rae.getRecord());
		
		com.rockwellcollins.spear.typing.Type t = SpearTypeChecker.typeCheck(rae);
		Macro m = CreateExpr.createMacro(getMacroName(), t.getType(), EcoreUtil2.copy(rae));
		EcoreUtil2.replace(rae, CreateExpr.createIdExpr(m));
		generated.add(m);
		
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject eo) {
		eo.eContents().stream().forEach(sub -> this.doSwitch(sub));
		return 0;
	}
}
