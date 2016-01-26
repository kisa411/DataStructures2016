/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

/**
 * Stores the name and game score for a player
 * @author kisa411
 */

public class GameEntry {
    
  /** name of the person earning this score */
  private String name;  
  /** the score value */
  private int score;    
  
  /**
   * Constructs a game entry with given parameters
   * @param n the name
   * @param s the score
   */ 
  public GameEntry(String n, int s) {
    name = n;
    score = s;
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
   * Returns a string representation of this entry.
   * @return a string with name and score
   */
  public String toString() {
    return  name + ", " + score;
  }
}