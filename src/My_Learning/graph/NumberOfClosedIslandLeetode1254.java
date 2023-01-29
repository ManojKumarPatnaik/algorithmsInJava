package My_Learning.graph;

public class NumberOfClosedIslandLeetode1254 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int closedIsland(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 0) {
					boolean flag = dfs(grid, i, j, r, c);
					if (flag)
						cnt++;
				}
			}
		}
		return cnt;
	}

	private boolean dfs(int[][] grid, int r, int c, int m, int n) {
		if (r < 0 || c < 0 || r >= m || c >= n)
			return false;
		if (grid[r][c] == 1)
			return true;
		grid[r][c] = 1;
		boolean south = dfs(grid, r, c + 1, m, n);
		boolean north = dfs(grid, r, c - 1, m, n);
		boolean west = dfs(grid, r + 1, c, m, n);
		boolean east = dfs(grid, r - 1, c, m, n);
		return (east && west && north && south);
	}

}
