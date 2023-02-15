
package studentRecordsBackupTree.bst;

import studentRecordsBackupTree.util.MyLogger;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of binary search tree
 */
public class BST {
    /**
     * Root node link
     */
    private Node root;

    /**
     * Constructor creating empty binary search tree
     */
    public BST() {
        MyLogger.writeMessage("Constructor is called", MyLogger.DebugLevel.CONSTRUCTOR);
        this.root = null;
    }

    /**
     * Method for inserting new data as node with no observers
     * @param bnumber integer data
     * @param description string data
     * @return inserted node
     */
    public Node insert(int bnumber, String description) {
        return insert(bnumber, description, new ArrayList<>());
    }

    /**
     * Method for inserting new data as node with given observers
     * @param bnumber integer data
     * @param description string data
     * @param observers observers to set
     * @return inserted node
     */
    public Node insert(int bnumber, String description, Collection<? extends Observer> observers) {
        MyLogger.writeMessage("Value is inserted", MyLogger.DebugLevel.NONE);
        if (root == null) {
            root = new Node(bnumber, description, observers);
            return root;
        }
        else {
            return insertStep(root, bnumber, description, observers);
        }
    }

    /**
     * Helper recursive method to make insertion of data into the tree
     * @param node current node
     * @param bnumber integer data
     * @param description string data
     * @param observers observers to set
     * @return inserted node
     */
    private Node insertStep(Node node, int bnumber, String description, Collection<? extends Observer> observers) {
        int diff = Integer.compare(node.getBnumber(), bnumber);
        if (diff < 0) {
            if (node.getRight() == null) {
                Node newNode = new Node(bnumber, description, observers );
                node.setRight(newNode);
                return newNode;
            }
            else {
                return insertStep(node.getRight(), bnumber, description, observers);
            }
        }
        else {
            if (node.getLeft() == null) {
                Node newNode = new Node(bnumber, description, observers );
                node.setLeft(newNode);
                return newNode;
            }
            else {
                return insertStep(node.getLeft(), bnumber, description, observers);
            }
        }
    }

    /**
     * Method for printing integer data from tree in in-order
     */
    public void printInorder() {
        printInorderStep(root);
    }

    /**
     * Helper recursive method to print tree content
     * @param node current node
     */
    private void printInorderStep(Node node) {
        if (node == null) {
            return;
        }

        printInorderStep(node.getLeft());
        System.out.println(node.getBnumber());
        printInorderStep(node.getRight());
    }

    /**
     * Calculates sum of integer data in tree
     * @return data sum
     */
    public int sum() {
        MyLogger.writeMessage("Calculating sum", MyLogger.DebugLevel.NONE);
        return sumStep(root);
    }

    /**
     * Helper recursive method to calculate integer data sum
     * @param node current node
     * @return data sum
     */
    private int sumStep(Node node) {
        if (node == null) {
            return 0;
        }

        return sumStep(node.getLeft()) + node.getBnumber() + sumStep(node.getRight());
    }

    /**
     * Increments content of each node in tree by given value
     */
    public void increment(int value) {
        MyLogger.writeMessage("Incrementing values", MyLogger.DebugLevel.NONE);
        incrementStep(root, value);
    }

    /**
     * Helper recursive method to increment node content by given value
     * @param node current node
     * @param value to increment data with
     */
    private void incrementStep(Node node, int value) {
        if (node == null) {
            return;
        }

        incrementStep(node.getLeft(), value);
        node.increment(value);
        incrementStep(node.getRight(), value);
    }
}
