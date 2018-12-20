package LeetCode.test14_LongestCommonPrefix;

public class LongestCommonPrefix {
//    public String longestCommonPrefix(String[] strs){
//        if(strs == null || strs.length == 0)
//            return new String("");
//
//        for(int i = 0; i < strs.length; i++){
//            if(strs[i] == null || strs[i].length() == 0)
//                return new String("");
//        }
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0; i < strs[0].length(); i++){
//            int j = 0;
//            for(; j < strs.length; j++){
//                if(i > strs[j].length() - 1){
//                    return sb.toString();
//                }else if(strs[j].charAt(i) == strs[0].charAt(i))
//                    continue;
//                else if(i == 0)
//                    return new String("");
//                else
//                    break;
//            }
//
//            if(j > strs.length - 1)
//                sb.append(strs[0].charAt(i));
//        }
//
//        return sb.toString();
//    }

    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.length() == 0)
                    return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        String[] strs2 = {"aca", "cba"};


        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs2));
    }
}
