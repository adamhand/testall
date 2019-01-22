package LRUDemo.LRULinkedHashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache(3);

        cache.put("0", 0);
        cache.put("1", 1);
        cache.put("2", 2);
        cache.put("3", 3);

        Set<Map.Entry<String, Integer>> entries = cache.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> me = iterator.next();
            System.out.println(me.getKey() + " " + me.getValue());
        }
    }
}
