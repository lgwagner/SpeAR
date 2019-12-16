package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetUsedPatterns extends SpearSwitch<Integer> {

	public static Collection<Pattern> get(EObject main) {
		GetUsedPatterns get = new GetUsedPatterns();
		if (main instanceof Pattern) {
			Pattern p = (Pattern) main;
			get.map.put(p.getName(), p);
		}
		get.doSwitch(main);
		return get.map.values();
	}

	// have to use a map to avoid dupes
	private Map<String, Pattern> map = new HashMap<>();
	private Set<EObject> traversed = new HashSet<>();

	@Override
	public Integer doSwitch(EObject o) {
		if (!traversed.contains(o)) {
			traversed.add(o);
			super.doSwitch(o);
		}
		return 0;
	}

	@Override
	public Integer casePatternCall(PatternCall pc) {
		map.put(pc.getPattern().getName(), pc.getPattern());
		this.defaultCase(pc);
		return 0;
	}

	@Override
	public Integer defaultCase(EObject o) {
		o.eContents().stream().forEach(ob -> doSwitch(ob));
		o.eCrossReferences().stream().forEach(ob -> doSwitch(ob));
		return 0;
	}
}
