import java.util.Arrays;


public class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;    
    private int topIndex; 
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
  
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayStack(int initialCapacity)
    {
        checkCapacity(initialCapacity);
      

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    } 
   
    public boolean isEmpty()
    {
        return topIndex < 0;
    }
  
    private void ensureCapacity()
    {
      if(topIndex == stack.length - 1)
      {
          int newLength = 2*stack.length;
          checkCapacity(newLength);
          stack = Arrays.copyOf(stack, newLength);
      }
    }
    
    private void ensureCapacity(int n)
    {
        // add n slots to the array
        if(topIndex == stack.length - 1){ 
            int newLength = 2*stack.length + n;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }
  
    private boolean checkCapacity(int capacity)
    {
      boolean bool = true;
      if(capacity > MAX_CAPACITY)
          bool = false;
      return bool;
    }
    
    private boolean checkInitialized()
    {
        return initialized;
    }

    @Override
    public void push(T newEntry)
    {
        checkInitialized();
        ensureCapacity();
        stack[topIndex+1] = newEntry;
        topIndex++;
        
    }
    
    @Override
    public T pop()
    {

        checkInitialized();
        if(!isEmpty())
        {
            T top = stack[topIndex];
            stack[topIndex]= null;
            topIndex --;
            return top;
        } else
        {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }

            
    }
    
    @Override
    public T peek()
    {

        checkInitialized();
        if(isEmpty())
        {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
          
        } else
            return stack[topIndex];
    }
    
    @Override
    public void clear()
    {
        
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;    
    }
    

    public T peek2()
    {
        checkInitialized();
        if(isEmpty())
        {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
          
        } else
            return stack[topIndex-1];
    
    }

    @Override
    public String toString()
    {
        String s = "";
        for(int i = 0; i < stack.length; i++)
        {
            s +=  stack[i] + ",";
        }
        return s;
    }

    public void remove(int n)
    {
        checkInitialized();
        if(n <= topIndex)
        {
            for(int i = n; i < (topIndex - 1); i++)
            {
                stack[i] = stack[i+1];
            }
        }
    }
    
    public void pushAll(T[] a)
    {
        checkInitialized();
        checkCapacity(topIndex + a.length);
        ensureCapacity(a.length);
        for(int i = 0; i < a.length; i ++)
        {
            stack[topIndex + 1] = a[i];
            topIndex ++;
        }
        
    }
} 
