package com.sdt.cache;

import java.util.LinkedHashMap;
import java.util.Map;



public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private final int MAC_CACHE_SIZE;
	
	public LRUCache(int cacheSize) {
		super((int)Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
		MAC_CACHE_SIZE = cacheSize;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAC_CACHE_SIZE;
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
