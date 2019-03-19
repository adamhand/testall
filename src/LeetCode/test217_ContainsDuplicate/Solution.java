package test217_ContainsDuplicate;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1){
            return false;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}
