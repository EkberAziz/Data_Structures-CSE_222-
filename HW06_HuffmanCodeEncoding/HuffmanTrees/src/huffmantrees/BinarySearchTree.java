/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmantrees;

/*<listing chapter="6" section="4">*/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * A class to represent a binary search tree.
 * @author Koffman and Wolfgang
 * @param <E> a data which extends camparable
 */
public class BinarySearchTree<E extends Comparable<E>>
         extends BinaryTree<E>{
    // Data Fields

    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected E deleteReturn;

    //Methods
    /*<listing chapter="6" number="3">*/
    /**
     * Starter method find.
     * @pre The target object must implement
     *      the Comparable interface.
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */

    public E find(E target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     * @param localRoot The local subtree�s root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
        if (localRoot == null) {
            return null;
        }

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0) {
            return localRoot.data;
        } else if (compResult < 0) {
            return find(localRoot.left, target);
        } else {
            return find(localRoot.right, target);
        }
    }
    /*</listing>*/

    /*<listing chapter="6" number="4">*/
    /**
     * Starter method add.
     * @pre The object to insert must implement the
     *      Comparable interface.
     * @param item The object being inserted
     * @return true if the object is inserted, false
     *         if the object already exists in the tree
     */

    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     * Recursive add method.
     * @post The data field addReturn is set true if the item is added to
     *       the tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the
     *         inserted item
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree � insert it.
            addReturn = true;
            return new Node<E>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    /*</listing>*/

    /*<listing chapter="6" number="5">*/
    /**
     * Starter method delete.
     * @post The object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree
     *         or null if the object was not in the tree
     * @throws ClassCastException if target does not implement
     *         Comparable
     */
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    /**
     * Recursive delete method.
     * @post The item is not in the tree;
     *       deleteReturn is equal to the deleted item
     *       as it was stored in the tree or null
     *       if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain
     *         the item
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    /*</listing>*/

// Insert solution to programming exercise 1, section 4, chapter 6 here

    /*<listing chapter="6" number="6">*/
    /**
     * Find the node that is the
     * inorder predecessor and replace it
     * with its left child (if any).
     * @post The inorder predecessor is removed from the tree.
     * @param parent The parent of possible inorder
     *        predecessor (ip)
     * @return The data in the ip
     */
    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }
    /**
     * Returns the in-order representation for the given tree.
     * 
     * @return  the iterator for in-order traversal
     */
    public Iterator<E> inorderIterator() {
        return new InOrderItr();
    }
    
    private class TreeNodeDataInOrder {
        Node<E> treeNode;
        boolean visitedLeftBranch;

        TreeNodeDataInOrder(Node<E> treeNode, Boolean foo) {
            this.treeNode = treeNode;
            this.visitedLeftBranch = foo;
        }
    }
    /**
     * creates an iterator which traverses in-order sequence
     * implements Iterator interface
     */
    private class InOrderItr implements Iterator<E> {
        private final Stack<TreeNodeDataInOrder> stack;
        /**
         * constructor
         */
        public InOrderItr() {
            stack = new Stack<TreeNodeDataInOrder>();
            stack.add(new TreeNodeDataInOrder(root, false));
        }
        /**
         * check if it has next element
         * @return true if has a next element
         */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        /**
         * takes next item
         * @return 
         */
        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");

            while (hasNext()) {
                final TreeNodeDataInOrder treeNodeData = stack.peek();
                final Node<E> treeNode = treeNodeData.treeNode;

                if (!treeNodeData.visitedLeftBranch) {
                    if (treeNode.left != null) {
                        stack.add(new TreeNodeDataInOrder(treeNode.left, false));
                    }
                    treeNodeData.visitedLeftBranch = true;
                } else {
                    stack.pop();
                    if (treeNode.right != null) {
                        stack.add(new TreeNodeDataInOrder(treeNode.right, false));
                    }
                    return treeNode.data;
                }
            }
            throw new AssertionError("A node has not been returned when it should have been.");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid operation for in-order iterator.");
        }

    }
    /*</listing>*/

// Insert solution to programming exercise 2, section 4, chapter 6 here

// Insert solution to programming exercise 3, section 4, chapter 6 here
    
    public static void main(String[] args) {
        
        BinarySearchTree<Integer> Btree = new BinarySearchTree<Integer>();
        Btree.add(2);
        Btree.add(1);
        Btree.add(12);
        Btree.add(20);
        Btree.add(11);
        Btree.add(0);
        
        //System.out.println(Btree.find(21));
        System.out.println(Btree.toString());
        Btree.add(15);
        System.out.println(Btree.toString());
        Btree.delete(11);
        System.out.println(Btree.toString());
        
        Iterator Iter = Btree.inorderIterator();
        while(Iter.hasNext()){
            System.out.println(Iter.next());
        }
    }
}
/*</listing>*/
