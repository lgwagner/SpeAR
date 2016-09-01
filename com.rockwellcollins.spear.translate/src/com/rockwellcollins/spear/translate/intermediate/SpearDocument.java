package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.HashMap;
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
	public Map<String,Map<Integer,SpearCall>> calls = new HashMap<>();
	
	public Map<EObject,Map<String,String>> renamed;

	public Specification getMain() {
		for(Specification s : specifications) {
			if(s.getName().equals(mainName)) {
				return s;
			}
		}
		return null;
	}
	
	private void insert(String specName, SpearCall call) {
		Map<Integer,SpearCall> temp = new HashMap<>();
		if(calls.containsKey(specName)) {
			temp.putAll(calls.get(specName));
		}
		Integer key = calls.keySet().size();
		temp.put(key, call);
		calls.put(specName, temp);
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
		
		try {
			this.renamed = PerformTransforms.apply(this);
			this.computeCallInfo();
		} catch (Exception e) {
			System.err.println("Error performing transformations.");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void computeCallInfo() {
		for(Specification s : specifications) {
			List<NormalizedCall> normalizedCalls = EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class);
			for(NormalizedCall ncall : normalizedCalls) {
				insert(s.getName(),new SpearCall(ncall));
			}
		}
	}
}
