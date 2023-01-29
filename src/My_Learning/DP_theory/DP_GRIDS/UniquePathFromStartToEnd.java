package My_Learning.DP_theory.DP_GRIDS;

import java.util.Arrays;

public class UniquePathFromStartToEnd {

	public static void main(String args[]) {

		int m = 3;
		int n = 2;

		System.out.println(countWays(m, n));
	}

	//Recursive Code
	static int countWaysRecursive(int i, int j) { // call at n-1 m-1
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		

		int up = countWaysRecursive(i - 1, j);
		int left = countWaysRecursive(i, j - 1);

		return up + left;

	}
	
	//Memoized Code
	static int countWays(int m, int n) {
		int dp[][] = new int[m][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return countWaysUtil(m - 1, n - 1, dp);

	}

	static int countWaysUtil(int i, int j, int[][] dp) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		int up = countWaysUtil(i - 1, j, dp);
		int left = countWaysUtil(i, j - 1, dp);

		return dp[i][j] = up + left;

	}

	// Tabulation
	static int countWaysUtilTabulation(int m, int n, int[][] dp) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// base condition
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0)
					up = dp[i - 1][j];
				if (j > 0)
					left = dp[i][j - 1];

				dp[i][j] = up + left;
			}
		}
		return dp[m - 1][n - 1];
	}

	// Space Optimized
	static int countWaysSpaceOptimized(int m, int n) {
		int prev[] = new int[n];
		for (int i = 0; i < m; i++) {
			int temp[] = new int[n];
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					temp[j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0)
					up = prev[j];
				if (j > 0)
					left = temp[j - 1];

				temp[j] = up + left;
			}
			prev = temp;
		}

		return prev[n - 1];

	}

	// Combinatorics Approach
	int uniquePaths(int m, int n) {
		int N = n + m - 2;
		int r = m - 1;
		double res = 1;

		for (int i = 1; i <= r; i++)
			res = res * (N - r + i) / i;
		return (int) res;
	}

}
