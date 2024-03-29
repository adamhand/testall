package LRUDemo.LRUHashMap;

public class Main {
    public static void main(String[] args) {
//        LRUCache<String, Integer> cache = new LRUCache<>(3);
//
////        System.out.println(cache.hashCode() & 0x7fffffff);
//
//        cache.put("0", 0);
//        cache.put("1", 1);
//        cache.put("2", 2);
//        cache.put("3", 3);
//
//        Iterator<String> integerIterator = cache.iterator();
//        while (integerIterator.hasNext()){
//            System.out.println(cache.get(integerIterator.next()) + " ");
//        }

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
