package Sort;

public class CountSort {
    public static int[] sort(int[] A){
        int[] C = new int[100];            //排序的数最大值不能超过100
        int[] B = new int[A.length];       //存放排序后的结果

        for(int i = 0; i < A.length; i++){  // 统计A中各元素个数，存入C数组
            C[A[i]]++;
        }

        for(int i = 1; i < C.length; i++){
            C[i] += C[i - 1];
        }

        for(int i = A.length - 1; i >= 0; i--){
            B[C[A[i]] - 1] = A[i];      //将A中该元素放到排序后数组B中指定的位置
            C[A[i]]--;                  //将C中该元素-1，方便存放下一个同样大小的元素
        }

        return B;
    }
}
