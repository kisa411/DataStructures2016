/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

import java.util.Arrays;
import java.util.Random;

/**
 * Implementation of Insertion Sort, Selection Sort, and Bubble Sort
 * @author kisa411
 */
public class ArrayMethods {

    /**
     * Insertion-sort of an array of integers into nondecreasing order 
     * @param data the array to sort
     */
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {            // begin with second character
          int cur = data[k];                     // time to insert cur = data[k]
          int j = k;                             // find correct index j for cur
          while (j > 0 && data[j-1] > cur) {     // thus, data[j-1] must go after cur
            data[j] = data[j-1];                 // slide data[j-1] rightward
            j--;                                 // and consider previous j for cur
          }
          data[j] = cur;                         // this is the proper place for cur
        }
    }
      
    /**
     * Selection Sort method into nondecreasing order
     * @param data the array to sort
     */
    public static void selectionSort(int[] data) {
        int n = data.length;
        
        for( int k = 0; k < (n-1); k++ ) { //go through array of integers  
            int index = k;
            for( int j=(k+1); j<n; j++ ) {
                if( data[j] < data[index] ) { //if the element is smaller than the element to its left
                    index = j;
                }
            }
            int minimum = data[index]; //minimum is the index at which the element is the smallest
            data[index] = data[k]; //put the index location element where the smallest number used to be
            data[k] = minimum; //swap out the values - minimum is now at the index location, element that was in the index locatino is now the smallest number (but not really)    
        }
    }
    
      
    /**
     * Bubble Sort method into nondecreasing order
     * @param data the array to sort
     */
    public static void bubbleSort(int[] data) {
        int n = data.length;
        int temp;
        boolean switchValues = true;
        
        while( switchValues ) {
            switchValues = false;
            
            for( int j=0; j<(n-1); j++ ) { //starting from the first element, compare the element at position j and j+!
                if( data[j] > data[j+1] ) { //if element at position j is greater than element at position j+1, then it's switched
                    temp = data[j]; //store the left element in a temporary variable
                    data[j] = data[j+1]; //store the right element into where the left element was
                    data[j+1] = temp; //put the temporary variable in the right element's space
                    switchValues = true;
                }
            }
        }
    }   
    
    /**
     * Wrapper method for quicksort sorting algorithm
     * @param data to sort
     */ 
    public static void quickSort(int[] data) {
        int n=data.length;
        quickSort(data, 0, n-1); 
    }
    
    /**
     * QuickSort method - binary recursive algorithm for sorting
     * @param data to sort
     * @param low left end
     * @param high right end
     */
    private static void quickSort(int[] data, int low, int high) {
        int ell = low, r = high - 1;                 
        // Note: a lowercase l and the number 1 are very similar -- not good to
        // use as a variable name!
        
        // pivot is at end
        int pivot = data[high];                      
        // Divide into higher/lower portions
        while (ell <= r) { //base case
            // Find an element in left list that's larger than pivot (if exists)
            while (ell <= r && data[ell] < pivot) {
                ell++; //loop will continue to run until it finds an element on the left that's bigger than the pivot
            }
            // Find an element in right list that's smaller than pivot (if exists)
            while (ell <= r && data[r] > pivot) {
                r--; //loop will continue to run until it finds an element on the right that's smaller than the pivot
            }
            // If l is still to the left of r, swap these values
            if (ell <= r) { //Swap the values
                int temp = data[ell]; //store left value
                data[ell] = data[r]; //store right value in left value position
                data[r] = temp; //store temp value (what was previously the left value) in the right value position
                ell++; //increment lower bound
                r--; //decrement upper bound
            }
        }
        //Swap pivot into correct location - put pivot in between l and r
        if(data[ell] >= data[high]) { //if the element at ell is greater than or equal to the pivot value, place pivot before ell
            int temp = data[ell]; 
            data[ell] = data[high];
            data[high] = temp;
        }
        
        // Recursion
        if (low < r) { //sort the lower half 
            quickSort(data, low, r);
        }
        if (ell < high) { //sort the upper half
            quickSort(data, ell, high);
        }
    }

    /**
     * Wrapper method for mergesort sorting algorithm
     * @param data to sort
     */ 
    public static void mergeSort(int[] data) {
        int n=data.length;
        mergeSort(data, 0, n-1); 
    }
    
    /**
     * MergeSort method - binary recursive algorithm for sorting
     * @param data to sort
     * @param low left end
     * @param high right end
     */
    private static void mergeSort(int[] data, int low, int high) {
        int[] helper = new int[data.length];  //new array with same number of indexes as data array  
        
        if (low < high) {                           // base case - otherwise the array is sorted
            int middle = low + (high - low) / 2;    // get middle index
            mergeSort(data, low, middle);           // sort left side
            mergeSort(data, middle + 1, high);      // sort right side
            
            // Now merge both sides:
            for (int i = low; i <= high; i++) {     // copy both parts into a helper array
                helper[i] = data[i];
            }
            
            int i = low;
            int j = middle + 1;
            int k = low;
            // copy the next smallest values from either side back to the array
            // note that helper[low] through helper[middle] is the sorted left half
            // and that helper[middle+1] through helper[high] is the sorted right half 
            while (i <= middle && j <= high) {
                if( helper[i] <= helper[j] ) { //if helper array from lowest value to middle value is smaller than from middle+1 value
                    data[k] = helper[i]; //assign lowest value in data array to the helper lowest value 
                    i++; //increment i so that you can look at the next lowest value
                } else {
                    data[k] = helper[j];
                    j++;
                }
                k++;
            }
            // Copy the rest of the left side of the array into the target array
            // Note: only left side can have entries left, and only at most one,
            //       in the case that the previous array size was odd
            while (i <= middle) {
            data[k] = helper[i];
            k++;
            i++;
            }   
        } //end if

        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] test = {3,6,87,35,0,14,22,67,92,11};           // a test array - unsorted
        System.out.println(Arrays.toString(test));
       
        int[] test1 = test.clone(); //clone of test array for insertion sort
        int[] test2 = test.clone(); //clone of test array for selection sort
