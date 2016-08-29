package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.actions.FindSpecificationDependencies;

public class SpearDocument {

	public String mainName;
	public List<TypeDef> typedefs = new ArrayList<>();
	public List<Constant> constants = new ArrayList<>();
	public List<Pattern> patterns = new ArrayList<>();
	public List<Specification> specifications = new ArrayList<>();

	public SpearDocument(Specification main) {
		this.mainName = main.getName();
		List<EObject> objects = FindSpecificationDependencies.getDependencies(main);
		for(EObject o : objects) {
			if (o instanceof TypeDef) {
				TypeDef typedef = (TypeDef) o;
				typedefs.add(typedef);
			}
			
			if (o instanceof Constant) {
				Constant constant = (Constant) o;
				constants.add(constant);
			}
			
			if (o instanceof Pattern) {
				Pattern pattern = (Pattern) o;
				patterns.add(pattern);
			}
			
			if (o instanceof Specification) {
				Specification spec = (Specification) o;
				specifications.add(spec);
			}
		}
	}	
}
