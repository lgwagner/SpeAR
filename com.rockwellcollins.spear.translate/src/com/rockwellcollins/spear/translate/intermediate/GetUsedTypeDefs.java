package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetUsedTypeDefs extends SpearSwitch<Integer> {

	public static Collection<TypeDef> get(EObject main) {
		GetUsedTypeDefs get = new GetUsedTypeDefs();
		get.doSwitch(main);
		return get.map.values();
	}
	
	private Map<String,TypeDef> map = new HashMap<>();
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
	public Integer caseTypeDef(TypeDef td) {
		map.put(td.getName(),td);
		this.defaultCase(td);
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject o) {
		o.eContents().stream().forEach(ob -> doSwitch(ob));
		o.eCrossReferences().stream().forEach(ob -> doSwitch(ob));
		return 0;
	}
}
