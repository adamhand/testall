package LeetCode.test451_SortCharactersByFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortChar {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0)
            return "";

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < chars.length; i++)
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);

        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for(Character ch : map.keySet()){
            int freq = map.get(ch);
            if(buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] != null){
                for(char c : buckets[i]){
                    for(int j = 0; j < i; j++)
                        sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "tree";

        System.out.println(new SortChar().frequencySort(str));
    }
}
