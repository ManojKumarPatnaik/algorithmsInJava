package My_Learning.binarySearch;

import java.util.Arrays;

public class MinDiffHighestAndLowestLeetcode1984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumDifference(int[] A, int k) {

		Arrays.sort(A);

		int start = 0;
		int end = k - 1;
		int OvrMin = Integer.MAX_VALUE;

		int N = A.length;
		// after sorting in a window of size k the smallest no is at start and highest
		// no is At end

		while (end < N) {
			int diff = A[end] - A[start];

			OvrMin = Math.min(OvrMin, diff);

			start++;
			end++;
		} //

		return OvrMin;

	}

}
