package quick_sort;

public class QuickSort_First_Iterative{

    /**
     * Select pivot, swap it with the last element of the sorting space
     * and move larger elements after the pivot
     * @param arr list
     * @param low from index
     * @param high to index
     * @param <E>  type
     * @return pivot index
     */
    private static  <E extends Comparable<? super E>> int partition(E[] arr, int low, int high) {
        //set pivot and move it at the back of the sortibg space
        E pivot = arr[low];
        swapReferences(arr, low, high);
        // index of smaller element
        int i = (low - 1);

        // go through all elements of the sorting space
        for (int j = low; j <= high - 1; j++) {
            // If current element is <= to pivot
            if (arr[j].compareTo(pivot) <= 0 ) {
                i++;
                // swap arr[i] and arr[j]
                swapReferences(arr, i, j);
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swapReferences(arr,i+1,high);
        return i + 1;
    }

    /**
     * swapping elements of the array
     * @param array list
     * @param a element
     * @param b element
     * @param <E> type
     */
    private static <E> void swapReferences(E[] array, int a, int b) {
        // a temporary E instance is used to store first element to swap
        E temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * implemeting the sort for both partitions
     * @param arr input
     * @param low  from
     * @param high to
     * @param <E> type
     */
    public static  <E extends Comparable<? super E>> void quickSort(E[] arr, int low, int high) {
        if (low < high) {
            // partIndex is partitioning index
            // arr[partIndex] is the pivot value
            int partIndex = partition(arr, low, high);

            quickSort(arr, low, partIndex - 1);// left partition
            quickSort(arr, partIndex + 1, high);// right partition
        }
    }

    /**
     * Driver method
     * Test
     * @param args .
     */
    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
         quickSort(arr, 0, arr.length-1);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
