package Collection.MapDemo.DemoOne;

import java.util.*;

/**
 * map元素提取的几种方法。
 */
public class MapDemoOne {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        method(map);
    }

    public static void method(Map<Integer, String> map)
    {
        map.put(8,"zhaoliu");
        map.put(2,"zhaoliu");
        map.put(2,"zhaoliu");
        map.put(5,"wngwu");

        /**
         * 使用map中的value
         */
        Collection<String> values = map.values();
        Iterator<String> it = values.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        System.out.println();
        /**
         * 使用map中的key
         */
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> it1 = keySet.iterator();
        while(it1.hasNext())
        {
            int key = it1.next();
            String value = map.get(key);
            System.out.println(key+" "+value);
        }

        System.out.println();

        /**
         * 使用entrySet。这个方法将key和value的映射关系存储到Set中，这个映射关系就是Map.Entry
         */
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it2 = entrySet.iterator();
        while(it2.hasNext())
        {
            Map.Entry<Integer, String> me = it2.next();
            Integer key = me.getKey();
            String value = me.getValue();
            System.out.println(key+" "+value);
        }

        System.out.println();

        /**
         * 使用for each循环
         */
        for(Map.Entry<Integer, String> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        System.out.println();

        for(Integer key : map.keySet())
        {
            System.out.println(key+" "+map.get(key));
        }

        for(String value : map.values())
        {
            System.out.println(value);
        }
    }
}
