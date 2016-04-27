
package graphutil;

import structures.SinglyLinkedList;

/**
 * An implementation of the Graph ADT using an adjacency list structure.
 * @author ewolf
 * @author SMC CPSC328 S16 class
 * @param <V> the type of element stored at a vertex
 * @param <E> the type of element stored at an edge
 */
public class Graph<V,E> {    
    /**
     * A list of all vertices in the graph
     */
    private SinglyLinkedList<Vertex<V,E>> vertices = new SinglyLinkedList<>();
    /**
     * A list of all edges in the graph
     */
    private SinglyLinkedList<Edge<V,E>> edges = new SinglyLinkedList<>();
    /**
     * Constructs an empty Graph object
     */
    public Graph() { }  
    /**
     * Returns the vertex list as an iterable collection so that the for-each
     * loop <pre>{@code for (Vertex<V,E> v : vertices()) {...}}</pre> can be used.
     * @return the iterable list
     */
    public Iterable<Vertex<V,E>> vertices() {return vertices;}
    /**
     * Returns the edge list as an iterable collection so that the for-each
     * loop <pre>{@code for (Edge<V,E> e : edges()) {...}}</pre> can be used.
     * @return the iterable list
     */
    public Iterable<Edge<V,E>> edges() {return edges;}
    /**
     * A string containing graph information; for testing purposes.
     * @return the string of graph information
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("List of vertices:\n");
        str.append("element -- label -- visited -- incident edges: \n");
        for (Vertex<V,E> v : vertices()) {
            str.append(v.getElement()).append(" -- ");
            str.append(v.getLabel()).append(" -- ");
            str.append(v.isVisited()).append(" -- ");
            for (Edge<V,E> e : v.adjList()) {
                str.append(e.getElement()).append(", ");
            }
            str.setLength(str.length() - 2);
            str.append("\n");
        }
        str.append("\nList of edges:\n");
        str.append("element -- endpoints -- used:\n");
        for (Edge<V,E> e : edges()) {
            str.append(e.getElement()).append(" -- ");
            str.append(e.getEndpoints()[0].getElement()).append(" , ");
            str.append(e.getEndpoints()[1].getElement()).append(" -- ");
            str.append(e.isUsed()).append("\n");
        }
        return str.toString();
    }  
    
//    public Edge<V,E> getEdge(V a, V b) {
//        //checks the endpoints of the edge to make sure they are not the same
//        if (a.equals(b)) return null;
//         for (Edge<V,E> e : edges()) {
//             Vertex<V,E>[] endpoints = e.getEndpoints();
//             if (endpoints[0].getElement().equals(a) && endpoints[1].getElement().equals(b)){
//                 return e;
//             }
//             if (endpoints[0].getElement().equals(b) && endpoints[1].getElement().equals(a)){
//                 return e;
//                }
//         }
//         return null;           //didn't find an edge
//    }

   
    /**
     * Gets the edge between two elements, or null if none
     * @param a the first element
     * @param b the second element
     * @return the edge between two elements
     */
    public Edge<V,E> getEdge(V a, V b) {
        //checks the endpoints of the edge to make sure they are not the same
        if (a.equals(b)) return null;
         for (Edge<V,E> e : edges()) {
             Vertex<V,E>[] endpoints = e.getEndpoints();
             if (endpoints[0].getElement().equals(a) && endpoints[1].getElement().equals(b)){
                 return e;
             }
             if (endpoints[0].getElement().equals(b) && endpoints[1].getElement().equals(a)){
                 return e;
                }
         }
         return null;           //didn't find an edge
    }


    /**
     * method to return the vertices incident to given edge
     * @param edge
     * @return array containing vertices
     */
    public Vertex<V,E>[] endVertices(Edge<V,E> edge) { //pass in edge
        Vertex<V,E>[] incidentVertices = new Vertex[2];

        incidentVertices = edge.getEndpoints(); //store the getEndpoints of the edge 

        return incidentVertices;
        
    }
    
