package com.rockwellcollins.spear.translate.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.actions.FindFileDependencies.Status;
import com.rockwellcollins.spear.util.SpearSwitch;

public class FindFileDependencies extends SpearSwitch<Status> {

	public static FindFileDependencies instance(Specification main) {
		FindFileDependencies findDeps = new FindFileDependencies();
		findDeps.set.add(main);
		findDeps.doSwitch(main);	
		return findDeps;
	}
	
	public static FindFileDependencies instance(File main) {
		FindFileDependencies findDeps = new FindFileDependencies();
		findDeps.set.add(main);
		findDeps.doSwitch(main);	
		return findDeps;
	}
	
	public static enum Status { DONE };
	private Set<File> set = new LinkedHashSet<>();
	
	public List<File> getCalledFiles() {
		List<File> files = new ArrayList<>(EcoreUtil2.copyAll(set));
		return files;
	}
	
	public Map<String,File> getMap() {
		Map<String,File> map = new HashMap<>();
		for(File f : this.set) {
			map.put(f.getName(), f);
		}
		return map;
	}
	
	@Override
	public Status caseFile(File f) {
		set.add(f);
		this.defaultCase(f);
		return Status.DONE;
	}
	
	@Override
	public Status defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			EObject root = EcoreUtil2.getRootContainer(ref);
			if(root instanceof File) {
				File f = (File) root;
				set.add(f);				
			}
			this.doSwitch(ref);	
		}
		return Status.DONE;
	}
}
