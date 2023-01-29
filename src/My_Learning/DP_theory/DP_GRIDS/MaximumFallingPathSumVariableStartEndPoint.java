package My_Learning.DP_theory.DP_GRIDS;

import java.util.Arrays;

public class MaximumFallingPathSumVariableStartEndPoint {

	public static void main(String args[]) {

		int matrix[][] = { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };

		System.out.println(getMaxPathSum(matrix));
	}

	// Memoized Code
	static int getMaxPathSum(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		int dp[][] = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		int maxi = Integer.MIN_VALUE;

		for (int j = 0; j < m; j++) {
			int ans = getMaxUtil(n - 1, j, m, matrix, dp);
			maxi = Math.max(maxi, ans);
		}

		return maxi;
	}

	// Recursive
	static int getMaxUtilRecursive(int i, int j, int m, int[][] matrix) {

		// Base Conditions
		if (j < 0 || j >= m)
			return (int) Math.pow(-10, 9);
		if (i == 0)
			return matrix[0][j];

		int up = matrix[i][j] + getMaxUtilRecursive(i - 1, j, m, matrix);
		int leftDiagonal = matrix[i][j] + getMaxUtilRecursive(i - 1, j - 1, m, matrix);
		int rightDiagonal = matrix[i][j] + getMaxUtilRecursive(i - 1, j + 1, m, matrix);

		return Math.max(up, Math.max(leftDiagonal, rightDiagonal));

	}

	// Memoized Code
	// added method to memoize code and get the max sum
	static int getMaxUtil(int i, int j, int m, int[][] matrix, int[][] dp) {

		// Base Conditions
		if (j < 0 || j >= m)
			return (int) Math.pow(-10, 9);
		if (i == 0)
			return matrix[0][j];

		if (dp[i][j] != -1)
			return dp[i][j];

		int up = matrix[i][j] + getMaxUtil(i - 1, j, m, matrix, dp);
		int leftDiagonal = matrix[i][j] + getMaxUtil(i - 1, j - 1, m, matrix, dp);
		int rightDiagonal = matrix[i][j] + getMaxUtil(i - 1, j + 1, m, matrix, dp);

		return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));

	}

	// Tabulation
	static int getMaxPathSumTabulation(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		int dp[][] = new int[n][m];

		// Initializing first row - base condition
		for (int j = 0; j < m; j++) {
			dp[0][j] = matrix[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {

				int up = matrix[i][j] + dp[i - 1][j];

				int leftDiagonal = matrix[i][j];
				if (j - 1 >= 0)
					leftDiagonal += dp[i - 1][j - 1];
				else
					leftDiagonal += (int) Math.pow(-10, 9);

				int rightDiagonal = matrix[i][j];
				if (j + 1 < m)
					rightDiagonal += dp[i - 1][j + 1];
				else
					rightDiagonal += (int) Math.pow(-10, 9);

				dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));

			}
		}

		int maxi = Integer.MIN_VALUE;

		for (int j = 0; j < m; j++) {
			maxi = Math.max(maxi, dp[n - 1][j]);
		}

		return maxi;
	}

	// Space Optimized
	int getMaxPathSumSpaceOptimized(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		int[] prev = new int[m];
		int[] cur = new int[m];

		// Initializing first row - base condition
		for (int j = 0; j < m; j++) {
			prev[j] = matrix[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {

				int up = matrix[i][j] + prev[j];

				int leftDiagonal = matrix[i][j];
				if (j - 1 >= 0)
					leftDiagonal += prev[j - 1];
				else
					leftDiagonal += -1e9;

				int rightDiagonal = matrix[i][j];
				if (j + 1 < m)
					rightDiagonal += prev[j + 1];
				else
					rightDiagonal += -1e9;

				cur[j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));

			}

			prev = cur;
		}

		int maxi = Integer.MIN_VALUE;

		for (int j = 0; j < m; j++) {
			maxi = Math.max(maxi, prev[j]);
		}

		return maxi;

	}

}