    /**
     * Gets the vertex storing the given element
     * @param ele
     * @return the vertex that stores the given element
     */
    public Vertex<V,E> getVertex(V ele){
        // search one by one through the whole vertex list
        for (Vertex<V,E> v : vertices()){
            if (ele.equals(v.getElement())){
                return v;
            }
        }
        // if nothing found, returns null
        return null;
    }

    
    /**
    * A method that returns its degree, given a Vertex
    *@parm generic Vertex stored as vert
    *@return the degree of vert
    * */
    public int degree(Vertex<V,E> vert){
        return vert.degree();
    }

    /**
     * This method creates, inserts, and returns an edge into the graph if:
     * 1. It wont be an edge from one vertex to itself
     * 2. It wont be an edge with the same vertices as an already existing edge
     * If either of these two cases exist, the method will return null otherwise
     * the method will create an edge, add it to the graph and return the newly 
     * created edge.
     * @param u One user defined vertex
     * @param v A second user defined vertex (must not be equal to u)
     * @param e A element to be stored as an Edge or between the given vertices.
     * @return the newly created/added edge.
     */
    public Edge<V,E> insertEdge(Vertex<V,E> u, Vertex<V,E> v, E e) {
        // not allowing loops or edges from one vertex to itself
        if (u.equals(v)) {return null;}
        // create and add the edge to the graph if the "edge" between these verts is empty.
        if (getEdge(u.getElement(),v.getElement()) == null) {
            //creates a new edge
            Edge<V,E> newedge = new Edge<>(u, v, e);
            //adds it to the graphs SinglyLinked List of Edges
            edges.addLast(newedge);
            //add edges as incident edges to the vertices
            u.addEdge(newedge);
            v.addEdge(newedge);
            //return the edge between these vertices
            return newedge;}
        // not allowing parallels or edges with the same vertices
        else {
            return null;
        } // end of else
    } // end of method


    /**
    * Method to insert a new vertex into a graph
    * @param V generic element to be stored at the vertex
    * @return the vertex which was added to the graph
    */
    public Vertex<V,E> insertVertex(V element){
	//first need to make sure the element is not already stored at another vertex
	for(Vertex<V,E> v : vertices()){  //for-each loop for all of the vertices in this graph
                 if(v.getElement().equals(element)){
                      //if we enter this if statement, we have found a condition where there is already a 
                      // vertex holding that element, in which case we can return that vertex
                      return v;
                 }
            }
           //if we have made it through the for-each loop, then we know that there is no vertex that
           // already has the element we want to add, in which case we will create a new element.
          Vertex<V,E> newVertex = new Vertex<V,E>(element);
          vertices.addLast(newVertex);
          return newVertex;
}

    /**
    * A method that returns the number of edges in a graph
    * @return integer - number of edges
    */
    public int numEdges(){
        return edges.size();
    }

    /**
    * A method that returns the number of vertices in a graph
    * @return integer - number of vertices
    */
    public int numVertices(){
        return vertices.size();
    }
    
    /**
    *A method that returns the vertex at the other end of e from v or null if neither of them equals vertx v
    *@ param First genetic element to be stored at the vertex
    *@ param Second genetic element to be stored as the other one at the vertex
    *@ return the vertex which is the opposite one
    */

    public Vertex<V,E> opposite(Vertex<V,E> v, Edge<V,E> e){

        Vertex<V,E> [] endpoint = new Vertex[2];
        endpoint = e.getEndpoints();

        Vertex<V,E> First = endpoint[0];
        Vertex<V,E> Second = endpoint[1];

        if ( First.equals(v)) { return Second;}
        // if the first endpoint equals the Vertex, it returns the opposite one

        if ( Second.equals(v)) {return First;}
        // if the Second endpointequals the Vertex, it returns the opposite one

        if(!First.equals(v) && !Second.equals(v)) { return null;}
        // if the first and the second endpoint do not satisfy the vertex, it returns null

        return null;
    } // end of the method

}



