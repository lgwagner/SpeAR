package com.rockwellcollins.spear.utilities;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.util.SpearSwitch;

public class LiteralMapper extends SpearSwitch<EAttribute> {

  public static EAttribute crunch(EObject e) {
    return new LiteralMapper().doSwitch(e);
  }

  private LiteralMapper() {
  }

  public EAttribute caseIdRef(IdRef ref) {
    return SpearPackage.Literals.ID_REF__NAME;
  }

  public EAttribute caseFile(File f) {
    return SpearPackage.Literals.FILE__NAME;
  }

  public EAttribute casePattern(Pattern p) {
    return SpearPackage.Literals.PATTERN__NAME;
  }

  public EAttribute caseContraint(Constraint c) {
    return SpearPackage.Literals.CONSTRAINT__NAME;
  }

  public EAttribute defaultCase(EObject e) {
    return null;
  }
}
