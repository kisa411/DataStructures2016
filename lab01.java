
package lab01;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.sqrt; //for square root function

/**
 * A program that can do some simple mathematical operations on vectors.
 * @author Emily Koh
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
        return sum;
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
        cross[0] = (a[1]*b[2]) - (a[2]*b[1]);
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
        double[] squares = new double[a.length]; //creates an array squares with the same length as given array containing the squares of the vector values
        double norm = 0;
        for ( int i=0; i<a.length; i++ ) {
            squares[i] = a[i]*a[i];
            norm += squares[i];
        }
        
        norm = sqrt(norm);
        
        return norm;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //test arrays for the methods
        //        int[] v1 = {1,2,3};
        //        int[] v2 = {-1,2,5};
        //        System.out.println(Arrays.toString(add(v1,v2)));
        //        System.out.println(dot(v1,v2));
        //        System.out.println(Arrays.toString(cross(v1,v2)));
        //        System.out.println(norm(v1));
        //        System.out.println(norm(v2));
        
        
        Scanner input = new Scanner(System.in);          //input taken from console, if you don't specify then it reads it in as a string
        System.out.println("Enter the length of the vectors: ");
        int length = input.nextInt();                   //read in length from user
        int[] vec1 = new int[length];                   //make vector of right size
        System.out.println("Enter the integer coordinates of the first vector, "
                           + "separated by spaces: ");
        for (int i=0; i<length; i++) {                  //for each coordinate
            vec1[i] = input.nextInt();               //store in vec1 array, nextInt tells it to read in as an integer
        }
        
        //        Scanner input = new Scanner(System.in);          //input taken from console
        System.out.println("Enter the length of the vectors: ");
        length = input.nextInt();                   //read in length from user
        int[] vec2 = new int[length];                   //make vector of right size
        System.out.println("Enter the integer coordinates of the second vector, "
                           + "separated by spaces: ");
        for (int i=0; i<length; i++) {                  //for each coordinate
            vec2[i] = input.nextInt();               //store in vec1 array
        }
        
        //System.out.println("Which operation would you like to use"
        //+ " (add, dot, cross, norm, or quit)? ");
        //String op = input.next();                        //store operation from user
        
        boolean loop = true;
        while (loop) {
            System.out.println("Which operation would you like to use"
                               + " (add, dot, cross, norm, or exit)? ");
            String op = input.next();                        //store operation from user
            
            switch(op) {
                case "add": //add
                    int[] add = add( vec1, vec2 );
                    System.out.println(Arrays.toString(add));
                    break;
                case "dot": //dot
                    int dot = dot( vec1, vec2 );
                    System.out.println(dot);
                    break;
                case "cross": //cross
                    if ( vec1.length != 3 && vec2.length !=3 ) {
                        System.out.println("Cross products can only be done for vectors with 3 elements");
                    } else {
                        int[] cross = cross( vec1, vec2 );
                        System.out.println(Arrays.toString(cross));
                    }
                    break;
                case "norm": //norm
                    System.out.println("Which vector would you like to find the norm of? vec1 or vec2?");
                    String vector = input.next();
                    if ( "vec1".equals(vector) ) { //compares one string to another
                        double norm = norm(vec1);
                        System.out.println(norm);
                    } else if ( "vec2".equals(vector) ) {
                        double norm = norm(vec2);
                        System.out.println(norm);
                    }
                    break;
                case "exit": //quit
                    loop = false; //exits out of the loop
                    break;
            }
            
        }
        
        
        
    }
    
}