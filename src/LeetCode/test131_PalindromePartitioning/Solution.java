package LeetCode.test131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtracing(result, list, s);

        return result;
    }

    public void backtracing(List<List<String>> result, List<String> list, String s){
        if (s.length() == 0)
            result.add(new ArrayList<String>(list));

        for (int i = 1; i <= s.length(); i++){
            if(!isPalindrome(s.substring(0, i))){
                continue;
            }
            list.add(s.substring(0, i));
            backtracing(result, list, s.substring(i));
            list.remove(list.size() - 1);
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
}
