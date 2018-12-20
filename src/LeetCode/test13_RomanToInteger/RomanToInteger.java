package LeetCode.test13_RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInteger(String s){
        if(s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        for(int i = 0; i < chars.length; i++){
            if(i + 1 >= chars.length){
                ans += map.get(chars[i]);
                break;
            }

            if(chars[i] == 'I'){
                if(chars[i + 1] == 'V'){
                    i++;
                    ans += 4;
                }
                else if(chars[i + 1] == 'X'){
                    i++;
                    ans += 9;
                }
                else
                    ans += map.get(chars[i]);
            }else if(chars[i] == 'X'){
                if(chars[i + 1] == 'L'){
                    i++;
                    ans += 40;
                }
                else if(chars[i + 1] == 'C') {
                    i++;
                    ans += 90;
                }else
                    ans += map.get(chars[i]);
            }else if(chars[i] == 'C'){
                if(chars[i + 1] == 'D'){
                    i++;
                    ans += 400;
                }
                else if(chars[i + 1] == 'M'){
                    i++;
                    ans += 900;
                }else
                    ans += map.get(chars[i]);
            }else
                ans += map.get(chars[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInteger("III"));
        System.out.println(new RomanToInteger().romanToInteger("IV"));
        System.out.println(new RomanToInteger().romanToInteger("IX"));
        System.out.println(new RomanToInteger().romanToInteger("LVIII"));
    }
}
