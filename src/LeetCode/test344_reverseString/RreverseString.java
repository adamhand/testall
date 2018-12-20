package LeetCode.test344_reverseString;

public class RreverseString {
    public static String reverseString(String s) {
        if(s == null || s.length() == 0)
            return s;

        char[] chars = s.toCharArray();
//        int head = 0, tail = s.length() - 1;
//        while(head <= tail){
//            char ch = chars[head];
//            chars[head] = chars[tail];
//            chars[tail] = ch;
//
//            head++;
//            tail--;
//        }

        for(int i = 0, j = chars.length - 1; i < j; i++, j--){
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
        String s_1 = reverseString(s);
        System.out.println(s_1);
    }
}
