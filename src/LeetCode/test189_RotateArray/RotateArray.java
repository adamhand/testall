package LeetCode.test189_RotateArray;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k)
            return;
        if(nums.length <= k){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private int[] reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums, 3);

        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
