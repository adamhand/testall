package LeetCode.test392_IsSubsequence;

public class IsSubsequence {
//    public boolean isSubsequence(String s, String t) {
//        if(s == null || t == null)
//            return false;
//
//        int i = 0, j = 0;
//        while(i < s.length() && j < t.length()){
//            if(s.charAt(i) == t.charAt(j))
//                i++;
//            j++;
//        }
//        return i == s.length();
//    }

    public boolean isSubsequence(String s, String t){
        if(s == null || t == null)
            return false;

        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c, index + 1);  //从指定的索引开始搜索，返回字符第一次出现的索引。
            if(index == -1)
                return false;
        }
        return true;
    }
}
