package LeetCode.test172_FactorialTrailingZeroes;

public class Solution {
    public int trailingZeroes(int n) {
        if(n <= 0)
            return 0;
        else if(n <= 1)
            return 1;

        long num = 1;
        int result = 0;
        while (n >= 1){
            num *= n;
            n--;
        }
        System.out.println(num);

        long m = num % 10;
        while (m == 0){
            result++;
            num /= 10;
            m = num % 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 14;
        System.out.println(new Solution().trailingZeroes(i));
    }
}
