
package lab09;


/*
####################          ####################
#s#       #f   #   #          #s#       #f...#   #
# ####### #### # # #          #.####### ####.# # #
#         #  # ### #          #.........#  #.### #
##### ### #        #          ##### ###.#   .... #
#   # #   ####### ##          #   # #...#######.##
#   # # ### #   #  #          #   # #.### #...#..#
#   # # #   # # ## #          #   # #.#...#.#.##.#
#     #   #   #    #          #     #...#...#....#
####################          ####################
 */

/**
 * A program to solve Mazes with queues.
 * @author duane a. bailey
 */
public class MazeRunner {

    /**
     * creates a Maze object from a file, then solves the maze and prints solution
     * @param arguments
     */
    public static void main(String[] arguments) {
        
        Maze m = new Maze("testmaze2.txt"); // construct the maze from file
        System.out.println(m.toString());  // print maze to console

        Position goal = m.finish();        // where the finish is
        Position curr = null;              // keep track of the current position
        
        
        //Create a LinkedQueue to manage the search - LinkedQueue containing Position information
        Queue<Position> path = new LinkedQueue<>();

        //Add starting position to queue
        Position start = m.start(); //store the starting position of Maze m
        path.enqueue( start ); //add the starting position of the Maze m to the queue
        curr = path.dequeue();
        
        //Do the search through the maze -- see our slides and pseudocode
        while ( !curr.equals(goal) ) { //while the current position isn't the finish spot, keep moving through maze
            if ( m.isClear(curr.west()) && !m.isVisited(curr.west()) ) {//if there are possible neighbors that can be added, add them to the queue
                path.enqueue( curr.west() );
                Position next = curr.west(); //set the current position as the previous position so that we can move through maze
                m.setPrevious(next, curr); //neighbor first, then current position (neighbor points back to current position)
            } if ( m.isClear(curr.south()) && !m.isVisited(curr.south()) ) {//if there are possible neighbors that can be added, add them to the queue
                path.enqueue( curr.south() );
                Position next = curr.south(); //set the current position as the previous position so that we can move through maze
                m.setPrevious(next, curr); //neighbor first, then current position (neighbor points back to current position)
            } if ( m.isClear(curr.east()) && !m.isVisited(curr.east()) ) {//if there are possible neighbors that can be added, add them to the queue
                path.enqueue( curr.east() );
                Position next = curr.east(); //set the current position as the previous position so that we can move through maze
                m.setPrevious(next, curr); //neighbor first, then current position (neighbor points back to current position)
            } if ( m.isClear(curr.north()) && !m.isVisited(curr.north()) ) {//if there are possible neighbors that can be added, add them to the queue
                path.enqueue( curr.north() );
                Position next = curr.north(); //set the current position as the previous position so that we can move through maze
                m.setPrevious(next, curr); //neighbor first, then current position (neighbor points back to current position)
            } //all statements are if statements because we want to do a breadth-first search 
                //and the queue should be able to add all the possible neighbors at each spot
            m.visit( curr ); //set the current position as to having been visited
            if ( path.isEmpty() ) { //if the queue is empty, there is no valid solution to the maze
                System.out.println("There is no valid solution to the maze.");
                break;
            }
            curr = path.dequeue(); //set the next available position as the current position           
            
        }

 
        //display path (will simply reprint the maze if no path has been found)
        System.out.println(m.showPath());

    } //end main method
}
