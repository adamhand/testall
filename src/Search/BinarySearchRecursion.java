package Search;

public class BinarySearchRecursion {
    public static int search(int[] arr, int target, int left, int right){
        if(left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return search(arr, target, mid + 1, right);
        }else {
            return search(arr, target, left, mid - 1);
        }
    }
}
