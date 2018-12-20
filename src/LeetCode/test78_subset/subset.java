package LeetCode.test78_subset;

import java.util.ArrayList;
import java.util.List;

public class subset {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < nums.length; i++){
            subsets(nums, 0, i, list, lists);
        }

        return lists;
    }

    public void subsets(int[] nums, int begin, int num, List<Integer> tempList, List<List<Integer>> list){
        if(begin == nums.length || num == 0){
            list.add(new ArrayList<>(tempList));
            return;
        }

        tempList.add(nums[begin]);
        subsets(nums, begin + 1, num - 1, tempList, list);
        //为什么这里不加上强制类型转换就会出错？
        tempList.remove((Integer) nums[begin]);
        subsets(nums, begin + 1, num, tempList, list);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        new subset().subsets(nums);
    }
}
