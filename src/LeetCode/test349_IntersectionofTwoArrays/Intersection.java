package LeetCode.test349_IntersectionofTwoArrays;

import java.util.*;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);

        Set<Integer> set1 = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i]))
                set1.add(nums2[i]);
        }

        int j = 0;
        int[] ans = new int[set1.size()];
        Iterator<Integer> it = set1.iterator();
        while (it.hasNext())
            ans[j++] = it.next();

        return ans;
    }
}
