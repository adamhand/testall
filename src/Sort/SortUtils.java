package Sort;

public class SortUtils {
    public static void swap(int[] nums, int i, int j){
//        nums[i] = nums[i] ^ nums[j];
////        nums[j] = nums[i] ^ nums[j];
////        nums[i] = nums[i] ^ nums[j];
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
