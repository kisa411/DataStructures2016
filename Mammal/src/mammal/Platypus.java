/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammal;

/**
 * Platypus extends abstract class Mammal
 * @author kisa411
 */
public class Platypus extends Mammal {
    
    /**
     * constructor
     * @param gender 
     */
    public Platypus( String gender ) { //constructor
        super(gender); //user provides input on gender of animal
    }
    
    /**
     * implementation of abstract method eat()
     */
    @Override
    public void eat() { //abstract method from abstract class Mammal
        System.out.println("Platypuses like to eat shrimp.");
    }
    
    /**
     * additional method unique to class Platypus
     */
    public void move() { 
        System.out.println("Platypuses can walk or swim.");
    }
}
