package com;

public class SingleThreadGnomeSort {
    public static <T extends Comparable<T>> void gnomeSort(T[] arr) {
        long start = System.currentTimeMillis();
        int index = 0;
        while (index < arr.length) {
            if (index == 0) {
                index++;
            } else if (arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                swap(arr, index, index - 1);
                index--;
            }
        }

        System.out.println("Time spent: " + (System.currentTimeMillis() - start) + " mills.");
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



