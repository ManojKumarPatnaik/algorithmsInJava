package My_Learning.binarySearch;

import java.util.Arrays;

public class LongestSubsequenceSumWithLimitedSumLeetcode2389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] answerQueries(int[] A, int[] queries) {
		Arrays.sort(A);
		int n = A.length, m = queries.length, res[] = new int[m];
		for (int i = 1; i < n; ++i)
			A[i] += A[i - 1];
		for (int i = 0; i < m; ++i) {
			int j = Arrays.binarySearch(A, queries[i]);
			res[i] = Math.abs(j + 1);
		}
		return res;
	}

}
