package My_Learning.Arrays3;

import java.util.Arrays;

public class SmallestSumRange2Leetcode910 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int smallestRangeII(int[] A, int K) {
		Arrays.sort(A);
		int n = A.length;
		int res = A[n - 1] - A[0];
		for (int i = 0; i < n - 1; i++) {
			int max = Math.max(A[i] + K, A[n - 1] - K);
			int min = Math.min(A[i + 1] - K, A[0] + K);
			res = Math.min(res, max - min);
		}
		return res;
	}

}
