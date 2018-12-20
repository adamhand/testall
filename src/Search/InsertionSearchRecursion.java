package Search;

//插值查找的递归实现，待查找数组有小到大排列
public class InsertionSearchRecursion {
    public static int search(int[] A, int target, int left, int right){
        int mid = left + (target - A[left]) / (A[right] - A[left]) * (right - left);
        if(A[mid] == target)
            return mid;
        else if(A[mid] > target)
            return search(A, target, left, mid - 1);
        else
            return search(A, target, mid + 1, right);
    }
}
