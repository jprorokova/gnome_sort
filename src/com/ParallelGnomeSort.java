package com;

import java.util.concurrent.*;

public class ParallelGnomeSort {
    private static long start;
    private static long end;

    public static <T extends Comparable<T>> void parallelGnomeSort(T[] arr, int numThreads) {
        int size = arr.length;
        if (size < 2) {
            return;
        }

        int chunkSize = (size + numThreads - 1) / numThreads;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        start = System.currentTimeMillis();
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = Math.min(startIndex + chunkSize, size);
            if (startIndex >= endIndex) {
                break;
            }
            executor.submit(() -> sequentialGnomeSort(arr, startIndex, endIndex));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Error waiting for thread pool shutdown");
            e.printStackTrace();
        }

        if (size >= numThreads) {
            for (int i = 0; i < size; i++) {
                int j = i;
                while (j > 0 && arr[j - 1].compareTo(arr[j]) > 0) {
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    j--;
                }
            }
        }

        System.out.println((System.currentTimeMillis() - start));
    }

    private static <T extends Comparable<T>> void sequentialGnomeSort(T[] arr, int startIndex, int endIndex) {
        for (int i = startIndex + 1; i < endIndex; ) {
            if (arr[i - 1].compareTo(arr[i]) <= 0) {
                i++;
            } else {
                T temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                if (i > startIndex + 1) {
                    i--;
                }
            }
        }

    }

}

