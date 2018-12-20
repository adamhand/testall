package Collection.MapDemo.HashMapDemoTwo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 利用TreeMap对HashMap的key进行排序
 */
public class HashMapDemoTwo {
    public static void main(String[] args) {
        HashMap<Integer, String> hs = new HashMap<>();
        hs.put(23,"张三");
        hs.put(24,"李四");
        hs.put(25,"王五");
        hs.put(21,"bob");
        hs.put(22,"alice");
        hs.put(23,"网三");

        sortHashMapByKey(hs);
    }

    public static void sortHashMapByKey(Map<Integer, String> hashMap)
    {
        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        treeMap.putAll(hashMap);
        for(Map.Entry<Integer, String> entry : treeMap.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
