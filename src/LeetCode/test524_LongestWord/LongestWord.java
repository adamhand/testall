package LeetCode.test524_LongestWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWord {
    public String findLongestWord(String s, List<String> d) {
        if(s == null || d == null || s.length() == 0 || d.size() == 0)
            return "";

        String longestWord = "";
        for(String t : d){
            int l1 = longestWord.length(), l2 = t.length();
            if(l1 > l2 || (l1 == l2 && longestWord.compareTo(t) < 0))
                continue;
            if(isValid(s, t))
                longestWord = t;
        }
        return longestWord;
    }

    private boolean isValid(String s1, String s2){
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()){
//            if(s1.charAt(i) != s2.charAt(j))
//                i++;
//            else {
//                i++;
//                j++;
//            }
            if(s1.charAt(i) == s2.charAt(j))
                j++;
            i++;
        }
        return j == s2.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String > d = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));

        System.out.println(new LongestWord().findLongestWord(s, d));
    }
}
