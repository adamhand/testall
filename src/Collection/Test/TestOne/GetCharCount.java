package Collection.Test.TestOne;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 获取每个字母出现的次数，并按照a(1)b(2)...方式打印
 * "fjisfjis jsdiofjig   werwfjiojgis"
 */
public class GetCharCount {
    public static void main(String[] args) {

        String str = "fjisfjis jsdiofjig   werwfjiojgis";

        String s = getCharCount(str);

        System.out.println(s);
    }

    public static String getCharCount(String str)
    {
        Map<Character, Integer> map = new TreeMap<>();

        //1.将字符串转变为字符数组
        char[] chars = str.toCharArray();
//        System.out.println(chars.length);

        for(int i = 0; i < chars.length; i++)
        {
            if(!(chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z'))
            {
                continue;
            }

            //2.拿去查表
            Integer value = map.get(chars[i]);
            int count = 1;

            if(value != null)
            {
                //value = value + count;
                count = value + 1;
            }
            map.put(chars[i], count);
        }

        printMap(map);
        return mapToString(map);
    }

    public static void printMap(Map<Character, Integer> map)
    {
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            //System.out.println(iterator.next().getKey()+"("+iterator.next().getValue()+")");
            Character key = iterator.next().getKey();
            Integer value = map.get(key);

            System.out.println(key+"("+value+")");
        }
    }

    public static String mapToString(Map<Character, Integer> map)
    {
        StringBuilder sb = new StringBuilder();

        Iterator<Character> iterator = map.keySet().iterator();

        while(iterator.hasNext())
        {
            Character key = iterator.next();
            Integer value = map.get(key);

            sb.append(key+"("+value+")");
        }

        return sb.toString();
    }

}
