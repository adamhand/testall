package Test.RefOrData;

import java.util.Arrays;

public class ChangeNumber {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(num);

        changeNumber(num);

        System.out.println(num);

        int[] nums = {3,2,1};

        changeNums(nums);

        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    private static void changeNumber(int x){
        x++;
    }

    private static void changeNums(int[] nums){
        for(int i = 0; i < nums.length; i++)
            nums[i]++;
    }
}
