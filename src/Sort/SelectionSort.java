package Sort;

public class SelectionSort {
    public static  void sort(int[] nums){
        int min ;
        int temp;
        for(int i = 0; i < nums.length - 1; i++) {
            min = i;                                 //记录最小元素的位置
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
//            SortUtils.swap(nums, min, i);           //为什么用这个就不对？？而且还和外层循环的次数有关系？？
//            temp = nums[min];
//            nums[min] = nums[i];
//            nums[i] = temp;

            nums[i] = nums[i] ^ nums[min];
            nums[min] = nums[i] ^ nums[min];
            nums[i] = nums[i] ^ nums[min];
        }

    }
}
