package My_Learning.Arrays2;

import java.util.Arrays;
import java.util.TreeMap;

public class TwoBestNonOverLappingEventLeetcode2054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxTwoEvents(int[][] events) {
		TreeMap<Integer, Integer> tm = new TreeMap();
		Arrays.sort(events, (a, b) -> a[1] - b[1]);
		int ans = 0;
		int max = 0;
		for (int[] event : events) {
			Integer lower = tm.lowerKey(event[0]);
			ans = Math.max(ans, event[2]);
			max = Math.max(max, event[2]);
			if (lower != null) {
				ans = Math.max(ans, tm.get(lower) + event[2]);
			}
			tm.put(event[1], max);
		}
		return ans;
	}

}
