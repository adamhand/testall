package LeetCode.test240_Searcha2DMatrixII;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = matrix.length;
        int colum = matrix[0].length;

        int r = row - 1, c = 0;
        while (r >= 0 && c <= colum - 1){
            if(matrix[r][c] == target){
                return true;
            }else if (matrix[r][c] < target){
                c++;
            }else {
                r--;
            }
        }
        return false;
    }
}
