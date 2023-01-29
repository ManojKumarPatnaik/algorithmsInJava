package My_Learning.dynamicProgramming2;

import java.util.HashMap;
import java.util.TreeSet;

public class AvoidFloodInCityLeetcode1488 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] avoidFlood(int[] rains) {
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> treeSet = new TreeSet<>();

		int[] ans = new int[rains.length];

		// Importaint for passing test case like 0, 2, 0, 2;
		for (int i = 0; i < ans.length; i++)
			if (rains[i] == 0)
				ans[i] = 1;

		for (int i = 0; i < rains.length; i++) {

			if (rains[i] == 0) {
				// dry day information store in treeset.
				treeSet.add(i);
			} else {
				int lakei = rains[i];
				// lake vs Day map
				if (map.containsKey(lakei)) {
					// getting the day lake got filled with rain.
					int day = map.get(lakei);

					// getting the nearest upcomming dry day from treeSet;
					if (treeSet.ceiling(day) != null) {
						int dryDay = treeSet.ceiling(day);
						// after getting dryday remove this day from treeset.
						treeSet.remove(dryDay);
						// on this dry day i am going to dry my lake.
						ans[dryDay] = lakei;

						// now lake can fill once again after drying
						map.put(lakei, i);
						ans[i] = -1;
					} else {
						// no ceiling dryday found.
						return new int[0];
					}
				} else {
					map.put(lakei, i);
					ans[i] = -1;
				}
			}
		}

		return ans;

	}

}
