/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammal;

/**
 * abstract class called Mammal
 * @author kisa411
 */
public abstract class Mammal {
    private String gender; 
    
    /**
     * constructor
     * @param mammalGender 
     */
    public Mammal( String mammalGender ) { //constructor
        gender = mammalGender;
    }
    
    /**
     * return the gender of the animal
     * @return 
     */
    public String getGender() { //return the gender of the animal
        return gender;
    }
    
    /**
     * reproduce method
     */
    public void reproduce() { System.out.println("Baby was born!"); }
    
    /**
     * abstract method eat
     */
    public abstract void eat();
}
