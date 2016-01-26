/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Stores the name and game score for a player
 * @author kisa411
 */

public class GameEntry {
    
  /** name of the person earning this score */
  private String name;  
  /** the score value */
  private int score; 
  /** the date*/
  private Date date; //variable date of type Date (Date is a class in Java)
  
  /**
   * Constructs a game entry with given parameters
   * @param n the name
   * @param s the score
   * @param d the date
   */ 
  public GameEntry(String n, int s, Date d) {
    name = n;
    score = s;
    date = d;
  }
  /**
   * Access method for name
   * @return the name field
   */
  public String getName() { return name; }
  
  /**
   * Access method for score
   * @return score
   */
  public int getScore() { return score; }
  
  /**
   * Access method for date
   * @return date
   */
  public Date getDate() { return date; }
  
  /**
   * Returns a string representation of this entry.
   * @return a string with name and score
   */
  @Override
  public String toString() { // desired format of date: 01/27/2015 3:30 PM
    String newstring = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(date); //changes the date object passed into method into a String with the desired format
    return  name + ", " + score + ", " + newstring;
  }
}