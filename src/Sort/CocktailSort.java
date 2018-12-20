package Sort;

public class CocktailSort {
    public static void sort(int[] nums){
        int left = 0, right = nums.length - 1;

        while(left < right){
            for(int i = left; i < right; i++){
                if(nums[i] > nums[i + 1])
                    SortUtils.swap(nums, i, i + 1);
            }
            right--;
            for(int i = right; i > left; i--){
                if(nums[i] < nums[i - 1])
                    SortUtils.swap(nums, i, i - 1);
            }
            left++;
        }
    }
}
