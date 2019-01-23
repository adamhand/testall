package LRUDemo.LRUHashMap;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);

//        System.out.println(cache.hashCode() & 0x7fffffff);

        cache.put("0", 0);
        cache.put("1", 1);
        cache.put("2", 2);
        cache.put("3", 3);

        Iterator<String> integerIterator = cache.iterator();
        while (integerIterator.hasNext()){
            System.out.println(cache.get(integerIterator.next()) + " ");
        }
    }
}
