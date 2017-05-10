package com.rockwellcollins.spear.typing;

import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UserType;

public class ArrayType extends Type {

  public final String id;
  public final Type   base;
  public final int    size;
  private TypeDef     typedef;

  public ArrayType(String id, Type base, int size, TypeDef atd) {
    this.id = id;
    this.base = base;
    this.size = size;
    // this *must* be an ArrayTypeDef or a ConcreteArrayTypeDef
    this.typedef = atd;
  }

  @Override
  public String toString() {
    return id;
  }

  @Override
  public int hashCode() {
    return base.hashCode() + size;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ArrayType) {
      ArrayType other = (ArrayType) obj;
      return size == other.size && base.equals(other.base);
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
