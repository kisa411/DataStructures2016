/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for storing high scores in an array in nondecreasing order.
 * @author kisa411
 */

public class Scoreboard {
  
  /** number of actual entries */
  private int numEntries = 0;              
  /** array of game entries (names & scores) */
  private GameEntry[] board;               
  
  /** 
   * Constructs an empty scoreboard with the given capacity for storing entries. 
   * @param capacity the number of high scores board will hold
   */
  public Scoreboard(int capacity) {
    board = new GameEntry[capacity];
  }

  /**
   * Attempt to add a new score to the collection (if it is high enough)
   * @param e the GameEntry to add
   */
  public void add(GameEntry e) {
    int newScore = e.getScore();
    // is the new entry e really a high score?
    if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
      if (numEntries < board.length)        // no score drops from the board
        numEntries++;                       // so overall number increases
      // shift any lower scores rightward to make room for the new entry
      int j = numEntries - 1;
      while (j > 0 && board[j-1].getScore() < newScore) {
        board[j] = board[j-1];              // shift entry from j-1 to j
        j--;                                // and decrement j
      }
      board[j] = e;                         // when done, add new entry
    }
  }

  /**
   * Remove and return the high score at index i. 
   * @param i the index for the entry to be removed
   * @return the GameEntry that was removed
   * @throws IndexOutOfBoundsException 
   */
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries)
      throw new IndexOutOfBoundsException("Invalid index: " + i);
    GameEntry temp = board[i];                 // save the object to be removed
    for (int j = i; j < numEntries - 1; j++)   // count up from i (not down)
      board[j] = board[j+1];                   // move one cell to the left
    board[numEntries -1 ] = null;              // null out the old last score
    numEntries--;
    return temp;                               // return the removed object
  }

  
  /**
   * Returns a string representation of the high scores list. 
   * @return a string with a list of names and scores, one per line
   */
  @Override
  public String toString() {
    /*When printing a string to the console, if "\n" is found, it is
      *not printed.  Instead, the console moves to the next line.  */ 
    StringBuilder sb = new StringBuilder("-----------------\n");    
    for ( int i=0; i < numEntries; i++ ) {
        sb.append(board[i].toString()+"\n");
    }
    sb.append("-----------------"); // adds given string to the end of sb
    return sb.toString();
  }

  /**
   * The main method tests class Scoreboard.
   * @param args 
   */
  public static void main(String[] args) {
    // The main method
    Scoreboard highscores = new Scoreboard(5);
    String[] names = {"Robb", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Beth"}; //names of players
    int[] scores = {750, 999, 591, 740, 515, 668, 720, 407}; //respective scores of players
    
    
    //array of dates given as strings
    String[] dateStr = {"2011-01-18 10-01-46","2011-09-09 03-36-05",
                        "2012-02-21 15-16-38","2012-07-12 03-13-50",
                        "2012-07-12 05-10-11","2013-03-30 22-33-42",
                        "2014-06-06 01-10-59","2015-01-27 15-30-00"};
    //create Date objects from these strings - desired format: 01/27/2015 3:30 PM
    Date[] dates = new Date[dateStr.length];
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); //("MM/dd/yyyy HH:mm a");
    for (int i=0; i<dateStr.length;i++) {
        try {
            dates[i] = sdf.parse(dateStr[i]);
        } catch (ParseException ex) {
        }
    }
    
    //create GameEntry objects for each score, and add into the board
    for (int i=0; i < names.length; i++) {
      GameEntry gE = new GameEntry(names[i], scores[i], dates[i]);
      //System.out.println("Adding " + gE); //prints out the GameEntry that's being added each time
      highscores.add(gE);
      //System.out.println("\n   Scoreboard:\n" + highscores.toString()); //line to check the order in which scores are added
    }
    
    System.out.println("\n   Scoreboard:\n" + highscores.toString());
    
    //check to see remove(1) output
//    highscores.remove(1);
//    System.out.println("\n   Scoreboard:\n" + highscores.toString());
  }
}
    

