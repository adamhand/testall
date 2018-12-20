package LeetCode.test179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strings[i] = String.valueOf(nums[i]);

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;

                return s2.compareTo(s1);
            }
        });

        if(strings[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strings.length; i++)
            sb.append(strings[i]);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};

        System.out.println(new LargestNumber().largestNumber(nums));
    }
}
