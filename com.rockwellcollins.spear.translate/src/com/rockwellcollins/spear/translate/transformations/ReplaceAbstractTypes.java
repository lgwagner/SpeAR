package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AbstractTypeDef;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReplaceAbstractTypes extends SpearSwitch<Integer> {

	public static void transform(Document d) {
		ReplaceAbstractTypes replacer = new ReplaceAbstractTypes();
		d.files.stream().forEach(eo -> replacer.doSwitch(eo));
		
		for(File f : d.files) {
			for(UserType ut : EcoreUtil2.getAllContentsOfType(f, UserType.class)) {
				if(replacer.map.containsKey(ut.getDef())) {
					ut.setDef(replacer.map.get(ut.getDef()));
				}
			}
		}
	}

	private Map<AbstractTypeDef,NamedTypeDef> map = new HashMap<>();
	
	public Integer caseAbstractTypeDef(AbstractTypeDef atd) {
		NamedTypeDef ntd = null;
		if(map.containsKey(atd)) {
			ntd = map.get(atd);
		} else {
			ntd = SpearFactory.eINSTANCE.createNamedTypeDef();
			ntd.setName(atd.getName());
			ntd.setType(SpearFactory.eINSTANCE.createIntType());
			map.put(atd, ntd);
		}
		EcoreUtil2.replace(atd, ntd);
		return 0;
	}
	
	public Integer defaultCase(EObject e) {
		e.eContents().stream().forEach(o -> this.doSwitch(o));
		e.eCrossReferences().stream().forEach(ref -> this.doSwitch(ref));
		return 0;
	}
}
