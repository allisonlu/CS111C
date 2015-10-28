/**
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.0
 */

public abstract class LinkedChainBase<T> {

    private Node firstNode;
    private int  numberOfEntries;

    public LinkedChainBase() {
        initializeDataFields();
    }

    public void clear() {
        initializeDataFields();
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        boolean result;

        if (numberOfEntries == 0) {
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null;
            result = false;
        }

        return result;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;

        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }

        return (T[]) result;
    }

    protected final Node getNodeAt(int givenPosition) {
        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);

        Node currentNode = firstNode;

        // Traverse the chain to locate the desired node
        // (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }

        assert currentNode != null;
        return currentNode;
    }

    protected final Node getFirstNode() {
        return firstNode;
    }

    protected final void addFirstNode(Node newNode) {
        assert newNode != null : "null argument in addFirstNode";
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        numberOfEntries++;
    }

    protected final void addAfterNode(Node nodeBefore, Node newNode) {
        assert newNode != null : "null newNode argument in addAfterNode";
        assert nodeBefore != null : "null nodeBefore argument in addAfterNode";

        Node nodeAfter = nodeBefore.getNextNode();

        nodeBefore.setNextNode(newNode);
        newNode.setNextNode(nodeAfter);

        numberOfEntries++;
    }

    protected final T removeFirstNode() {
        assert firstNode != null;
        Node oldNode = firstNode;

        firstNode = firstNode.next;
        numberOfEntries--;

        return oldNode.getData();
    }

    protected final T removeAfterNode(Node nodeBefore) {
        assert nodeBefore != null : "null argument in removeAfterNode";

        Node nodeToRemove = nodeBefore.getNextNode();

        if (nodeToRemove != null ) {
            nodeBefore.setNextNode(nodeToRemove.getNextNode());
            numberOfEntries--;
            return nodeToRemove.getData();
        } else {
            return null;
        }
    }

    protected final void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    // Node Class

    protected final class Node {
        private T data;     // Entry in list
        private Node next;  // Link to next node

        protected Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        protected T getData() {
            return data;
        }

        protected void setData(T value) {
            data = value;
        }

        protected Node getNextNode() {
            return next;
        }

        private void setNextNode(Node value) {
            next = value;
        }
    }
}



