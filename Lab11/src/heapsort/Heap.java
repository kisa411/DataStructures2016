
package heapsort;

import java.util.ArrayList;

/**
 * An implementation of an array-based heap.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @param <E>
 */
public class Heap<E extends Comparable>{ //has a comparable setting 
  /** 
   * an array storing the elements in the heap
   */
  protected ArrayList<E> heap = new ArrayList<>();

  /** 
   * Creates an empty heap.
   */
  public Heap() { }

  /**
   * Creates a heap using the given array of elements using a
   * bottom-up construction.
   * @param elements an array of the elements for the heap
   */
  public Heap(E[] elements) {
    for (int j=0; j < elements.length; j++)
      heap.add(elements[j]);
    heapify();
  }

  // protected utilities
  /**
   * returns the index of the parent of the element at the given index
   * @param j the index
   * @return the index of the parent of the given index
   */
  protected int parent(int j) { return (j-1) / 2; }     // truncating division
  /**
   * returns the index of the left child of the element at the given index
   * @param j the index
   * @return the index of the left child of the given index
   */  
  protected int left(int j) { return 2*j + 1; }
  /**
   * returns the index of the right child of the element at the given index
   * @param j the index
   * @return the index of the right child of the given index
   */
  protected int right(int j) { return 2*j + 2; }
  /**
   * decides whether the element at the given index has a left child
   * @param j the index
   * @return true if the element at the given index has a left child
   */
  protected boolean hasLeft(int j) { return left(j) < heap.size(); }
  /**
   * decides whether the element at the given index has a right child
   * @param j the index
   * @return true if the element at the given index has a right child
   */
  protected boolean hasRight(int j) { return right(j) < heap.size(); }

  /** Exchanges the entries at indices i and j of the array list.
   * @param i one index
   * @param j another index
   */
  protected void swap(int i, int j) {
    E temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  /** Moves the entry at index j higher, if necessary, to restore the heap property. 
   * @param j the index of the entry to move
   */
  private void upheap(int j) {
//    E parentIndex = heap.get(parent(j));
//    E currentIndex = heap.get(j);
    //while parent node of index j is greater than the value at index j, swap the two
    while ( j != 0 ) { //while index j is not the root of the heap
        if( heap.get(parent(j)).compareTo(heap.get(j)) > 0 ) { //if the value of j's parent node is greater than value of j
            swap(j, parent(j) ); //otherwise swap the two values
            System.out.println("in upheap function");
            j=parent(j);
        } 
        
    }  
  }

  /** Moves the entry at index j lower, if necessary, to restore the heap property. 
   * @param j the index of the entry to move
   */
  private void downheap(int j) {
    while (hasLeft(j)) {               // continue to bottom (or break statement)
      int leftIndex = left(j);
      int smallChildIndex = leftIndex;     // although right may be smaller
      if (hasRight(j)) {
          int rightIndex = right(j);
          if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) > 0)
            smallChildIndex = rightIndex;  // right child is smaller
      }
      if (heap.get(smallChildIndex).compareTo(heap.get(j)) >= 0)
        break;                             // heap property has been restored
      swap(j, smallChildIndex);
      j = smallChildIndex;                 // continue at position of the child
    }
  }

  /** Performs a bottom-up construction of the heap in linear time.
   */
  private void heapify() {
    int startIndex = parent(size()-1);    // start at PARENT of last entry
    for (int j=startIndex; j >= 0; j--)   // loop until processing the root
      downheap(j);
  }

  // public methods

  /**
   * Returns the number of items in the heap.
   * @return number of items
   */
  public int size() { return heap.size(); }

  /**
   * Returns (but does not remove) a minimal entry.
   * @return a minimal entry (or null if empty)
   */
  public E min() {
    if (heap.isEmpty()) return null;
    return heap.get(0);
  }

  /**
   * Inserts an element and returns the element.
   * @param newest the element to add
   * @return the element
   */
  public E insert(E newest) {
    heap.add(newest);                      // add to the end of the list
    upheap(heap.size() - 1);               // upheap newly added entry
    return newest;
  }

  /**
   * Removes and returns a minimal entry.
   * @return a minimal entry (or null if empty)
   */
  public E removeMin() {
    if (heap.isEmpty()) return null;
    E answer = heap.get(0);
    swap(0, heap.size() - 1);              // put minimum item at the end
    heap.remove(heap.size() - 1);          // and remove it from the list;
    downheap(0);                           // then fix new root
    return answer;
  }

  /**
   * Method creating a string representation of the heap.
   * @return the string representation of the heap
   */
  @Override
  public String toString(){
      StringBuilder sb = new StringBuilder();
      int linelength = 1;
      int currloc = 0;
      for (int i = 0; i < heap.size(); i++) {
          currloc++;
          sb.append(heap.get(i));
          sb.append("  ");
          if (currloc == linelength) {
              sb.append("\n");
              currloc = 0;
              linelength *= 2;
          }
      }
      return sb.toString();
  }
}