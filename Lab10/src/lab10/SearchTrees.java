/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import binaryTree.*;  //this means import everything from this package

/**
 * a class for creating and using binary search trees of String objects
 * @author ewolf
 */
public class SearchTrees {
    
    public static <E extends Comparable> LinkedBinaryTree<E> makeBinaryTree (E[] arr) {
        //create a tree to hold entries of type E
        LinkedBinaryTree<E> tree = new LinkedBinaryTree();
        
        //add root to the tree
        tree.addRoot(arr[0]);
        //you will need to keep a pointer to a Position<E> representing
        //the current location as you move through the tree
        Position<E> currloc = tree.root();
        int added = 0;
        
        //for strings, sort alphabetically - smaller goes to left child; otherwise vice-versa
        //for ints or doubles, if amount is smaller than current node then place as left child; otherwise vice-versa
        
        for ( int i=1; i<arr.length; i++ ) { //for each element in the array, add it to the tree
//            System.out.println("adding " + i);
            added = 0; //re-set the control variable to 0
            while ( added == 0 ) { //until the element is added somewhere in the tree
                if ( arr[i].compareTo( currloc.getElement() ) <=0 ) { //if compareTo is 0 or less, check against left child
//                    System.out.println("Here");
                    if ( tree.left(currloc) == null ) { //if the left child doesn't yet exist, create a node there
                        tree.addLeft( currloc, arr[i] ); //add element at arr[i] to the left of the current node
                        added = 1; //break out of while loop
//                        System.out.println("Here 2");
                    } else {
                        currloc = tree.left(currloc); //update current location to the left child node of current node
//                        System.out.println("Here 3");
                    }
                } else { //if compareTo is greater than 0, check against right child 
//                    System.out.println("Here 4");
                    if ( tree.right(currloc) == null ) { //if the right child doesn't yet exist, create a node there
                        tree.addRight( currloc, arr[i] ); //add element at arr[i] to the left of the current node
                        added = 1; //break out of while loop
//                        System.out.println("Here 5");
                    } else {
                        currloc = tree.right(currloc); //update current location to the right child node of current node
//                        System.out.println("Here 6");
                    }
                }
            }
       
            
            currloc = tree.root(); //re-set the current location to root node
        }
        
        return tree;
        
    }

    /**
     * main method; for creating search trees
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //the data to put into the search trees
        String[] names = {"Joe","Cat","Bob","Peg","Sara","Chris","Jane","John"};
        Integer[] grades = {86,89,99,75,61,95,100,70,91,80};
        String[] sports = {"hockey","baseball","basketball","gymnastics",
                            "tennis","ping-pong","football","rugby","ultimate","soccer",
                            "water polo"};
        Double[] stockPrices = {43.87,75.74,127.08,160.4,48.5};
        String[] javaWords = {"Java","class","compile","String","int","double",
                              "object","interface","exceptions","ADT","System"};
    
        //create a search tree from the names array
        LinkedBinaryTree<String> nameTree = makeBinaryTree(names);
        
        //this will print a rudimentary picture of the binary tree for testing;
        //note that the second parameter must be an element of the same type 
        //as the tree which will denote a location where a node does not exist
        nameTree.printTree(nameTree.root(),"--");
        System.out.println("");
        
        //create and print the other trees to test your method
        LinkedBinaryTree<Integer> gradeTree = makeBinaryTree(grades);
        gradeTree.printTree(gradeTree.root(), 0);
        System.out.println("");
        
        LinkedBinaryTree<String> sportTree = makeBinaryTree(sports);
        sportTree.printTree(sportTree.root(),"--");
        System.out.println("");
        
        LinkedBinaryTree<Double> stockTree = makeBinaryTree(stockPrices);
        stockTree.printTree(stockTree.root(), 00.00);
        System.out.println("");
        
        LinkedBinaryTree<String> javaTree = makeBinaryTree(javaWords);
        javaTree.printTree(javaTree.root(),"--");
        System.out.println("");
    }
    
}