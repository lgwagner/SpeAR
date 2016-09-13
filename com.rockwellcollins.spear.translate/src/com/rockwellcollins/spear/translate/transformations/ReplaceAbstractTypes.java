package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AbstractTypeDef;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReplaceAbstractTypes extends SpearSwitch<EObject> {

	public static void transform(SpearDocument d) {
		ReplaceAbstractTypes replacer = new ReplaceAbstractTypes(d);
		for(TypeDef td : d.typedefs.values()) {
			replacer.doSwitch(td);
		}
	}
	
//	public static void transform(PatternDocument d) {
//		ReplaceAbstractTypes replacer = new ReplaceAbstractTypes();
//		for(TypeDef td : d.typedefs) {
//			replacer.doSwitch(td);
//		}		
//	}

	private SpearDocument document;
	
	public ReplaceAbstractTypes(SpearDocument d) {
		this.document=d;
	}
	
	public EObject caseAbstractTypeDef(AbstractTypeDef atd) {
		NamedTypeDef ntd = SpearFactory.eINSTANCE.createNamedTypeDef();
		ntd.setName(atd.getName());
		ntd.setType(SpearFactory.eINSTANCE.createIntType());
		EcoreUtil2.replace(atd, ntd);
		document.typedefs.put(ntd.getName(), ntd);
		return ntd;
	}
	
	public EObject defaultCase(EObject e) {
		for(EObject o : e.eContents()) {
			this.doSwitch(o);
		}
		
		for(EObject o : e.eCrossReferences()) {
			this.doSwitch(o);
		}
		return e;
	}
}
