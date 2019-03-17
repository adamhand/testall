package Algorithm.DP.DP1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//数字三角形问题
public class Solution {
    public int maxSum(int i, int j, int n, int[][] matrix){
        if (i == n){
            return matrix[i][j];
        }
        int x = maxSum(i+1, j, n, matrix);
        int y = maxSum(i+1, j+1, n, matrix);
        return matrix[i][j] + Math.max(x, y);
    }

    public int maxSum_1(int i, int j, int n, int[][] matrix, int[][] maxSum){
        if (maxSum[i][j] != -1){
            return maxSum[i][j];
        }
        if (i == n){
            maxSum[i][j] = matrix[i][j];
        }else {
            int x = maxSum_1(i+1, j, n, matrix, maxSum);
            int y = maxSum_1(i+1, j+1, n, matrix, maxSum);
            maxSum[i][j] = matrix[i][j] + Math.max(x, y);
        }
        return maxSum[i][j];
    }

    public int maxSum_2(int i, int j, int n, int[][] matrix, int[][] maxSum){
        for (int m = 1; m < n; m++){
            maxSum[n][m] = matrix[n][m];
        }

        for (int m = n - 1; m >= 1; m--){
            for (int p = 1; p <= m; p++){
                maxSum[m][p] = Math.max(maxSum[m+1][p], maxSum[m+1][p+1]) + matrix[m][p];
            }
        }
        return maxSum[1][1];
    }

    public int maxSum_3(int i, int j, int n, int[][] matrx, int[] maxSum){
        maxSum = matrx[n];

        for (int m = n-1; m >= 1; --m){
            for (int p = 1; p <= m; p++){
                maxSum[p] = Math.max(maxSum[p], maxSum[p+1]) + matrx[m][p];
            }
        }
        return maxSum[1];
    }

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[6][6];
        int[][] maxSum = new int[6][6];
        int[] maxSum_1 = new int[6];
        int n = 5;

//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j <= i; j++){
//                matrix[i][j] = scanner.nextInt();
//            }
//        }

        File file = new File("D:\\Prom\\testAll\\src\\Algorithm\\DP\\DP1\\array.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = null;
        int row = 1;
        while ((line = in.readLine()) != null){
            String[] temp = line.split(" ");
            for (int i = 0; i < temp.length; i++){
                matrix[row][i+1] = Integer.parseInt(temp[i]);
            }
            row++;
        }
        in.close();

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(matrix[i][j]);
                maxSum[i][j] = -1;
            }
            System.out.println();
        }

//         System.out.println(new Solution().maxSum(1, 1, 5, matrix));
//         System.out.println(new Solution().maxSum_1(1, 1, 5, matrix, maxSum));
//         System.out.println(new Solution().maxSum_2(1, 1, 5, matrix, maxSum));
         System.out.println(new Solution().maxSum_3(1, 1, 5, matrix, maxSum_1));
    }
}
