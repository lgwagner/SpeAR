package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetUsedTypeDefs extends SpearSwitch<Integer> {

	public static Collection<TypeDef> get(EObject main) {
		GetUsedTypeDefs get = new GetUsedTypeDefs();
		get.doSwitch(main);
		return get.set;
	}
	
	private Collection<TypeDef> set = new HashSet<>();

	@Override
	public Integer caseTypeDef(TypeDef td) {
		set.add(td);
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
