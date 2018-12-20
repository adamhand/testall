package LeetCode.test455_AssignCookies;

import java.util.Arrays;

public class AssignCookies {
    /**
     * @param g：孩子
     * @param s：蛋糕
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j])
                i++;
            j++;
        }
        return i;
    }
}
