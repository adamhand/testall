package LeetCode.test36_isValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class isValidSudoku_1 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char cur = board[i][j];
                if(cur != '.'){
                    if(!set.add(cur + "in cow" + i) ||
                       !set.add(cur + "in column" +j) ||
                       !set.add(cur + "in block" + i / 3 + "-" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }
}
