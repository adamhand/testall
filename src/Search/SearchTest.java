package Search;

public class SearchTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 63, 45, 85, 6, 9};
        int[] arr_two = {1, 2, 6, 9, 45, 63, 85};
        int result = 0;

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
//        result =  SequenceSearch.search(arr, 45);
//        result = BinarySearchRecursion.search(arr_two, 2, 0, arr_two.length-1);
//        result = BinarySearchIterator.search(arr_two, 6);
//        result = InsertionSearch.search(arr_two, 84);
        result = FinonacciSearch.finonacciSearch(arr_two, 3);
//        result = InsertionSearchRecursion.search(arr_two, 84, 0, arr_two.length - 1);
        System.out.printf("result= "+result);

    }
}
