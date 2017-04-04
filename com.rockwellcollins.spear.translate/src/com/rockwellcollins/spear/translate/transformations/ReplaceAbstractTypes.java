package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AbstractTypeDef;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReplaceAbstractTypes extends SpearSwitch<Integer> {

	public static void transform(Document d) {
		ReplaceAbstractTypes replacer = new ReplaceAbstractTypes();
		d.files.stream().forEach(eo -> replacer.doSwitch(eo));
	}

	public Integer caseAbstractTypeDef(AbstractTypeDef atd) {
		NamedTypeDef ntd = SpearFactory.eINSTANCE.createNamedTypeDef();
		ntd.setName(atd.getName());
		ntd.setType(SpearFactory.eINSTANCE.createIntType());
		EcoreUtil2.replace(atd, ntd);
		return 0;
	}
	
	public Integer defaultCase(EObject e) {
		e.eContents().stream().forEach(o -> this.doSwitch(o));
		e.eCrossReferences().stream().forEach(ref -> this.doSwitch(ref));
		return 0;
	}
}
