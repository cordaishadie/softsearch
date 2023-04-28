package edu.guilford;

import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class SoftSearch {
    public static void main(String[] args) {
        // define two constants MAX (number of elements in array)
        // and RANGE (range of random numbers)
        // MAX = 10000
        // RANGE = 5000000
        final int MAX = 20000;
        final int RANGE = 50000;
        Random rand = new Random();

        // create an array of MAX integers with random assigned values in RANGE
        int[] array = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            array[i] = rand.nextInt(1, RANGE + 1);
        }

        // System.out.println("Original: " + Arrays.toString(array));
        // time how long it takes to sort the array
        long startTime = System.nanoTime();
        // Sort the array using the selection sort algorithm
        SortandSearch.selectionSort(array);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Selection sort took " + (duration / 1.e6) + " milliseconds");
        // System.out.println("Sorted: " + Arrays.toString(array));

        // shuffle the array for the next test
        shuffle(array);
        // sort the array using quicksort
        startTime = System.nanoTime();
        SortandSearch.quickSort(array);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Quick sort took " + (duration / 1.e6) + " milliseconds");

        // shuffle the array for the next test
        shuffle(array);
        // use linear search to find a random value
        int randomValue = rand.nextInt(1, RANGE + 1);
        startTime = System.nanoTime();
        int index = SortandSearch.linearSearch(array, randomValue);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Linear search took " + (duration / 1.e6) + " milliseconds");
        System.out.println("Found " + randomValue + " at index " + index);

        // to use binary search, the array must be sorted
        // sort the array using quicksort
        SortandSearch.quickSort(array);
        // we only have to do the sort once, and then we can do as many searches as we want
        // use binary search to find the same value as before
        startTime = System.nanoTime();
        index = SortandSearch.binarySearch(array, randomValue);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Binary search took " + (duration / 1.e6) + " milliseconds");
        System.out.println("Found " + randomValue + " at index " + index);
    }

    // add a static method to shuffle the array
    public static void shuffle(int[] array) {
        // loop over all elements in the array
        // swap the current element with a random element in the array
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            // generate a random index between 0 and array.length - 1
            int randomIndex = (int) (Math.random() * array.length);
            // swap the current element with the element at randomIndex
            swap(array, i, randomIndex);
        }
    }

    // add a static method to swap two elements in an array
    public static void swap(int[] array, int i, int j) {
        // swap the elements at index i and j in the array
        // create a temporary variable to hold the value array[i]
        int temp = array[i];
        // set array[i] to array[j]
        array[i] = array[j];
        // set array[j] to temp
        array[j] = temp;
    }
}
