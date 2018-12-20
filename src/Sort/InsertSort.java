package Sort;

public class InsertSort {
    public static void sort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int get = nums[i];                //现将待排序的数取出，可以减少交换的次数
            int j = i - 1;
            while(j >= 0 && nums[j] > get){   //从后向前查找，当前数比待排序的数大，就将当前数后移，腾出位置
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = get;                //当前数不比排序数大，就插入
        }
    }
}
