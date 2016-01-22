/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

/**
 *a class that creates multiple polygons
 * @author kisa411
 */
public class Sketchpad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //make new isoscelestriangle object
        IsoscelesTriangle isosceles = new IsoscelesTriangle(10, 5, 6);
        System.out.println(isosceles.area()); //print out area
        System.out.println(isosceles.perimeter()); //print out perimeter
        
        //make new rectangle object
        Rectangle rectangle = new Rectangle(5, 5);
        System.out.println(rectangle.area()); //print out area
        System.out.println(rectangle.perimeter()); //print out perimeter
        
        //make new equilateraltriangle object
        EquilateralTriangle equilateral = new EquilateralTriangle(6);
        System.out.println(equilateral.area()); //print out area
        System.out.println(equilateral.perimeter()); //print out perimeter
        
        //make new square object
        Square square = new Square(7);
        System.out.println(square.area()); //print out area
        System.out.println(square.perimeter()); //print out perimeter
        
    }
    
}
