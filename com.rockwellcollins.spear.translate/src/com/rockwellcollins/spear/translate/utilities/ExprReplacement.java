package com.rockwellcollins.spear.translate.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.PredicateSubTypeDef;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.references.Reference;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ExprReplacement extends SpearSwitch<Integer> {
	
	public static Expr replace(Reference ref, PredicateSubTypeDef pstd) {
		ExprReplacement replace = new ExprReplacement(ref,pstd);
		replace.crunch();
		return replace.replacement;
	}
	
	private Reference original;
	private Variable predVar;
	private Expr replacement;
	
	private ExprReplacement(Reference ref, PredicateSubTypeDef pstd) {
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
			EcoreUtil2.replace(ide, original.toExpr());
		}
		return 0;
	}
	
	public Integer defaultCase(EObject e) {
		e.eContents().stream().forEach(o -> this.doSwitch(o));
		e.eCrossReferences().stream().forEach(ref -> this.doSwitch(ref));
		return 0;
	}
}
