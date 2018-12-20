package Collection.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        testLinkedList();
    }

    public static void testLinkedList(){
        //非accessOrder模式，迭代顺序为插入顺序
        HashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("s1", 1);
        map.put("s2", 2);
        map.put("s3", 3);
        map.put("s4", 4);
        map.put("s5", 5);
        map.put(null, 9);
        map.put("s6", 6);
        map.put("s7", 7);
        map.put("s8", 8);
        map.put(null, 11);
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(map);

        System.out.println();

        //accessOrder模式，迭代顺序为最近访问顺序
        HashMap<String, Integer> map1 = new LinkedHashMap<>(16, 0.75f, true);

        map1.put("s1", 1);
        map1.put("s2", 2);
        map1.put("s3", 3);
        map1.put("s4", 4);
        map1.put("s5", 5);
        map1.put(null, 9);
        map1.put("s6", 6);
        map1.put("s7", 7);
        map1.put("s8", 8);
        map1.put(null, 11);
        for(Map.Entry<String,Integer> entry:map1.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(map1);
    }
}
