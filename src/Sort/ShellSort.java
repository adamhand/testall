package Sort;

public class ShellSort {
    public static void sort(int[] nums){
        int length = nums.length;
        int h = 1;
        while(h < length / 3){
            h = 3 *h + 1;              //增量，1,4,13,40....
        }

        while(h >= 1){
            for(int i = h; i < length; i++){   //插入排序
                int j = i - h;
                int get = nums[i];
                while(j >= 0 && nums[i] > get){
                    nums[j + h] = nums[j];
                    j = j - h;
                }
                nums[j + h] = get;
            }
            h = (h - 1) / 3;          //缩小增量
        }
    }
}
