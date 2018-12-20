package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException {
//        int result = getClassDemo(10);
//        System.out.println(result);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(1);
        list.add(2);
        System.out.println(list.get(1));
    }
    public static int getClassDemo(int target) throws ClassNotFoundException {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }
}
