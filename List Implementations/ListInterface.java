/**
 * ListInterface
 */

public interface ListInterface {

	public void add(T);
	public void add(int, T);
	public T remove(int);

	/**
	 * replace method
	 */
	public T replace(int, T);
	public void clear();
	public T getEntry(int);
	public boolean contains(T);

	// utility methods

	public T[] toArray();
	public int getLength();
	public boolean isEmpty();
}