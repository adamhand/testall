package Sort;

public class HeapSort {
    public static void sort(int[] nums){
        //1.构建大顶堆
        for(int i = nums.length / 2 - 1; i >= 0; i--){
            adjustHeap(nums, i, nums.length);              //从第一个非叶子结点从下至上，从右至左调整结构
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = nums.length - 1; j > 0; j--){
            SortUtils.swap(nums, 0, j);           //将堆顶元素与末尾元素进行交换
            adjustHeap(nums, 0, j);               //重新对堆进行调整。j表示的是需要排列的数组的长度，每次讲最后一个踢出去，因为已经是最大。
        }
    }

    /**
     * 调整大顶堆。只是调整，建立在大顶堆已经构建的基础上。
     * @param nums：存储堆元素的数组
     * @param i：从第i个元素开始调整
     * @param length：数组的长度
     */
    public static void adjustHeap(int[] nums, int i, int length){
        int temp = nums[i];
        for(int j = 2*i+1; j < length; j = j*2+1){            //从当前节点nums[i]的左子节点即nums[2*i+1]开始，如果当前节点的左子节点还有左子节点，继续寻找(j=j*2+1)
            if((j + 1) < length && nums[j] < nums[j + 1]){    //如果左子结点小于右子结点，j指向右子结点
                j++;
            }
            if(nums[j] > temp){                               //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                nums[i] = nums[j];
                i = j;
            }
        }
        nums[i] = temp;                                       //将当前元素放到合适的位置
    }

    public static void main(String[] args) {
        int[] nums = {9,5,6,3,7,8,4,1,2};
        HeapSort.sort(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i]+" ");
    }
}
