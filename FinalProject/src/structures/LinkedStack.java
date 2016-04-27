/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package structures;

/**
 * Realization of a stack as an adaptation of a SinglyLinkedList.
 * All operations are performed in constant time.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see SinglyLinkedList
 */
public class LinkedStack<E> implements Stack<E> {

  /** The primary storage for elements of the stack */
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty list

  /** Constructs an initially empty stack. */
  public LinkedStack() { }                   // new stack relies on the initially empty list

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  @Override
  public int size() { return list.size(); }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() { return list.isEmpty(); }

  /**
   * Inserts an element at the top of the stack.
   * @param element   the element to be inserted
   */
  @Override
  public void push(E element) { list.addFirst(element); }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack (or null if empty)
   */
  @Override
  public E top() { return list.first(); }

  /**
   * Removes and returns the top element from the stack.
   * @return element removed (or null if empty)
   */
  @Override
  public E pop() { return list.removeFirst(); }

  /** 
   * Produces a string representation of the contents of the stack.
   *  (ordered from top to bottom)
   * @return textual representation of the stack
   */
  @Override
  public String toString() {
    return list.toString();
  }
  
  public int search(E e) {
      LinkedStack temp = new LinkedStack();
      int loc = -1;
      //must save size because it changes as for loop runs
      int size = this.size();
      //look for e in this stack 
      for (int i = 0; i < size; i++) {
          if (this.top().equals(e)) {
              loc = i;
              break;
          }
          else {
              temp.push(this.pop());
          }
      }
      //put all elements of temp back into this stack
      for (int j=0; j < size; j++) {
          if (!temp.isEmpty())
            this.push((E)temp.pop());
      }
      return loc;
  }
 
}

