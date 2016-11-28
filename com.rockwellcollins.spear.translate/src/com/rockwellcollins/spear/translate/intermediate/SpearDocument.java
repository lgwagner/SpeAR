package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;

public class SpearDocument extends Document {

	public Map<String,Specification> specifications = new HashMap<>();

	public Specification getMain() {
		return specifications.get(this.mainName);
	}
	
	public SpearDocument(Specification main) {
		this.mainName = main.getName();
		List<EObject> objects = FindSpecificationDependencies.getDependencies(main);
		for(EObject o : objects) {
			if (o instanceof TypeDef) {
				TypeDef typedef = (TypeDef) o;
				typedefs.put(typedef.getName(),typedef);
			}
			
			if (o instanceof Constant) {
				Constant constant = (Constant) o;
				constants.put(constant.getName(),constant);
			}
			
			if (o instanceof Pattern) {
				Pattern pattern = (Pattern) o;
				patterns.put(pattern.getName(),pattern);
			}
			
			if (o instanceof Specification) {
				Specification spec = (Specification) o;
				specifications.put(spec.getName(),spec);
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
