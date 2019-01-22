package LRUDemo.LRULinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int size;
    private static final float loadFactor = 0.75f;

    public LRUCache(int size){
        super(size, loadFactor, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    @Override
    public boolean containsKey(Object key) {
        synchronized (this){
            return super.containsKey(key);
        }
    }

    @Override
    public V get(Object key) {
        synchronized (this){
            return super.get(key);
        }
    }

    @Override
    public V put(K key, V value) {
        synchronized (this){
            return super.put(key, value);
        }
    }

    @Override
    public int size() {
        synchronized (this){
            return super.size();
        }
    }

    @Override
    public void clear() {
        synchronized (this){
            super.clear();
        }
    }
}
