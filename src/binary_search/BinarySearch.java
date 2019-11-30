package binary_search;

import merge_sort.MergeSort_Recursive;
import java.util.Arrays;

/**
 * @author alexo
 */

public class BinarySearch {


    public static boolean binarySearchRecursive(int[] arr, int search){
        if (search > arr[arr.length - 1] || search < arr[0]){
            return false;
        }else if(arr.length < 2){
            return arr[0] == search;
        }else if (arr.length > 2){
            if (arr[arr.length / 2] == search){
                return true;
            }else if (arr[arr.length / 2] > search){
                int[] left = Arrays.copyOf(arr,arr.length / 2);
                return binarySearchRecursive(left,search);
            }else{
                int[] right = Arrays.copyOfRange(arr,arr.length / 2 + 1,arr.length);
                return binarySearchRecursive(right,search);
            }
        }else{
            return false;
        }
    }
/**
 * https://medium.com/@gustavo.ponce.ch/binary-search-with-java-recursive-iterative-java-collections-5a12a814a27c
 * */
    public static boolean binarySearchIterative( int[] array, int search) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (search < array[middle]) {
                end = middle - 1;
            }
            if (search > array[middle]) {
                start = middle + 1;
            }
            if (search == array[middle]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test Driver method
     *
     * @param args .
     */
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 9, 3, 2, 9, 1, 6, 5, 4, 45, 56, 98, 87, 9, 43, 45, 423, 32, 12};
        MergeSort_Recursive.sortRecursive(arr,0,arr.length-1);
        System.out.println(binarySearchRecursive(arr, 424));
        System.out.println(binarySearchIterative(arr, 424));
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
