package Collection.MapDemo.LinkedHashMapDemo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 读出的顺序和放入的顺序一样
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(12, "zhagnsan");
        linkedHashMap.put(2, "lisi");
        linkedHashMap.put(122, "wanwu");
        linkedHashMap.put(99, "taiqi");

        Iterator<Map.Entry<Integer, String>> iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, String> me = iterator.next();

            System.out.println(me.getKey()+"  "+me.getValue());
        }
    }
}
