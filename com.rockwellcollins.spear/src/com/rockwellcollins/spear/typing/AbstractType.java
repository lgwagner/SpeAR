package com.rockwellcollins.spear.typing;

import com.rockwellcollins.spear.AbstractTypeDef;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.UserType;

public class AbstractType extends Type {
  public String           id;
  private AbstractTypeDef typedef;

  public AbstractType(AbstractTypeDef atd) {
    this.id = atd.getName();
    this.typedef = atd;
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
    if (obj instanceof AbstractType) {
      AbstractType other = (AbstractType) obj;
      return this.id.equals(other.id);
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
