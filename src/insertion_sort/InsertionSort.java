package insertion_sort;

public class InsertionSort {
    /**
     * Iterative inserytion sort
     *
     * @param arr list
     * @param <E> type
     */
    public static <E extends Comparable<? super E>> void insertionSortIterative(E[] arr) {
        int k;
        for (int i = 1; i < arr.length; i++) {
            E temp = arr[i];
            for (k = i; k > 0 && temp.compareTo(arr[k - 1]) < 0; k--) {
                arr[k] = arr[k - 1];
            }
            arr[k] = temp;
        }
    }

    /**
     * @author https://www.geeksforgeeks.org/insertion-sort/
     * iterative
     */
    public static void sort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            //Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * recursive insertion sort
     * @param arr list
     * @param pointer the current to be compared
     * @param <E> type
     */
    public static <E extends Comparable<? super E>> void insertionSortRecursive(E[] arr, int pointer) {

        if (pointer < arr.length ) {
            int counter = pointer;
            while (arr[counter-1].compareTo(arr[counter]) > 0) {
                E tmp = arr[counter];
                arr[counter] = arr[counter-1];
                arr[counter-1] = tmp;
                if (counter > 1)
                    counter--;
            }
            if(pointer < arr.length-1)
                insertionSortRecursive(arr, pointer+1);
        }
    }


    /**
     * Test Driver method
     *
     * @param args .
     */
    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 9, 3, 2, 9, 1, 6, 5, 4,45,56,98,87,9,43,45,423,32,12,
                34,46,786,45,3,4,5,6,7,2,3,1,0,34,98,99,43,23,87, 3, 2, 1, 0};
        insertionSortIterative(arr);
        //insertionSortRecursive(arr, 1);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
