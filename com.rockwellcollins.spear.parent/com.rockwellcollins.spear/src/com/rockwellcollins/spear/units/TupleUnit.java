package com.rockwellcollins.spear.units;

import java.util.Iterator;
import java.util.List;

public class TupleUnit extends Unit {

	public List<Unit> units;

	public TupleUnit(List<Unit> units) {
		this.units = units;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		Iterator<Unit> unitsIterator = units.iterator();
		while (unitsIterator.hasNext()) {
			sb.append(unitsIterator.next());
			if (unitsIterator.hasNext()) {
				sb.append(" , ");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TupleUnit) {
			TupleUnit other = (TupleUnit) obj;
			if (units.size() == other.units.size()) {
				for (int i = 0; i < units.size(); i++) {
					if (!units.get(i).equals(other.units.get(i))) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
