import java.util.*;

/*
 * Iterator Experiments
 * ArrayList implementation
 */

public class IteratorExperiments {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		fillList(list, 1000000);

		// grabs clock time
		long startTime = (new Date()).getTime();
		// timed code here....
		System.out.println("average value: " + average(list));
		long endTime = (new Date()).getTime();

		System.out.println("milliseconds: " + (endTime-startTime));
	}

	public static double average(List<Integer> list) {
		double total = 0;

		Iterator<Integer> iterator = list.iterator();
		// this is an object that implements both List and Iterator interfaces

		/*
		while (has more elements....) {
			total += ??? / (double)list.size();
		}
		 */

		while (iterator.hasNext()) {
			total += iterator.next() / (double) list.size();
		}

		// returns an average
		return total;
	}

	public static void fillList(List<Integer> list, int count) {
		for (int i = 0; i < count; i++) {
			list.add((int) (Math.random() * 1000));
		}
	}



	/* returns random index, up to but not including count
	 * casts double to int
	 */
	public static int randomIndex(int count) {
		return (int) Math.random()*count;
	}
}