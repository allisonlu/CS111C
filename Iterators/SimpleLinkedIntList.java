/*
 * practice writing own simple linkedlist
 */

public class SimpleLinkedIntList { 
	private Node first; // helpful for get
	private Node last; // helpful for add
	private int size;

	public SimpleLinkedIntList() {
		first = last = null;
		size = 0;
	}

	public SimpleLinkedIntList iterator() {
		// creates a new object, which "answers questions on behalf of list"
		return new MyIterator();
	}

	public void add(int value) {
		Node newNode = new Node();
		newNode.data = value;

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

	public int get(int index) {
		Node n = first;

		for (int i = 0; i < index; i++) {
			n = n.next;
		}

		return n.data;
	}

	public int size() {
		return size;
	}

	private static class Node {
		public Node next;
		public int data;
	}

	/*
	 * MyIterator private class
	 * internal data type
	 */
	private class MyIterator implements SimpleIntIterator {
		private Node current;

		public MyIterator() {
			current = first;
		}

		public boolean hasNext() {
			return current != last;
		}

		public int next() {
			int nextValue = current.data;
			current = current.next;

			return nextValue;
		}
	}

}