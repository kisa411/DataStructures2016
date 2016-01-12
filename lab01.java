
package lab01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A program that can do some simple mathematical operations on vectors.
 * @author Dr Wolf
 */
public class VectorCalculator {
      
    /**
     * Adds two vectors of the same size
     * @param a the first vector
     * @param b the second vector
     * @return an int[] that is sum of a and b
     */

    //addition of two vectors
    public static int[] add (int[] a, int[] b) { 
        int[] sum = new int[a.length];          //declare new int[] of same length as a    
        for ( int i=0; i<a.length; i++ ) {
            sum[i] = a[i] + b[i]; //add the numbers of the two vector arrays and put them in the sum array;
        }
        return sum;
    }
    
    /**
     * Finds the dot product of the two vectors of the same size
     * @param a the first vector
     * @param b the second vector
     * @return an int that is the dot product of a and b
     */

    //dot product of two vectors
    public static int dot (int[] a, int[] b) {
        int[] product = new int[a.length]; //stores the products of the vector values
        int sum = 0; //stores the sum of the products
        for ( int i=0; i<a.length; i++ ) {
            product[i] = a[i] * b[i];
            sum += product[i];
        }
        return 0;
    }
    
    /**
     * Finds the cross product of two vectors of length 3.
     * @param a the first vector
     * @param b the second vector
     * @return an int[] that is the cross product of a and b
     */

    //cross product of two vectors
    public static int[] cross (int[] a, int[] b) {
        int[] cross = new int[a.length];        //declare new int[] of same length as a  
        cross[0] = (a[1]*b[2]) - (a[3]*b[1]);
        cross[1] = (a[2]*b[0]) - (a[0]*b[2]);
        cross[2] = (a[0]*b[1]) - (a[1]*b[0]);
        return cross;
    }
    
    /**
     * Finds the norm (magnitude) of a vector
     * @param a a vector
     * @return the norm of a
     */

    //Euclidean norm of two vectors
    public static double norm (int[] a) {
        int[] squares = new int[a.length]; //creates an array squares with the same length as given array containing the squares of the vector values
        int norm = 0;
        for ( i=0; i<a.length; i++ ) {
            square[i] = a[i]*a[i];
            norm += square[i];
        }
        
        norm = sqrt(norm);

        return 0;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //test arrays for the methods        
        int[] v1 = {1,2,3};        
        int[] v2 = {-1,2,5};    
        System.out.println(Arrays.toString(add(v1,v2)));        
        System.out.println(dot(v1,v2));
        System.out.println(Arrays.toString(cross(v1,v2)));
        System.out.println(norm(v1));        
        System.out.println(norm(v2));
        
        /*
        Scanner input = new Scanner(System.in);          //input taken from console
        System.out.print("Enter the length of the vectors: ");
        int length = input.nextInt();                   //read in length from user
        int[] vec1 = new int[length];                   //make vector of right size
        System.out.print("Enter the integer coordinates of the first vector, "
                + "separated by spaces: ");
        for (int i=0; i<length; i++) {                  //for each coordinate
                vec1[i] = input.nextInt();               //store in vec1 array
        }
        
        //TODO part b
        
        System.out.print("Which operation would you like to use"
                + " (add, dot, cross, or norm)? ");
        String op = input.next();                        //store operation from user
        
        //TODO part d -- hint: the command string1.equals(string2) returns a boolean
        //      that is true if string1 and string2 are the same sequence of characters
        
        //TODO parts e and f
        */
         
    }
    
}