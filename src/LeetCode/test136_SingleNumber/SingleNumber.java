package LeetCode.test136_SingleNumber;

import java.util.Arrays;

public class SingleNumber {
//    public int singleNumber(int[] nums) {
//        if(nums.length < 0 || nums.length % 2 == 0)
//            return -1;
//        if(nums.length == 1)
//            return nums[0];
//
//        Arrays.sort(nums);
//
//        int ans = 0;
//        for(int i = 0, j = 1; j < nums.length && i < nums.length; ) {
//            if (nums[i] == nums[j]) {
//                i = j + 1;
//                j = i + 1;
//                ans = nums[i];
//            } else {
//                return nums[i];
//            }
//        }
//        return ans;
//    }

    //用异或
    public int singleNumber(int[] nums) {
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++)
            ans ^= nums[i];

        return ans;
    }
}
