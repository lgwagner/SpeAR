package com.rockwellcollins.ui.contentassist;

import java.util.List;

import com.rockwellcollins.spear.BaseUnit;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Data;
import com.rockwellcollins.spear.DerivedUnit;
import com.rockwellcollins.spear.DescriptionData;
import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.util.SpearSwitch;

/**
 * @author lgwagner
 *
 *         This is called by the SpearDocumentationProvider.
 * 
 *         Here is where you should define what string should be displayed for
 *         the documentation when the user hovers over text in a specification.
 * 
 */
public class SpearDescriptionFetcher extends SpearSwitch<String> {

  private String getDescriptorIfAvailable(List<Data> datalist) {
    for (Data d : datalist) {
      if (d instanceof DescriptionData) {
        DescriptionData description = (DescriptionData) d;
        return description.getString();
      }
    }
    return null;
  }

  @Override
  public String caseConstant(Constant c) {
    return this.getDescriptorIfAvailable(c.getData());
  }

  @Override
  public String caseMacro(Macro m) {
    return this.getDescriptorIfAvailable(m.getData());
  }

  @Override
  public String caseBaseUnit(BaseUnit base) {
    return base.getDescription();
  }

  @Override
  public String caseDerivedUnit(DerivedUnit derived) {
    return derived.getDescription();
  }

  @Override
  public String caseFormalConstraint(FormalConstraint fc) {
    return this.getDescriptorIfAvailable(fc.getData());
  }

  @Override
  public String caseEnglishConstraint(EnglishConstraint ec) {
    return this.getDescriptorIfAvailable(ec.getData());
  }
}
