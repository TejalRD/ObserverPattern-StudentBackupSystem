package studentRecordsBackupTree.bst;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Builder class for Binary search tree instance
 */
public class BSTBuilder {
    /**
     * Inner binary search tree
     */
    private final BST bst;

    /**
     * Collection of backup tree buildes
     */
    private final Collection<BSTBuilder> backups;

    /**
     * Constructor creating builder with given backup builders
     *
     * @param backups backup builders
     */
    public BSTBuilder(Collection<BSTBuilder> backups) {
        bst = new BST();
        this.backups = new ArrayList<>(backups);
    }

    /**
     * Constructor creating builder with no backups
     */
    public BSTBuilder() {
        this(new ArrayList<>());
    }


    /**
     * Method for adding data to inner tree field
     * @param bnumber integer data
     * @param description string data
     * @return this builder instance
     */
    public BSTBuilder add(int bnumber, String description) {
        Collection<Node> nodes = new ArrayList<>();
        for (BSTBuilder backup : backups) {
            nodes.add(backup.bst.insert(bnumber, description));
        }
        bst.insert(bnumber, description, nodes);
        return this;
    }

    /**
     * Build method, returning inner bst instance
     * @return inner built bst
     */
    public BST build() {
        return bst;
    }
}
