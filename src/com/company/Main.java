package com.company;

import java.util.Arrays;
import java.util.Random;

class Main {

    public static void main(String[] args) {
        QuicksortTest sortTest = new QuicksortTest();
        sortTest.testNull();
        sortTest.printResult(numbers);
    }

    /**
     * Created by piotrek on 02/10/2015.
     */

    public static class Quicksort {
        private int[] numbers;
        private int number;

        public void sort(int[] values) {
            // check for empty or null array
            if (values == null || values.length == 0) {
                return;
            }
            this.numbers = values;
            number = values.length;
            quicksort(0, number - 1);
        }

        private void quicksort(int low, int high) {
            int i = low, j = high;
            //Get the pivot element from the pivot of the list
            int pivot = numbers[low + (high - low) / 2];

            //Divide into two lists
            while (i <= j) {
                //If the current value from the left is smaller then the pivot
                //element then get the next element from the left list
                while (numbers[i] < pivot) {
                    i++;
                }
                //If the current element is larger then the pivot
                //get the next element from right list
                while (numbers[j] > pivot) {
                    j--;
                }
                //When we found an element from a left list which is bigger
                // then the pivot and we found element from the right list
                // which is lower then the pivot we exchange them
                //We also increase i and lower j by one
                if (i <= j) {
                    exchange(i, j);
                    i++;
                    j--;
                }
            }
            if (low < j)
                quicksort(low, j);
            if (i < high)
                quicksort(i, high);
        }

        private void exchange(int i, int j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    public static class QuicksortTest {
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
                fail("Should not happen");
            }
            assertTrue(true);
        }

        @Test
        public void testSpecial() {
            Quicksort sorter = new Quicksort();
            int[] test = {5, 5, 6, 6, 4, 4, 5, 5, 6, 6, 4, 4, 5, 5};
            sorter.sort(test);
            if (!validate(test)) {
                fail("Should not happen");
            }
            printResult(test);
        }

        @Test
        public void testStandardSort() {
            long startTime = System.currentTimeMillis();
            Arrays.sort(numbers);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Standard Java sort " + elapsedTime);
            if (!validate(numbers)) {
                fail("Should not happen");
            }
            assertTrue(true);
        }

        private boolean validate(int[] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    return false;
                }
                return true;
            }
        }

        private void printResult(int[] numbers) {
            for (int number : numbers) {
                System.out.print(number);
            }
            System.out.println();
        }
    }
}
