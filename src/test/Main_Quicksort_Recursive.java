package test;

import quick_sort.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_Quicksort_Recursive {
    private static int[] arr;
    private static Integer[] arr100 = new Integer[100];
    private static Integer[] arr10000 = new Integer[10000];
    private static Integer[] arr1000000 = new Integer[1000000];

    public static void main(String[] args) {
        //populate the arrays
        readFile();
        /**quick sort first pivot*/
        quickFirst(arr100, 10000);
        quickFirst(arr10000, 100);
        quickFirst(arr1000000, 1);
        /**quick sort random pivot*/
        quickRandom(arr100, 10000);
        quickRandom(arr10000, 100);
        quickRandom(arr1000000, 1);
        /**quick sort median pivot*/
        quickMedian(arr100, 10000);
        quickMedian(arr10000, 100);
        quickMedian(arr1000000, 1);
    }

    private static void quickFirst(Integer[] arr, int iterations) {
        MyTimer timer = new MyTimer();
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            QuickSort_First.quicksort(arr);
        }
        timer.stopTimer();
        System.out.println("Average time fot using FIRST pivot, input " + arr.length +
                ", iterations: " + iterations + "/ is: " + timer.getTime() / iterations + " nanoseconds");
    }

    private static void quickRandom(Integer[] arr, int iterations) {
        MyTimer timer = new MyTimer();
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            QuickSort_Random.quicksort(arr);
        }
        timer.stopTimer();
        System.out.println("Average time fot using RANDOM pivot, input " + arr.length +
                ", iterations: " + iterations + "/ is: " + timer.getTime() / iterations + " nanoseconds");
    }

    private static void quickMedian(Integer[] arr, int iterations) {
        MyTimer timer = new MyTimer();
        timer.startTimer();
        for (int i = 0; i < iterations; i++) {
            QuickSort_Median_Of_Three.quicksort(arr);
        }
        timer.stopTimer();
        System.out.println("Average time fot using MEDIAN pivot, input " + arr.length +
                ", iterations: " + iterations + "/ is: " + timer.getTime() / iterations + " nanoseconds");
    }

    /**
     * copy the file random numbers into arrays
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
