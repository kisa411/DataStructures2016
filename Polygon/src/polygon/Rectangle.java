/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

/**
 * a class that implements Polygon
 * @author kisa411
 */
public class Rectangle implements Polygon {
    double area, perimeter, length1, width1, side1; 
    
    /**
     * constructor
     * @param length
     * @param width 
     */
    public Rectangle( double length, double width ) { //constructor
        length1 = length;
        width1 = width;
    }
    
    public Rectangle( double side ) { //constructor for square
        side1 = side;
    }
    
    /**
     * calculate the area of a rectangle
     * @return area
     */
    @Override
    public double area() { //calculate area of rectangle
        area = length1*width1;
        return area;
    }
    
    /**
     * calculate the perimeter of a rectangle
     * @return perimeter
     */
    @Override
    public double perimeter() { //calculate perimeter of rectangle
        perimeter = (2*length1) + (2*width1);
        return perimeter;
    }
    
}
