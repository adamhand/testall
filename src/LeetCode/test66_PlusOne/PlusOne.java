package LeetCode.test66_PlusOne;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDig = new int[digits.length + 1];
        newDig[0] = 1;

        return newDig;
    }
}
