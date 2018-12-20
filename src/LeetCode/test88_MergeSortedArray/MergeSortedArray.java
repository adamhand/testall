package LeetCode.test88_MergeSortedArray;

import com.sun.org.apache.bcel.internal.generic.MethodGen;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sumLen = m + n - 1;

        int i = m - 1, j = n - 1;
        while(i >= 0 && j >= 0){
            if(i < 0)
                nums1[sumLen--] = nums2[j--];
            else if(j < 0)
                nums1[sumLen--] = nums1[i--];
            else if(nums1[i] > nums2[j]){
                nums1[sumLen--] = nums1[i--];
            }else {
                nums1[sumLen--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        new MergeSortedArray().merge(nums1, 3, nums2, 3);

        for(int i = 0; i < nums1.length; i++)
            System.out.print(nums1[i] + " ");
    }
}
