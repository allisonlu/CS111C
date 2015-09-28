public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; 
    private int topIndex; 
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
  
   public LinkedStack()
   {
      topNode = null;
      initialized = true;
      topIndex = -1;
   } 
  

    private class Node
    {
      private T    data; 
      private Node next; 
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } 
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      } 
      
      private T getData()
      {
         return data;
      }
      
      private void setData(T newData)
      {
         data = newData;
      } 
      
      private Node getNextNode()
      {
         return next;
      } 
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } 
    } 


    private boolean checkInitialization()
    {
        return initialized;
    }
    
    public T peek()
    {
       if (isEmpty())
          throw new ArrayIndexOutOfBoundsException("Stack is empty");
       else
          return topNode.getData();
    }
    
    public T pop()
    {
       T top = peek();  // Might throw EmptyStackException

       assert (topNode != null);
       topNode = topNode.getNextNode();
       topIndex --;

       return top;
    } 
    
    public boolean isEmpty()
    {
       return topNode == null;
    } // end isEmpty

    public void clear()
    {
       topNode = null;
       topIndex = -1;
    }
    
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
        topIndex ++;
    }

    @Override
    public T peek2()
    {
        Node currentNode = topNode;
        currentNode = currentNode.getNextNode();
        return currentNode.getData();
    }

    @Override
    public void remove(int n)
    {
        
        Node currentNode = topNode;
        if(n <= topIndex)
        {
            for(int i = 0; i < (n - 1); i++)
            {
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
            }
        }
        topIndex --;        
    }

    @Override
    public void pushAll(T[] a)
    {
        Node newNode;
        for(int i = 0; i < a.length; i++)
        {
            newNode = new Node(a[i], topNode);
            topNode = newNode;
            topIndex++;
        }
    }  
} 
