//package com.rockwellcollins.spear.translate.naming;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.eclipse.emf.ecore.EObject;
//
//import com.rockwellcollins.spear.File;
//import com.rockwellcollins.spear.NormalizedCall;
//import com.rockwellcollins.spear.Pattern;
//import com.rockwellcollins.spear.Variable;
//import com.rockwellcollins.spear.translate.master.SCall;
//import com.rockwellcollins.spear.translate.master.SFile;
//import com.rockwellcollins.spear.translate.master.SPattern;
//import com.rockwellcollins.spear.utilities.Utilities;
//
//public class NameMap {
//
//	public Map<File,FileMap> fileMap = new LinkedHashMap<>();
//	public Map<Pattern,PatternMap> patternMap = new LinkedHashMap<>();
//	
//	public Map<File,SFile> fileMapping = new LinkedHashMap<>();
//	public Map<Pattern,SPattern> patternMapping = new LinkedHashMap<>();
//	public Map<NormalizedCall,SCall> callMapping = new LinkedHashMap<>();
//	
//	public void addFile(File file, SFile sfile) {
//		fileMapping.put(file, sfile);
//		fileMap.put(file, new FileMap(file));
//	}
//	
//	public void addPattern(Pattern pattern, SPattern spattern) {
//		patternMapping.put(pattern, spattern);
//		patternMap.put(pattern,new PatternMap());
//	}
//	
//	public void addCall(NormalizedCall call, SCall scall) {
//		callMapping.put(call, scall);
//	}
//	
//	/* these three methods are used for getting unique names*/
//	public String getDefinitionsName(EObject o) {
//		File root = Utilities.getRoot(o);
//		FileMap fm = fileMap.get(root);
//		String renamed = fm.getDefinitionsName(o);
//		fileMap.put(root,fm);
//		return renamed;
//	}
//	
//	public String getShadowName(Variable v) {
//		File root = Utilities.getRoot(v);
//		FileMap fm = fileMap.get(root);
//		String renamed = fm.getShadowName(v);
//		fileMap.put(root, fm);
//		return renamed;
//	}
//	
//	public String getName(EObject o) {
//		File root = Utilities.getRoot(o);
//		FileMap fm = fileMap.get(root);
//		String renamed = fm.getName(o);
//		fileMap.put(root, fm);
//		return renamed;
//	}
//	
//	public String getName(File f, String name) {
//		FileMap fm = fileMap.get(f);
//		String renamed = fm.getName(name);
//		fileMap.put(f, fm);
//		return renamed;
//	}
//	
//	public String getName(Pattern p, String name) {
//		PatternMap pm = patternMap.get(p);
//		String renamed = pm.getName(name);
//		patternMap.put(p, pm);
//		return renamed;
//	}
//	
//	public String getFileBasedName(EObject o) {
//		File root = Utilities.getRoot(o);
//		FileMap fm = fileMap.get(root);
//		String renamed = fm.getFileBasedName(o);
//		fileMap.put(root, fm);
//		return renamed;
//	}
//	
//	/* this method is used for looking up names */
//	public String lookup(EObject o) {
//		File root = Utilities.getRoot(o);
//		FileMap fm = fileMap.get(root);
//		return fm.lookup(o);
//	}
//	
//	public String lookup(File f, String string) {
//		FileMap fm = fileMap.get(f);
//		return fm.lookup(string);
//	}
//	
//	public String lookup(Pattern p, String string) {
//		PatternMap pm = patternMap.get(p);
//		return pm.lookup(string);
//	}
//}
