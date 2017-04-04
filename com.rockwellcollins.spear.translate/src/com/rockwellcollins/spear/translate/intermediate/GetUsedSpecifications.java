package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;

public class GetUsedSpecifications {

	public static Collection<Specification> get(Document d) {
		Collection<Specification> specs = new ArrayList<>();
		for(File f : d.files) {
			if (f instanceof Specification) {
				Specification s = (Specification) f;
				specs.add(s);
			}
		}
		return specs;
	}
}
