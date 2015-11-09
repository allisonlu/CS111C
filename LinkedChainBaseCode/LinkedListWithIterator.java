import java.util.*;

/* 
 * LinkedListWithIterator is a subclass of LinkedChainList
 * as described in text chapter 15, segment 15.9
 */

public class LinkedListWithIterator<T> extends LinkedChainList<T> {
	private Node currentNode;
	private int size;

	public LinkedListWithIterator(Node firstNode) {
		currentNode = firstNode;
		size = 1;
	}

	public Iterator<T> iterator() {
		return new Iterator();
	}

	private class IteratorForLinkedList implements Iterator<T> {
		private Node nextNode;

		private IteratorForLinkedList() {
			nextNode = currentNode; 
		}

		public T next() {
			if (hasNext()) {
				Node returnNode = nextNode; // get next node
				nextNode = nextNode.getNextNode(); // advance iterator
				size++;

				return returnNode.getData(); // return next entry in iteration
			}
			else 
				throw new NoSuchElementException("Illegal call to next().");
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public void remove() {
			throw new UnsupportedOperationException("remove() is not supported by this iterator.");
		}
	} // end IteratorforLinkedList

	private class Node {
		private T data;
		private Node next;

		private Node(T dataEntry) {
			data = dataEntry;
			next = null;
		}

		private Node(T dataEntry, Node nextNode) {
			data = dataEntry;
			next = nextNode;
		}

		private Node getNextNode() {
			return next;
		}
	} // end Node class
}