/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;

/**
 *A class that describes features of a bird
 * @author kisa411
 */
public class Bird {
    /**
     * default constructor for class Bird with parameters
     * @param number 
     */
    public Bird( int number ) { age = number; } //sets the given number as the age of the bird
    
    /**
     * 
     * @return age
     */
    public int getAge() { return age; } //accessor method that returns the bird's age
    
    /**
     * increases the age of the bird by one year
     */
    public void incrAge() { age++; } //update method that increases the age of the bird by 1 year
    
    /**
     * the age of the bird
     */
    protected int age;
    
    /**
     * Constructs a new Bird instance
     */
    public Bird() {age = 0;}
    
    /**
     * makes the bird fly
     */
    public void move() {System.out.println("Flying");}
    
    /** 
     * makes the bird chirp
     */
    public void makeNoise() {System.out.println("Chirp!");}
}
    
