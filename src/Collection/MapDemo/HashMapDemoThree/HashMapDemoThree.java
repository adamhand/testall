package Collection.MapDemo.HashMapDemoThree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * value去重
 */
public class HashMapDemoThree {
    public static void main(String[] args) {
        HashMap<Integer, String> hs = new HashMap<>();
        hs.put(23,"张三");
        hs.put(24,"张三");
        hs.put(25,"王五");
        hs.put(21,"bob");
        hs.put(22,"alice");

        System.out.println(hs.toString());

        hs = method(hs);

        System.out.println(hs.toString());
    }

    public static HashMap<Integer, String> method(HashMap<Integer, String> hs){
        HashMap<Integer, String> hashMap = new HashMap<>();

        for(Integer key : hs.keySet()){
            if(!hashMap.containsValue(hs.get(key)))
                hashMap.put(key, hs.get(key));
        }

        return hashMap;
    }
}
