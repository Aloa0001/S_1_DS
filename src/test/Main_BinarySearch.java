package test;

import binary_search.BinarySearch;
import merge_sort.MergeSort_Recursive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main_BinarySearch {
    private static int[] arr1000000;
    private static int[] arr10000;
    private static int[] arr100;
    private static MyTimer timer = new MyTimer();

    public static void main(String[] args) {
        readFile();
        mergeSortRecursive(arr1000000,1);
        timer.startTimer();
        System.out.println(BinarySearch.binarySearch(arr1000000, 144));
        timer.stopTimer();
        System.out.println("Binary search time: "+timer.getTime()+" nanoseconds");

        mergeSortRecursive(arr10000,1);
        timer.startTimer();
        System.out.println(BinarySearch.binarySearch(arr10000, 144));
        timer.stopTimer();
        System.out.println("Binary search time: "+timer.getTime()+" nanoseconds");

        mergeSortRecursive(arr100,1);
        timer.startTimer();
        System.out.println(BinarySearch.binarySearch(arr100, 144));
        timer.stopTimer();
        System.out.println("Binary search time: "+timer.getTime()+" nanoseconds");
    }
    private static void mergeSortRecursive(int[] arr, int iterations){
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            MergeSort_Recursive.sortRecursive(arr, 0, arr.length - 1);
        }
        timer.stopTimer();
        System.out.println("Average time for recursive merge sort, input "+arr.length+
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
