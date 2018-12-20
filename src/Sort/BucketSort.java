package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//桶排序
public class BucketSort {
    public static void sort(int[] nums){
        //找到最大值和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        //桶的个数
        int bucketNum = (max - min) / nums.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将待排序数组的中的数放入合适的桶中
        for(int i = 0; i < nums.length; i++){
            int num = (nums[i] - min) / nums.length;
            bucketArr.get(num).add(nums[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        //将排序后的结果由ArrayList返回到数组中
        int j = 0;
        for(ArrayList<Integer> arr : bucketArr){
            for(int i : arr){
                nums[j++] = i;
            }
        }
    }
}
