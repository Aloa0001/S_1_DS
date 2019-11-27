package test;

import insertion_sort.InsertionSort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_InsertionSort {
    private static int[] arr;
    private static Integer[] arr100 = new Integer[100];
    private static Integer[] arr10000 = new Integer[10000];
    private static Integer[] arr1000000 = new Integer[1000000];

    public static void main(String[] args) {
        //populate the arrays
        readFile();
        /**iterative insertin sort*/
        insertionSortIterative(arr100,1000000);
        insertionSortIterative(arr10000,10000);
        insertionSortIterative(arr1000000,1);
        /**recursive insertion sort*/
        insertionSortRecursive(arr100,1000000);
        insertionSortRecursive(arr10000,10000);
        insertionSortRecursive(arr1000000,1);
       /* for (int x : arr10000){
            System.out.println(x);
        }*/
    }
    private static void insertionSortRecursive(Integer[] arr, int iterations){
        MyTimer timer = new MyTimer();
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            InsertionSort.insertionSortRecursive(arr, 1);
        }
        timer.stopTimer();
        System.out.println("Average time for recursive insertion sort, input "+arr.length+
                " ,iterations: "+iterations+"/ is: "+timer.getTime()/iterations+" nanoseconds");
    }
    private static void insertionSortIterative(Integer[] arr, int iterations){
        MyTimer timer = new MyTimer();
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            InsertionSort.insertionSortIterative(arr);
        }
        timer.stopTimer();
        System.out.println("Average time for recursive insertion sort, input "+arr.length+
                " ,iterations: "+iterations+"/ is: "+timer.getTime()/iterations+" nanoseconds");
    }
    /**
     * copy the file nbr into the
     */
    private static void readFile() {
        try {
            arr = Files.lines(Paths.get("Numbers.txt")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000000; i++) {
            if (i < 100) {
                arr100[i] = Integer.valueOf(arr[i]);
            }
            if (i < 10000) {
                arr10000[i] = Integer.valueOf(arr[i]);
            }
            arr1000000[i] = Integer.valueOf(arr[i]);
        }
    }
}
