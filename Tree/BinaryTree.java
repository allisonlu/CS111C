import java.util.*;/**   A class that implements the ADT binary tree.      @author Frank M. Carrano   @author Timothy M. Henry   @version 4.0*/public class BinaryTree<T> implements BinaryTreeInterface<T>{   private BinaryNode<T> root;   public BinaryTree()   {      root = null;   }   public BinaryTree(T rootData) {      root = new BinaryNode<T>(rootData);   }   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {      privateSetTree(rootData, leftTree, rightTree);   }   public void setTree(T rootData) {       root = new BinaryNode<T>(rootData);   }   public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {      privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);   }   /*   leftTree and rightTree are children   if these are either null or empty, we'll have to deal with them in a different way    */    private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {      root = new BinaryNode<T>(rootData);      /*       root.setLeftChild(leftTree.root);       leftTree.clear();       root.setRightChild(rightTree.root);       rightTree.clear();       */      if ((leftTree != null) && !leftTree.isEmpty())         root.setLeftChild(leftTree.root);             if ((rightTree != null) && !rightTree.isEmpty()) {         if (rightTree != leftTree)            root.setRightChild(rightTree.root);         else            root.setRightChild(rightTree.root.copy());      }      /*       * we're emptying the leftTree and rightTree objects       * and use the nodes instead       */      if ((leftTree != null) && (leftTree != this))         leftTree.clear();              if ((rightTree != null) && (rightTree != this))         rightTree.clear();	}	public T getRootData() {		if (isEmpty())			throw new IllegalStateException();		else            return root.getData();	}	public boolean isEmpty()	{      return root == null;	}	public void clear() {        root = null;    }	protected void setRootData(T rootData) {      root.setData(rootData);	}	protected void setRootNode(BinaryNode<T> rootNode)	{      root = rootNode;	}	protected BinaryNode<T> getRootNode()	{      return root;	}	public int getHeight()	{      return root.getHeight();	}	public int getNumberOfNodes()	{      return root.getNumberOfNodes();	}	public Iterator<T> getPreorderIterator() {return new PreorderIterator();}	public Iterator<T> getInorderIterator()	{		return new InorderIterator();		}	public Iterator<T> getPostorderIterator()	{		return new PostorderIterator();		}	public Iterator<T> getLevelOrderIterator()	{		return new LevelOrderIterator();		}	private class PreorderIterator implements Iterator<T>	{		private StackInterface<BinaryNode<T>> nodeStack;				public PreorderIterator() {			nodeStack = new LinkedStack<BinaryNode<T>>();            if (root != null)				nodeStack.push(root);		}				public boolean hasNext() {            return !nodeStack.isEmpty();		}				public T next() {			BinaryNode<T> nextNode;						if (hasNext()) {				nextNode = nodeStack.pop();				BinaryNode<T> leftChild = nextNode.getLeftChild();				BinaryNode<T> rightChild = nextNode.getRightChild();								// Push into stack in reverse order of recursive calls				if (rightChild != null)					nodeStack.push(rightChild);									if (leftChild != null)					nodeStack.push(leftChild);			} else {				throw new NoSuchElementException();			}					return nextNode.getData();		}			public void remove()		{			throw new UnsupportedOperationException();		}	}   public void iterativePreorderTraverse() {      StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<BinaryNode<T>>();      if (root != null)         nodeStack.push(root);      BinaryNode<T> nextNode;      while (!nodeStack.isEmpty())      {			nextNode = nodeStack.pop();			BinaryNode<T> leftChild = nextNode.getLeftChild();			BinaryNode<T> rightChild = nextNode.getRightChild();						// Push into stack in reverse order of recursive calls			if (rightChild != null)				nodeStack.push(rightChild);         			if (leftChild != null)				nodeStack.push(leftChild);                  System.out.print(nextNode.getData() + " ");      }   }   	private class InorderIterator implements Iterator<T> {      public boolean hasNext()      {         return false;      }      public T next() {return null;}      public void remove()      {         throw new UnsupportedOperationException();      } // end remove	}   public void iterativeInorderTraverse() {      StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<BinaryNode<T>>();      BinaryNode<T> currentNode = root;            while (!nodeStack.isEmpty() || (currentNode != null))      {         // Find leftmost node with no left child         while (currentNode != null)         {            nodeStack.push(currentNode);            currentNode = currentNode.getLeftChild();         } // end while                  // Visit leftmost node, then traverse its right subtree         if (!nodeStack.isEmpty())         {            BinaryNode<T> nextNode = nodeStack.pop();            assert nextNode != null; // Since nodeStack was not empty                                     // before the pop            System.out.print(nextNode.getData() + " ");            currentNode = nextNode.getRightChild();         }      }   }   	private class PostorderIterator implements Iterator<T> {        public boolean hasNext()        {            return false;        }        public T next() {return null;}        public void remove()        {            throw new UnsupportedOperationException();        } // end remove	}		private class LevelOrderIterator implements Iterator<T> {        public boolean hasNext()        {            return false;        }        public T next() {return null;}        public void remove()        {            throw new UnsupportedOperationException();        } // end remove	}}