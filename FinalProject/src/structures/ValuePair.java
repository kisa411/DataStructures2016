


package structures;

/**
 * A special kind of Pair in which the second object must be a number
 * @author ewolf
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
        return getSecond().doubleValue();
    }
    

}
