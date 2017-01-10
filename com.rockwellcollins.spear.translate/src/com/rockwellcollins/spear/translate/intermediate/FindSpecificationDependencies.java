package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.intermediate.FindSpecificationDependencies.Status;
import com.rockwellcollins.spear.util.SpearSwitch;

public class FindSpecificationDependencies extends SpearSwitch<Status> {

	public static List<EObject> getDependencies(Specification main) {
		FindSpecificationDependencies find = new FindSpecificationDependencies();
		find.set.add(main);
		find.doSwitch(main);
		return find.getCalledFiles();
	}
	
	public static enum Status { DONE };
	private Set<EObject> set = new LinkedHashSet<>();
	private Set<EObject> traversed = new LinkedHashSet<>();
	
	public List<EObject> getCalledFiles() {
		List<EObject> objects = new ArrayList<>(EcoreUtil2.copyAll(set));
		return objects;
	}
	
	@Override
	public Status caseTypeDef(TypeDef td) {
		set.add(EcoreUtil2.copy(td));
		this.defaultCase(td);
		return Status.DONE;
	}
	
	@Override
	public Status caseConstant(Constant c) {
		set.add(EcoreUtil2.copy(c));
		this.defaultCase(c);
		return Status.DONE;
	}
	
	@Override
	public Status casePattern(Pattern p) {
		set.add(EcoreUtil2.copy(p));
		this.defaultCase(p);
		return Status.DONE;
	}
	
	@Override
	public Status caseSpecification(Specification s) {
		set.add(s);
		this.defaultCase(s);
		return Status.DONE;
	}
	
	@Override
	public Status defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			if(!traversed.contains(sub)) {
				traversed.add(sub);
				this.doSwitch(sub);
			}
							
		}
		
		for(EObject ref : e.eCrossReferences()) {
			if(!traversed.contains(ref)) {
				traversed.add(ref);
				this.doSwitch(ref);
			}
		}
		return Status.DONE;
	}
}
