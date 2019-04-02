package LeetCode.test198_HouseRobber;

public class Solution {
    //递归，时间超过限制
    // public int rob(int[] nums) {
    //     return rob(nums, nums.length - 1);
    // }
    // private int rob(int[] nums, int i){
    //     if (i <0){
    //         return 0;
    //     }
    //     return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    // }

    //递归+缓存
    // int[] memo;
    // public int rob(int[] nums){
    //     memo = new int[nums.length + 1];
    //     Arrays.fill(memo, -1);
    //     return rob(nums, nums.length - 1);
    // }
    // private int rob(int[] nums, int i){
    //     if (i < 0){
    //         return 0;
    //     }
    //     if (memo[i] >= 0){
    //         return memo[i];
    //     }
    //     int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    //     memo[i] = result;
    //     return result;
    // }

    //递推+缓存
    // public int rob(int[] nums){
    //     if (nums == null || nums.length == 0)
    //         return 0;
    //     int[] memo = new int[nums.length + 1];
    //     memo[0] = 0;
    //     memo[1] = nums[0];
    //     for (int i = 1; i < nums.length; i++){
    //         int value = nums[i];
    //         memo[i + 1] = Math.max(memo[i - 1] + value, memo[i]);
    //     }
    //     return memo[nums.length];
    // }

    //继续简化空间复杂度
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int pre1 = 0, pre2 = 0;
        for (int num : nums) {
            int temp = pre1;
            pre1 = Math.max(pre2 + num, pre1);
            pre2 = temp;
        }
        return pre1;
    }
}
