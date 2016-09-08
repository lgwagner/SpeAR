package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.intermediate.FindPatternDependencies.Status;
import com.rockwellcollins.spear.util.SpearSwitch;

public class FindPatternDependencies extends SpearSwitch<Status> {

	public static FindPatternDependencies instance(Pattern main) {
		FindPatternDependencies findDeps = new FindPatternDependencies();
		findDeps.set.add(main);
		findDeps.doSwitch(main);	
		return findDeps;
	}
	
	public static enum Status { DONE };
	private Set<EObject> set = new HashSet<>();
	private Set<EObject> traversed = new HashSet<>();
	
	public List<EObject> getObjects() {
		List<EObject> objects = new ArrayList<>(EcoreUtil2.copyAll(set));
		return objects;
	}
	
	@Override
	public Status caseTypeDef(TypeDef td) {
		set.add(td);
		this.defaultCase(td);
		return Status.DONE;
	}
	
	@Override
	public Status caseConstant(Constant c) {
		set.add(c);
		this.defaultCase(c);
		return Status.DONE;
	}
	
	@Override
	public Status casePattern(Pattern p) {
		set.add(p);
		this.defaultCase(p);
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
