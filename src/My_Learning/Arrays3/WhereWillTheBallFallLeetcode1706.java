package My_Learning.Arrays3;

public class WhereWillTheBallFallLeetcode1706 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int m;
	int n;

	// Leetcode daily solution
	public int[] findBall(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = helper(grid, i, 0);
		}
		return res;
	}

	int helper(int[][] grid, int col, int row) {
		while (row < m) {
			int num = grid[row][col];
			if (col + num < 0 || col + num >= n || num != grid[row][col + num])
				return -1;
			row++;
			col = col + num;
		}
		return col;
	}
}
