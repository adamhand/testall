package LeetCode.test131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

//https://segmentfault.com/a/1190000005669590
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtracing(result, list, s);

        return result;
    }

    public void backtracing(List<List<String>> result, List<String> list, String s){
        if (s.length() == 0) {
            result.add(new ArrayList<String>(list));
            return;
        }

        for (int i = 1; i <= s.length(); i++){
            if(!isPalindrome(s.substring(0, i))){
                continue;
            }
            list.add(s.substring(0, i));
            backtracing(result, list, s.substring(i));
            list.remove(list.size() - 1);  //回溯
        }
    }

    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> result = new ArrayList<>();
        result = new Solution().partition(s);
    }
}
