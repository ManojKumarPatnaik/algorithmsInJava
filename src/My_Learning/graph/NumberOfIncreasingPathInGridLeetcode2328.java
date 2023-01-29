package My_Learning.graph;

public class NumberOfIncreasingPathInGridLeetcode2328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long[][] dp;
	int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	int mod = 1000000007;

	public int countPaths(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		dp = new long[rows][cols];

		long ans = 0;

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				ans = (ans + increasingPaths(i, j, rows, cols, grid, 0)) % mod;

		return (int) ans;
	}

	private long increasingPaths(int i, int j, int rows, int cols, int[][] grid, int prev) {
		if (i < 0 || j < 0 || i == rows || j == cols || grid[i][j] <= prev)
			return 0;

		if (dp[i][j] != 0)
			return dp[i][j];

		dp[i][j] = 1;
		for (int k = 0; k < 4; k++) {
			int x = i + directions[k][0];
			int y = j + directions[k][1];

			dp[i][j] = (dp[i][j] + increasingPaths(x, y, rows, cols, grid, grid[i][j])) % mod;
		}

		return dp[i][j];
	}

}
