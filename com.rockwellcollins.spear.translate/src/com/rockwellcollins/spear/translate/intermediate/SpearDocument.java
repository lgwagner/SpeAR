package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;

public class SpearDocument {

	public String mainName;
	public List<TypeDef> typedefs = new ArrayList<>();
	public List<Constant> constants = new ArrayList<>();
	public List<Pattern> patterns = new ArrayList<>();
	public List<Specification> specifications = new ArrayList<>();
	public List<Call> calls = new ArrayList<>();
	public Map<EObject,Map<String,String>> renamed;

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

		//transform the document
		try {
			this.renamed = PerformTransforms.apply(this);
		} catch (Exception e) {
			System.err.println("Error performing transformations.");
			e.printStackTrace();
			System.exit(-1);
		}
		
		Specification transformedMain = this.getMain();
		//compute the call info.
		computeCallInfo(transformedMain);
	}
	
	private void computeCallInfo(Specification s) {
		Call.reset();
		for(NormalizedCall nc : EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class)) {
			Call call = new Call(nc);
			calls.add(call);
		}
	}
}
