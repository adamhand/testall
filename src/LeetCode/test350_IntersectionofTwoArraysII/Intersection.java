package LeetCode.test350_IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i = 0; i < nums1.length; i++)
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);

        for(int i = 0; i < nums2.length; i++)
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);

        List<Integer> list = new ArrayList<>();
        for(Integer key : map1.keySet()){
            if (map2.containsKey(key)){
                int max = Math.min(map1.get(key), map2.get(key));
                for(int i = 0; i < max; i++)
                    list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        int j = 0;
        for(int i = 0; i < list.size(); i++)
            ans[j++] = list.get(i);

        return ans;
    }
}
