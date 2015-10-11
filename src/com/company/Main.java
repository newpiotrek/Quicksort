package com.company;

import java.util.Arrays;
import java.util.Random;

class Main {

    public static void main(String[] args) {
        QuicksortTest sortTest = new QuicksortTest();
        try {
            sortTest.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sortTest.testNull();
        /*sortTest.printResult();
        Quicksort sortNumbers = new Quicksort();
        sortNumbers.sort(sortTest.getNumbers());
        sortTest.printResult();*/
        sortTest.testQuickSort();
        // bla bla
        // bla bla 13432432
    }

    /**
     * Created by piotrek on 02/10/2015.
     */




}
