package merge_sort;

/**
 * https://www.geeksforgeeks.org/merge-sort/
 */

public class MergeSort_Recursive {

    /**
     * Merge two halves of array
     * @param arr  input
     * @param from starting with
     * @param m middle of the list
     * @param to up to
     */
    public static void merge(int arr[], int from, int m, int to) {
        // Find sizes of two subarrays to be merged
        int n1 = m - from + 1;
        int n2 = to - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(arr, from , L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = from;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sortRecursive (int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sortRecursive(arr, l, m);
            sortRecursive(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /**
     * Test Driver method
     *
     * @param args .
     */
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 9, 3, 2, 9, 1, 6, 5, 4, 45, 56, 98, 87, 9, 43, 45, 423, 32, 12};
        sortRecursive(arr, 0, arr.length-1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
