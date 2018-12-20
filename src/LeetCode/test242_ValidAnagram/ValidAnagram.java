package LeetCode.test242_ValidAnagram;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    //为什么不对？？？
//    public boolean isAnagram(String s, String t) {
//        if(s == null || t == null || s.length() != t.length())
//            return false;
//        if(s.length() == 0 && t.length() == 0)
//            return true;
//
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//
//        for(int i = 0; i < s.length(); i++){
//            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
//            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
//        }
//
//        for(Character key : map1.keySet()){
//            if(!map2.containsKey(key) || map1.get(key) != map2.get(key))
//                return false;
//        }
//
//        return true;
//    }

//     public boolean isAnagram(String s, String t) {
//         if (s==null && t==null) return true;
//         else if (s==null || t==null) return false;
//         else if (s.length() != t.length()) return false;

//         Map<Character, Integer> dict = new HashMap<>();
//         for(char c : s.toCharArray()) dict.put(c, dict.getOrDefault(c, 0) + 1);
//         for(char c : t.toCharArray()) {
//             int count = dict.getOrDefault(c, 0);
//             if (count == 0) return false;
//             else dict.put(c, count - 1);
//         }

//         return true;
//     }


    //用排序
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1, str2);
//    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String t = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(new ValidAnagram().isAnagram(s, t));
    }
}
