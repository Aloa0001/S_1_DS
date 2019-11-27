package merge_sort;

/**
 * https://www.geeksforgeeks.org/iterative-merge-sort/
 */
public class MergeSort_Iterative {

    public static void mergeSortIterative(int[] arr) {
        int n = arr.length;
        int size;
        int from;

        // Merge subarrays in bottom up manner. First merge subarrays of size 1 to create sorted subarrays of size 2, then merge
        // subarrays of size 2 to create sorted subarrays of size 4, and so on.
        for (size = 1; size <= n - 1; size = 2 * size) {

            // Pick starting point of different subarrays of current size
            for (from = 0; from < n - 1; from += 2 * size) {
                // Find ending point of left subarray. mid+1 is starting point of right
                int mid = Math.min(from + size - 1, n - 1);

                int to = Math.min(from + 2 * size - 1, n - 1);
                // merge array from -> to
                merge(arr, from, mid, to);
            }
        }
    }

    // Function to merge the two haves arr[from..m] and arr[m+1..to] of array arr[]
    private static void merge(int[] arr, int from, int m, int to) {
        int i, j, k;
        int n1 = m - from + 1;
        int n2 = to - m;

        // create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temp arrays left[] and right[]
        System.arraycopy(arr, from , left, 0, n1);
        System.arraycopy(arr, m + 1, right, 0, n2);

        // Merge the temp arrays back into arr[from..to]
        i = 0;
        j = 0;
        k = from;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        // Copy the remaining elements of left[], if there are any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        // Copy the remaining elements of right[], if there are any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    /**
     * Test Driver method
     *
     * @param args .
     */
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 9, 3, 2, 9, 1, 6, 5, 4, 45, 56, 98, 87, 9, 43, 45, 423, 32, 12};
        mergeSortIterative(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