//        System.out.println(Arrays.toString(test2));
//        int[] test3 = test.clone(); //clone of test array for bubble sort
        
//        mergeSort(test2, 0, test2.length-1);                                 // merge sort test 2
//        System.out.println(Arrays.toString(test2)); 
//        
//        quickSort(test1, 0, test1.length-1);                                 // quick sort test 1
//        System.out.println(Arrays.toString(test1));
        
        
//        insertionSort(test1);                                 // insertion sort test 1
//        System.out.println(Arrays.toString(test1));
//        
//        selectionSort(test2);                                 // selection sort test 2
//        System.out.println(Arrays.toString(test2));
        
//        bubbleSort(test3);                                 // bubble sort test 3
//        System.out.println(Arrays.toString(test3));
//        

        mergeSort(test2);                                                      // merge sort test 2 (using wrapper)
        System.out.println(Arrays.toString(test2)); 
        
        quickSort(test1);                                                      // quick sort test 1 (using wrapper)
        System.out.println(Arrays.toString(test1));
        
        /*checking the running time of the sorting algorithms*/
        Random rand = new Random();                           // pseudorandom # generator
        rand.setSeed(System.currentTimeMillis());             // set seed for rand
        
        int[] rtest = new int[10];
        //fill test2 with pseudorandom integers from 0 to 99 inclusive
        for (int i=0; i<rtest.length; i++) {
            rtest[i] = rand.nextInt(100);                     // getting next random #
        }
//        System.out.println("Generated random array is: ");
//        System.out.println(Arrays.toString(rtest));
        
        //create clones of the random test array for the other sorting algorithms to sort the arrays
//        int[] rtest1 = rtest.clone();
//        int[] rtest2 = rtest.clone();
//        int[] rtest3 = rtest.clone();
//        int[] rtest4 = rtest.clone();
//        int[] rtest5 = rtest.clone();
                
//        //time the insertionSort method
//        long startTime = System.currentTimeMillis();          // save current time
//        insertionSort(rtest1); 
//        long endTime = System.currentTimeMillis();            // save current time
//        System.out.println("Insertion Sort Time: "); 
//        System.out.println(endTime - startTime);              // find elasped time
////        System.out.println(Arrays.toString(rtest1));
//        
//        //time the selectionSort method
//        long startTime2 = System.currentTimeMillis();          // save current time
//        selectionSort(rtest2); 
//        long endTime2 = System.currentTimeMillis();            // save current time
//        System.out.println("Selection Sort Time: "); 
//        System.out.println(endTime2 - startTime2);              // find elasped time
////        System.out.println(Arrays.toString(rtest2));
//        
//        //time the bubbleSort method
//        long startTime3 = System.currentTimeMillis();          // save current time
//        bubbleSort(rtest3); 
//        long endTime3 = System.currentTimeMillis();            // save current time
//        System.out.println("Bubble Sort Time: "); 
//        System.out.println(endTime3 - startTime3);              // find elasped time
////        System.out.println(Arrays.toString(rtest3));

        //time the quickSort method
//        long startTime4 = System.currentTimeMillis();          // save current time
//        quickSort(rtest4, 0, rtest4.length-1); 
//        long endTime4 = System.currentTimeMillis();            // save current time
//        System.out.println("Quick Sort Time: "); 
//        System.out.println(endTime4 - startTime4);              // find elasped time
//        System.out.println(Arrays.toString(rtest4));
        
        //time the mergeSort method
//        long startTime5 = System.currentTimeMillis();          // save current time
//        mergeSort(rtest5, 0, rtest5.length-1); 
//        long endTime5 = System.currentTimeMillis();            // save current time
//        System.out.println("Merge Sort Time: "); 
//        System.out.println(endTime5 - startTime5);              // find elasped time
//        System.out.println(Arrays.toString(rtest5));
        
        
        
    }
    
}
