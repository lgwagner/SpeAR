package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AbstractTypeDef;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReplaceAbstractTypes extends SpearSwitch<Integer> {

	public static void transform(SpearDocument d) {
		ReplaceAbstractTypes replacer = new ReplaceAbstractTypes();
		for(Specification s : d.specifications) {
			replacer.doSwitch(s);
		}
		
		for(Pattern p : d.patterns) {
			replacer.doSwitch(p);
		}
	}
	
	public static void transofrm(PatternDocument d) {
		ReplaceAbstractTypes replacer = new ReplaceAbstractTypes();
		for(Pattern p : d.patterns) {
			replacer.doSwitch(p);
		}
	}
	
	public Integer caseAbstractTypeDef(AbstractTypeDef atd) {
		NamedTypeDef ntd = SpearFactory.eINSTANCE.createNamedTypeDef();
		ntd.setName(atd.getName());
		ntd.setType(SpearFactory.eINSTANCE.createIntType());
		EcoreUtil2.replace(atd, ntd);
		return 0;
	}
	
	public Integer defaultCase(EObject e) {
		for(EObject o : e.eContents()) {
			this.doSwitch(o);
		}
		
		for(EObject o : e.eCrossReferences()) {
			this.doSwitch(o);
		}
		return 0;
	}
}
