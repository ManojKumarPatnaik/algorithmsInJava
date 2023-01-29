package My_Learning.maths;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FindRightIntervalLeetcode436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findRightInterval(int[][] intervals) {
		int res[] = new int[intervals.length];
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < intervals.length; i++) {
			String key = intervals[i][0] + ":" + intervals[i][1];
			hm.put(key, i);
		}
		Arrays.sort(intervals, new SortByFirst());
		for (int interval[] : intervals) {
			String key = interval[0] + ":" + interval[1];
			int pos = binarySearch(hm, intervals, interval[1]);
			res[hm.get(key)] = pos;
		}
		return res;
	}

	public int binarySearch(HashMap<String, Integer> hm, int[][] intervals, int end1) {
		int low = 0, end = intervals.length - 1, res = -1;
		while (low <= end) {
			int mid = low + (end - low) / 2;
			if (intervals[mid][0] == end1)
				return hm.get(intervals[mid][0] + ":" + intervals[mid][1]);
			else if (intervals[mid][0] > end1) {
				res = hm.get(intervals[mid][0] + ":" + intervals[mid][1]);
				end = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	class SortByFirst implements Comparator<int[]> {
		public int compare(int[] val1, int[] val2) {
			return val1[0] - val2[0];
		}
	}

}
