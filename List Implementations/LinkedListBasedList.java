/*
 * A linkedlist implementation of ListInterface<T>
 *
 */

public class LinkedListBasedList<T> implements ListInterface<T> {

	private Node first;
	private Node last;
	private int size;

	public LinkedListBasedList() {
		first = null;
		last = null;
		size = 0;
	}

	public void add(T newEntry) {
		Node newNode = new Node();
		newNode.data = newEntry;

		// consider two cases
		// if list is empty
		if (first == null) {
			// make both head and tail nodes point to newNode
			first = last = newNode;
			size = 1;
		}
		else {
			last.next = newNode;
			last = newNode;
			size++; 
		}
	}

	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= size + 1)) {
			Node newNode = new Node (newEntry);

			if (newPosition == 1) {
				newNode.setNextNode(first);
				first = newNode;
			}
			else {
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();

				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}

			size++;
		}
		else
			throw new IndexOutOfBoundersException("Index out of bounds.");
	}

	public T remove(int givenPosition) {
		T result = null;

		if (size >= 1 && givenPosition <= size) {
			assert !isEmpty();

			// given position is first
			if (givenPosition == 1) {
				result = first.getData();
				first = first.getNextNode();
			}
			// given position is not first
			else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
         		Node nodeToRemove = nodeBefore.getNextNode();
         		result = nodeToRemove.getData(); 
         		Node nodeAfter = nodeToRemove.getNextNode();
         		nodeBefore.setNextNode(nodeAfter);
			}

			size--;
			return result;
		}
		else 
			throw new IndexOutOfBoundersException("Index out of bounds.");
	} // end remove

	public void clear() {
		first = last = null;
		size = 0;
	}

	public T replace(int givenPosition, T newEntry) {
		if (givenPosition >= 1 && givenPosition <= size) {
			assert !isEmpty();

			Node desired = getNodeAt(givenPosition);
			T original = desired.getData();
			desired.setData(newEntry);
			return original;
		}
		else 
			throw new IndexOutOfBoundersException("Index out of bounds.");
	}

	public T getEntry(int givenPosition) {
		if (givenPosition >= 1 && givenPosition <= size) {
			assert !isEmpty();

			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundersException("Index out of bounds.");
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked") 
		T[] result = (T[]) new Object[size];

		int i = 0;
		Node current = first;

		while (i < size && current != null) {
			result[i] = current.getData();
			current = current.getNextNode();
			i++;
		}

		return result;
	}

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currnet = first;

		while(!found && curent != null) {
			if(anEntry.equals(current.getData())) {
				found = true;
			}
			else
				current = current.getNextNode();
		}

		return found;
	}

	public int getLength() {
		return size;
	}


	public boolean isEmpty() {
		boolean result;

		if (size == 0) {
			assert first == null;
			result = true;
		}
		else {
			assert first != null;
			result = false;
		}

		return result;
	}


	private static class Node {

		public Node next;
		public T data;

		private Node(T dataPortion) {
         	data = dataPortion;
         	next = null;
         } // end constructor
      
      	private Node(T dataPortion, Node nextNode) {
         	data = dataPortion;
         	next = nextNode;
      	} // end constructor
      
      	private T getData() {
         return data;
     	 } // end getData
      
      	private void setData(T newData) {
         	data = newData;
      	} // end setData
      
      	private Node getNextNode() {
         	return next;
      	} // end getNextNode
      
      	private void setNextNode(Node nextNode) {
         	next = nextNode;
		}
}