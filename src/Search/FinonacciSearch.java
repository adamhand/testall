package Search;

public class FinonacciSearch {
    //构造一个长度为20的斐波那契数组
    private static int[] fibonacci(){
        int[] f = new int[20];
        f[0] = f[1] = 1;
        for(int i = 2; i < f.length; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int finonacciSearch(int[] arr, int target){
        int left = 0, mid = 0, right = arr.length - 1;
        int k = 0;
        int[] f = fibonacci();
        //找到大于arr.length且最接近arr.length的斐波那契数
        while(arr.length > f[k] - 1)
            k++;
        //构造长度为f[k]-1的新数组
        int[] temp = new int[f[k] - 1];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        //用原数组最右边的数填充新数组的看过你白
        for(int i = arr.length; i < f[k] - 1; i++){
            temp[i] = arr[right];
        }

        while(left <= right){
            mid = left + f[k - 1] - 1;

            if(temp[mid] > target){
                right = mid - 1;
                k -= 1;
            }else if(temp[mid] < target){
                left = mid + 1;
                k -= 2;
            }else {
                if(mid <= right)    // 若相等则说明mid即为查找到的位置
                    return mid;
                else
                    return right;  // mid的值已经大于right,进入扩展数组的填充部分,即最后一个数就是要查找的数。
            }
        }
        return -1;
    }
}
