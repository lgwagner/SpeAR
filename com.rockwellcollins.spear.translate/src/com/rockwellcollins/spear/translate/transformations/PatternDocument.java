package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.actions.FindPatternDependencies;

public class PatternDocument {

	public String mainName;
	public List<Pattern> patterns = new ArrayList<>();
	public List<TypeDef> typedefs = new ArrayList<>();
	public List<Constant> constants = new ArrayList<>();
	
	public PatternDocument(Pattern main) {
		this.mainName = main.getName();
		for(EObject o : FindPatternDependencies.instance(main).getObjects()) {
			if (o instanceof Pattern) {
				Pattern p = (Pattern) o;
				patterns.add(p);
			}
			
			if (o instanceof TypeDef) {
				TypeDef td = (TypeDef) o;
				typedefs.add(td);
			}
			
			if (o instanceof Constant) {
				Constant c = (Constant) o;
				constants.add(c);
			}
		}
	}
}
