package LeetCode.test215_KthLargest;

import java.util.PriorityQueue;

//寻找第K大的元素。
public class KthLargest {
//    public int findKthLargest(int[] nums, int k) {
//        if(nums == null || nums.length == 0)
//            return -1;
//        int l = 0, r = nums.length - 1;
//        k = nums.length - k; //这句话很重要，第K大的值，就是第nums.length - k 小的值
//        while (l < r){
//            int j = patition(nums, l, r);
//            if(j == k)
//                return nums[k];
//            else if(j < k)
//                l = j + 1;
//            else
//                r = j - 1;
//        }
//        return nums[k];
//    }
//
//    private int patition(int[] nums, int l, int r){
//        int p = nums[l];
//        int i = l, j = r + 1;
//        while(true){
//            while (i < r && nums[++i] < p);
//            while (j > l && nums[--j] > p);
//            if(i >= j)
//                break;
//            swqp(nums, i, j);
//        }
//        swqp(nums, l, j);
//
//        return j;
//    }
//
//    private void swqp(int[] nums, int i, int j){
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }

    //用堆
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

//        System.out.println(new KthLargest().partition(nums, 0, nums.length - 1));
    }
}
