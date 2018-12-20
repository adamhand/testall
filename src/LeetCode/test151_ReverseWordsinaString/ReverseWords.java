package LeetCode.test151_ReverseWordsinaString;

public class ReverseWords {
//    public String reverseWords(String s) {
//        if(s == null || s.length() == 0)
//            return s;
//
//        s = s.trim();
//        String[] strings = s.split(" ");
//        int l = 0, r = strings.length - 1;
//        while (l < r){
//            String temp = strings[l];
//            strings[l] = strings[r];
//            strings[r] = temp;
//
//            l++;
//            r--;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < strings.length; i++){
//            if(i == strings.length - 1)
//                sb.append(strings[i]);
//            else
//                sb.append(strings[i]+" ");
//        }
//
//        return sb.toString();
//    }

    //太慢
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }


    public static void main(String[] args) {
        String str = "   a   b ";

        System.out.println(new ReverseWords().reverseWords(str));
    }
}
