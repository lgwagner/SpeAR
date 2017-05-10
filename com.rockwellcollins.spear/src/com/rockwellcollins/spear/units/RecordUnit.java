package com.rockwellcollins.spear.units;

import java.util.Iterator;
import java.util.Map;

public class RecordUnit extends Unit {

  public String            name;
  public Map<String, Unit> fields;

  public RecordUnit(String name, Map<String, Unit> fields) {
    this.name = name;
    this.fields = fields;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    Iterator<String> keys = fields.keySet().iterator();

    while (keys.hasNext()) {
      String key = keys.next();
      sb.append(key + " : " + fields.get(key).toString());
      if (keys.hasNext()) {
        sb.append(", ");
      }
    }
    sb.append("}");
    return sb.toString();
  }

  public boolean equals(Object obj) {
    if (obj instanceof RecordUnit) {
      RecordUnit other = (RecordUnit) obj;
      if (name.equals(other.name)) {
        for (String field : fields.keySet()) {
          if (!fields.get(field).equals(other.fields.get(field))) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
}
