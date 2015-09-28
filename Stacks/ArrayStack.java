/**
  * ArrayStack  
  */

public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack; // array of stack entries
	private int topIndex; // index of top entry
	private boolean initializad = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	// default constructor
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	// constructor
	public ArrayStack(int initialCapacity) {
		checkCapacity(initialCapacity);

		// cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}

	// implementations of the stack operations

	/** Adds a new entry to top of this stack.
     * @param newEntry An object to be added to this stack
     */
	public void push(T newEntry) {
		stack[topIndex++] = newEntry;
	}

	/** Removes and returns this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty before the operation.
	*/
	public T pop() {
		if(stack.isEmpty()) {
			throw new ArrayIndexOutOfBoundException("Stack is empty.");
		}

		T result = stack[topIndex--];
		stack[--topIndex] = null;
		return result;
	}

	/** Retrieves this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty.
	*/
	public T peek() {
		if(stack.isEmpty()) {
			throw new ArrayIndexOutOfBoundException("Stack is empty.");
		}
		return stack[topIndex];
	}

	/** Detects whether this stack is empty.
	@return True if the stack is empty.
	*/
	public boolean isEmpty() {
		boolean flag = true;

		if (topIndex == -1) 
			return true;
		else
			return false;
	}

	/** Removes all entries from this stack.
	*/
	public void clear() {
		T[] emptyArray = new T[DEFAULT_CAPACITY];
		stack = emptyArray;
		topIndex = -1;
	}

	// implementations of Jason's methods

	/** Returns the element below the top element or throw an exception if there are less than two elements
	 */
	public T peek2() {
		if(topIndex<0) {
			System.out.println("nope!");
		}

		return stack[topIndex-1];
	}

	/** Returns a string that shows all of the elements on the stack
	 */
	public String toString() {
		String s = "";

		for(int i=0; i<stack.length; i++) {
			s += stack[i];
		}

		return s;
	}

	/** Removes the top n entries from the stack and stops as soon as the stack is empty.
	*/
	public void remove(int n) {
		if (stack!=isEmpty) {
			//
		}
	}

	/** Pushes each element in the array, beginning with index 0
	 */
	public void pushAll (T[] a) {
		for(int i=0; i<a.length; i++) {
			push(a[i]);
		}
	}

	/** checkCapacity throws an exception if the client requests a capacity that is too large.
	 */
   private void checkCapacity(int capacity) {
   		if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
    // assert newLength >= MAX_CAPACITY : "Request exceeds capacity: " + newLength;

   } // end checkCapacity

} // end ArrayStack