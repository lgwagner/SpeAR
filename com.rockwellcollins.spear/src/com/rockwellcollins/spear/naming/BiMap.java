package com.rockwellcollins.spear.naming;

import java.util.HashMap;

public class BiMap<K,V> {

    public HashMap<K,V> map = new HashMap<K, V>();
    public HashMap<V,K> inverse = new HashMap<V, K>();
    
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

    public boolean containsKey(K k) {
    	return map.containsKey(k);
    }
    
    public boolean invContainsKey(V v) {
    	return inverse.containsKey(v);
    }
    
    public V get(K k) {
        return map.get(k);
    }

    public K invGet(V v) {
        return inverse.get(v);
    }
}
