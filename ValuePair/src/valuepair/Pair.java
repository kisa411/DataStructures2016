/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valuepair;

/**
 * Generic class for Pair class
 * @author kisa411
 */

@SuppressWarnings({"unchecked"})
public class Pair<A, B> {

    A first;
    B second;

    /**
     * constructor for Pair class
     * @param a first element
     * @param b second element
     */
    public Pair(A a, B b) {                  // constructor
        first = a;
        second = b;
    }
    
    /**
     * accessor method for first
     * @return first value
     */
    public A getFirst() {
        return first;
    }

    /**
     * accessor method for second
     * @return second value
     */
    public B getSecond() {
        return second;
    }

    /**
     * print out the first and second values
     * @return string
     */
    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }
    
}
