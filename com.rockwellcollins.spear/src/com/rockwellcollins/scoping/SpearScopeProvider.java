/*
 * generated by Xtext
 */
package com.rockwellcollins.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.RecordUpdateExpr;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class SpearScopeProvider extends org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider {

	IScope scope_RecordAccessExpr_field(RecordAccessExpr e, EReference reference) {
		return getRecordScope(e.getRecord());
	}

	IScope scope_RecordUpdateExpr_field(RecordUpdateExpr e, EReference reference) {
		return getRecordScope(e.getRecord());
	}

	private IScope getRecordScope(Expr expr) {
		RecordTypeDef record = CompositeTypeLookup.getRecordType(expr);
		if (record != null) {
			return Scopes.scopeFor(record.getFields());
		} else {
			return IScope.NULLSCOPE;
		}
	}
}
