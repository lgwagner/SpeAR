package com.rockwellcollins.spear.translate.naming.backend;

import java.util.HashMap;

public class BiMap<K,V> {

    HashMap<K,V> map = new HashMap<K, V>();
    HashMap<V,K> inverse = new HashMap<V, K>();

	public V put(K key, V value) {
		if (inverse.containsKey(value)) {
			throw new IllegalArgumentException("BiMap already has a mapping to value: " + value);
		}

		if (map.containsKey(key)) {
			inverse.remove(map.get(key));
		}

		map.put(key, value);
		inverse.put(value, key);
		return value;
	}

    boolean containsKey(K k) {
    	return map.containsKey(k);
    }
    
    boolean invContainsKey(V v) {
    	return inverse.containsKey(v);
    }
    
    V get(K k) {
        return map.get(k);
    }

    K invGet(V v) {
        return inverse.get(v);
    }
}
