import java.util.PriorityQueue;

/**
 * MyPriorityQueue class is an implementation of the QueueInterface (included in directory)
 * uses LinkedList
 * written by Allison Lu
 * last modified: 10/13/15
 */


public class MyPriorityQueue<T extends Comparable<? super T>> implements QueueInterface {
	private Node front; // front of queue
	private Node rear; // back of queue
	private int size;

	public MyPriorityQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	/** Adds a new entry to the back of this queue.
      @param newEntry A plane object to be added. */
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);

		if (isEmpty()) {
			newNode.setNextNode(front);
			front = newNode;
			rear = newNode;
		}
		// enter into nonempty queue
		else {
			Node currentNode = front;

			for(int i=0; i < size; i++) {
				if (newNode.getData().compareTo(currentNode.getData()) {
					newNode.setNextNode(currentNode);
					newNode.setPreviousNode(currentNode.getPreviousNode());

					if (currentNode.getPreviousNode != null) {
						currentNode.getPreviousNode().setNextNode(newNode);
					}

					if (i==0) {
						front = newNode;
					}
				} else if (i==(size-1)) {
					newNode.setPreviousNode(currentNode);
					currentNode.setNextNode(newNode);
				} // end else if
			} // end for
		}

		size++;

	} // end enqueue

	/** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue. 
      @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() {
		if(isEmpty()) {
			throw new EmptyQueueException("Error: empty queue. Cannot dequeue.");
		}
		// if not empty, remove front
		else {
			Node firstNode = null;
			firstNode = front.getData();
			front = front.getNextNode();

			if (front == null) 
				rear = null;

			size--;
		}

		return front;
	} // end dequeue

	/**  Retrieves the entry at the front of this queue.
      @return  The plane object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty. */
  	public T getFront() {
  		if (isEmpty()) {
  			throw new EmptyQueueException("Error: empty queue. Cannot retrieve front entry.");
  		}
  		else {
  			return front.getData();
  		}
  	}
  
  	/** Detects whether this queue is empty.
      @return  True if the queue is empty, or false otherwise. */
  	public boolean isEmpty() {
  		if(front != null) 
  			return true;
  		else
  			return false;
  	}
  
  	/** Removes all entries from this queue. */
  	public void clear() {
  		front = null;
  		rear = null;
  		size = 0;
  	}

  	private class Node {
		private T data; // entry in stack
		private Node next; // link to next node
		private Node previous;

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(Node previousNode, T dataPortion, Node nextNode) {
			previous = previousNode;
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

		private void getPreviousNode(Node previousNode) {
			return previous;
		}

		private void setPreviousNode(Node previousNode) {
			previous = previousNode;
		}
	} // end private class Node
}