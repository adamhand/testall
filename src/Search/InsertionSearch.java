package Search;

//待查找的数组由小到大排列
public class InsertionSearch {
    public static int search(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int mid = 0;
        if(target > arr[right])
            return -1;
        while(left <= right){
            mid = left + (target - arr[left]) / (arr[right] - arr[left]) * (right - left);
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
