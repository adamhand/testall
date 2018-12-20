package DataStructureAndAlgorithm.KMP;

public class KMP2 {
    public static void main(String[] args) {
        String str = "bacbababadababacambabacaddababacasdsd";
        String tStr = "ababaca";
        int ans = KMP(str, tStr);
        System.out.println(ans);
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

    public static int KMP(String str, String tStr){
        int[] next = new int[tStr.length()];
        next = getNext(tStr, next);
        int j = -1;
        for(int i = 0; i < str.length(); i++){
            while(j > -1 && str.charAt(i) != tStr.charAt(j + 1))
                j = next[j];
            if(str.charAt(i) == tStr.charAt(j + 1))
                j++;
            if(j == tStr.length() - 1)
                return (i - tStr.length() + 1);
        }
        return -1;
    }
}
