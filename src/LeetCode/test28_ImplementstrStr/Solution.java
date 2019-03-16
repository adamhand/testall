package LeetCode.test28_ImplementstrStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()){
            return -1;
        }else if (needle.length() == 0){
            return 0;
        }

        int len1 = haystack.length(), len2 = needle.length();
        int threshold = len1 - len2;
        for (int i = 0; i <= threshold; i++){
            if (needle.equals(haystack.substring(i, i+len2))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        System.out.println(new Solution().strStr(haystack, needle));
    }
}
