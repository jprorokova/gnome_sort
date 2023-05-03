package com;

import java.util.Random;

public class Utils {
    private static final Random random = new Random();

    public static Integer[] generateRandomIntArray(int length, int minValue, int maxValue) {
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return arr;
    }
}