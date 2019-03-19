package test33_SearchinRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[left] <= nums[mid]){
                if (target <= nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

            if (nums[right] >= nums[mid]){
                if (target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;

        System.out.println(new Solution().search(nums, target));
    }
}
