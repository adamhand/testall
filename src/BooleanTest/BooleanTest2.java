package BooleanTest;

import java.util.HashMap;
import java.util.Hashtable;

public class BooleanTest2 {
    public static void main(String[] args) {
        Character character = 'a';
        Character character1 = 'a';

        System.out.println(character == character1);

        HashMap<String, String> map = new HashMap();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        System.out.println(map.hashCode());

        HashMap<String, String> map1 = new HashMap();
        map1.put("1", "1");
        map1.put("2", "1");
        map1.put("3", "1");
        System.out.println(map1.hashCode());

        System.out.println(map1 == map);

        String s = "abc";
        int i = 0;

        new BooleanTest2().method(s);
        new BooleanTest2().method(i, s);
        new BooleanTest2().method(s, i);

        Hashtable<String, Integer> stringIntegerHashtable = new Hashtable<>();
    }

    public void method(String s, int i){}

    public void method(String s){}

    public void method(int i, String s){}
}
