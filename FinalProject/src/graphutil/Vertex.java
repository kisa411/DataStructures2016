
package graphutil;

import java.util.Iterator;
import structures.SinglyLinkedList;

/**
 * A nested Vertex class representing a node storing an element in the graph.
 * @author ewolf
 * @param <V> the type of element stored at vertices
 * @param <E> the type of element stored at edges
 */
public class Vertex<V,E> {
    /**
     * The element stored at the vertex.
     */
    private V element;
    /**
     * A place to store an integer label; for use with graph algorithms that
     * require labeling functionality; 0 is default
     */
    private int label;
    /**
     * A variable to mark a vertex as visited; for use with graph algorithms
     * that require this functionality; false is default.
     */
    private boolean visited;
    /**
     * The adjacency list of the vertex; that is, a list of all edges incident to
     * the vertex.
     */
    private SinglyLinkedList<Edge<V,E>> adjList = new SinglyLinkedList<>();
    /**
     * Creates a vertex storing an element of type E.
     * @param elem vertex element
     */
    public Vertex(V elem) {
        element = elem;
    }
    /**
     * Access the vertex element.
     * @return the element
     */
    public V getElement() {
        return element;
    }
    /**
     * Access the vertex label.
     * @return the label
     */
    public int getLabel() {
        return label;
    }
    /**
     * Sets the vertex label.
     * @param l the label to set
     */
    public void setLabel(int l) {
        label = l;
    }
    /**
     * Checks whether vertex is visited.
     * @return true if vertex is visited
     */
    public boolean isVisited() {
        return visited;
    }
    /**
     * Marks the vertex as visited.
     */
    public void visit() {
        visited = true;
    }
    /**
     * Removes visited mark from the vertex.
     */
    public void clearVisit() {
        visited = false;
    }
    /**
     * Adds the given edge to the adjacency list of the vertex.
     * @param e the edge to add
     */
    public void addEdge(Edge<V,E> e) {
        adjList.addLast(e);
    }
    /**
     * Returns the adjacency list as an iterable collection so that 
     * <pre>{@code for (Edge<V,E> e : adjList()) {...} }</pre> is valid.
     * @return the iterable list
     */
    public Iterable<Edge<V,E>> adjList() {
        return adjList;
    }
    /**
     * Creates an Iterator of the edges incident to the vertex.
     * @return the iterator
     */
    public Iterator<Edge<V,E>> adjListIter() {
        return adjList.iterator();
    }
    /**
     * Gets degree of this vertex
     * @return degree
     */
    public int degree() {
        return adjList.size();
    }
    /**
     * Checks to see if another vertex is equal to this one.
     * @param other vertex to check
     * @return true if they contain the same element
     */
    public boolean equals(Vertex<V,E> other) {
        return element.equals(other.getElement());
    }
}
