package My_Learning.binarySearch;

public class MinSideLengthSquareLeetcode1292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSideLength(int[][] mat, int threshold) {

		int m = mat.length;
		int n = mat[0].length;

		int preSum[][] = new int[m][n];

		// Creating prefix sum array
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					preSum[0][0] = mat[0][0];
					continue;
				}

				if (i == 0 && j >= 1) {
					preSum[i][j] = preSum[i][j - 1] + mat[i][j];
					continue;
				}

				if (j == 0 && i >= 1) {
					preSum[i][0] = preSum[i - 1][0] + mat[i - 1][0];
					continue;
				}

				preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i][j];
			}
		}

		// Applying Binary Search
		int low = 1;
		int high = Math.min(m, n);

		while (low <= high) {
			int size = (low + high) / 2;

			int sum = 0;

			int minm = findMinValue(size, preSum);

			if (minm > threshold) {
				high = size - 1;
			} else {
				low = size + 1;
			}
		}

		return low - 1;
	}

	// This function calculates the minimum sum of a square matrix from all the
	// square matrices of sideLength = size
	public int findMinValue(int size, int[][] preSum) {

		int minm = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = size - 1; i < preSum.length; i++) {
			for (int j = size - 1; j < preSum[0].length; j++) {
				if (i == size - 1 && j == size - 1) {
					sum = preSum[i][j];
				} else if (i == size - 1 && j >= size) {
					sum = preSum[i][j] - preSum[i][j - size];
				} else if (i >= size && j == size - 1) {
					sum = preSum[i][j] - preSum[i - size][j];
				} else {
					sum = preSum[i][j] - preSum[i - size][j] - preSum[i][j - size] + preSum[i - size][j - size];
				}
				minm = Math.min(minm, sum);
			}
		}

		return minm;
	}

}
