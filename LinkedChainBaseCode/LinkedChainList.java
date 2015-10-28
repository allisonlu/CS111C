/**
 * Created by schatz on 10/21/15.
 */
public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {

    public LinkedChainList() {
        super();
    }

    // Here is an example of how LinkedChainList's methods can be implemented
    // using methods inherited from LinkedChainBase
    public T remove(int givenPosition) {
        // Make sure we have a good index
        if (givenPosition < 1 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("index: " + givenPosition);
        }

        if (givenPosition == 1) {
            return removeFirstNode();
        } else {
            Node nodeBefore = getNodeAt(givenPosition);
            return removeAfterNode(nodeBefore);
        }
    }

    // Stub
    public void add(T newEntry) {
        // create newNode
        // set new node's data to newEntry
        Node newNode = new Node();
        newNode.data = newEntry;

        // if list is empty, set first and last node to newNode
        // update size to 1
        // otherwise set last node to newNode, set pointer to newNode
        // increase size
    }

    // Stub
    public void add(int newPosition, T newEntry) {
        // make sure index is okay
        if ((newPosition >= 1) && (newPosition <= size + 1)) {
            // create new node, pass in newEntry

            // if adding to index 1, set next node to first
            // otherwise
        }
        else
            throw new IndexOutOfBoundsException("index: " + newPosition);
    }

    // Stub
    public T replace(int givenPosition, T newEntry) {
        return null;
    }

    // Stub
    public T getEntry(int givenPosition) {
        return null;
    }

    //Stub
    public boolean contains(T anEntry) {
        return false;
    }
}
