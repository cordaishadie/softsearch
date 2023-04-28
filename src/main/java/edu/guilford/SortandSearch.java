package edu.guilford;

public class SortandSearch {
    // add a static selectionSort method that takes an array of integers as a parameter
    // and sorts the array using the selection sort algorithm
    public static void selectionSort(int[] array) {
        // loop over all elements in the array and find the smallest one
        // swap the smallest element with the first element
        // repeat for all elements in the array except the last one
        for (int i = 0; i < array.length; i++) {
            // find the smallest element in the array
            int smallest = i; // keeping track of the index of the smallest element, not its value
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }
            // swap the smallest element with the first element
            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }
    }

    // add a static quickSort method that takes an array of integers as a parameter
    // and sorts the array using the quick sort algorithm
    public static void quickSort(int[] array) {
        // call the recursive quickSort method
        quickSort(array, 0, array.length - 1);
    }

    // add a static quickSort method that takes an array of integers as a
    // parameter and sorts the array using the quick sort algorithm
    // this method is recursive
    public static void quickSort(int[] array, int start, int end) {
        // if the array has 1 or 0 elements, it is already sorted
        if (start >= end) {
            return;
        }
        // partition the array
        int pivot = partition(array, start, end);
        // sort the left half of the array
        quickSort(array, start, pivot - 1);
        // sort the right half of the array
        quickSort(array, pivot + 1, end);
    }

    // add a partition method that takes an array of integers as a
    // parameter and partitions the array using the quick sort algorithm
    public static int partition(int[] array, int start, int end) {
        // choose the last element in the array as the pivot
        int pivot = array[end];
        // set the partition index to the start of the array
        int partitionIndex = start;
        // loop over all elements in the array
        for (int i = start; i < end; i++) {
            // if the current element is smaller than the pivot
            if (array[i] < pivot) {
                // iswap the current element with the element at the partition index
                swap(array, i, partitionIndex);
                // increment the partition index
                partitionIndex++;
            }
        }
        // swap the partition index with the pivot
        swap(array, partitionIndex, end);
        // return the partition index
        return partitionIndex;
    }


    // let's create a method that swaps two elements in an array
    public static void swap(int[] array, int i, int j) {
        // swap the elements at index i and j in the array
        // create a temporary variable to hold the value array[i]
        int temp = array[i];
        // set array[i] to array[j]
        array[i] = array[j];
        // set array[j] to temp
        array[j] = temp;
    }

    // add alinear or sequential search algorithm
    public static int linearSearch(int[] array, int target) {
        // loop over all elements in the array
        // we're going to go though each element one at a a time and 
        // stop when we find what we're looking for
        for (int i = 0; i < array.length; i++) {
            // if the current element is equal to the target
            if (array[i] == target) {
                // return the index of the current element
                return i;
            }
        }
        // if the target is not found, return -1 (we get to the end of the array
        // and haven't found the target)
        return -1;
    }

    // add a binary search algorithm
    public static int binarySearch(int[] array, int target) {
        // set the start index to 0
        int start = 0;
        // set the end index to the last index in the array
        int end = array.length - 1;
        // loop over all elements in the array
        while (start <= end) {
            // set the middle index to the middle of the array
            int middle = (start + end) / 2;
            // if the middle element is equal to the target
            if (array[middle] == target) {
                // return the index of the middle element
                return middle;
            }
            // if the middle element is greater than the target
            if (array[middle] > target) {
                // set the end index to the middle index - 1
                end = middle - 1;
            }
            // if the middle element is less than the target
            if (array[middle] < target) {
                // set the start index to the middle index + 1
                start = middle + 1;
            }
        }
        // if the target is not found, return -1 (we get to the end of the array
        // and haven't found the target)
        return -1;
    }

}
