package My_Learning.DP_theory.DP_GRIDS;

import java.util.Arrays;

public class UniquePathWithObstacles {

	public static void main(String args[]) {

		int[][] maze = { { 0, 0, 0 }, { 0, -1, 0 }, { 0, 0, 0 } };

		int n = maze.length;
		int m = maze.length;

		System.out.println(mazeObstacles(n, m, maze));
	}

	// Recursive Code
	// Recursive Code
	static int mazeObstaclesRecursive(int i, int j, int[][] maze) { // call at n-1 m-1
		
		if (i > 0 && j > 0 && maze[i][j] == -1)
			return 0;
		
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		int up = mazeObstaclesRecursive(i - 1, j, maze);
		int left = mazeObstaclesRecursive(i, j - 1, maze);

		return up + left;

	}

	// Memoized Code
	static int mazeObstacles(int n, int m, int[][] maze) {
		int dp[][] = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return mazeObstaclesUtil(n - 1, m - 1, maze, dp);

	}

	static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
		if (i > 0 && j > 0 && maze[i][j] == -1)
			return 0;
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		int up = mazeObstaclesUtil(i - 1, j, maze, dp);
		int left = mazeObstaclesUtil(i, j - 1, maze, dp);

		return dp[i][j] = up + left;

	}

	// Tabulation
	static int mazeObstaclesUtilTabulation(int n, int m, int[][] maze, int[][] dp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// base conditions
				if (i > 0 && j > 0 && maze[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}
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

		return dp[n - 1][m - 1];

	}

	// Space Optimized
	static int mazeObstaclesOptimized(int n, int m, int[][] maze) {

		int prev[] = new int[n];
		for (int i = 0; i < n; i++) {
			int temp[] = new int[m];
			for (int j = 0; j < m; j++) {
				if (i > 0 && j > 0 && maze[i][j] == -1) {
					temp[j] = 0;
					continue;
				}
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

}
