package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.language.CreateExpr;
import com.rockwellcollins.spear.translate.intermediate.SpearDocument;
import com.rockwellcollins.spear.util.SpearSwitch;

public class PropagatePredicates {

	public static void transform(SpearDocument d) {
		PropagatePredicates propagate = new PropagatePredicates(d);
		propagate.propagate(d);
	}
	
	private Map<String,TypeDef> typedefs = new HashMap<>();
	private List<FormalConstraint> assumptions;
	private List<FormalConstraint> properties;
	
	public PropagatePredicates(SpearDocument d) {
		typedefs = new HashMap<>(d.typedefs);
	}

	private boolean isPredSubType(Type t) {
		if (t instanceof UserType) {
			UserType userType = (UserType) t;
			if(userType.getDef() instanceof PredicateSubTypeDef) {
				return true;
			}
		}
		return false;
	}
	
	private void propagate(SpearDocument d) {
		d.specifications.values().stream().forEach(s -> propagate(s));
	}
	
	private void propagate(Specification s) {
		assumptions = new ArrayList<>();
		properties = new ArrayList<>();
		for(Variable v : s.getInputs()) {
			if(isPredSubType(v.getType())) {
				assumptions.add(getFormalConstraint(v));
			}
		}
		
		for(Variable v : s.getOutputs()) {
			if(isPredSubType(v.getType())) {
				properties.add(getFormalConstraint(v));
			}			
		}
		
		for(Variable v : s.getState()) {
			if(isPredSubType(v.getType())) {
				properties.add(getFormalConstraint(v));
			}			
		}
		
		for(Macro m : s.getMacros()) {
			if(isPredSubType(m.getType())) {
				properties.add(getFormalConstraint(m));
			}
		}
		
		s.getAssumptions().addAll(assumptions);
		s.getBehaviors().addAll(properties);
	}
	
	private FormalConstraint getFormalConstraint(Variable v) {
		UserType ut = (UserType) v.getType();
		PredicateSubTypeDef pstd = (PredicateSubTypeDef) typedefs.get(ut.getDef().getName());
		String name = v.getName() + "_satisfies_predicate";
		return CreateExpr.createFormalConstraint(name, ExprReplacement.replace(v, pstd));
	}
	
	private FormalConstraint getFormalConstraint(Macro m) {
		UserType ut = (UserType) m.getType();
		PredicateSubTypeDef pstd = (PredicateSubTypeDef) typedefs.get(ut.getDef().getName());
		String name = m.getName() + "_satisfies_predicate";
		return CreateExpr.createFormalConstraint(name, ExprReplacement.replace(m, pstd));
	}

	public static class ExprReplacement extends SpearSwitch<Integer> {
		
		public static Expr replace(IdRef idref, PredicateSubTypeDef pstd) {
			ExprReplacement replace = new ExprReplacement(idref,pstd);
			replace.crunch();
			return replace.replacement;
		}
		
		private IdRef ref;
		private Variable predVar;
		
		private Expr replacement;
		
		private ExprReplacement(IdRef ref, PredicateSubTypeDef pstd) {
			this.ref = ref;
			this.predVar = pstd.getPredVar();
			this.replacement = EcoreUtil2.copy(pstd.getPredExpr());
		}
		
		public void crunch() {
			doSwitch(this.replacement);
		}
		
		@Override
		public Integer caseIdExpr(IdExpr ide) {
			if(ide.getId().equals(predVar)) {
				ide.setId(ref);
			}
			return 0;
		}
		
		public Integer defaultCase(EObject e) {
			e.eContents().stream().forEach(o -> this.doSwitch(o));
			e.eCrossReferences().stream().forEach(ref -> this.doSwitch(ref));
			return 0;
		}
	}
	
}
