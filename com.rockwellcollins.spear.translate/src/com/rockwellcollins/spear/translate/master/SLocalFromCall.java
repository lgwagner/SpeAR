//package com.rockwellcollins.spear.translate.master;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.rockwellcollins.spear.File;
//import com.rockwellcollins.spear.NormalizedCall;
//import com.rockwellcollins.spear.Specification;
//import com.rockwellcollins.spear.Type;
//import com.rockwellcollins.spear.Variable;
//import com.rockwellcollins.spear.translate.lustre.TranslateType;
//import com.rockwellcollins.spear.translate.naming.NameMap;
//import com.rockwellcollins.spear.utilities.Utilities;
//
//import jkind.lustre.IdExpr;
//import jkind.lustre.VarDecl;
//
//public class SLocalFromCall {
//
//	public static List<VarDecl> getVarDecls(List<SLocalFromCall> locals, PNameMap map) {
//		List<VarDecl> list = new ArrayList<>();
//		for(SLocalFromCall local : locals) {
//			list.add(local.getVarDecl(map));
//		}
//		return list;
//	}
//	
//	public static List<IdExpr> getArgIds(List<SLocalFromCall> locals, PNameMap map) {
//		List<IdExpr> names = new ArrayList<>();
//		for(SLocalFromCall local : locals) {
//			names.add(local.getName());
//		}
//		return names;
//	}
//	
//	public String name;
//	public Type type;
//	public Specification caller;
//	public Specification called;
//	
//	public SLocalFromCall(NormalizedCall call, SCall scall, Variable v, PNameMap map) { 
//		this.caller=(Specification) Utilities.getRoot(call);
//		this.called=(Specification) Utilities.getRoot(v);
//		String proposed = caller.getName() + "_calls_" + called.getName() + "_" + v.getName() + "_" + scall.localKey;
//		File root = Utilities.getRoot(call);
//		this.name=map.getName(root, proposed);
//		this.type=v.getType();
//
//	}
//	
//	public VarDecl getVarDecl(NameMap map) {
//		return new VarDecl(name,TranslateType.translate(this.type, map));
//	}
//	
//	public IdExpr getName() {
//		return new IdExpr(name);
//	}
//}
//
