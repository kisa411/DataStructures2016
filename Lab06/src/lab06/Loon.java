/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;

/**
 *A class that is a subclass of Bird - a Loon is a special kind of Bird
 * @author kisa411
 */
public class Loon extends Bird {        //a Loon is special kind of Bird
    
    protected Boolean hasMate; //variable that tells whether or not the bird has a mate
    
    /**
     * Default constructor for class Loon - sets age to 0 and hasMate is false
     */
    public Loon() {
        super(); 			    //this calls Bird(), so age set to 0
        hasMate = false;		    //hasMate must be initiated too
    }
    
    /**
     * constructor for class Loon with parameters
     * @param number
     */
    public Loon( int number ) {
        super( number );
        hasMate = false;
    }
    /**
     * check whether or not the loon has a mate
     * @return boolean
     */
    public boolean getMate() { return hasMate;} //returns whether or not the loon has a mate
    
    /**
     * overrides method from Bird, prints out "Loooon" instead of "Chirp!"
     */
    @Override
    public void makeNoise() {               //overrides method from Bird
        System.out.println("Loooon"); 
    }
    
    /**
     * new method that exists only in class Loon, hasMate is true
     */
    public void mate() {hasMate = true;}    //new method (not in class Bird)
    
    /**
     * method that prints out the word "diving"
     */
    public void dive() {System.out.println("Diving");} //method prints out the word "diving"
}
