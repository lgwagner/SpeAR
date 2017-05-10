package com.rockwellcollins.spear.translate.intermediate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.preferences.PreferenceConstants;
import com.rockwellcollins.spear.preferences.Preferences;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.master.SProgram;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.api.results.MapRenaming;
import jkind.api.results.MapRenaming.Mode;
import jkind.api.results.Renaming;
import jkind.lustre.Program;

public class Document {

	public EObject main;
	public Collection<File> files = new HashSet<>();
	public Map<EObject,Map<String,String>> renamed = new HashMap<>();
	private Specification spec;
	
	private SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
	
	public Document(Specification f) {
	  this(f,true);
	}
	
	public Document(Specification f, boolean flag) {
	  spec = f;
	  Collection<File> deps = FindDependencies.get(f);

	  //fixme
	  Map<String,File> filemap = new HashMap<>();
	  deps.stream().forEach(file -> filemap.put(file.getName(), file));
	  files.addAll(deps);
	  main=filemap.get(spec.getName());
	  transform(flag);
	}
	
	public Document(Pattern p) {
		Collection<File> deps = FindDependencies.get(p);
		
		File mainFile = (File) Utilities.getTopFile(p);
		Map<String,File> filemap = new HashMap<>();
		deps.stream().forEach(f -> filemap.put(f.getName(), f));
	
		File newMainFile = filemap.get(mainFile.getName());
		Map<String,Pattern> patternmap = new HashMap<>();
		newMainFile.getPatterns().stream().forEach(pat -> patternmap.put(pat.getName(),pat));
		
		files.addAll(filemap.values());
		this.main=patternmap.get(p.getName());
	}
	
	public Document(TypeDef td) {
		Collection<File> deps = FindDependencies.get(td);
		
		File mainFile = (File) Utilities.getTopFile(td);
		Map<String,File> filemap = new HashMap<>();
		deps.stream().forEach(f -> filemap.put(f.getName(), f));
	
		File newMainFile = filemap.get(mainFile.getName());
		Map<String,TypeDef> typedefmap = new HashMap<>();
		newMainFile.getTypedefs().stream().forEach(tydef -> typedefmap.put(tydef.getName(),tydef));
		
		files.addAll(filemap.values());
		this.main=typedefmap.get(td.getName());		
	}

	public void transform(boolean rename) {
		try {
			PerformTransforms.apply(this,rename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMainName() {
		return resolver.apply(this.main);
	}
	
	public Program getLogicalConsistencyWithLustre() throws Exception {
	  Program p = SProgram.build(this).getLogicalConsistency();
	  FileOutputStream out = lustreOutputStream();
	  out.write(p.toString().getBytes());
	  return p;
	}

	 public Program getLogicalConsistency() {
	    Program p = SProgram.build(this).getLogicalConsistency();
	    return p;
	  }

	public Program getLogicalEntailmentWithLustre() throws Exception {
	  Program p = SProgram.build(this).getLogicalEntailment();
	  FileOutputStream out = lustreOutputStream();
	  out.write(p.toString().getBytes());
	  return p;
	}
	
	 public Program getLogicalEntailment() {
	    Program p = SProgram.build(this).getLogicalEntailment();
	    return p;
	  }
	
	public Program getRealizabilityWithLustre() throws Exception {
	  Program p = SProgram.build(this).getRealizability();
	  FileOutputStream out = lustreOutputStream();
	  out.write(p.toString().getBytes());
	  return p;
	}
	
	 public Program getRealizability() {
	    Program p = SProgram.build(this).getRealizability();
	    return p;
	  }

	public Renaming getRenaming(Mode mode) {
	  return new MapRenaming(renamed.get(main),mode);
	}
	
	private FileOutputStream lustreOutputStream() {
	  URI extLessURI = spec.eResource().getURI().trimFileExtension();
	  IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	  Path p = new Path(extLessURI.toPlatformString(true));
    IFolder f = root.getFolder(p);
    IPath r = f.getRawLocation();
    String stem = r.toString();
	  try {
      FileOutputStream out = new FileOutputStream(stem+".lus");
      return out;
    } catch (Exception e) {
      System.err.println("Could not create file " + stem + ", lustre file will not be generated : " + e);
      return null;
    }
	}
}
