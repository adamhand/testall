package LeetCode.test680_ValidPalindrome;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if(s.length() == 1)
            return true;

        int l = -1, r = s.length();
        while(l++ < r--){  //不管把++/--放在前面还是后面，执行完这一行之后，++/--动作都会执行
            if(s.charAt(l) != s.charAt(r))
                return subValid(s, l + 1, r) || subValid(s, l, r - 1);
        }
        return true;
    }

    private boolean subValid(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome("aba"));
        System.out.println(new ValidPalindrome().validPalindrome("abca"));
        System.out.println(new ValidPalindrome().validPalindrome("abc"));
    }
}
