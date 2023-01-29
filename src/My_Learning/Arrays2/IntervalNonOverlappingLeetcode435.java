package My_Learning.Arrays2;

import java.util.Arrays;

public class IntervalNonOverlappingLeetcode435 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int eraseOverlapIntervals(int[][] intervals) {
		// Maintain a counter, initialized at 1 since you're already taking the 1st
		// interval into consideration
		int count = 1;
		// Sort the array by the interval ends in order to have the correct sorting
		// order
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		// The first interval end is the very first lastEnd
		int lastEnd = intervals[0][1];
		// Iterate over intervals from 1st element
		for (int i = 1; i < intervals.length; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];
			// If the previous end is less than or equal to current start, increment
			// non-mergable count
			if (lastEnd <= start) {
				count++;
				// set the current end as the lastEnd for the next iteration
				lastEnd = end;
			}
		}
		// subtract the non-mergable count from the total initial intervals, which will
		// result in the actual mergable intervals (which were to be removed)
		return intervals.length - count;
	}

}
