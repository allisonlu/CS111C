java.util.*;

public class MapPractice {

	public static void main(String[] args) {
		Map<String, Integer> d = new HashMap<String, Integer>();
		String[] words = {"a", "b", "c", "c", "z", "a"};

		for (int i = 0; i < words.length; i++) {

			// if map already contains the word	
			// get(key) method returns value of key
			if (d.containsKey(words[i])) {
				int value = d.get(words[i]);
				value++;
				put(words[i], value);
			}
			else {
				put(words[i], 1);
			}

			// String word = words[i];
			// Integer count = d.get(word);

			// count = (count == null) ? 1 : count + 1;

			// d.put(word, count);

		} // end for

			// fancy way:
			// for(String word : words) {
			// int count = d.containsKey(word) ? d.get(word) + 1 : 1;
			// d.put(word, count) }

		// create iterator object
		Iterator<String> keys = d.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next;
			System.out.println(key + ": " + d.get(key));
		}
	}
}