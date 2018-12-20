package DataStructureAndAlgorithm.KMP;

public class KMP3 {
    public static void main(String[] args) {
        String str = "bacbababadababacambabacaddababacasdsd";
        String tStr = "ababaca";
        int[] ans = new int[10];
        KMP(str, tStr, ans);
        for(int i = 0; i < ans.length; i++)
            System.out.println(ans[i]+" ");
    }

    private static int[] getNext(String str, int[] next){
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < str.length(); i++){
            while(j > -1 && str.charAt(j + 1) != str.charAt(i))
                j = next[j];
            if(str.charAt(i) == str.charAt(j + 1))
                j++;
            next[i] = j;
        }
        return next;
    }

    public static void KMP(String str, String tStr, int[] ans){
        int[] next = new int[tStr.length()];
        next = getNext(tStr, next);
        int j = -1;
        int k = 0;
        for(int i = 0; i < str.length() - 1; i++){
            while(j > -1 && str.charAt(i) != tStr.charAt(j + 1))
                j = next[j];
            if(str.charAt(i) == tStr.charAt(j + 1))
                j++;
            if(j == tStr.length() - 1)
                ans[k++] = (i - tStr.length() + 1);
        }
//        return -1;
    }
}
