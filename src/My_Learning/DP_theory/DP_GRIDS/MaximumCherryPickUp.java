package My_Learning.DP_theory.DP_GRIDS;

import java.util.Arrays;

public class MaximumCherryPickUp {

	public static void main(String args[]) {

		int matrix[][] = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } };
		int n = matrix.length;
		int m = matrix[0].length;

		System.out.println(maximumChocolates(n, m, matrix));
	}

	// Recursive Code
	static int maxChocoUtilRecursive(int i, int j1, int j2, int n, int m, int[][] grid) {
		if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
			return (int) (Math.pow(-10, 9));

		if (i == n - 1) {
			if (j1 == j2)
				return grid[i][j1];
			else
				return grid[i][j1] + grid[i][j2];
		}

		int maxi = Integer.MIN_VALUE;
		for (int di = -1; di <= 1; di++) {
			for (int dj = -1; dj <= 1; dj++) {
				int ans;
				if (j1 == j2)
					ans = grid[i][j1] + maxChocoUtilRecursive(i + 1, j1 + di, j2 + dj, n, m, grid);
				else
					ans = grid[i][j1] + grid[i][j2] + maxChocoUtilRecursive(i + 1, j1 + di, j2 + dj, n, m, grid);
				maxi = Math.max(maxi, ans);
			}
		}
		return maxi;
	}

	// Memoized Code
	static int maximumChocolates(int n, int m, int[][] grid) {

		int dp[][][] = new int[n][m][m];

		for (int row1[][] : dp) {
			for (int row2[] : row1) {
				Arrays.fill(row2, -1);
			}
		}

		return maxChocoUtil(0, 0, m - 1, n, m, grid, dp);
	}

	static int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
		if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
			return (int) (Math.pow(-10, 9));

		if (i == n - 1) {
			if (j1 == j2)
				return grid[i][j1];
			else
				return grid[i][j1] + grid[i][j2];
		}

		if (dp[i][j1][j2] != -1)
			return dp[i][j1][j2];

		int maxi = Integer.MIN_VALUE;
		for (int di = -1; di <= 1; di++) {
			for (int dj = -1; dj <= 1; dj++) {
				int ans;
				if (j1 == j2)
					ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
				else
					ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
				maxi = Math.max(maxi, ans);
			}
		}
		return dp[i][j1][j2] = maxi;
	}

	// Tabulation
	static int maximumChocolatesTabeluation(int n, int m, int[][] grid) {

		int dp[][][] = new int[n][m][m];

		for (int j1 = 0; j1 < m; j1++) {
			for (int j2 = 0; j2 < m; j2++) {
				if (j1 == j2)
					dp[n - 1][j1][j2] = grid[n - 1][j1];
				else
					dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
			}
		}

		// Outer Nested Loops for travering DP Array
		for (int i = n - 2; i >= 0; i--) {
			for (int j1 = 0; j1 < m; j1++) {
				for (int j2 = 0; j2 < m; j2++) {

					int maxi = Integer.MIN_VALUE;

					// Inner nested loops to try out 9 options
					for (int di = -1; di <= 1; di++) {
						for (int dj = -1; dj <= 1; dj++) {

							int ans;

							if (j1 == j2)
								ans = grid[i][j1];
							else
								ans = grid[i][j1] + grid[i][j2];

							if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))

								ans += (int) Math.pow(-10, 9);
							else
								ans += dp[i + 1][j1 + di][j2 + dj];

							maxi = Math.max(ans, maxi);
						}
					}
					dp[i][j1][j2] = maxi;
				}
			}
		}

		return dp[0][0][m - 1];
	}

	// Space Optimized
	static int maximumChocolatesSpaceOptimized(int n, int m, int[][] grid) {

		int[][] front = new int[m][m];
		int[][] cur = new int[m][m];

		for (int j1 = 0; j1 < m; j1++) {
			for (int j2 = 0; j2 < m; j2++) {
				if (j1 == j2)
					front[j1][j2] = grid[n - 1][j1];
				else
					front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
			}
		}

		// Outer Nested Loops for travering DP Array
		for (int i = n - 2; i >= 0; i--) {
			for (int j1 = 0; j1 < m; j1++) {
				for (int j2 = 0; j2 < m; j2++) {

					int maxi = Integer.MIN_VALUE;

					// Inner nested loops to try out 9 options
					for (int di = -1; di <= 1; di++) {
						for (int dj = -1; dj <= 1; dj++) {

							int ans;

							if (j1 == j2)
								ans = grid[i][j1];
							else
								ans = grid[i][j1] + grid[i][j2];

							if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))

								ans += (int) Math.pow(-10, 9);
							else
								ans += front[j1 + di][j2 + dj];

							maxi = Math.max(ans, maxi);
						}
					}
					cur[j1][j2] = maxi;
				}
			}

			for (int a = 0; a < m; a++) {
				front[a] = (int[]) (cur[a].clone());
			}
		}

		return front[0][m - 1];
	}

}
