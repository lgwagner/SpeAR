package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.translate.master.SCall;
import com.rockwellcollins.spear.translate.master.SSpecification;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Expr;
import jkind.lustre.NodeCallExpr;

public class TranslateCallExpr extends SpearSwitch<Expr> {

	public static Expr translate(EObject e, SSpecification spec) {
		return new TranslateCallExpr(spec).doSwitch(e);
	}
	
	private SSpecification specification;

	public TranslateCallExpr(SSpecification s) {
		this.specification=s;
	}
	
	@Override
	public Expr caseNormalizedCall(com.rockwellcollins.spear.NormalizedCall call) {
		List<Expr> args = new ArrayList<>();
		for(com.rockwellcollins.spear.Expr e : call.getArgs()) {
			args.add(this.doSwitch(e));
		}
		
		for(IdRef idr : call.getIds()) {
			args.add(this.doSwitch(idr));
		}

		String nodeName = specification.map.lookupOriginal(call.getSpec().getName());
		SCall scall = SCall.get(call,specification.calls);
		args.addAll(scall.getCallArgs());
		return new NodeCallExpr(nodeName,args);
	}
	
	@Override
	public Expr defaultCase(EObject o) {
		return TranslateExpr.translate(o, specification.map);
	}
}
