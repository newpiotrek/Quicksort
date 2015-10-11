package com.company;

/**
 * Created by Piotr on 11/10/2015.
 */
public class Quicksort {
    private int[] numbers;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        int number = values.length;
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
