/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author ewolf
 */


@SuppressWarnings({"unchecked"})
public class Pair<A, B extends Number> {

    A first;
    B second;

    public Pair(A a, B b) {                  // constructor
        first = a;
        second = b;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public String toString() {
        return "[" + first + ", " + second + "]";
    }
}
