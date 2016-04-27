
package graphutil;

/**
 * A nested class representing an edge storing an element in the graph.
 * @param <V> the type of element stored at vertices
 * @param <E> the type of element stored at edges
 * @author ewolf
 */
public class Edge<V,E> {

    /**
     * The element stored at the edge.
     */
    private E element;
    /**
     * An array holding the two vertices to which the edge is incident.
     */
    private Vertex<V,E>[] endpoints = new Vertex[2];
    /**
     * A variable to mark an edge as used; for use with graph algorithms that
     * require this functionality.
     */
    private boolean used;
    /**
     * Create an edge between two specified vertices storing a given element.
     * @param u the first vertex
     * @param v the second vertex
     * @param elem the element
     */
    public Edge(Vertex<V,E> u, Vertex<V,E> v, E elem) {
        element = elem;
        endpoints[0] = u; 
        endpoints[1] = v;
        used = false;
    }
    /**
     * Access the edge element.
     * @return the element
     */
    public E getElement() {
        return element;
    }
    /**
     * Access the vertices on the two ends of the edge.
     * @return an array of size two with the endpoints
     */
    public Vertex<V,E>[] getEndpoints() {
        return endpoints;
    }
    /**
     * Checks whether edge is used.
     * @return true if edge is used
     */
    public boolean isUsed() {
        return used;
    }
    /**
     * Marks the edge as used.
     */
    public void use() {
        used = true;
    }
    /**
     * Removes used mark from the edge.
     */
    public void clearUsed() {
        used = false;
    }
    
    public void print() {
        System.out.println(element);
    }
    
    public boolean equals(Edge<V,E> other) {
        if ( getEndpoints() == other.getEndpoints() ){
            return element.equals(other.getElement());
        } else {
            return false;
        }
    }
}
