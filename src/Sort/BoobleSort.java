package Sort;

public class BoobleSort {
    public static void sort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    SortUtils.swap(nums, j, j + 1);
                }
            }
        }
    }
}
