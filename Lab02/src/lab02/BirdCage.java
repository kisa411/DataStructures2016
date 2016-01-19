/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

/**
 *The birdcage has objects of the Bird, Loon, and Duck classes
 * @author kisa411
 */
public class BirdCage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bird tweety = new Bird(2); //tweety is a bird that is 2 years old, instantiates an object of class Bird
        tweety.incrAge(); //testing out the incrAge() function of tweety
        System.out.println("Tweety's age is: " + tweety.getAge()); //print out the age of tweety - should be 3
        tweety.makeNoise(); //test makeNoise() method
        tweety.move(); //test move() method
        
        Duck ducky = new Duck(); //ducky is a duck that is 0 years old, call on default constructor
        System.out.println("Ducky's age is: " + ducky.getAge()); //print out the age of ducky
        
        Duck donald = new Duck(2); //donald is a duck that is 2 years old, instantiates an object of class Duck
        System.out.println("Donalds's age is: " + donald.getAge()); //print out the age of donald
        donald.move(); //test to see if makeNoise() method was properly overridden in class Duck
        donald.makeNoise(); //test to see if makeNoise() method was properly overridden in class Duck
        donald.paddle(); //test paddle() method
        
        Loon loony = new Loon(3); //loony is a Loon that is 3 years old, instntiates an object of class Loon
        loony.makeNoise(); //test to see if makeNoise() method was properly overridden in class Loon
        if (loony.getMate() == false) { //test hasMate() method
            System.out.println("Loony has no mate");
        } else {
            System.out.println("Loony has a mate");
        }
        System.out.println("Calling on loony.mate() method");
        
        loony.mate();
        if (loony.getMate() == false) { //test hasMate() method
            System.out.println("Loony has no mate");
        } else {
            System.out.println("Loony has a mate");
        }
        loony.dive(); //test dive() method
    }
    
}

/* QUESTIONS & ANSWERS:

i. Which class(es) can call the method getAge()? Why? Does the method behavior
depend on the class that calls the method? Why?
-All three classes (Bird, Loon, and Duck) can call on the method getAge() because the method is part of the Bird class, and Loon and Duck are subclasses of the superclass Bird. 
This means that the Loon and Duck classes inherited the methods that are part of the Bird Class. 
The method behavior does not depend on the class that calls the method because the method is not overridden anywhere and it does the same thing regardless of which class is calling it.

ii. Which class(es) can call the method move()? Why? Does the method behavior
depend on the class that calls the method? Why?
-All three classes (Bird, Loon, and Duck) can call on the method getAge() because the method is part of the Bird class, and Loon and Duck are subclasses of the superclass Bird. 
This means that the Loon and Duck classes inherited the methods that are part of the Bird Class. 
The method behavior depends on the class that calls the method because the different classes have different code bodies (what happens) if the method is called. 

iii. Which class(es) can call the method dive? Why?
-Only the Loon class can call on the method dive because it is a method local to the Loon class and therefore only it has access to the method.
*/
