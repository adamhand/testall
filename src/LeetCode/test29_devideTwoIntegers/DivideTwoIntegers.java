package LeetCode.test29_devideTwoIntegers;

public class DivideTwoIntegers {
//    /**真是一个清奇的想法
//     * @param dividend：被除数
//     * @param divisor：除数
//     * @return
//     */
//    public int divide(int dividend, int divisor) {
//        if(dividend == 0)
//            return 0;
//        if(dividend==Integer.MIN_VALUE && divisor==-1)
//            return Integer.MAX_VALUE;
//        int sign = -1;
//        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0)
//            sign = 1;
//
//        int numDividend = 0, numDivisor = 0;
//        dividend = Math.abs(dividend);
//        divisor = Math.abs(divisor);
//        while(dividend != 0){
//            numDividend++;
//            dividend >>= 1;
//        }
//        while(divisor != 0){
//            numDivisor++;
//            divisor >>= 1;
//        }
//
//        return sign < 0 ? -(numDividend - numDivisor + 1) : (numDividend - numDivisor + 1);
//    }

    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;

        int sign = -1;
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0)
            sign = 1;

        if(dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
        else if(dividend==Integer.MIN_VALUE && divisor==1){
            return Integer.MIN_VALUE;
        }
        else if(dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
        }


        int ans = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = divisor;

        while(sum <= dividend && sum > 0){
            sum += divisor;
            ans++;
        }

        return sign < 0 ? -ans : ans;
    }

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();

        System.out.println(new DivideTwoIntegers().divide(
                2147483647, 1));

        Long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
