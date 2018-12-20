package Sort;

public class BirdSort {
    public static void sort(int[] nums){
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    SortUtils.swap(nums, i, j);
                }
            }
        }
    }
}
