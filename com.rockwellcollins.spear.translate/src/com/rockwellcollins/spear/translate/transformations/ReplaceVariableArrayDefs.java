package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.ConcreteArrayTypeDef;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.intermediate.PatternDocument;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.IntConstantFinder;


public class ReplaceVariableArrayDefs extends SpearSwitch<EObject> {

	public static void transform(SpearDocument d) {
		ReplaceVariableArrayDefs replacer = new ReplaceVariableArrayDefs(d);
		for(TypeDef td : d.typedefs.values()) {
			replacer.doSwitch(td);
		}
	}
	
	public static void transform(PatternDocument d) {
		ReplaceVariableArrayDefs replacer = new ReplaceVariableArrayDefs(d);
		for(TypeDef td : d.typedefs.values()) {
			replacer.doSwitch(td);
		}		
	}

	private Document document;
	
	public ReplaceVariableArrayDefs(Document d) {
		this.document=d;
	}
	
	public EObject caseArrayTypeDef(ArrayTypeDef atd) {
		Integer size = IntConstantFinder.fetch(atd);
		ConcreteArrayTypeDef ctd = SpearFactory.eINSTANCE.createConcreteArrayTypeDef();
		ctd.setName(atd.getName());
		ctd.setBase(EcoreUtil2.copy(atd.getBase()));
		ctd.setSize(size);
		EcoreUtil2.replace(atd, ctd);
		document.typedefs.put(ctd.getName(), ctd);
		return ctd;
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
