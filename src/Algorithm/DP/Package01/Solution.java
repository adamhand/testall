package Algorithm.DP.Package01;

public class Solution {
    public int test(){
        int V = 10;    //背包容量
        int N = 5;     //物品个数

        int[] values = {0,8,10,4,5,5};  //第i个物品的价值，下标为0的位置不是物品
        int[] weight = {0,6,4,2,4,3};   //第i个物品占用的空间
        int[][] f = new int[N+1][V+1];

        for (int i = 0; i < N+1; i++){
            for (int j = 0; j < V+1; j++){
                f[i][j] = 0;
            }
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= V; j++){
                if (weight[i] > j){
                    f[i][j] = f[i-1][j];
                }else {
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-weight[i]]+values[i]);
                }
            }
        }
        return f[N][V];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().test());
    }
}
