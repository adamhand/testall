package Sort;

//基数排序，使用计数排序
public class RadixSort {
    //多次调用基数排序对每一位进行排序
    public static void sort(int[] nums){
        int max = getMax(nums);

        for(int exp = 1; max / exp > 0; exp *= 10){
            countSort(nums, exp);
        }
    }

    //得到待排序数组中的最大值
    private static int getMax(int[] nums){
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }

    //计数排序
    private static void countSort(int[] A, int exp){
        int[] C = new int[10];
        int[] B = new int[A.length];

        for(int i = 0; i < A.length; i++){
            C[A[i] / exp % 10]++;
        }
        for(int i = 1; i < C.length; i++){
            C[i] += C[i-1];
        }
        for(int i = A.length - 1; i >= 0; i--){
            B[C[A[i] / exp % 10] - 1] = A[i];
            C[A[i] / exp % 10]--;
        }
        for(int i = 0; i < A.length; i++){
            A[i] = B[i];
        }
    }
}
