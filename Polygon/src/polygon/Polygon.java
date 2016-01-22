/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

/**
 *An interface called polygon
 * @author kisa411
 */
public interface Polygon { //only define the methods that are going to be required in classes that implement the interface
    /**
     * returns the area of a polygon
     * @return area
     */
    public double area();
    
    /**
     * returns the perimeter of a polygon
     * @return perimeter
     */
    public double perimeter();
}
