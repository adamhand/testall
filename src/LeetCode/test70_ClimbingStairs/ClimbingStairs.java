package LeetCode.test70_ClimbingStairs;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;

        int pre1 = 1, pre2 = 2;
        int result = 0;
        for(int i = 2; i < n; i++){
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
