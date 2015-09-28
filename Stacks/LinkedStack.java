import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 */

public class LinkedStack<T> implements StackInterface<T> {
	private Node topNode; // references first node in chain
	private int size;

	// default constructor
	public LinkedStack() {
		topNode = null;
		size = -1;
	}

	// implementations of stack operations

	/** Adds a new entry to top of this stack.
    @param newEntry An object to be added to this stack
     */
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		size++;
	}

	/** Removes and returns this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty before the operation.
	*/
	public T pop() {
		if (topNode == null) {
			throw new ArrayIndexOutOfBoundException("Stack is empty.");
		}

		T item = peek();
		topNode = topNode.getNextNode();
		size--;
		return item;
	}

	/** popTo removes argument entry
	 * 
	 */
	public void popTo(T) {
		if (topNode.next == top)

	//topNode.nextNode.getData() - not committing, only looking down the well but not jumping
	//topNode.getNextNode - physically getting the node
	}

	/** Retrieves this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty.
	*/
	public T peek() {
		if (topNode == null) {
			throw new ArrayIndexOutOfBoundException("Stack is empty.");
		}

		return topNode.data;
	}

	/** Detects whether this stack is empty.
	@return True if the stack is empty.
	*/
	public boolean isEmpty() {
		return (top==null);
	}

	/** Removes all entries from this stack.
	*/
	public void clear(){
		size = 0;
		topNode = null;
	}

	private class Node {
		private T data; // entry in stack
		private Node next; // link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node linkPortion) {
			data = dataPortion;
			next = linkPortion;
		} // end constructor

		private T getData() {
			return data;
		} 

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	} // end private class Node
} // end LinkedStack