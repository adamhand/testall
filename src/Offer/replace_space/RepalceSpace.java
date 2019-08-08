package Offer.replace_space;

import Offer.ListNodeUtils.ListNode;

public class RepalceSpace {
    private static String relaceSpace(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ' ) {
                sb.replace(i, i + 1, "%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(relaceSpace(new StringBuilder("we are happy")));

        String str = "hah   haha";
        str.replace(" ", "fd");
    }
}

