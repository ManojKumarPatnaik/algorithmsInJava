package My_Learning.matrixProblems;

public class MinimumPathSumLeetCode64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid) {
		// return solve(grid, grid.length, grid[0].length);
		return solve2(grid);
	}

	public int solve(int[][] matrix, int n, int m) {
		int dp[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = matrix[i][j];
				else {

					int up = matrix[i][j];
					if (i > 0)
						up += dp[i - 1][j];
					else
						up += (int) Math.pow(10, 9);

					int left = matrix[i][j];
					if (j > 0)
						left += dp[i][j - 1];
					else
						left += (int) Math.pow(10, 9);

					dp[i][j] = Math.min(up, left);
				}
			}
		}

		return dp[n - 1][m - 1];
	}

	public int solve2(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j != 0)
					grid[i][j] += grid[i][j - 1];
				if (i != 0 && j == 0)
					grid[i][j] += grid[i - 1][j];
				if (i != 0 && j != 0)
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}

}
