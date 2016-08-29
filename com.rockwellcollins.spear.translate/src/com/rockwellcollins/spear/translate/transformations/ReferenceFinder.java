//package com.rockwellcollins.spear.translate.transformations;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.eclipse.emf.ecore.EObject;
//
//import com.rockwellcollins.spear.Constant;
//import com.rockwellcollins.spear.Pattern;
//import com.rockwellcollins.spear.Specification;
//import com.rockwellcollins.spear.TypeDef;
//import com.rockwellcollins.spear.util.SpearSwitch;
//
//public class ReferenceFinder extends SpearSwitch<Void> {
//
//	public static ReferenceFinder get(Specification s) {
//		ReferenceFinder refs = new ReferenceFinder();
//		refs.doSwitch(s);
//		return refs;
//	}
//
//	public Specification root = null;
//	
//	public Map<Specification,Set<EObject>> references = new HashMap<>();
//	
//	public List<TypeDef> getSpecificationTypeDefs(Specification s) {
//		List<TypeDef> typedefs = new ArrayList<>();
//		if(references.containsKey(s)) {
//			Set<EObject> list = references.get(s);
//			for(EObject o : list) {
//				if (o instanceof TypeDef) {
//					TypeDef td = (TypeDef) o;
//					typedefs.add(td);
//				}
//			}
//		}
//		return typedefs;
//	}
//	
//	public List<Constant> getSpecificationConstants(Specification s) {
//		List<Constant> constants = new ArrayList<>();
//		if(references.containsKey(s)) {
//			Set<EObject> list = references.get(s);
//			for(EObject o : list) {
//				if (o instanceof Constant) {
//					Constant c = (Constant) o;
//					constants.add(c);
//				}
//			}
//		}
//		return constants;
//	}
//	
//	public List<Pattern> getSpecificationPatterns(Specification s) {
//		List<Pattern> patterns = new ArrayList<>();
//		for(EObject o : references.get(s)) {
//			if (o instanceof Pattern) {
//				Pattern pattern = (Pattern) o;
//				patterns.add(pattern);
//			}
//		}
//		return patterns;
//	}
//	
//	private void insert(Specification s, EObject o) {
//		Set<EObject> set;
//		if(references.containsKey(s)) {
//			set = references.get(s);
//		} else {
//			set = new HashSet<>();
//		}
//		set.add(o);
//		references.put(s, set);
//	}
//	
//	@Override
//	public Void caseTypeDef(TypeDef td) {
//		insert(root,td);
//		return null;
//	}
//	
//	@Override
//	public Void caseConstant(Constant c) {
//		insert(root,c);
//		return null;
//	}
//	
//	@Override
//	public Void casePattern(Pattern p) {
//		insert(root,p);
//		return null;
//	}
//	
//	@Override
//	public Void caseSpecification(Specification s) {
//		Specification previous = this.root;
//		this.root = s;
//		this.defaultCase(s);
//		this.root = previous;
//		return null;
//	}
//	
//	@Override
//	public Void defaultCase(EObject e) {
//		for(EObject sub : e.eContents()) {
//			this.doSwitch(sub);
//			this.defaultCase(sub);
//		}
//		
//		for(EObject ref : e.eCrossReferences()) {
//			this.doSwitch(ref);
//			this.defaultCase(ref);
//		}
//		return null;
//	}
//}
