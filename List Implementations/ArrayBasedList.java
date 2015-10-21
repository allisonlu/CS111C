/*
 * An array implement of ListInterface<T>
 * 
 */

public class ArrayBasedList<T> implements ListInterface<T> {

	private T[] array;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACTY;

	// constructors from textbook
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayBasedList(int intialCapacity) {
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Ojbect[initialCapacity + 1];

		array = tempList;
		size = 0;
	}

	/*
	 * adds new entry to end of array list
	 * entries currently in list are unaffected
	 * @param newEntry Object to be added
	*/
	public void add(T newEntry) {
		array[size + 1] = newEntry;
		size++;
	}

	/*
	 * adds new entry at specified position
	 * entries at and above specified position are at next heigher position on list
	 * @param newPosition integer of specified position
	 * @param newEntry Object to be added
	*/
	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= size +1)) {
			if (newPosition <= size) {
				makeRoom(newPosition);
			}

			array[newPosition] = newEntry;
			size++;
		}
		else
			throw new IndexOutOfBoundsException("Given position is out of bounds");
	}

	/*
	 * removes entry at given position
	 * entries at positions higher are given next lower position 
	 * @param givenPosition integer of given position
	 * @return reference to removed entry
	 * @throws IndexOutOfBoundsException if givenPosition<1 or givenPosition>getLength()
	*/
	public T remove(int givenPosition) {
		if (givenPosition < 1 || givenPosition > getLength()) {
			throw new IndexOutOfBoundsException("Can't remove entry at that index.");
		}
		else if ((givenPosition >= 1) && (givenPosition <= size)) {
			T result = array[givenPosition];
			size--;
			return result;
		}
	}

	/*
	 * removes all entries
	*/
	public void clear() {

		size = 0;
	}

	/*
	 * replaces entry at given position 
	 * @param givenPosition integer of given position
	 * @param newEntry Object that will replace
	 * @return original entry that was replaced
	 * @throws IndexOutOfBoundsException if eithergivenPosition < 1 or givenPosition > getLength()
	*/
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= size)) {
			asset !isEmpty();

			T original = list[givenPosition];
			array[givenPosition] = newEntry];
			return orignal;
		}
		else 
			throw new IndexOutOfBoundsException("Index out of bounds.");
	}

	/*
	 * retrieves entry at given position  
	 * @param givenPosition integer of given position
	 * @return refrence to indicated entry
	 * @throws IndexOutOfBoundsException if eithergivenPosition < 1 or givenPosition > getLength()
	*/
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && givenPosition <= size)) {
			assert !isEmpty();
			return array[givenPosition];
		}
	else 
		throw new IndexOutOfBoundsException("Index out of bounds.");
	}

	/*
	 * retrieves all entries in list in the order in which they occur in list
	 * @return newly allocated array of all entries in array
	*/
	public T[] toArray() {
		return array;
	}

	/*
	 * sees whether this list contains given entry
	 * @param anEntry Object that is desired entry
	 * @return true if list contains anEntry, falise if otherwise
	*/
	public boolean contains(T anEntry) {
		boolean found = false;

		int i = 1;
		while (!found && i < size) {
			if (anEntry.equals(list[i])) {
				found = true;
			}
			i++;
		}

		return found;
	}

	/*
	 * gets length of this list
	 * @return number of entries currently in list
	*/
	public int getLength() {
		return size;
	}

	/*
	 * sees whether list is empty
	 * @return true if list is empty, false if not
	*/
	public boolean isEmpty() {
		return size==0;
	}

	/* helper method makeRoom expands array for new entry at newPosition
	 * precondition: 1 <= newPosition <= size + 1 or size is list's length before addition
	 */
	private void makeRoom(int newPosition) {
		assert (newPosition >= 1) && (newPosition <= size+1);

		int newIndex = newPosition;
		int lastIndex = size;

		// move each entry to next higher index, starting at end of list and continuing until entry at newIndex is removed
		for (int i = lastIndex; i >= newIndex; i--) {
			array[i + 1] = array[i];
		}
	}
}