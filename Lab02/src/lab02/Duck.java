/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

/**
 *
 * @author kisa411
 */
public class Duck extends Bird {
    public Duck(); //default constructor
    
    /**
     * method that prints waddling
     */
    @Override
    public void move() {System.out.println("Waddling");} //overrides move() in Bird
    
    /**
     * method that prints quack
     */
    @Override
    public void makeNoise() {System.out.println("Quack");} //overrides makeNoise() in Bird
    
    /**
     * method that ____
     */
    public void paddle(); //method 
    
}
