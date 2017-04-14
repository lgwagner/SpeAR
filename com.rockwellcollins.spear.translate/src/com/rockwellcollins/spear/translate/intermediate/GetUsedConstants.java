package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetUsedConstants extends SpearSwitch<Integer> {

	public static Collection<Constant> get(EObject main) {
		GetUsedConstants get = new GetUsedConstants();
		get.doSwitch(main);
		return get.map.values();
	}
	
	private Map<String,Constant> map = new HashMap<>();
	private Set<EObject> traversed = new HashSet<>();

	@Override
	public Integer doSwitch(EObject o) {
		if(!traversed.contains(o)) {
			traversed.add(o);
			super.doSwitch(o);
		}
		return 0;
	}
	
	@Override
	public Integer caseConstant(Constant c) {
		map.put(c.getName(),c);
		this.defaultCase(c);
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject o) {
		o.eContents().stream().forEach(ob -> doSwitch(ob));
		o.eCrossReferences().stream().forEach(ob -> doSwitch(ob));
		return 0;
	}
}
