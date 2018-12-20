package Shift;

//字符串循环左右移
public class StringShift {
    public static void main(String[] args) {
        String str = "123456789";
        System.out.println(str);
//        System.out.println(reverse(str));
        System.out.println(loopLeftShift(str, 3));
        System.out.println(loopRightShift(str, 3));
    }

    //字符串翻转
    public static String reverse(String str){
        char[] strs = str.toCharArray();
        for(int i = 0; i < str.length() / 2; i++){
            char temp = strs[i];
            strs[i] = strs[str.length() - i - 1];
            strs[str.length() - i - 1] = temp;
        }
        return String.valueOf(strs);
    }

    //循环左移
    public static String loopLeftShift(String str, int index){
        str = reverse(str);
        String left = reverse(str.substring(0, str.length() - index));  //substring(int beginIndex, int endIndex)
        String right = reverse(str.substring(str.length() - index));  //substring(int beginIndex)
        str = left + right;
        return str;
    }

    //循环右移
    public static String loopRightShift(String str, int index){
        String left = reverse(str.substring(0, str.length() - index));
        String right = reverse(str.substring(str.length() - index));
        str = left + right;
        str = reverse(str);
        return str;
    }
}
