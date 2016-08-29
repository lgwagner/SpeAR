package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;

public class SpearDocument {

	public String mainName;
	public List<TypeDef> typedefs = new ArrayList<>();
	public List<Constant> constants = new ArrayList<>();
	public List<Pattern> patterns = new ArrayList<>();
	public List<Specification> specifications = new ArrayList<>();

	public Specification getMain() {
		for(Specification s : specifications) {
			if(s.getName().equals(mainName)) {
				return s;
			}
		}
		return null;
	}
	
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
