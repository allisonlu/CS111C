import java.util.*;

/*
 * Iterator Experiments
 * LinkedList implementation
 */

public class IteratorExperiments2 {

	public static void main(String[] args) {

		SimpleLinkedIntList list = new SimpleLinkedIntList();

		fillList(list, 1000);

		// grabs clock time
		long startTime = (new Date()).getTime();
		// timed code here....
		System.out.println("average value: " + average(list));
		long endTime = (new Date()).getTime();

		System.out.println("milliseconds: " + (endTime-startTime));
	}

	public static double average(SimpleLinkedIntList list) {
		double total = 0;

		SimpleIntIterator iterator = list.iterator();

		while(iterator.hasNext()) {
			total += iterator.next() / (double) list.size();
		}

		// returns an average
		return total;
	}

	public static void fillList(SimpleLinkedIntList list, int count) {
		for (int i = 0; i < count; i++) {
			list.add((int)(Math.random() * 1000));
		}
	}

	/* returns random index, up to but not including count
	 * casts double to int
	 */
	public static int randomIndex(int count) {
		return (int) Math.random()*count;
	}
}