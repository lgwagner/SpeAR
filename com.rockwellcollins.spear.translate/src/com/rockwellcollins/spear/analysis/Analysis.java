package com.rockwellcollins.spear.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.javatuples.Pair;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.translate.intermediate.Document;

import jkind.JKindException;
import jkind.api.JKindApi;
import jkind.api.JRealizabilityApi;
import jkind.api.results.JKindResult;
import jkind.api.results.JRealizabilityResult;
import jkind.api.results.Renaming;
import jkind.api.results.MapRenaming.Mode;
import jkind.lustre.Program;

public class Analysis {
  
  private JKindApi jKindApi;
  private JKindResult jKindResult;
  private JRealizabilityApi jRealizabilityApi;
  private JRealizabilityResult jRealizabilityResult;
  private boolean isJKindApi;

  private Program p;
  
  private Analysis(JKindApi api, Program p, JKindResult r) {
    this.jKindApi = api;
    isJKindApi = true;
    jKindResult = r;
    this.p = p;
  }

  private Analysis(JRealizabilityApi api, Program p, JRealizabilityResult r) {
    this.jRealizabilityApi = api;
    isJKindApi = false;
    jRealizabilityResult = r;
    this.p = p;
  }

  public void analyze(IProgressMonitor m) throws JKindException {
    if(isJKindApi) {
      jKindApi.execute(p,jKindResult,m);
    } else {
      jRealizabilityApi.execute(p,jRealizabilityResult,m);
    }
  }
  
  private static Pair<JKindApi,Document> commonJKindAnalysisSetup(Specification specification, String jkindjarpth) {
    JKindApi api = new JKindApi();
    api.setJKindJar(jkindjarpth.toString());
    PreferencesUtil.configureJKindApi(api);
    Document document = new Document(specification);
    return Pair.with(api, document);
  }
  
  public static Pair<Analysis,JKindResult> entailment
  (Specification specification,
   String jkindjarpth,
   String resultname) throws IOException {
    
    Pair<JKindApi,Document> pair = commonJKindAnalysisSetup(specification,jkindjarpth);
    Program p = null;
    if(PreferencesUtil.printFinalLustre()) {
      try {
        p = pair.getValue1().getLogicalEntailmentWithLustre();
      } catch (Exception e) {
        System.out.println("Failed to generate lustre intermediate files, skipping.");
        p = pair.getValue1().getLogicalEntailment();
      }
    } else {
      p = pair.getValue1().getLogicalEntailment();
    }
    Renaming renaming = pair.getValue1().getRenaming(Mode.IDENTITY);

    List<Boolean> invert = new ArrayList<>();
    Specification s = (Specification) pair.getValue1().main;
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
    
    // this is a hack to ensure the invert list accounts for the
    // additional property that captures all properties.
    if (PreferencesUtil.getEnableIVCDuringEntailment()) {
      pair.getValue0().setIvcReduction();
      invert.add(false);
    }
    
    JKindResult result = new JKindResult(resultname, p.getMainNode().properties, invert, renaming);
    return Pair.with(new Analysis(pair.getValue0(),p,result), result);
  }

  public static Pair<Analysis,JKindResult> consistency
  (Specification specification,
   String jkindjarpth,
   String resultname) throws IOException {
    
    Pair<JKindApi,Document> pair = commonJKindAnalysisSetup(specification,jkindjarpth);
    Program p = null;
    if(PreferencesUtil.printFinalLustre()) {
      try {
        p = pair.getValue1().getLogicalConsistencyWithLustre();
      } catch (Exception e) {
        System.out.println("Failed to generate lustre intermediate files, skipping.");
        p = pair.getValue1().getLogicalConsistency();
      }
    } else {
      p = pair.getValue1().getLogicalConsistency();
    }
    Renaming renaming = pair.getValue1().getRenaming(Mode.IDENTITY);

    List<Boolean> invert = p.getMainNode().properties.stream().map(prop -> true).collect(Collectors.toList());
    JKindResult result = new JKindResult(resultname, p.getMainNode().properties, invert, renaming);
    return Pair.with(new Analysis(pair.getValue0(),p,result), result);
  }
  
  public static Pair<Analysis,JKindResult> realizability(Specification specification, String jkindjarpth, String resultname) throws Exception {
    JRealizabilityApi api = new JRealizabilityApi();
    api.setJKindJar(jkindjarpth.toString());
    PreferencesUtil.configureRealizabilityApi(api);
    Document doc = new Document(specification);
    Program p = null;
    if(PreferencesUtil.printFinalLustre()) {
      try {
        p = doc.getRealizabilityWithLustre();
      } catch (Exception e) {
        System.out.println("Failed to generate lustre intermediate files, skipping.");
        p = doc.getRealizability();
      }
    } else {
      p = doc.getRealizability();
    }

    try {
      api.checkAvailable();
    } catch (Exception e) {
      System.err.println("Error executing JRealizability");
      throw e;
    }
    PreferencesUtil.configureRealizabilityApi(api);
    JRealizabilityResult result = new JRealizabilityResult("result", doc.getRenaming(Mode.IDENTITY));

    return Pair.with(new Analysis(api,p,result), result);
  }


}
