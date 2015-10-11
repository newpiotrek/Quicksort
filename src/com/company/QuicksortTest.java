package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Piotr on 11/10/2015.
 */
public class QuicksortTest {
    private int numbers[];
    private final static int SIZE = 7;
    private final static int MAX = 20;

    /* @Before*/
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    /*@Test*/
    public void testNull() {
        Quicksort sorter = new Quicksort();
        sorter.sort(null);
    }

    /*@Test*/
    public void testEmpty() {
        Quicksort sorter = new Quicksort();
        sorter.sort(new int[0]);
    }

    /*@Test*/
    public void testSimpleElement() {
        Quicksort sorter = new Quicksort();
        int[] test = new int[1];
        test[0] = 5;
        sorter.sort(test);
    }

    /*@Test*/
    public void testQuickSort() {
        for (Integer i : numbers) {
            System.out.println(i + " ");
        }
        long startTime = System.currentTimeMillis();

        Quicksort sorter = new Quicksort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("com.company.Main.Quicksort " + elapsedTime);

        if (!validate(numbers)) {
            System.out.println("Should not happen");
        }
        /*assertTrue(true);*/
    }

    /*@Test*/
    public void testSpecial() {
        Quicksort sorter = new Quicksort();
        int[] test = {5, 5, 6, 6, 4, 4, 5, 5, 6, 6, 4, 4, 5, 5};
        sorter.sort(test);
        if (!validate(test)) {
            System.out.println("Should not happen");
        }
        printResult();
    }

    /*@Test*/
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if (!validate(numbers)) {
            System.out.println("Should not happen");
        }
        /*assertTrue(true);*/
    }

    private boolean validate(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void printResult() {
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    public int[] getNumbers() {
        return numbers;
    }
}
