package LeetCode.test22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solutiono {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, "", 0, 0, n);

        return ans;
    }

    public void backtracking(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == 2 * max){
            ans.add(cur);
            return;
        }

        if (open < max){
            backtracking(ans, cur + "(", open + 1, close, max);
        }
        //注意这里
        if (close < open){
            backtracking(ans, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solutiono().generateParenthesis(2));
    }
}
