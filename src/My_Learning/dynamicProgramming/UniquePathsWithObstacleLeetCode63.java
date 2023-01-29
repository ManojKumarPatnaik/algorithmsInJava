package My_Learning.dynamicProgramming;

public class UniquePathsWithObstacleLeetCode63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = -1;

		return solve(obstacleGrid, m - 1, n - 1, dp);
	}

	public int solve(int[][] matrix, int m, int n, int[][] dp) {

		if (m == 0 && n == 0 && matrix[m][n] != 1)
			return 1;
		if (m < 0 || n < 0)
			return 0;

		if (matrix[m][n] == 1)
			return 0;

		if (dp[m][n] != -1)
			return dp[m][n];

		int up = 0, left = 0;

		up = solve(matrix, m - 1, n, dp);
		left = solve(matrix, m, n - 1, dp);

		return dp[m][n] = (up + left);
	}

}
