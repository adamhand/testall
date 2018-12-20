package LeetCode.test665_NondecreasingArray;

public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;

        int count = 0;
        for(int i = 1; i < nums.length && count < 2; i++){
            if(nums[i] >= nums[i - 1])
                continue;
            count++;
            if(i >= 2 && nums[i - 2] > nums[i]){
                nums[i] = nums[i - 1];
            }else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,3};

        System.out.println(new NondecreasingArray().checkPossibility(nums));
    }
}
