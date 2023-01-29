package My_Learning.graph;

public class MaximumAreaOfIslandLeetcode695 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Daily Leetcode solution 
	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, dfs(grid, i, j));
				}
			}
		}
		return max;
	}

	public int dfs(int[][] grid, int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
			// marking this cell as visited
			grid[i][j] = 0;
			return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
		}
		return 0;
	}
}
