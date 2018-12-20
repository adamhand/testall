package LeetCode.test633_JudgeSqrt;

public class JudgeSqrt {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int)Math.sqrt(c);

        while(i <= j){
            int m = i * i + j * j;
            if(m == c)
                return true;
            else if(m < c)
                i++;
            else
                j--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JudgeSqrt().judgeSquareSum(1000));
    }
}
