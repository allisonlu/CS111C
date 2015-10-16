
/** interleave method
 * what does this method do?
 */

public void interleave(StackInterface<T> s) {
	// create new Stack objects
	StackInterface<T> tempS = new StackInterface<T>(); //for param
	StackInterface<T> temp = new StackInterface<T>(); //temporary
	StackInterface<T> result = new StackInterface<T>(); //with all items
	StackInterfaceT<T> finalResult = new StackInterface<T>(); //FINAL RESULT

	//reverse both stacks
	while(!isEmpty()) {
		temp.push(pop());
	}

	while(!tempS.isEmpty()) {
		tempS.push(s.pop());
	}

	//alternate 
	while(!temp.isEmpty() || !tempS.isEmpty()) {
		result.push(temp.pop());
		result.push(tempS.pop());
	}

	if(!temp.isEmpty()) {
		while(!temp.isEmpty())
			result.push(temp.pop());
	}
	else {
		while(!tempS.isEmpty())
			result.push(tempS.pop());
	}

	while(!result.isEmpty()) {
		finalResult.push(result.pop());
	}

	clear();

	while(!finalResult.isEmpty()) {
		push(finalResult.pop());
	}

}

/** double method
 */

public void double() {
	peek(push());
}

/** filter method
 */

public void filter(T item) {

}

/**
 * CS111C Fall 2015 Midterm 
 * write a reverse method for a LinkedStack
 */

public void reverse() {
	LinkedStack<T> temp = clone();
	clear();

	while(!temp.isEmpty()) {
		push(temp.pop());
	}
} //end reverse

/** CS111C Fall 2015 Midterm
 * write a clone method for a LinkedStack
 */

public LinkedStack<T> clone() {
	// first thing to do is make a LinkedStack object to return
	LinkedStack<T> clone = new LinkedStack<T>();

	while(!isEmpty()) {
		clone.push(pop());
	}

	return clone;
} //end clone