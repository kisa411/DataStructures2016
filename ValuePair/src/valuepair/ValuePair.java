
package valuepair;

/**
 * A special kind of Pair in which the second object must be a number
 * @author kisa411
 * @param <A>
 */

/*
The first extends is used to limit the parameter B to classes that implement an interface or inherits from an abstract or a base class. 
The second extend is used to make sure the ValuePair inherits from the class Pair.
The constructor makes a call to super so that it can use the constructor from the Pair class to instantiate the ValuePair object.
*/
@SuppressWarnings({"unchecked"})
public class ValuePair<A, B extends Number> extends Pair<A, B>{

    /**
     * A constructor that calls the constructor of the superclass Pair
     * @param a the first object
     * @param b the second object (a number)
     */
    public ValuePair(A a, B b) {                  // constructor
        super(a,b);
    }

    /**
     * a method to access the second object in numeric form
     * @return the second object as a double
     */
    public double getValue() {
        return getSecond().doubleValue();   //doubleValue is a member function that returns the number as a double
    }
    

}