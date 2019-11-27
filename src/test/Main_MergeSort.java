package test;

import merge_sort.MergeSort_Iterative;
import merge_sort.MergeSort_Recursive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main_MergeSort {
    private static int[] arr1000000;
    private static int[] arr10000;
    private static int[] arr100;

    public static void main(String[] args) {
        readFile();
        /**iterative insertin sort*/
        mergeSortIterative(arr100,1000000);
        mergeSortIterative(arr10000,10000);
        mergeSortIterative(arr1000000,10);
        /**recursive insertion sort*/
        mergeSortRecursive(arr100,1000000);
        mergeSortRecursive(arr10000,10000);
        mergeSortRecursive(arr1000000,10);

    }
    private static void mergeSortRecursive(int[] arr, int iterations){
        MyTimer timer = new MyTimer();
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            MergeSort_Recursive.sortRecursive(arr, 0, arr.length - 1);
        }
        timer.stopTimer();
        System.out.println("Average time for recursive merge sort, input "+arr.length+
                " ,iterations: "+iterations+"/ is: "+timer.getTime()/iterations+" nanoseconds");
    }
    private static void mergeSortIterative(int[] arr, int iterations){
        MyTimer timer = new MyTimer();
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            MergeSort_Iterative.mergeSortIterative(arr);
        }
        timer.stopTimer();
        System.out.println("Average time for iterative merge sort, input "+arr.length+
                " ,iterations: "+iterations+"/ is: "+timer.getTime()/iterations+" nanoseconds");
    }

    /**
     * copy the file nbr into the
     */
    private static void readFile() {
        try {
            arr1000000 = Files.lines(Paths.get("Numbers.txt")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        arr10000 = Arrays.copyOf(arr1000000, 10000);
        arr100 = Arrays.copyOf(arr1000000, 100);

    }
}
