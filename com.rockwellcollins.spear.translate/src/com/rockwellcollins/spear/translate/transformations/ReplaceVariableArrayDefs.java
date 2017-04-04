package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.ConcreteArrayTypeDef;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.IntConstantFinder;

public class ReplaceVariableArrayDefs extends SpearSwitch<Integer> {

	public static void transform(Document d) {
		ReplaceVariableArrayDefs replacer = new ReplaceVariableArrayDefs();
		d.files.forEach(f -> replacer.doSwitch(f));
		
		for(File f : d.files) {
			for(UserType ut : EcoreUtil2.getAllContentsOfType(f, UserType.class)) {
				if(replacer.map.containsKey(ut.getDef())) {
					ut.setDef(replacer.map.get(ut.getDef()));
				}
			}
		}
	}
	
	public Map<ArrayTypeDef,ConcreteArrayTypeDef> map = new HashMap<>();
	
	public Integer caseArrayTypeDef(ArrayTypeDef atd) {
		Integer size = IntConstantFinder.fetch(atd);
		ConcreteArrayTypeDef ctd = SpearFactory.eINSTANCE.createConcreteArrayTypeDef();
		ctd.setName(atd.getName());
		ctd.setBase(EcoreUtil2.copy(atd.getBase()));
		ctd.setSize(size);
		EcoreUtil2.replace(atd, ctd);
		map.put(atd, ctd);
		return 0;
	}
	
	public Integer defaultCase(EObject e) {
		e.eContents().stream().forEach(o -> this.doSwitch(o));
		e.eCrossReferences().stream().forEach(ref -> this.doSwitch(ref));
		return 0;
	}
}
