/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammal;

/**
 * Pangolin extends abstract class Mammal
 * @author kisa411
 */
public class Pangolin extends Mammal {
    
    /**
     * constructor
     * @param gender 
     */
    public Pangolin( String gender ) { //constructor
        super(gender);
    }
    
    /**
     * implementation of abstract method eat()
     */
    @Override
    public void eat() { //abstract method from abstract class Mammal
        System.out.println("Pangolins like to eat ants.");
    }
    
    /**
     * additional method unique to class Pangolin
     */
    public void makeNoise() { 
        System.out.println("Pangolins make huffing sounds when they're annoyed.");
    }
}
