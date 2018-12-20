package Sort;

//二分插入排序
public class InsertionSortDichotomy {
    public static void sort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int get = nums[i];                     //将待排序的数去除
            int left = 0, right = i - 1, mid = 0;
            while(left <= right){                  //左边已经是排好序的，可以用二分法查找
                mid = (left + right) / 2;
                if(nums[mid] > get){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            for(int j = i - 1; j >= left; j--){   //移动，腾出插入的位置
                nums[j + 1] = nums[j];
            }
            nums[left] = get;                     //left的位置就是需要插入的位置
        }
    }
}
