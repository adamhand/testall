package LeetCode.test387_FirstUniqueCharacter;

public class Solution {
//    public int firstUniqChar(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++){
//            char ch = s.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//
//        for (int i = 0; i < s.length(); i++){
//            if (map.get(s.charAt(i)) == 1){
//                return i;
//            }
//        }
//        return -1;
//    }

    //LinkedHashMap中默认取出数据的顺序等于放入的顺序
//    public int firstUniqChar(String s){
//        Map<Character, Integer> map = new LinkedHashMap<>();
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++){
//            if (set.contains(s.charAt(i))){
//                if (map.get(s.charAt(i)) != null){
//                    map.remove(s.charAt(i));
//                }
//            }else {
//                set.add(s.charAt(i));
//                map.put(s.charAt(i), i);
//            }
//        }
//        return map.size() > 0 ? map.entrySet().iterator().next().getValue() : -1;
//    }

    public int firstUniqChar(String s){
        char[] letters = s.toCharArray();
        int[] tracker = new int[26];

        for (char c : letters){
            tracker[c - 'a']++;
        }

        for (int i = 0; i < letters.length; i ++){
            if (tracker[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
