
package studentRecordsBackupTree.bst;

import java.util.ArrayList;
import java.util.Collection;

/**
 * BST tree node which also acts as an observer
 */
public class Node implements Observer {
    /**
     * BNumber data
     */
    private int bnumber;

    /**
     * String description
     */
    private final String description;

    /**
     * Link to left child
     */
    private Node left;

    /**
     * Link to right node
     */
    private Node right;

    /**
     * Collection of node change observers
     */
    private Collection<Observer> observers;

    /**
     * Constructor creating node with given data
     * @param bnumber integer data
     * @param description string data
     * @param observers collection of observers
     */
    public Node(int bnumber, String description, Collection<? extends Observer> observers) {
        this.bnumber = bnumber;
        this.description = description;
        this.observers = new ArrayList<>(observers);
    }

    /**
     * Getter for bNumber field
     * @return integer data of node
     */
    public int getBnumber() {
        return bnumber;
    }

    /**
     * Getter for description field
     * @return string data of node
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for left field
     * @return left child
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Setter for left field
     * @param left left child to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Getter for right field
     * @return right child
     */
    public Node getRight() {
        return right;
    }

    /**
     * Setter for right field
     * @param right right child to set
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Increments integer value of the node
     * @param value to increment integer with
     */
    public void increment(int value) {
        bnumber += value;
        notifyObservers();
    }

    /**
     * Method for updating node with given integer
     * @param value to update with
     */
    @Override
    public void update(int value) {
        bnumber = value;
    }

    /**
     * Notify observers method
     */
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(bnumber);
        }
    }
}
