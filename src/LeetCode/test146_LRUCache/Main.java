package LeetCode.test146_LRUCache;

public class Main {
    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(3);
//
//        cache.put(0, 0);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.put(3, 3);
//
//        System.out.println(cache.get(1)+" "+cache.get(2)+" "+cache.get(3));
//
//        System.out.println(cache.get(0));  //出错，key=0的节点已经被移除。

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
