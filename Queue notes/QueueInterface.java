public interface QueueInterface<T> {
	/**
	 * adds new entry to back of queue
	 * @param newEntry Object to be added
	 */
	public void enqueue(T newEntry);
	
	/**
	 * removes and returns the entry at front of queue
	 * @return Object at front of queue
	 * @throws EmptyQueueException if queue is empty before operation
	 */
	public T dequeue();

	/** 
	 * retrieves entry at front of this queue
	 * @return Object at front of queue
	 * @throws EmptyQueueException if queue is empty
	 */
	public T getFront();

	/**
	 * detects whether this queue is empty
	 * @return True if queue is empty, false if otherwise
	 */
	public boolean isEmpty();

	/**
	 * removes all entries from queue
	 */
	public void clear();
}