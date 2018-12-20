package Sort;

import java.util.ArrayList;

//使用桶排序的LSD基数排序
public class LSDRadisSort {
    public static void sort(int[] A){
        int max = A[0];
        for(int i = 1; i < A.length; i++){
            max = A[i] > max ? A[i] : max;
        }
        int bucketNum = 10;                 //桶的个数
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketList.add(new ArrayList<Integer>());
        }

        //从低位到高位依次入桶和出桶
        for(int exp = 1; max / exp > 0; exp *= 10){
            for(int i = 0; i < A.length; i++){
                int num = A[i] / exp % 10;
                bucketList.get(num).add(A[i]);
            }

            int j = 0;
            for(ArrayList<Integer> arr : bucketList){
                for(int i : arr){
                    A[j++] = i;
                }
                arr.clear();           //记得清空，否则会有重复元素
            }
        }
    }
}
