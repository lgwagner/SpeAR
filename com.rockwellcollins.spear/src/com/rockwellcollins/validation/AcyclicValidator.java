package com.rockwellcollins.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.Utilities;

public class AcyclicValidator extends SpearSwitch<Integer> {

	public static List<EObject> validate(EObject o) {
		AcyclicValidator validate = new AcyclicValidator();
		validate.defaultCase(o);
		return validate.dependencies;
	}

	public static String getMessage(EObject start, List<EObject> dependencies) {
		File root = Utilities.getRoot(start);
		Iterator<EObject> iterate = dependencies.iterator();
		StringBuilder builder = new StringBuilder();
		while(iterate.hasNext()) {
			EObject next = iterate.next();
			File currentRoot = Utilities.getRoot(next);
			if(currentRoot.equals(root)) {
				builder.append(Utilities.getName(next));
			} else {
				builder.append(Utilities.getFileBasedName(next));
			}
			
			if(iterate.hasNext()) {
				builder.append(" -> ");
			}
		}
		return builder.toString();
	}
	
	public List<EObject> dependencies = new ArrayList<>();
	public Set<EObject> visited = new HashSet<>();
	
	@Override
	public Integer casePreviousExpr(PreviousExpr pe) {
		return 0;
	}
	
	@Override
	public Integer caseTypeDef(TypeDef td) {
		if(!dependencies.contains(td)) {
			dependencies.add(td);
			this.defaultCase(td);				
		}
		return 0;
	}
	
	@Override
	public Integer caseIdRef(IdRef idr) {
		if(!dependencies.contains(idr)) {
			dependencies.add(idr);
			this.defaultCase(idr);			
		}
		return 0;
	}
	
	@Override
	public Integer casePattern(Pattern p) {
		if(!dependencies.contains(p)) {
			dependencies.add(p);
			this.defaultCase(p);
		}
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject o) {
		for(EObject sub : o.eContents()) {
			if(!visited.contains(sub)) {
				visited.add(sub);
				this.doSwitch(sub);	
			}
		}
		
		for(EObject ref : o.eCrossReferences()) {
			if(!visited.contains(ref)) {
				visited.add(ref);
				this.doSwitch(ref);				
			}
		}
		
		return 0;
	}
}
