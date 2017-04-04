package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetUsedPatterns extends SpearSwitch<Integer> {

	public static Collection<Pattern> get(EObject main) {
		GetUsedPatterns get = new GetUsedPatterns();
		get.doSwitch(main);
		return get.set;
	}
	
	private Collection<Pattern> set = new HashSet<>();

	@Override
	public Integer casePattern(Pattern p) {
		set.add(p);
		this.defaultCase(p);
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject o) {
		o.eContents().stream().forEach(ob -> doSwitch(ob));
		o.eCrossReferences().stream().forEach(ob -> doSwitch(ob));
		return 0;
	}
}
