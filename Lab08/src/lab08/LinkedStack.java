/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab08;
/**
 * Linked Stack Implementation
 * @author kisa411
 * @param <E> Generic element
 */
public class LinkedStack<E> implements Stack<E> {

  /** The primary storage for elements of the stack */
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an initially empty linked list

  /** Constructs an initially empty stack. */
  public LinkedStack() { }                   // new stack relies on the initially empty list

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  @Override
  public int size() { 
    return list.size(); 
  }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() { 
    return list.size() == 0; //if there's nothing in list then return true, otherwise return false
  }

  /**
   * Inserts an element at the top of the stack.
   * @param element   the element to be inserted
   */
  @Override
  public void push(E element) { 
    list.addFirst( element ); //add the element to the head
  }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack (or null if empty)
   */
  @Override
  public E top() { 
    E top;
    top = list.first(); //return the element at the top of linkedstack
//    System.out.println(" The first element: " + top);
    return top;
  }

  /**
   * Removes and returns the top element from the stack.
   * @return element removed (or null if empty)
   */
  @Override
  public E pop() { 
    E removed;
    removed = list.removeFirst(); //remove the first element at the top of linkedStack, returns the removed element
    return removed;
  }

  /** 
   * Produces a string representation of the contents of the stack.
   *  (ordered from top to bottom)
   * @return textual representation of the stack
   */
  @Override
  public String toString() { 
    String contents;
    contents = list.toString(); //put the contents of the stack in a string format
    return contents; //return the contents of stack
  }
  
}

