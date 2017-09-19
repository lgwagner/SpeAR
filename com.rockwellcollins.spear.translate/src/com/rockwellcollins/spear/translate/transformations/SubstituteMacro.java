package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.util.SpearSwitch;

public class SubstituteMacro extends SpearSwitch<Integer> {

	public static void substitute(Expr e) {
		SubstituteMacro subs = new SubstituteMacro();
		subs.doSwitch(e);
	}

	@Override
	public Integer caseIdExpr(IdExpr ide) {
		if (ide.getId() instanceof Macro) {
			Macro macro = (Macro) ide.getId();
			if(macro.getInline() != null) {
				Expr copy = EcoreUtil2.copy(macro.getExpr());
				doSwitch(copy);
				EcoreUtil2.replace(ide, copy);
			}
		}
		return 0;
	}
	
	@Override
	public Integer defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject sub : e.eCrossReferences()) {
			this.doSwitch(sub);
		}
		
		return 0;
	}
}
