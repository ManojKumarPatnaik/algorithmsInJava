package My_Learning.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumDeletionToMakeCharUniqueLeetcode1647 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added minDeletion function
	public int minDeletions(String s) {
		// initalize hashmap and count to return
		HashMap<Character, Integer> map = new HashMap();
		int count = 0;

		// get the frequencies of each letter in the string
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		// store the frequencies into an arraylist
		List<Integer> frequencies = new ArrayList(map.values());

		// initalize hashset
		HashSet<Integer> set = new HashSet();

		// loop through the arraylist (frequencies) and check if the value is in the
		// hashset
		// if it isn't add it, if not, decrement the value and increment our counter
		// until it hits zero then add the value to the set
		for (int value : frequencies) {
			if (!set.contains(value)) {
				set.add(value);
			} else {
				while (value > 0 && set.contains(value)) {
					value--;
					count++;
				}
				set.add(value);
			}
		}
		return count;
	}

}
