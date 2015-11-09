/**
 * Created by schatz on 10/21/15.
 */
public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {

    private int size = 0;

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
        Node newNode = new Node(newEntry);
        Node currentNode = getFirstNode();

        while(currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        addAfterNode(currentNode, newNode);

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

            Node newNode = new Node(newEntry);
            Node currentNode = getFirstNode();

            for(int i = 0; i < newPosition; i++) {
                currentNode = currentNode.getNextNode();
            }
            addAfterNode(currentNode, newNode);
        }
        else
            throw new IndexOutOfBoundsException("Index: " + newPosition + " out of bounds");
    }

    // Stub
    public T replace(int givenPosition, T newEntry) {
        if (givenPosition < 1 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("Index " + givenPosition + " out of bounds");
        }
        else {
            Node newNode = new Node(newEntry);
            Node currentNode = getFirstNode();

            for(int i = 0; i < givenPosition; i++) {
                currentNode = currentNode.getNextNode();
            }

            T temp = removeAfterNode(currentNode);
            addAfterNode(currentNode, newNode);
            return temp;
        }

    }

    // Stub
    public T getEntry(int givenPosition) {
        if (givenPosition < 1 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("Index " + givenPosition+ " out of bounds");
        }
        else {
            Node currentNode = getFirstNode();

            for (int i = 0; i < givenPosition; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getData();
        }
    }

    //Stub
    public boolean contains(T anEntry) {
        return false;
    }
}
