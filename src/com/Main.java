package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arrOne = Utils.generateRandomIntArray(100, -200000, 200000);
        Integer[] arrTwo = Utils.generateRandomIntArray(500, -200000, 200000);
        Integer[] arrThree = Utils.generateRandomIntArray(1000, -200000, 200000);
        Integer[] arrFour = Utils.generateRandomIntArray(5000, -200000, 200000);
        Integer[] arrFive = Utils.generateRandomIntArray(10000, -200000, 200000);
        Integer[] arrSix = Utils.generateRandomIntArray(50000, -200000, 200000);
        Integer[] arrSeven = Utils.generateRandomIntArray(100000, -200000, 200000);
        Integer[] arrEight = Utils.generateRandomIntArray(125000, -200000, 200000);


        int num = 32;
        ParallelGnomeSort.parallelGnomeSort(arrOne, num);
        ParallelGnomeSort.parallelGnomeSort(arrTwo, num);
        ParallelGnomeSort.parallelGnomeSort(arrThree, num);
        ParallelGnomeSort.parallelGnomeSort(arrFour, num);
        ParallelGnomeSort.parallelGnomeSort(arrFive, num);
        ParallelGnomeSort.parallelGnomeSort(arrSix, num);
        ParallelGnomeSort.parallelGnomeSort(arrSeven, num);
        ParallelGnomeSort.parallelGnomeSort(arrEight, num);
    }

    public static void printArray(Integer[] arr){
        for(int i = 0; i < arr.length; i++){
            if(i % 25 == 0){
                System.out.print("\n");
            }
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public void testGnomeSort(){
        int size = 1000;
        Integer[] expected = new Integer[size];
        Integer[] actual = new Integer[size];
        for(int i = 0; i < size; i++){
            expected[i] = i;
            actual[i] = size - (i + 1);
        }
        Assert.assertNotEquals(actual, expected);
        ParallelGnomeSort.parallelGnomeSort(actual, 4);
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        Assert.assertEquals(actual, expected);
    }

}
