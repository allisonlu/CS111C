/** CS111C Fall 2015 Midterm
 * write a clone method for LinkedStack
 */

public LinkedStack<T> clone() {
	// first thing to do is make a LinkedStack object to return
	LinkedStack<T> clone = new LinkedStack<T>();

	while(!isEmpty()) {
		clone.push(pop());
	}

	return clone;
}