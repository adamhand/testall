package Collection.MapDemo.TreeMapDemoOne;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemoOne {
    public static void main(String[] args) {
        TreeMap<Student, String> treeMap = new TreeMap<>(new CompareByName());

        treeMap.put(new Student("zhangsan", 14), "北京");
        treeMap.put(new Student("lisi", 15), "上海");
        treeMap.put(new Student("wangwu", 91), "广东");
        treeMap.put(new Student("zhaoliu", 12), "深圳");
        treeMap.put(new Student("hehe", 1), "杭州");

        Iterator<Map.Entry<Student, String>> iterator = treeMap.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<Student, String> me = iterator.next();
            Student key = me.getKey();
            String value = me.getValue();

            System.out.println(key.getName()+" "+key.getAge()+"   "+value);
        }
    }
}
