public interface StackInterface<T>
{
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry);
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop();
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek();
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty();
  
   /** Removes all entries from this stack. */
   public void clear();
   
   public T peek2();  // Returns the element below the top element, or throw an exception if there are less than two elements
   public String toString();  // Returns a string that shows all of the elements on the stack. You can choose the format.
   public void remove(int n); // removes the top n entries from the stack. Stops as soon as the stack is empty.
   public void pushAll(T[] a); // pushes each element in the array , beginning with index 0. 
   
} 