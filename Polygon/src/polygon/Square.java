/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

/**
 * class Square is a subclass of class Rectangle
 * @author kisa411
 */
public class Square extends Rectangle { //is a subclass of class Rectangle
    
    /**
     * constructor
     * @param side 
     */
    public Square( double side ) { //constructor
        super(side);
    }
    
    /**
     * calculate the area of a square
     * @return area
     */
    @Override
    public double area() { 
        area = side1*side1;
        return area;
    }
   
    /**
     * calculate the perimeter of a square
     * @return perimeter
     */
    @Override
    public double perimeter() { 
        perimeter = (4*side1);
        return perimeter;
    }
    
}
