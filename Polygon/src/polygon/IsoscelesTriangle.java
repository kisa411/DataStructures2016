/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

/**
 *a class that implements Polygon
 * @author kisa411
 */
public class IsoscelesTriangle implements Polygon {
    double base1, height1, side1, area, perimeter; 
    
    /**
     * constructor (three parameters)
     * @param base
     * @param height
     * @param side 
     */
    public IsoscelesTriangle( double base, double height, double side ) { //constructor
        base1 = base;
        height1 = height;
        side1 = side;
    }
    
    /**
     * constructor (one parameter)
     * @param side 
     */
    public IsoscelesTriangle( double side ) { //constructor for EquilateralTriangle
        side1 = side;
    }
    
    /**
     * calculates the area of an isosceles triangle
     * @return area
     */
    @Override
    public double area() { //calculate the area of isoceles triangle
        area = (base1*height1)/2;
        return area;
    }
    
    /**
     * calculates the perimeter of an isosceles triangle
     * @return perimeter
     */
    @Override
    public double perimeter() { //calculate perimeter of isoceles triangle
        perimeter = (2*side1) + base1;
        return perimeter;
    }
    
}
