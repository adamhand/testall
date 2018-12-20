package Sort;

public class QuickSort {
/*    public static void sort(int[] nums, int left, int right){
        if(left > right){
            return;
        }
        dealPivot(nums, left, right);
        int pivIndex = right - 1;
        int head = left, tail = right - 1;
        while(head < tail){
            while(head <= tail && nums[++head] < nums[pivIndex]);
            while(tail > left && nums[--tail] > nums[pivIndex]);
            if(head < tail){
                SortUtils.swap(nums, head, tail);
            }
        }
//        while (true){
//            while(nums[++head] < nums[pivIndex]);
//            while(tail > left && nums[--tail] > nums[pivIndex]);
//            if(head < tail){
//                SortUtil.swap(nums, head, tail);
//            }else {
//                break;
//            }
//        }
        if(head < right){
            SortUtils.swap(nums, head, right - 1);
        }
        sort(nums, left,head - 1);
        sort(nums, head + 1, right);
    }

    *//**
     *
//     * @param nums
     * @param left
     * @param right:数组右边界，即nums.length - 1
     *//*
    public static void dealPivot(int[] nums, int left, int right){
        int mid = (left + right) / 2;
        if(nums[left] > nums[mid]){
            SortUtils.swap(nums, left, mid);
        }
        if(nums[left] > nums[right]){
            SortUtils.swap(nums, left, right);
        }
        if(nums[mid] > nums[right]){
            SortUtils.swap(nums, mid, right);
        }
        //将pivot放在倒数第二个元素的位置上
        SortUtils.swap(nums, mid, right - 1);
    }*/

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            //获取枢纽值，并将其放在当前待处理序列末尾
            dealPivot(arr, left, right);
            //枢纽值被放在序列末尾
            int pivot = right - 1;
            //左指针
            int i = left;
            //右指针
            int j = right - 1;
            while (true) {
                while (arr[++i] < arr[pivot]) {
                }
                while (j > left && arr[--j] > arr[pivot]) {
                }
                if (i < j) {
                    SortUtils.swap(arr, i, j);
                } else {
                    break;
                }
            }
            if (i < right) {
                SortUtils.swap(arr, i, right - 1);
            }
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }

    }

    /**
     * 处理枢纽值
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            SortUtils.swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            SortUtils.swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            SortUtils.swap(arr, right, mid);
        }
        SortUtils.swap(arr, right - 1, mid);
    }
}
