package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class FindTypeDependencies extends SpearSwitch<Integer> {

	public static List<EObject> instance(TypeDef td) {
		FindTypeDependencies findDeps = new FindTypeDependencies();
		findDeps.set.add(td);
		findDeps.doSwitch(td);	
		return findDeps.getObjects();
	}
	
	private Set<EObject> set = new HashSet<>();
	private Set<EObject> traversed = new HashSet<>();
	
	public List<EObject> getObjects() {
		List<EObject> objects = new ArrayList<>(EcoreUtil2.copyAll(set));
		return objects;
	}
	
	@Override
	public Integer caseConstant(Constant c) {
		set.add(c);
		this.defaultCase(c);
		return 0;
	}
	
	@Override
	public Integer caseTypeDef(TypeDef td) {
		set.add(td);
		this.defaultCase(td);
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject e) {
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
		return 0;
	}
}
