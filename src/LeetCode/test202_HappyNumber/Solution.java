package LeetCode.test202_HappyNumber;

public class Solution {
    /**
     * 解法1，使用set
     * @param n
     * @return
     */
//    public boolean isHappy(int n) {
//        Set<Integer> set = new HashSet<>();
//        while (n != 1 && !set.contains(n)){
//            set.add(n);
//            int sum = 0;
//            while (n > 0){
//                int remain = n % 10;
//                sum += remain * remain;
//                n /= 10;
//            }
//            n = sum;
//        }
//        return n == 1;
//    }

    /**
     * 使用链表找环的快慢指针法。因为如果不是快乐数，会产生一个环。比如给定n=11
     * 1^2 + 1^2 = 2
     * 2^2 = 4
     * 4^2 = 16
     * 1^2 + 6^2 = 37
     * 3^2 + 7^2 = 58
     * 5^2 + 8^2 = 89
     * 8^2 + 9^2 = 145
     * 1^2 + 4^2 + 5^2 = 42
     * 4^2 + 2^2 = 20
     * 2^2 + 0^2 = 4
     * 可以看到，4又出现了，后面就会陷入一个循环
     */
    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do{
            slow = digit(slow);
            fast = digit(digit(fast));
        }while (slow != fast);

        return slow == 1;
    }

    public int digit(int n){
        int sum = 0;
        while (n > 0){
            int remain = n % 10;
            sum += remain * remain;
            n /= 10;
        }
        return sum;
    }
}
