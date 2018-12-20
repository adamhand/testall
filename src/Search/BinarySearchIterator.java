package Search;

public class BinarySearchIterator {
    public static int search(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
