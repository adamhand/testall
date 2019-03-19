package Algorithm.DP.LongestSubSequence;

public class Solution {
    public int test(){
        int[] nums = {-2, 11, -4, 13, -5, -2};
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        for (int i = 1; i < len;i ++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < len; i++){
            max = max > dp[i] ? max : dp[i];
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().test());
    }
}
