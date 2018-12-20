package LeetCode.test49_groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams_3 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        HashMap<Integer, List<String>> map = new HashMap<>();

        for(String str : strs){
            int key = 1;
            char[] chars = str.toCharArray();
            for(char ch : chars){
                key *= prime[ch - 'a'];  //每个非素数都可以唯一地被分解为若干个素数的乘积，保证了key的唯一性。
            }

            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());

        //思路是一样的，为什么这个就快呢？
/*        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;*/
    }
}
