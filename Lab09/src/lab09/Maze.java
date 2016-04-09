
package lab09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


// A class for reading and manipulating mazes.
// August 1996 kimberly tabtiang, duane bailey

/* An example maze:
10
####################
#s#       #f   #   #
# ####### #### # # #
#         #  # ### #
##### ### #        #
#   # #   ####### ##
#   # # ### #   #  #
#   # # #   # # ## #
#     #   #   #    #
####################
 */




/**
 * This class creates a Maze object from a text file
 * as array of cell objects, and start and finish locations
 * @author ewolf
 */
public class Maze {

    /**
     * a nested class structure for holding info about a given location in maze
     */
    private class cell {
        /**
         * true if this location has no wall
         */
        boolean clear = true;       
        /**
         * false if as yet unvisited
         */
        boolean visited = false;  
        /**
         * false if not on final path
         */
        boolean onPath = false; 
        /**
         * the position previous to this cell on the search path
         */
        Position previous = null;
    }

    /**
     * number of rows in maze
     */
    private int nrows;        
    /**
     * array of cell arrays; rows may have varying lengths
     */
    private cell map[][];     
    /**
     * location of start
     */
    private Position start;  
    /**
     * location of finish
     */
    private Position finish; 

    /**
     * Reads and constructs maze from file
     * @param filename at which the maze is stored, in which first line contains
     *      number of rows, # is a wall,
     *      's' marks the start, and 'f' marks the finish.
     */
    public Maze(String filename) {
        Scanner rstream = null; // eventually, the reader
        try {
            rstream = new Scanner(new BufferedReader(new FileReader(filename)));
        }
        catch (FileNotFoundException ex) {
            System.out.println("That file cannot be found.");
        }
        try {
            // we read # of rows.  the # of cols depends on line length
            nrows = rstream.nextInt();
            rstream.nextLine();

            // allocate rows
            map = new cell[nrows][]; // allocate row pointers

            // for each row, read it
            for (int row=0; row < nrows; row++) { // read rows
                
                // read in a line
                String s = rstream.nextLine();
                // allocate array of cell refs for each line
                int len = s.length();
                map[row] = new cell[len];
                
                // now, initialize each cell reference to a cell
                for (int col=0; col<len; col++) {
                    char c = s.charAt(col);
                    map[row][col] = new cell();
                    // process each character
                    switch(c) {
                      case 's':
                        start = new Position(row,col); 
                        break;
                      case 'f': 
                        finish = new Position(row,col); 
                        break;
                      case ' ':
                      case '.': // means visited, but clear
                        break;
                      case '#': 
                      default:
                        map[row][col].clear = false;
                    }
                }
            }

        }
        catch (Exception e)
        {
            System.out.println("IOException on maze read.");
        }
    }

    /**
     * cell at position p is set to visited
     * @param p a position within the maze
     */
    public void visit(Position p) {
        if (isValid(p))
        {
            map[p.row()][p.col()].visited = true; //if this position is a valid position in the maze,
                                                  //mark this position as having been visited
        }
    }

    /**
     * returns true if the position has been visited
     * @param p a position within the maze
     * @return true if position has been visited
     */
    public boolean isVisited(Position p) {
        return isValid(p) && map[p.row()][p.col()].visited;
    }
    
    /**
     * Set a pointer from Position p back to Position prev 
     * @param p a Position
     * @param prev the previous position
     */
    public void setPrevious (Position p, Position prev) {
        //System.out.println(p);
        //System.out.println(prev);
        if (map[p.row()][p.col()].previous == null) //if the the position doesn't have a previous pointer yet
            map[p.row()][p.col()].previous = prev; //set the position's pointer to the previous position
    }
    
    /**
     * returns true if the position is on the final path;
     * method buildPath() must be run first to generate this path
     * @param p the position
     * @return true if position is on final path
     */
    public boolean isOnPath(Position p) {
        return map[p.row()][p.col()].onPath;
    }

    /**
     * returns start position
     * @return start position
     */
    public Position start() {
        return start;
    }

    /**
     * returns finish position
     * @return finish position
     */
    public Position finish() {
        return finish;
    }

    /**
     * determines if position exists in maze
     * @param p a position
     * @return true if p is a location in the maze
     */
    protected boolean isValid(Position p) {
        int row = p.row();
        int col = p.col();
        return (row >= 0) && (row < nrows) &&
               (col >= 0) && (col < map[row].length);
    }

    /**
     * check if location is a clear location in the maze
     * @param p a location
     * @return true if p is a clear location within the maze
     */
    public boolean isClear(Position p)
    {
        return isValid(p) && map[p.row()][p.col()].clear;
    }

    /**
     * Displays maze with visited locations marked
     * @return String representing maze state in which
     *      "." is used to mark visited non-start/finish locations
     */
    @Override
    public String toString()
    {
        // a mutable string
        StringBuilder s = new StringBuilder();

        
        for (int row=0; row < nrows; row++) {
            for (int col=0; col < map[row].length; col++) {
                Position here = new Position(row,col);
                // determine character to represent location
                // note --- no implementation dependent actions
                if (here.equals(start)) s.append('s');
                else if (here.equals(finish)) s.append('f');
                else if (isVisited(here)) s.append('.');
                else if (isClear(here)) s.append(' ');
                else s.append('#');
            }
            s.append('\n');
        }
        return s.toString();
    }
    
    /**
     * Retraces steps from finish to start to rebuild the search path;
     * if called before finish is reached in the search, no path is built
     */
    public void buildPath() {
        Position p = map[finish.row()][finish.col()].previous; //start from the position before the finish
        if (p != null) { //if the current position has a pointer to a previous position
            while (p != start) { //until the start of the maze
               map[p.row()][p.col()].onPath = true; //indicate that the position was on the path to the finish
               p = map[p.row()][p.col()].previous;  //move the pointer backwards (progress backtracking)     
            }
        }
    }
    
    /**
     * Builds and displays maze with visited locations marked
     * @return String representing maze state in which
     *      "." is used to mark visited non-start/finish locations
     */
    public String showPath() {
        buildPath();
        // a mutable string
        StringBuilder s = new StringBuilder();

        
        for (int row=0; row < nrows; row++) {
            for (int col=0; col < map[row].length; col++) {
                Position here = new Position(row,col);
                // determine character to represent location
                // note --- no implementation dependent actions
                if (here.equals(start)) s.append('s');
                else if (here.equals(finish)) s.append('f');
                else if (isOnPath(here)) s.append('.');
                else if (isClear(here)) s.append(' ');
                else s.append('#');
            }
            s.append('\n');
        }
        return s.toString();
    }

}