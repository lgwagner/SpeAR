package com.rockwellcollins.spear.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetAllIdRefs extends SpearSwitch<Integer> {

	public static List<IdRef> getReferences(Expr e) {
		GetAllIdRefs finder = new GetAllIdRefs();
		finder.doSwitch(e);
		return finder.list;
	}

	private List<IdRef> list = new ArrayList<>();

	@Override
	public Integer defaultCase(EObject o) {
		o.eContents().stream().forEach(sub -> this.doSwitch(sub));
		for (EObject ref : o.eCrossReferences()) {
			if (ref instanceof IdRef) {
				IdRef idr = (IdRef) ref;
				list.add(idr);
			}
		}
		return 0;
	}
}