package DataStructureAndAlgorithm.KMP;

//KMP算法
public class KMP {
    public static void main(String[] args) {
        String str = "bacbababadababacambabacaddababacasdsd";
        String tStr = "ababaca";
        int ans = KMP(str, tStr, 1);
        System.out.println(ans);
    }

    private static int[] getNext(String str, int[] next){
        next[0] = 1;
        int i = 1, j = 0;
        while(i < str.length()){
            if(j == 0 || str.charAt(i) == str.charAt(j)){
                i++;
                j++;
                if(str.charAt(i) != str.charAt(j))
                    next[i] = j;
                else
                    next[i] = next[j];
            }
            else
                j = next[j];
        }
        return next;
    }

    /**
     *
     * @param str：主串
     * @param tStr：模式串
     * @param pos
     * @return
     */
    public static int KMP(String str, String tStr, int pos){
        int[] next = new int[tStr.length() + 1];
        next = getNext(tStr, next);
        int i = pos, j = 1;
        while(i <= str.length() && j <= tStr.length()){
            if(j == 0 || str.charAt(i) == tStr.charAt(j)){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if(j > tStr.length())
            return i - tStr.length();
        else
            return 0;
    }
}
