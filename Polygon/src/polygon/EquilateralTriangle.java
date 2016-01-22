/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

/**
 * class EquilateralTriangle is a subclass of class IsoscelesTriangle
 * @author kisa411
 */
public class EquilateralTriangle extends IsoscelesTriangle {
    
    /**
     * constructor
     * @param side
     */
    public EquilateralTriangle( double side ) { //constructor
        super(side);
    }
    
    /**
     * calculate the area of an equilateral triangle
     * @return area
     */
    @Override
    public double area() {
        area = ((Math.sqrt(3))/4)*(side1*side1);
        return area;
    }
    
    /**
     * calculate the perimeter of an equilateral triangle
     * @return perimeter
     */
    @Override
    public double perimeter() {
        perimeter = 3*side1;
        return perimeter;
    }
    
}
