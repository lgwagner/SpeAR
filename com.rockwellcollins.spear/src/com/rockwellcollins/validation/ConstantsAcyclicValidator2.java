package com.rockwellcollins.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.Utilities;

public class ConstantsAcyclicValidator2 extends SpearSwitch<Integer> {

	public static List<EObject> validate(Constant c) {
		ConstantsAcyclicValidator2 valid8 = new ConstantsAcyclicValidator2();
		valid8.doSwitch(c.getExpr());
		return valid8.dependencies;
	}
	
	public static String getMessage(Constant start, List<EObject> dependencies) {
		File root = Utilities.getRoot(start);
		Iterator<EObject> iter8 = dependencies.iterator();
		StringBuilder builder = new StringBuilder();
		while(iter8.hasNext()) {
			EObject next = iter8.next();
			File currentRoot = Utilities.getRoot(next);
			if(currentRoot.equals(root)) {
				builder.append(Utilities.getName(next));
			} else {
				builder.append(Utilities.getFileBasedName(next));
			}
			
			if(iter8.hasNext()) {
				builder.append(" -> ");
			}
		}
		return builder.toString();
	}
	
	public List<EObject> dependencies = new ArrayList<>();
	
	@Override
	public Integer caseIdRef(IdRef idr) {
		if(!dependencies.contains(idr)) {
			dependencies.add(idr);
			this.defaultCase(idr);			
		}
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject o) {
		for(EObject sub : o.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : o.eCrossReferences()) {
			this.doSwitch(ref);
		}
		
		return 0;
	}
}
