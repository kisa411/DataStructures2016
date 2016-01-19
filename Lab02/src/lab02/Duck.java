/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

/**
 * default constructor for class Duck
 * @author kisa411
 */
public class Duck extends Bird {
    public Duck() { //default constructor
        super(); //==Bird();
    }
    
    /**
     * constructor with parameters
     * @param age 
     */
    public Duck( int age ) { //constructor that allows you to set the age of the bird
        super( age ); //==Bird( int age );
    }
    
    /**
     * makes the bird waddle
     */
    @Override
    public void move() {System.out.println("Waddling");} //overrides move() in Bird
    
    /**
     * makes the bird quack
     */
    @Override
    public void makeNoise() {System.out.println("Quack");} //overrides makeNoise() in Bird
    
    /**
     * makes the bird paddle
     */
    public void paddle() {System.out.println("Paddling");} //method 
    
}
