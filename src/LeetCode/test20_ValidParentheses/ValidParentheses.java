package LeetCode.test20_ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

//    public boolean isValid(String s) {
//        if(s == null)
//            return false;
//        if(s.length() == 0)
//            return true;
//
//        Stack<Character> stack = new Stack<>();
//        char[] chars = s.toCharArray();
//        char temp;
//
//        for(int i = 0; i < chars.length; i++){
//            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '[')
//                stack.push(chars[i]);
//            else if(!stack.isEmpty()){
//                temp = stack.pop();
//                if(chars[i] == ')' && temp != '('){
//                    return false;
//                }else if(chars[i] == '}' && temp != '{'){
//                    return false;
//                }else if(chars[i] == ']' && temp != '['){
//                    return false;
//                }
//            }else
//                return false;
//        }
//
//        return stack.isEmpty() ? true : false;
//    }

    public boolean isValid(String s){
        if(s == null)
            return false;
        if(s.length() == 0)
            return true;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                char temp = stack.isEmpty() ? '#' : stack.pop();
                if(temp != map.get(ch))
                    return false;
            }else
                stack.push(ch);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "]";

        System.out.println(new ValidParentheses().isValid(str));
    }
}
