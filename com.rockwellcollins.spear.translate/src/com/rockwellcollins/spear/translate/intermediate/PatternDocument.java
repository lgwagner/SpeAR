package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;

public class PatternDocument extends Document {

	public Map<String,Constant> constants = new HashMap<>();
	public Map<String,Pattern> patterns = new HashMap<>();
	
	public PatternDocument(Pattern main) {
		this.mainName = main.getName();
		for(EObject o : FindPatternDependencies.instance(main).getObjects()) {
			if (o instanceof Pattern) {
				Pattern p = (Pattern) o;
				patterns.put(p.getName(),p);
			}
			
			if (o instanceof TypeDef) {
				TypeDef td = (TypeDef) o;
				typedefs.put(td.getName(),td);
			}
			
			if (o instanceof Constant) {
				Constant c = (Constant) o;
				constants.put(c.getName(),c);
			}
		}
	}
	
	public void transform() {
		//transform the document
		try {
			this.renamed = PerformTransforms.apply(this);
		} catch (Exception e) {
			System.err.println("Error performing transformations.");
			e.printStackTrace();
			System.exit(-1);
		}		
	}
}
