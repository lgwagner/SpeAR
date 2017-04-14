package com.rockwellcollins.spear.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;
import com.rockwellcollins.spear.translate.master.SProgram;

import jkind.api.JKindApi;
import jkind.api.JRealizabilityApi;
import jkind.api.results.JKindResult;
import jkind.api.results.JRealizabilityResult;
import jkind.api.results.MapRenaming;
import jkind.api.results.Renaming;
import jkind.api.results.MapRenaming.Mode;
import jkind.lustre.Program;

public class Analysis {
  
  public static JKindResult entailment(Specification specification, String jkindjarpth, IProgressMonitor progmon) {
    JKindApi api = new JKindApi();
    api.setJKindJar(jkindjarpth.toString());
    PreferencesUtil.configureJKindApi(api);
    
    Document workingCopy = new Document(specification);
    workingCopy.transform();

    SProgram program = SProgram.build(workingCopy);
    Program p = program.getLogicalEntailment();
    
    Renaming renaming = new MapRenaming(workingCopy.renamed.get(workingCopy.main), Mode.IDENTITY);
    List<Boolean> invert = new ArrayList<>();
    Specification s = (Specification) workingCopy.main;
    for (Constraint c : s.getBehaviors()) {
      if (c instanceof FormalConstraint) {
        FormalConstraint fc = (FormalConstraint) c;
        if (fc.getFlagAsWitness() != null) {
          invert.add(true);
        } else {
          invert.add(false);
        }
      } else {
        invert.add(false);
      }
    }
    JKindResult result = new JKindResult("result", p.getMainNode().properties, invert, renaming);
    
    try {
      api.execute(p, result, progmon);
    } catch (Exception e) {
      throw e;
    }
    return result;
  }

  public static JKindResult consistency(Specification specification, String jkindjarpth, IProgressMonitor progmon) {
    JKindApi api = new JKindApi();
    api.setJKindJar(jkindjarpth.toString());
    PreferencesUtil.configureJKindApi(api);
    
    Document workingCopy = new Document(specification);
    workingCopy.transform();

    SProgram program = SProgram.build(workingCopy);
    Program p = program.getLogicalConsistency();
    
    Renaming renaming = new MapRenaming(workingCopy.renamed.get(workingCopy.main), Mode.IDENTITY);
    List<Boolean> invert = p.getMainNode().properties.stream().map(prop -> true).collect(Collectors.toList());
    JKindResult result = new JKindResult("result", p.getMainNode().properties, invert, renaming);
    
    try {
      api.execute(p, result, progmon);
    } catch (Exception e) {
      throw e;
    }
    return result;
  }
  
  public static JRealizabilityResult realizability(Specification specification, String jkindjarpth, IProgressMonitor progmon) throws Exception {
    JRealizabilityApi api = new JRealizabilityApi();
    api.setJKindJar(jkindjarpth.toString());

    try {
      api.checkAvailable();
    } catch (Exception e) {
      System.err.println("Error executing JRealizability");
      throw e;
    }
    PreferencesUtil.configureJRealizabilityApi(api);
    
    Document workingCopy = new Document(specification);
    workingCopy.transform();

    SProgram program = SProgram.build(workingCopy);
    Program p = program.getRealizability();
    
    Renaming renaming = new MapRenaming(workingCopy.renamed.get(workingCopy.main), Mode.IDENTITY);
    JRealizabilityResult result = new JRealizabilityResult("result", renaming);
    
    try {
      api.execute(p, result, progmon);
    } catch (Exception e) {
      throw e;
    }
    return result;
  }


}
