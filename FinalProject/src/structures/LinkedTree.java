/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.Iterator;

/**
 * A realization of a generic tree as a linked structure; each position may have any
 * number of children
 * @author ewolf
 */
public class LinkedTree<E> extends AbstractTree {



//---------------- nested Node class ----------------
    /**
     * Nested static class for a tree node with an arbitary number of children
     */
    protected static class Node<E> implements Position<E> {

        private E element;          // an element stored at this node
        private Node<E> parent;     // a reference to the parent node (if any)        
        private ArrayList<Node<E>> children; //a list of this node's children
        private int numChildren;             //number of children
        /**
         * Constructs a node with the given element and children.
         * @param e the element to be stored
         * @param above reference to a parent node
         * @param ch reference to a left child node
         */
        public Node(E e, Node<E> above, ArrayList<Node<E>> ch) {
            element = e;
            parent = above;
            children = ch;
            if (children==null)
                children = new ArrayList<Node<E>>();
            if (ch==null)
                numChildren = 0;
            else
                numChildren = ch.size();
        }

        // accessor methods
        /**
         * gets the element at this Node
         * @return the element
         */
        public E getElement() {
            return element;
        }

        /**
         * gets the parent at this node
         * @return the parent
         */
        public Node<E> getParent() {
            return parent;
        }
        /**
         * gets the children of this node
         * @return an arraylist of the children
         */
        public ArrayList<Node<E>> getChildren() {
            return children;
        }

        // update methods
        /**
         * set the element of this node to given element
         * @param e the new element
         */
        public void setElement(E e) {
            element = e;
        }
        /**
         * set the parent of this node
         * @param parentNode the parent
         */
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }
        /**
         * add a child to this node
         * @param child the child to add
         */
        public void addChild(Node<E> child) {
            children.add(numChildren, child);
        }
    } //----------- end of nested Node class -----------

    /**
     * Create a new node storing element e with given parent and children
     * @param e the element to store
     * @param parent the parent node
     * @param children the children to store
     * @return the new node
     */
    protected Node<E> createNode(E e, Node<E> parent,ArrayList<Node<E>> children) {
        return new Node<E>(e, parent, null);
    }

    // LinkedTree instance variables
    /**
     * The root of the binary tree
     */
    protected Node<E> root = null;     // root of the tree

    /**
     * The number of nodes in the binary tree
     */
    private int size = 0;              // number of nodes in the tree

    // constructor
    /**
     * Constructs an empty binary tree.
     */
    public LinkedTree() {}      // constructs an empty binary tree

    // nonpublic utility
    /**
     * Verifies that a Position belongs to the appropriate class, and is not one
     * that has been previously removed. Note that our current implementation
     * does not actually verify that the position belongs to this particular
     * list instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;       // safe cast
        if (node.getParent() == node) // our convention for defunct node
        {
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    // accessor methods (not already implemented in AbstractBinaryTree)
    /**
     * Returns the number of nodes in the tree.
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the children of p in a list
     * @param p the Position
     * @return the children of Position p
     * @throws IllegalArgumentException if p is not a valid position in the tree
     */
    @Override
    public Iterable<Node<E>> children(Position p) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        return parent.children;
    }




    // update methods supported by this class
    /**
     * Places element e at the root of an empty tree and returns its new
     * Position.
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null);
        size = 1;
        return root;
    }

    /**
     * Creates a new child of Position p storing element e and returns its
     * Position.
     * @param p the parent of the new child
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree
     */
    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        Node<E> child = createNode(e, parent, null);
        parent.addChild(child);
        size++;
        return child;
    }

    /**
     * Replaces the element at Position p with element e and returns the
     * replaced element.
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * A method that prints some tree info; for testing only
     */
    public void printTree() {
        System.out.println("Root is " + root.getElement()+"\n");
        printSubTree(root);        
    }
    
    private void printSubTree(Node<E> node){
        System.out.print(node.getElement()+" has children: ");
        for(Node<E> child: node.children) {
            System.out.print(child.getElement()+" ");
        } 
        System.out.println("");
        for(Node<E> child: node.children) {
            printSubTree(child);
        } 
    }
    
} //----------- end of LinkedTree class -----------


