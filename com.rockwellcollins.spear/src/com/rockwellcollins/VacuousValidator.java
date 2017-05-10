package com.rockwellcollins;

import com.rockwellcollins.validation.IValidatorAdvisor;

class VacuousValidator
    implements IValidatorAdvisor {

  public boolean isUnusedValidationsDisabled() {
    return true;
  }

  public boolean isSolverNonlinear() {
    return false;
  }

}
