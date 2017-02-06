package com.rockwellcollins.spear.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ExprReplacement extends SpearSwitch<Integer> {
	
	public static Expr replace(IdRef ref, PredicateSubTypeDef pstd) {
		ExprReplacement replace = new ExprReplacement(ref,pstd);
		replace.crunch();
		return replace.replacement;
	}
	
	private IdRef original;
	private Variable predVar;
		private Expr replacement;
	
	private ExprReplacement(IdRef ref, PredicateSubTypeDef pstd) {
		this.original = ref;
		this.predVar = pstd.getPredVar();
		this.replacement = EcoreUtil2.copy(pstd.getPredExpr());
	}
	
	public void crunch() {
		doSwitch(this.replacement);
	}
	
	@Override
	public Integer caseIdExpr(IdExpr ide) {
		if(ide.getId().equals(predVar)) {
			ide.setId(original);
		}
		return 0;
	}
	
	public Integer defaultCase(EObject e) {
		e.eContents().stream().forEach(o -> this.doSwitch(o));
		e.eCrossReferences().stream().forEach(ref -> this.doSwitch(ref));
		return 0;
	}
}
