package Sort;

import com.sun.scenario.effect.Merge;

//归并排序
public class MergeSort {
    //将A[left, mid]和A[mid +1, right]合并在一起，形成一个有序数组
    public static void Merge(int[] A, int left, int mid, int right){
        //int length = A.length;   //注意这里不是这么写
        int length = right - left + 1;
        int temp = 0;
        int[] tmp = new int[length];
        int i = left, j = mid + 1;
        while(i <= mid && j <= right){
            tmp[temp++] = A[i] <= A[j] ? A[i++] : A[j++];   //带等号保证排序的稳定性。
        }
        while(i <= mid){
            tmp[temp++] = A[i++];
        }
        while(j <= right){
            tmp[temp++] = A[j++];
        }
        for(int k = 0; k < length; k++){
            A[left++] = tmp[k];            //注意这里不是A[k]=tem[k]
        }
    }

    /**
     * 归并排序递归操作：自顶向下
     * @param A
     * @param left
     * @param right
     */
    public static void sortRecursion(int[] A, int left, int right){
        if(left == right){
            return;
        }
        int mid = (left + right) / 2;
        sortRecursion(A, left, mid);
        sortRecursion(A, mid + 1, right);
        Merge(A, left, mid, right);
    }

    /**
     * 归并排序迭代操作：自下而上
     * @param A
     */
    public static void sortIteration(int[] A){
        int left, mid, right;                    // 子数组索引,前一个为A[left...mid]，后一个子数组为A[mid+1...right]
        int length = A.length;
        for(int i = 1; i < length; i *= 2){     // 子数组的大小i初始为1，每轮翻倍
            left = 0;
            while(left + i < length){           // 后一个子数组存在(需要归并)
                mid = left + i - 1;
                right = mid + i < length ? mid + i : length - 1;  // 后一个子数组大小可能不够
                Merge(A, left, mid, right);
                left = right + 1;               // 前一个子数组索引向后移动
            }
        }
    }
}
