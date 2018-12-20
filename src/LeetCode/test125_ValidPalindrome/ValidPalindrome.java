package LeetCode.test125_ValidPalindrome;

public class ValidPalindrome {
//    public boolean isPalindrome(String s) {
//        if(s == null || s.length() == 0)
//            return true;
//
//        int head = 0, tail = s.length() - 1;
//        while(head < tail){
//            while(!isWord(s.charAt(head++))){
//
//            }
//            while(!isWord(s.charAt(tail--))){
//
//            }
//            if(head >= s.length() || tail <= 0)
//                return false;
//            if((s.charAt(head - 1) - s.charAt(tail + 1) != 0) && Math.abs(s.charAt(head - 1) - s.charAt(tail + 1)) != 32)
//                return false;
//        }
//        return true;
//    }
//
//    private boolean isWord(char ch){
//        if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
//            return true;
//        else
//            return false;
//    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String str1 = "race a car";
        String str2 = "a";
        String str3 = "aa";
        String str4 = ".,";

        System.out.println(new ValidPalindrome().isPalindrome(str));
        System.out.println(new ValidPalindrome().isPalindrome(str1));
        System.out.println(new ValidPalindrome().isPalindrome(str2));
        System.out.println(new ValidPalindrome().isPalindrome(str3));
        System.out.println(new ValidPalindrome().isPalindrome(str4));
        System.out.println('a' - 'A');

        System.out.println(Integer.toBinaryString(33));
    }
}
