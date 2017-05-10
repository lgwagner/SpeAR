package com.rockwellcollins.spear.naming;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UnitDef;

public class SpearDeclarativeQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

  protected QualifiedName qualifiedName(EnumValue e) {
    return QualifiedName.create(e.getName());
  }

  protected QualifiedName qualifiedName(UnitDef d) {
    return QualifiedName.create(d.getName());
  }

  protected QualifiedName qualifiedName(TypeDef t) {
    return QualifiedName.create(t.getName());
  }

  protected QualifiedName qualifiedName(Constant c) {
    return QualifiedName.create(c.getName());
  }

  protected QualifiedName qualifiedName(Pattern p) {
    return QualifiedName.create(p.getName());
  }
}
