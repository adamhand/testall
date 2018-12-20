package LeetCode.test7_ReverseInteger;

public class ReverseInteger {
//    public int reverse(int x) {
//        if(x == Integer.MIN_VALUE)
//            return 0;
//
//        int sign = 1;
//        if(x < 0)
//            sign = -1;
//
//        long newNum = 0;
//        x = Math.abs(x);
//        while(x != 0){
//            int temp = x % 10;
//            newNum = newNum * 10 + temp;
//            x /= 10;
//        }
//
//        if(sign < 0)
//            newNum = -newNum;
//
//        if(newNum < Integer.MIN_VALUE || newNum > Integer.MAX_VALUE)
//            return 0;
//
//        return (int)newNum;
//    }

    public int reverse(int x) {
        int res = 0;

        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && pop == 7))
                return 0;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE && pop == -8))
                return 0;
            res = res * 10 + pop;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(Integer.MAX_VALUE));
        System.out.println(new ReverseInteger().reverse(Integer.MIN_VALUE));
        System.out.println(-123 % 10);
    }
}
