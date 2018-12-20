package LeetCode.test8_myAtoi;

import org.omg.CORBA.INTERNAL;

public class myAtoi_1 {
    public int myAtoi(String str) {
        //1.异常情况
        if(str == null || str.length() == 0)
            return 0;

        int index = 0, sign = 1, total = 0;
        //2.处理空格
        while(index < str.length() && str.charAt(index) == ' ')
            index++;

        //3.正负号
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4.转换数字
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9)
                break;

            if(total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = total * 10 + digit;
            index++;
        }
        return sign * total;
    }
}
