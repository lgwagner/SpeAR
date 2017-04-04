package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetUsedConstants extends SpearSwitch<Integer> {

	public static Collection<Constant> get(EObject main) {
		GetUsedConstants get = new GetUsedConstants();
		get.doSwitch(main);
		return get.set;
	}
	
	private Collection<Constant> set = new HashSet<>();

	@Override
	public Integer caseConstant(Constant c) {
		set.add(c);
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
