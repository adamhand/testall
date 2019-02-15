package LeetCode.test287_FindtheDuplicateNumber;

public class Sulotion {
//    public int findDuplicate(int[] nums) {
//        int min = 0, max = nums.length - 1;
//        while(min <= max){
//            int mid = min + (max - min) / 2;
//            int cnt = 0;
//            for(int i = 0; i < nums.length; i++){
//                if(nums[i] <= mid){
//                    cnt++;
//                }
//            }
//            if(cnt > mid){
//                max = mid - 1;
//            } else {
//                min = mid + 1;
//            }
//        }
//        return min;
//    }

    public int findDuplicate(int[] nums){
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        int find = 0;

        while (find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,2,3,5,6};
        int i = new Sulotion().findDuplicate(nums);
        System.out.println(i);
    }
}
