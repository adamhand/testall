package Collection.MapDemo.HashMapDemoOne;

import java.util.*;

/**
 * 按照Key排序
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hs = new HashMap<>();
        hs.put(23,"张三");
        hs.put(24,"李四");
        hs.put(25,"王五");
        hs.put(21,"bob");
        hs.put(22,"alice");

        sortHashMap(hs);

    }

    public static void sortHashMap(Map<Integer, String> hashMap)
    {
        //1.用HashMap构造一个LinkedList
        Set<Map.Entry<Integer, String>> set = hashMap.entrySet();
        LinkedList<Map.Entry<Integer, String>> linkedList = new LinkedList<>(set);

        //2.用Collection的sort方法排序
        Collections.sort(linkedList, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                //return o1.getKey() - o2.getKey();
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //3.将排序后的LinkedList赋值LinkedHashMap
        Map<Integer, String> map = new LinkedHashMap<>();
        for(Map.Entry<Integer, String> entry : linkedList)
        {
            map.put(entry.getKey(), entry.getValue());
        }

        for(Map.Entry<Integer, String> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
