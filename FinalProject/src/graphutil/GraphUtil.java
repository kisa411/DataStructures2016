
package graphutil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import structures.ArrayList;

/**
 * A class in which a user can create Graph objects with String vertex elements
 * and Integer edge elements; the user can also access several other methods to 
 * analyze the Graph objects.
 * @author ewolf
 * @author SMC CPSC328 S16 class
 */
public class GraphUtil {
    /**
     * Creates a Graph with String vertex elements and int edge elements
     * by reading in specifications from a file
     * @param filename of graph specifications
     * @return the graph object
     */
    public static Graph<String,Integer> createGraph(String filename) {
        Graph<String, Integer> graph = new Graph<>();
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(filename)));
        }
        catch (FileNotFoundException ex) {
            System.out.println("That file cannot be found.");
        }
        try {
            //scan first line (all vertex elements)
            Scanner line = new Scanner(s.nextLine());
            while (line.hasNext()) {
                graph.insertVertex(line.next());
            }
            //now scan matrix rows; there is one row per vertex, and they are
            //in the same order as in the first row
            for (Vertex<String,Integer> vrow : graph.vertices()) {
                line = new Scanner(s.nextLine());
                line.next(); //ignore name of vertex element
                //read weights one at a time, add edge if weight is not 0
                for (Vertex<String,Integer> vcol : graph.vertices()) {
                    int weight = line.nextInt();
                    if (weight!= 0) graph.insertEdge(vrow, vcol, weight);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Problem reading in graph specifications.");
        }
        return graph;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a test graph
        Graph<String,Integer> testgraph = createGraph("testgraph.txt");
//        System.out.println(testgraph.toString());
        

        
        /*TESTING CODE*/
        ArrayList< Vertex<String,Integer>> path = new ArrayList<>();
        path = null;
        
        Vertex<String, Integer> vert1 = testgraph.getVertex("A");
        Vertex<String, Integer> vert2 = testgraph.getVertex("C");
//        System.out.println("The vertex's element is: " + vert1.getElement());
//        System.out.println("The vertex's element is: " + vert2.getElement());
        path = BFSutil.findPath(testgraph, vert1, vert2);
        
        if ( path!=null ) {
            System.out.println("The number of edges in this path is: " + (BFSutil.numEdgesinPath()));
        } else {
            System.out.println("path wasn't returned");
        }
        
        Vertex<String, Integer> vert3 = testgraph.getVertex("A");
        Vertex<String, Integer> vert4 = testgraph.getVertex("B");
//        System.out.println("The vertex's element is: " + vert1.getElement());
//        System.out.println("The vertex's element is: " + vert2.getElement());
        path = BFSutil.findPath(testgraph, vert3, vert4);
        
        if ( path!=null ) {
            System.out.println("The number of edges in this path is: " + (BFSutil.numEdgesinPath()));
        } else {
            System.out.println("path wasn't returned");
        }
        
        /*END TESTING CODE*/
        
      
    }
    
    
    
}
