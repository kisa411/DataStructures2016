/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A short class to implement heap sort.
 * @author kisa411
 */

package heapsort;

import java.util.Arrays;

public class HeapSort {

    /**
     * implementation of heapSort
     * @param data - elements to be sorted
     */
    public static void heapSort(Integer[] data){
        //make the initial heap - included in heap constructor
        Heap<Integer> heap = new Heap<>(data);
        int j=0;
        
//        System.out.println( heap.toString() ); //heap before sorting should have all the elements
        
        while ( heap.size()!=0 ) { //while the heap isn't empty
            int elementRemoved = heap.removeMin(); //remove the smallest element (the root) from the heap
            data[j] = elementRemoved; //overwrite the original array with the sorted elements now
            j++; //update the index of next element to put in sorted array
        }
//        System.out.println( heap.toString() ); //heap after sorting is now empty
        
    }
    
    /**
     * test for heapSort method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer[] test = {3, 6, 87, 35, 0, 14, 22, 67, 92, 11, 100};           // a test array
        System.out.println(Arrays.toString(test));

        heapSort(test);                                 // sort test1
        System.out.println(Arrays.toString(test));
    }
    
}