package My_Learning.maths;

public class MaxIncreaseInSkyLineLeetcode807 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxIncreaseKeepingSkyline(int[][] grid) {

		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				res += helper(grid, i, j) - grid[i][j];
			}
		}
		return res;
	}

	private int helper(int[][] grid, int i, int j) { // helper to find min(max(row), max(column))
		int max1 = 0, max2 = 0;
		for (int c = 0; c < grid[0].length; c++) {
			max1 = Math.max(max1, grid[i][c]);
		}
		for (int r = 0; r < grid[0].length; r++) {
			max2 = Math.max(max2, grid[r][j]);
		}
		return max1 = Math.min(max1, max2);
	}

}
