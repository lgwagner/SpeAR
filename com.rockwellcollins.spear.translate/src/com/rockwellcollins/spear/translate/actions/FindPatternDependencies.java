package com.rockwellcollins.spear.translate.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.actions.FindPatternDependencies.Status;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.Utilities;

public class FindPatternDependencies extends SpearSwitch<Status> {

	public static FindPatternDependencies instance(Pattern main) {
		FindPatternDependencies findDeps = new FindPatternDependencies();
		findDeps.map.add(main);
		findDeps.doSwitch(main);	
		return findDeps;
	}
	
	public static enum Status { DONE };
	private Map<EObject,File> map = new HashMap<>();
	
	public List<EObject> getObjects() {
		List<EObject> objects = new ArrayList<>(EcoreUtil2.copyAll(map));
		return objects;
	}
	
	@Override
	public Status caseTypeDef(TypeDef td) {
		map.put(td,Utilities.getRoot(td));
		this.defaultCase(td);
		return Status.DONE;
	}
	
	@Override
	public Status caseConstant(Constant c) {
		map.put(c,Utilities.getRoot(c));
		this.defaultCase(c);
		return Status.DONE;
	}
	
	@Override
	public Status casePattern(Pattern p) {
		map.add(p,Utilities.getRoot(p));
		this.defaultCase(p);
		return Status.DONE;
	}
	
	@Override
	public Status defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			this.doSwitch(ref);	
		}
		return Status.DONE;
	}
}
