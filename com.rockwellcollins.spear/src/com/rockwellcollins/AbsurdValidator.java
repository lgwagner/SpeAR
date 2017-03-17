package com.rockwellcollins;

import com.rockwellcollins.validation.IValidatorAdvisor;

class AbsurdValidator implements IValidatorAdvisor {

  public boolean isUnusedValidationsDisabled() {return false;}
  public boolean isSolverNonlinear() { return false;}

}
