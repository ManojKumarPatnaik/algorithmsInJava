package My_Learning.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervalLeetcode57 {
	
	// added interval merge method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };

		int[][] intervals2 = { { 1, 3 }, { 6, 9 } };
		int[] newInterval2 = { 2, 5 };

		System.out.println(insert3(intervals2, newInterval2));

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		int n = intervals.length;
		List<int[]> rows = new LinkedList<>();

		int start = getIndex(intervals, newInterval[0], 0, n - 1);
		int end = getIndex(intervals, newInterval[1], 0, n - 1);

		if (start == -1 && end == -1) {
			start = 0;

		}

		if (end == -1) {
			end = n - 1;
		}

		System.out.println("Start :: " + start);
		System.out.println("End :: " + end);

		for (int i = 0; i < intervals.length; i++) {
			if (i >= start && i <= end) {
				if (i == start) {
					intervals[i][0] = Math.min(intervals[start][0], intervals[i][0]);
					intervals[i][1] = Math.max(intervals[end][1], intervals[i][1]);

					rows.add(intervals[i]);
				}
			} else {
				rows.add(intervals[i]);
			}

		}

		for (int[] row : rows) {
			System.out.println(Arrays.toString(row));
		}
		return rows.toArray(new int[rows.size()][]);
	}

	public static int getIndex(int[][] arr, int start, int low, int high) {

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (start >= arr[mid][0] && start <= arr[mid][1]) {
				return mid;
			} else if (start >= arr[mid][0] && start > arr[mid][1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	public int[][] insert2(int[][] intervals, int[] newInterval) {
		List<int[]> result = new LinkedList<>();
		int i = 0;
		// add all the intervals ending before newInterval starts
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			// we could mutate newInterval here also
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}

		// add the union of intervals we got
		result.add(newInterval);

		// add all the rest
		while (i < intervals.length) {
			result.add(intervals[i]);
			i++;
		}

		return result.toArray(new int[result.size()][]);
	}

	public static int[][] insert3(int[][] intervals, int[] newInterval) {
		List<int[]> ans = new ArrayList<>();
		int[] toAdd = newInterval;

		for (int i = 0; i < intervals.length; i++) {
			/*
			 * 1. No overlap and toAdd appears before current interval, add toAdd to result.
			 */
			if (intervals[i][0] > toAdd[1]) {
				ans.add(toAdd);
				toAdd = intervals[i];
			}
			/* 2. Has overlap, update the toAdd to the merged interval. */
			else if (intervals[i][1] >= toAdd[0])
				toAdd = new int[] { Math.min(intervals[i][0], toAdd[0]), Math.max(intervals[i][1], toAdd[1]) };
			/*
			 * 3. No overlap and toAdd appears after current interval, add current interval
			 * to result.
			 */
			else
				ans.add(intervals[i]);
		}
		ans.add(toAdd);
		return ans.toArray(new int[ans.size()][2]);
	}

}
