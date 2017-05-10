package com.rockwellcollins.spear.typing;

import java.util.List;

import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.UserType;

public class EnumType extends Type {
  public final String       id;
  public final List<String> values;
  private EnumTypeDef       typedef;

  public EnumType(String id, List<String> values, EnumTypeDef etd) {
    this.id = id;
    this.values = values;
    this.typedef = etd;
  }

  @Override
  public String toString() {
    return id;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof EnumType) {
      EnumType other = (EnumType) obj;
      return id.equals(other.id);
    }
    return false;
  }

  @Override
  public com.rockwellcollins.spear.Type getType() {
    UserType ut = SpearFactory.eINSTANCE.createUserType();
    ut.setDef(typedef);
    return ut;
  }
}
