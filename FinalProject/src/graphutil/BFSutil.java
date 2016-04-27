/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphutil;
import structures.ArrayList;
import structures.Queue;
import structures.LinkedQueue;
import structures.UnsortedTableMap;
import structures.Map;


/**
 * class that finds the shortest path between two given vertices
 * @author kisa411
 */
public class BFSutil  {
    /**
     * array list to contain the pathway between vertices
     */
    public static ArrayList< Vertex<String,Integer>> path = new ArrayList<>();
    
    /**
     * map to contain relationship between vertices
     */
    public static Map<Vertex<String,Integer>, Vertex<String,Integer>> prev = new UnsortedTableMap<Vertex<String,Integer>, Vertex<String,Integer>>();
    
    /**
     * returns pathway from vertex v to vertex u, null if path doesn't exist
     * @param v starting vertex
     * @param u ending vertex
     * @param g graph 
     * @return ArrayList containing pathway
     */
    public static ArrayList< Vertex<String,Integer> > findPath( Graph<String,Integer> g, Vertex<String,Integer> v, Vertex<String,Integer> u ) {
        
        
	Vertex<String,Integer> start = v;
	Vertex<String,Integer> end = u;
	Vertex<String,Integer> curr = null; //set current vertex to null initially
        Vertex<String,Integer> next = null;

	//Create a LinkedQueue to manage the search - LinkedQueue containing vertex information
        Queue< Vertex<String,Integer> > pathway = new LinkedQueue<>();
        pathway.enqueue(start); //enqueue starting position to pathway
        curr = start;
        curr.visit();

        
        if ( start.equals(end) ) { //starting vertex and end vertex are the same
            System.out.println("Can't find a path between two same vertices");
            return null;
        }
        
	while ( !pathway.isEmpty() ) { //while queue isn't empty
            curr = pathway.dequeue(); //dequeue starting position from pathway
//            System.out.println("Current vertex (just dequeued): " + curr.getElement());
            if ( curr.equals(end) ) {
                break;
            } else {
                //for each vertex adjacent to current vertex
                for ( Edge<String,Integer> e : curr.adjList() ) { 
                    if ( g.opposite(curr, e)!=null ) {
                        next = g.opposite(curr, e); //next is an adjacent vertex to current
                    }
                    //if vertex hasn't yet been visited
                    if ( !next.isVisited() ) {
                        pathway.enqueue(next); //enqueue the vertex to the pathway queue
//                        System.out.println("Just enqueued: " +next.getElement());
                        next.visit(); //mark next as having been visited
                        prev.put(next, curr); //add pair of vertices to map (curr=value, next=key)
                    }
                }
            }
        }
        
        

         //debugging for map 
//       for (Vertex<String, Integer> key : prev.keySet()) 
//       {
//           System.out.println("In map:" + key.getElement());
//           System.out.println("Key's value: " + prev.get(key).getElement());
//       }

        if ( !curr.equals(end) ) { //if queue is empty but current isn't the end vertex
            System.out.println("There is no pathway.");
            return null; //pathway doesn't exist, wasn't able to reach the end vertex without running out of vertices
        }
        
        //add pathway to arraylist now
        int i=0;
        for( Vertex<String,Integer> vert = end; vert != null; vert = prev.get(vert)) {
            path.add(i, vert); //add vertex to pathway starting from last location
            i++;
        }
        
        for ( int j=0, k=path.size()-1; j<k; j++ ) { //reverse the arraylist so that we can get direction from start to end
            path.add(j, path.remove(k));
        }
        
        if (path.isEmpty()) {
            System.out.println("There's nothing in the path.");
        }
        
        //print out path
        System.out.print("Here's the pathway: ");
        for ( int position=0; position<path.size(); position++ ) {
            System.out.print(path.get(position).getElement()+" ");
        }
        System.out.println(" ");
        

        
        return path;
    }
    
    /**
     * function to return the number of edges on path
     * @return number of edges in path
     */
    public static int numEdgesinPath() {
        return path.size()-1;
    }

}