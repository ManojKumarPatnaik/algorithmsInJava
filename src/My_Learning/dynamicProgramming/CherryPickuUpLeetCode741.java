package My_Learning.dynamicProgramming;

import java.util.Arrays;

public class CherryPickuUpLeetCode741 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int cherryPickup1(int[][] grid) {
		// getting maximum cherry by going dwon from 00 to (n-1,n-1)
		// also make the cherry cell from 1 to 0 so that while coming back I don't pic
		int n = grid.length;
		int m = grid[0].length;

		int tempAns1 = getMaximumCherryDownR(0, 0, n, m, grid);

		// getting maximum cherry by coming back from n-1,n-1 to 00
		int tempAns2 = getmaximumCherryUpR(n - 1, n - 1, n, m, grid);

		return tempAns1 + tempAns2;
	}

	private int getmaximumCherryUpR(int i, int j, int n, int m, int[][] grid) {
		// getting maximum cherry by going down from 00 to (n-1,n-1)
		// also make the cherry cell from 1 to 0 so that while coming back I don't pic
//		int n = grid.length;
//		int m = grid[0].length;

		int tempAns1 = getMaximumCherryDownR(0, 0, n, m, grid);

		// getting maximum cherry by coming back from n-1,n-1 to 00
		int tempAns2 = getmaximumCherryUpR(n - 1, n - 1, n, m, grid);

		return tempAns1 + tempAns2;
	}

	public int getMaximumCherryDownR(int i, int j, int n, int m, int[][] grid) {

		// Base case for out of bound
		if (i >= n || j >= n) {
			// return minimim so that that path is not included
			return (int) Math.pow(-10, 9);
		}

		// Base case for destination
		if (i == n - 1) {
			int temp = grid[i][j];
			grid[i][j] = 0;
			return temp;
		}
		return m;

	}

	public int cherryPickupR(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int n = grid.length;

		int[][][] dp = new int[n + 1][n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				Arrays.fill(dp[i][j], -1);

		dp[1][1][1] = grid[0][0];
		for (int x1 = 1; x1 <= n; x1++) {
			for (int y1 = 1; y1 <= n; y1++) {
				for (int x2 = 1; x2 <= n; x2++) {
					int y2 = x1 + y1 - x2;
					if (dp[x1][y1][x2] >= 0 || y2 < 1 || y2 > n || grid[x1 - 1][y1 - 1] < 0 || grid[x2 - 1][y2 - 1] < 0)
						continue;
					int max1 = Math.max(dp[x1 - 1][y1][x2], dp[x1][y1 - 1][x2]);
					int max2 = Math.max(dp[x1 - 1][y1][x2 - 1], dp[x1][y1 - 1][x2 - 1]);
					int max = Math.max(max1, max2);
					if (max == -1)
						continue;

					dp[x1][y1][x2] = max + grid[x1 - 1][y1 - 1];
					if (x2 != x1)
						dp[x1][y1][x2] += grid[x2 - 1][y2 - 1];
				}
			}
		}
		return Math.max(0, dp[n][n][n]);
	}

}
