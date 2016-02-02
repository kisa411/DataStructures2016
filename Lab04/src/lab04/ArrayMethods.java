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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        int[] test = {3,6,87,35,0,14,22,67,92,11};           // a test array - unsorted
//        System.out.println(Arrays.toString(test));
//       
//        int[] test1 = test.clone(); //clone of test array for insertion sort
//        int[] test2 = test.clone(); //clone of test array for selection sort
//        System.out.println(Arrays.toString(test2));
//        int[] test3 = test.clone(); //clone of test array for bubble sort
        
//        insertionSort(test1);                                 // insertion sort test 1
//        System.out.println(Arrays.toString(test1));
//        
//        selectionSort(test2);                                 // selection sort test 2
//        System.out.println(Arrays.toString(test2));
//        
//        bubbleSort(test3);                                 // bubble sort test 3
//        System.out.println(Arrays.toString(test3));
        
        /*checking the running time of the sorting algorithms*/
        Random rand = new Random();                           // pseudorandom # generator
        rand.setSeed(System.currentTimeMillis());             // set seed for rand
        
        int[] rtest = new int[75000];
        //fill test2 with pseudorandom integers from 0 to 99 inclusive
        for (int i=0; i<rtest.length; i++) {
            rtest[i] = rand.nextInt(100);                     // getting next random #
        }
//        System.out.println("Generated random array is: ");
//        System.out.println(Arrays.toString(rtest));
        
        //create clones of the random test array for the other sorting algorithms to sort the arrays
        int[] rtest1 = rtest.clone();
        int[] rtest2 = rtest.clone();
        int[] rtest3 = rtest.clone();
                
        //time the insertionSort method
        long startTime = System.currentTimeMillis();          // save current time
        insertionSort(rtest1); 
        long endTime = System.currentTimeMillis();            // save current time
        System.out.println("Insertion Sort Time: "); 
        System.out.println(endTime - startTime);              // find elasped time
//        System.out.println(Arrays.toString(rtest1));
        
        //time the selectionSort method
        long startTime2 = System.currentTimeMillis();          // save current time
        selectionSort(rtest2); 
        long endTime2 = System.currentTimeMillis();            // save current time
        System.out.println("Selection Sort Time: "); 
        System.out.println(endTime2 - startTime2);              // find elasped time
//        System.out.println(Arrays.toString(rtest2));
        
         //time the bubbleSort method
        long startTime3 = System.currentTimeMillis();          // save current time
        bubbleSort(rtest3); 
        long endTime3 = System.currentTimeMillis();            // save current time
        System.out.println("Bubble Sort Time: "); 
        System.out.println(endTime3 - startTime3);              // find elasped time
//        System.out.println(Arrays.toString(rtest3));
        
        
        
    }
    
}
