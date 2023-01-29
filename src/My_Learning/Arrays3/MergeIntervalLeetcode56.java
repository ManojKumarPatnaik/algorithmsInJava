package My_Learning.Arrays3;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervalLeetcode56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method for merge interval
	public int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length == 0)
			return intervals;

		Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

		Stack<int[]> s = new Stack<>();
		s.push(intervals[0]);

		for (int[] interval : intervals) {
			int[] top_list = s.peek();
			if (top_list[1] < interval[0])
				s.push(interval);
			else if (top_list[1] < interval[1]) {
				top_list[1] = interval[1];
				s.pop();
				s.push(top_list);
			}
		}

		return s.toArray(new int[s.size()][2]);
	}

}
