package Sort;

public class TestSort {
    public static void main(String[] args) {
        //int[] nums = {34, 19, 11, 109, 3, 56};
        int[] nums = {34, 19, 11, 14, 3, 56};

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }

        System.out.println();
//        BirdSort.sort(nums);
//        BoobleSort.sort(nums);
//        SelectionSort.sort(nums);
//        InsertSort.sort(nums);
//        InsertionSortDichotomy.sort(nums);
//        ShellSort.sort(nums);
//        MergeSort.sortRecursion(nums, 0, nums.length - 1);
//        MergeSort.sortIteration(nums);
//        CocktailSort.sort(nums);
        HeapSort.sort(nums);
//        QuickSort.sort(nums, 0, nums.length - 1);
//        int[] B = CountSort.sort(nums);
//        RadixSort.sort(nums);
//        BucketSort.sort(nums);
//        LSDRadisSort.sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }

    }
}
