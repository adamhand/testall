package LeetCode.test345_ReverseString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseString {
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1)
            return s;

        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] result = new char[s.length()];
        int left = 0, right = s.length() - 1;
        while(left <= right){
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            if(!set.contains(cLeft)){
                result[left++] = cLeft;
            }else if(!set.contains(cRight)){
                result[right--] = cRight;
            }else {
                result[left++] = cRight;
                result[right--] = cLeft;
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseVowels("leetcode"));
    }
}
