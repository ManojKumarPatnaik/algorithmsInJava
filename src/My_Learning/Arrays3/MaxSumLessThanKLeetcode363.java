package My_Learning.Arrays3;

import java.util.TreeSet;

public class MaxSumLessThanKLeetcode363 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int n = matrix.length, m = matrix[0].length;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int A[] = new int[n];
			for (int j = i; j < m; j++) {
				for (int l = 0; l < n; l++) {
					A[l] += matrix[l][j];
				}
				res = Math.max(res, maxSubSumarray(A, k));
			}
		}
		return res;
	}

	private int maxSubSumarray(int[] A, int k) {
		TreeSet<Integer> presum = new TreeSet<>();
		presum.add(0);
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			Integer x = presum.ceiling(sum - k);
			if (x != null)
				res = Math.max(res, sum - x);
			presum.add(sum);
		}
		return res;
	}

}
