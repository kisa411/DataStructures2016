/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammal;

/**
 * create objects of different mammals
 * @author kisa411
 */
public class Zoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //make new object of Platypus
        Platypus platypus = new Platypus("female"); //platypus is female
        platypus.reproduce();
        platypus.eat();
        System.out.println("This platypus is a " + platypus.getGender() + ".");
        platypus.move();
        
        System.out.println("\n");
        
        //make new object of Pangolin
        Pangolin pangolin = new Pangolin("male"); //pangolin is male
        pangolin.reproduce();
        pangolin.eat();
        System.out.println("This pangolin is a " + pangolin.getGender() + ".");
        pangolin.makeNoise();
    }
    
}
